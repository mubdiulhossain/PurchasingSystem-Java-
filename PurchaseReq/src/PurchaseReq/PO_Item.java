package PurchaseReq;


import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PO_Item {

	private String POID;
	private String itemID;
	private Integer quantity;
	private Double price;
	
	public PO_Item(ArrayList<String> data) {
		this.POID = data.get(0);
		this.itemID = (data.get(1));
		quantity = (Integer.parseInt(data.get(2)));
		this.setPrice(Double.parseDouble(data.get(3)));
	}
	
	public PO_Item(String POID, Item item, Integer quantity) {
		this.POID = POID;
		this.itemID = item.getItemID();
		this.quantity = quantity;
		this.price = item.getPrice() * (double)this.getQuantity();
	}

	public String getPOID() {
		return POID;
	}

	public void setPOID(String poID) {
		this.POID = poID;
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

		initiation<PO_Item> updater = new initiation<>();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`po_item` (`poid`, `item_ID`, `quantity`)" + 
			" VALUES ('"+POID+"','"+itemID+"', '"+quantity+"')");
						
			return true;
		} catch (SQLException e) {
			System.out.println(5555);

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

