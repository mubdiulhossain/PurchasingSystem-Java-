package PurchaseReq;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Quotation {
	
	private String QuotationID;
	private String VendorID;
	private String CompanyID;
	private String RFQID;
	private Double TotalPrice;
	private String Date;
	private String Validity;
	private Double Delivery;
	private ArrayList<Object[]> itemsAndQuantity = new ArrayList();
	
	public Quotation(ArrayList<String> data) {
		this.QuotationID = data.get(0);
		this.VendorID = data.get(1);
		this.CompanyID = data.get(2);
		this.RFQID = data.get(3);
		this.TotalPrice=Double.parseDouble(data.get(4));
		this.setDate(data.get(5), data.get(6));
		this.Delivery=Double.parseDouble(data.get(7));
	}
	
	public Quotation() {
		// TODO Auto-generated constructor stub
	}
	public String getQuotationID() {
		return QuotationID;
	}
	public void setQuotationID(String quotationID) {
		QuotationID = quotationID;
	}
	public String getVendorID() {
		return VendorID;
	}
	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}
	public String getCompanyID() {
		return CompanyID;
	}
	public void setCompanyID(String companyID) {
		CompanyID = companyID;
	}
	public String getRFQID() {
		return RFQID;
	}
	public void setRFQID(String rFQID) {
		RFQID = rFQID;
	}
	public Double getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		TotalPrice = totalPrice;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getValidity() {
		return Validity;
	}
	public void setValidity(String validity) {
		Validity = validity;
	}
	public Double getDelivery() {
		return Delivery;
	}
	public void setDelivery(Double delivery) {
		Delivery = delivery;
	}
	
	public void setDate(String date, String date2) {
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		
		this.Date = year+"-"+month+"-"+day;
		
		String year2 = date2.substring(0, 4);
		String month2 = date2.substring(5, 7);
		String day2 = date2.substring(8, 10);

		this.Validity = year2+"-"+month2+"-"+day2;
	}
	
	public void addToItemsAndQuantity(int quantity, Item item) {
		Object[] objs = {quantity, item};
		itemsAndQuantity.add(objs);
	}
	
	public void setItemsAndQuantity() {
		
		for(int i = 0; i < PurchaseReqSystem.item.size(); i++) {
			for(int j = 0; j < PurchaseReqSystem.quotation_item.size(); j++) {
				if(QuotationID.equals(PurchaseReqSystem.quotation_item.get(j).getQuotationID())
										&&
					PurchaseReqSystem.item.get(i).getItemID().equals(PurchaseReqSystem.quotation_item.get(j).getItemID())) {
					this.addToItemsAndQuantity(PurchaseReqSystem.quotation_item.get(j).getQuantity(),PurchaseReqSystem.item.get(i));
				}
			}
		}
	}
	
	public int getSizeOFItemsAndQuantity() {
		return itemsAndQuantity.size();
	}
	
	public Item getItem(int i) {
		return ((Item) itemsAndQuantity.get(i)[1]);
	}
	
	public Integer getQuantity(int i) {
		return (Integer) itemsAndQuantity.get(i)[0];
	}

	
	public boolean updateDatabase() {

		initiation<Quotation> updater = new initiation();
		try {

			updater.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		
		try {
			updater.setStatement(updater.getConnection().createStatement() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			updater.getStatement().execute("INSERT INTO `purchasereq`.`quotation` (`quotationID`,`vendorID`,`companyID`,`rfqID`,`totalprice`,`validity`,`date`,`delivery`)" + 
			" VALUES ('"+QuotationID+"', '"+VendorID+"', '"+CompanyID+"', '"+RFQID+"','"+TotalPrice+"','"+Validity+"', '"+Date+"', '"+Delivery+"')");
			
			JOptionPane.showMessageDialog(null,"Success! Your Quotation was successfully created.  Quotation ID : " + QuotationID ,"Quotation Creation successful",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	
	
	
	
}