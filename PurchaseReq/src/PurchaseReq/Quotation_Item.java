package PurchaseReq;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Quotation_Item { 
	
	private String quotationID;
	private String itemID;
	private Integer quantity;
	private Double unitPrice;
	
	public Quotation_Item(ArrayList<String> data) {
		this.quotationID = data.get(0);
		this.itemID = (data.get(1));
		this.setQuantity(data.get(2));	
		this.setUnitPrice(data.get(3));
	}
	
	public Quotation_Item(String QuotationID, String itemID, Integer quantity, Double UnitPrice) {
		this.quotationID = QuotationID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.unitPrice= UnitPrice;
	}
	
	public String getQuotationID() {
		return quotationID;
	}

	public void setQuotationID(String quotationID) {
		this.quotationID = quotationID;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	

	public Integer getQuantity() {
		return quantity;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setQuantity(String quantity){
		
		try{
			this.quantity = Integer.valueOf(quantity);
		}catch(Exception e) {
			System.out.println(e); 
		}
		
	}
	
	public void setUnitPrice(String unitprice){
		
		try{
			this.unitPrice = Double.valueOf(unitprice);
		}catch(Exception e) {
			System.out.println(e); 
		}
		
	}
	
	public boolean updateDatabase() {

		initiation<Quotation_Item> updater = new initiation();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`quotation_item` (`quotationID`,`itemID`,`quantity`,`unitprice`)" + 
			" VALUES ('"+quotationID+"', '"+itemID+"', '"+quantity+"', '"+unitPrice+"')");
								
			return true;
		} catch (SQLException e) {
			System.out.println(5555);

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}
}