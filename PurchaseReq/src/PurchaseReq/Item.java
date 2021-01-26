package PurchaseReq;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Item {
	
	private String itemID;
	private Double price;
	private String name;
	
	public Item(ArrayList<String> data) {
		this.itemID = data.get(0);
		this.setPrice(data.get(1));
		this.name = data.get(2);
		
	}
	
	public Item(String itemID, String price, String name) {
		this.itemID = itemID;
		this.setPrice(price);
		this.name = name;
		
	}
	
	public boolean updateDatabase() {
		initiation<Item> updater = new initiation();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`item` (`itemID`, `price`, `name`)" + 
			" VALUES ('"+itemID+"', '"+price+"', '"+name+"')");
			
			JOptionPane.showMessageDialog(null,"well done, your " + name + " was successfully created.  item id : " + itemID + "\n" + "You can keep creating items all you want, click on 'Cancel' if you want to stop" ,"Item Creation successful",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong, please check the name and price and try again! , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public String getItemID() {
		return itemID;
	}


	public void setItemID(String itemID) {
		this.itemID = itemID;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	public void setPrice(String price){
		try{
			this.price = Double.valueOf(price);
		}catch(Exception e) {
			System.out.println(e); 
		}
		
	}
	
	

}
