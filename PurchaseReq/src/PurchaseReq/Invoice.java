package PurchaseReq;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Invoice{
	
	DatabaseConnection connection = new DatabaseConnection();
	Connection connect = connection.conn();
	
	private  String invoiceId;
	java.sql.Date sqldate;
	private String vendorName,id,deliveryId;
	private double total = 0;
	private double totalPrice = 0;
	private double delivery = 0;
	private double amount = 0;
	private ArrayList<Invoice_Item>Item;
	private ArrayList<String> list = new ArrayList();
	private ArrayList<Invoice_Item> addList = new ArrayList();
	private ArrayList<String> invoice = new ArrayList();
	private ArrayList<String> invoiceList =  new ArrayList();
	private ArrayList<String> statusList =  new ArrayList();
	private ArrayList<String> deliverId = new ArrayList();
	
	
	
	
	public void Invoice_Item(ArrayList<Invoice_Item>item)
	{
		Item = item;
	}
	
	public ArrayList<String> getInvoiceLst()
	{
		return invoiceList;
	}
	
	public ArrayList<String> getStatusList()
	{
		return statusList;
	}
	public void totalPrice(int quantity, double unitPrice)
	{
		totalPrice = quantity * unitPrice;
	}
	public double returntotalPrice()
	{
		return totalPrice;
	}
	public void updateItem()
	{
	    for(Invoice_Item  d : Item)
	    {	
	    	  String name  = d.getName();
	    	  String s1 = "select itemID from item where Name = ? ";
			try {
				PreparedStatement st = connect.prepareStatement(s1);
				st.setString(1, name);
	    	    ResultSet rs = st.executeQuery();
			    String id ="";
				while(rs.next())
					 {
						
						id = rs.getString(1);
						
					 } 
	    	  String sql = "insert into invoice_item" + "(InvoiceId, ItemId, Item_Quantity, UnitPrice, TotalPrice)" + "values(?,?,?,?,?)";
	    	  PreparedStatement st1 = connect.prepareStatement(sql);
				st1.setString(1, invoiceId );
				st1.setString(2, id);
				st1.setInt(3, d.getQuantity());
				st1.setDouble(4, d.getunitPrice());
				st1.setDouble(5, d.gettotalPrice());
				st1.execute();
				
				st.close();
				rs.close();
				st1.close();
				
			}catch (SQLException e) {
       		e.printStackTrace();
			}
	    }
	}
	
	public void updateInvoice(String financeStaffID)
	{
		
		updateVendorDetails();
		String sql = "select * from invoiceT";
		try {
			PreparedStatement	st = connect.prepareStatement(sql);
		     ResultSet rs = st.executeQuery();
	         int count = 0;
			while (rs.next()) {
			    count++;
			  }
			Date d = new Date();
			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			sqldate = new java.sql.Date(d.getTime());
			count = count + 1001;
			String Id = Integer.toString(count);
			invoiceId = "IN" + Id;
			String sql2 = "insert into invoiceT" + "(InvoiceId,Date,SubTotal,DeliveryCost,Total,vendorID,deliveryID,staffID,Payment_Status)" + "Values(?,'"+sqldate+"',?,?,?,?,?,?,?)";
			PreparedStatement	st1 = connect.prepareStatement(sql2);
			st1.setString(1, invoiceId);
			st1.setDouble(2, amount);
			st1.setDouble(3, delivery);
			st1.setDouble(4, total); 
			st1.setString(5, id);
			st1.setString(6, deliveryId);
			st1.setString(7, financeStaffID );
			st1.setString(8, "Pending");
		    st1.execute();
		    
		    st.close();
			rs.close();
			st1.close();
			
		    
			}catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public  ArrayList<String> filled_Comboxbox()
	{   
		     String sql = "select * from item";
			try {
				PreparedStatement st = connect.prepareStatement(sql);
			    ResultSet rs = st.executeQuery();
			 while(rs.next())
			 {
				 list.add(rs.getString("Name"));
			 }
			 st.close();
			 rs.close();
			 
			 return list;
			  
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
	}
	public double getPrice()
	{
		amount = 0;
		for(Invoice_Item  d : Item)
		{
			amount = amount + d.gettotalPrice();
		}
		return amount;
	}
	public void setTotalPrice(double price)
	{
		delivery = price;
		total = amount + delivery;
	}
	
	public double getTotalPrice()
	{
		return total;
	}
	
	public void updateVendorDetails()
	{
	  
	    	  String s1 = "select vendorID  from vendor where name = ? ";
			try {
				PreparedStatement st = connect.prepareStatement(s1);
				st.setString(1, vendorName);
	    	    ResultSet rs = st.executeQuery();
			    while(rs.next())
				 {
					
					id = rs.getString(1);
					
				 } 
			    st.close();
				rs.close();
			  
			}catch (SQLException e) {
       		e.printStackTrace();
			}
	}
	public  void getVendorDetails(String Name)
	{
	       vendorName = Name;
	}
	public void  retrieveItemFromDatabase(String invoiceId)
	{
		String invoiceid = invoiceId;
   	    String s1 = "select Name,Item_Quantity,UnitPrice,TotalPrice from invoice_item,item where  item.ItemId = invoice_item.ItemId and InvoiceId = ?";
		try {
			PreparedStatement st = connect.prepareStatement(s1);
			st.setString(1, invoiceid);
   	        ResultSet rs = st.executeQuery();
		    while(rs.next())
			 {
				
		    	  Invoice_Item item = new Invoice_Item(rs.getString(1),rs.getInt(2),rs.getDouble(3),rs.getDouble(4));
		    	  addList.add(item);
			 } 
		    st.close();
			rs.close();
		
		}catch (SQLException e) {
  		e.printStackTrace();
		}
	}
	public void  retrieveVendorInvoiceFromDatabase(String invoiceId)
	{
		String invoiceid = invoiceId;
		  
		  String s1 = "select name,address,hphone,Date,SubTotal,DeliveryCost,Total,deliveryID,Payment_Status from invoiceT,vendor where  vendor.vendorID = invoiceT.VendorID and InvoiceId = ?";
			try {
				
				PreparedStatement st = connect.prepareStatement(s1);
				st.setString(1, invoiceid);
	   	        ResultSet rs = st.executeQuery();
			    while(rs.next())
				 {
			    	Date sqlDate = rs.getDate(4);
			    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    	String date = df.format(sqlDate);
			    	String subTotal = Double.toString(rs.getDouble(5));
			    	String deliveryCost = Double.toString(rs.getDouble(6));
			    	String total = Double.toString(rs.getDouble(7));
			    	invoice.add(rs.getString(1));
			    	invoice.add(rs.getString(2));
			    	invoice.add(rs.getString(3));
			    	invoice.add(date);
			    	invoice.add(subTotal);
			    	invoice.add(deliveryCost);
			    	invoice.add(total);
			    	invoice.add(rs.getString(8));
			    	invoice.add(rs.getString(9));
				 }  
			    st.close();
				rs.close();
				
				
			}catch (SQLException e) {
	  		e.printStackTrace();
			}
	}
	
	public ArrayList<Invoice_Item> getItemList()
	{
		return addList;
	}
	public ArrayList<String> getInvoice()
	{
		return invoice;
	}
	public void updateInvoiceWindow()
	{
		    String s1 = "select InvoiceId, Payment_Status from invoicet";
			try {
					PreparedStatement	st = connect.prepareStatement(s1);
					ResultSet rs = st.executeQuery();
				    while(rs.next())
					 {
				    	invoiceList.add(rs.getString(1));
				    	statusList.add(rs.getString(2));
				    	
					 } 
				    st.close();
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   	     
	}
	public  ArrayList<String> filledDelivery_Comboxbox()
	{   
		     String sql = "select do_id from delivery_order";
			try {
				PreparedStatement st = connect.prepareStatement(sql);
			    ResultSet rs = st.executeQuery();
			 while(rs.next())
			 {
				 deliverId.add(rs.getString(1));
			 }
			 st.close();
			 rs.close();
			
			 return deliverId;
			  
			}catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
	}
	public void getDeliveryId(String id)
	{
		deliveryId = id;
	}
	
			
}

