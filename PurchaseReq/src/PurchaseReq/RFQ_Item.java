package PurchaseReq;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class RFQ_Item {

	private String rfqID;
	private String itemID;
	private Integer quantity;
	
	public RFQ_Item(ArrayList<String> data) {
		this.rfqID = data.get(0);
		this.itemID = (data.get(1));
		this.setQuantity(data.get(2));	
	}
	
	public RFQ_Item(String rfqID, String itemID, Integer quantity) {
		this.rfqID = rfqID;
		this.itemID = itemID;
		this.quantity = quantity;
	}

	public String getRFQID() {
		return rfqID;
	}

	public void setRFQID(String rfqID) {
		this.rfqID = rfqID;
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

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setQuantity(String quantity){
		
		try{
			this.quantity = Integer.valueOf(quantity);
		}catch(Exception e) {
			System.out.println(e); 
		}
		
	}
	
	
	public boolean updateDatabase() {

		initiation<RFQ_Item> updater = new initiation();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`rfq_item` (`rfqID`, `itemID`, `quantity`)" + 
			" VALUES ('"+rfqID+"','"+itemID+"', '"+quantity+"')");
						
			return true;
		} catch (SQLException e) {
			System.out.println(5555);

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}
}

