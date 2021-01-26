package PurchaseReq;



import java.util.Date;

import javax.swing.JOptionPane;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@SuppressWarnings({ "deprecation", "unused" })
public class PO {
	private String POID;
	private String staffID;
	private Date date;
	private ArrayList<Object[]> itemsAndQuantity = new ArrayList<>();
	private double total_price;
	private String vendorID;
	private String companyID;
	
	public PO(ArrayList<String> data) {
		setPOID(data.get(0));
		setDate(data.get(1));
		setStaffID(data.get(3));
		setVendorID(data.get(4));
	}
	
	public PO() {}
	
	/**
	 *
	 * Setters And Getters
	 * 
	 * 
	 */

	/**
	 * @return the pOID
	 */
	public String getPOID() {
		return POID;
	}

	/**
	 * @param pOID the pOID to set
	 */
	public void setPOID(String pOID) {
		POID = pOID;
	}

	/**
	 * @return the staffID
	 */
	public String getStaffID() {
		return staffID;
	}

	/**
	 * @param staffID the staffID to set
	 */
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			String year = date.substring(0, 4);
			String month = date.substring(5, 7);
			String day = date.substring(8, 10);

			this.date = format.parse ( year+"-"+month+"-"+day );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the itemsAndQuantity
	 */
	public ArrayList<Object[]> getItemsAndQuantity() {
		return itemsAndQuantity;
	}

	/**
	 * @param itemsAndQuantity the itemsAndQuantity to set
	 */
	public void setItemsAndQuantity(ArrayList<Object[]> itemsAndQuantity) {
		this.itemsAndQuantity = itemsAndQuantity;
	}

	/**
	 * @return the total_price
	 */
	public double getTotal_price() {
		return total_price;
	}

	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	/**
	 * @return the vendorID
	 */
	public String getVendorID() {
		return vendorID;
	}

	/**
	 * @param vendorID the vendorID to set
	 */
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	
	/**
	 * 
	 * Methods
	 * 
	 */
	
	
	public void addToItemsAndQuantity(int quantity, Item item) {
		Object[] objs = {quantity, item, item.getPrice()};
		itemsAndQuantity.add(objs);
	}
	
	public void setItemsAndQuantity() {
			
			for(int i = 0; i < PurchaseReqSystem.item.size(); i++) {
				for(int j = 0; j < PurchaseReqSystem.po_item.size(); j++) {
					System.out.println(5353);
					if(POID.equals(PurchaseReqSystem.po_item.get(j).getPOID())
											&&
						PurchaseReqSystem.item.get(i).getItemID().equals(PurchaseReqSystem.po_item.get(j).getItemID())) {
							this.addToItemsAndQuantity(PurchaseReqSystem.po_item.get(j).getQuantity(),PurchaseReqSystem.item.get(i));
					}
				}
			}
		}
	
	public int getSizeOFItemsAndQuantity() {
		return itemsAndQuantity.size();
	}
	

	public String getItemsAndQuantity(int i) {
		return itemsAndQuantity.get(i)[0].toString() + "," +  ((Item) itemsAndQuantity.get(i)[1]).getName() ;
	}
	
	public Item getItem(int i) {
		return ((Item) itemsAndQuantity.get(i)[1]);
	}
	
	public Integer getQuantity(int i) {
		return (Integer) itemsAndQuantity.get(i)[0];
	}

	public Double getTotal() {
		Double total = new Double(0);
		for(int i = 0 ; i < getSizeOFItemsAndQuantity(); i++) {
			total = total + (getItem(i).getPrice() * this.getQuantity(i));
		}
		
		return total;
	}
	
	
	public String getFormatedDate() {
		String DATE = date.toString();
		return DATE;
	}

//	public void viewPRFinance(FinanceStaff FS) {
//		CreatePO window = new CreatePO(this, FS, "");
//	}
	
	public String getFStaffName(){
		for(int i = 0; i < PurchaseReqSystem.financestaff.size(); i++)
			if(PurchaseReqSystem.financestaff.get(i).getFinanceStaffID().equals(getStaffID())) {
				return PurchaseReqSystem.financestaff.get(i).getName();
			}
		return "Not found";
	}
	
	public boolean updateDatabase(String DATE) {

		initiation<PO> updater = new initiation<>();
		try {

			updater.connect("purchasereq?useSSL=false", "root", "1234");
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`po` (`id`,`date`, `finance_staffID`, `vendorID`)" + 
			" VALUES ('"+POID+"', '"+DATE+"', '"+staffID+"', '"+vendorID+"')");
			
			JOptionPane.showMessageDialog(null,"well done, your Purcahse Order was successfully created.  PR id : " + POID ,"PO Creation successful",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {
			System.out.println(5555);

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
	}

	public void createPurchaseOrder(FinanceStaff FS, Object vendorID) {
		// TODO Auto-generated method stub
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
		
}
