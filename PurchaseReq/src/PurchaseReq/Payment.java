package PurchaseReq;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Payment {
	DatabaseConnection connection = new DatabaseConnection();
	Connection connect = connection.conn();
	private ArrayList<String> bankName = new ArrayList();
	private ArrayList<String> invoiceList = new ArrayList();
	java.sql.Date sqldate;
	private String payId;
	private double amount =0;
	public void UpdatePayment(String invoiceId,String bankName,String accountNo,String accountName)
	{
		try {
				String sql = "select * from payment";
				PreparedStatement	st = connect.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				int count = 0;
				while (rs.next()) {
					count++;
				}
				count = count + 1001;
				String Id = Integer.toString(count);
				payId = 'P' + Id;
				Date d = new Date();
				SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
				sqldate = new java.sql.Date(d.getTime());
		
				String sql2 = "insert into payment" + "(PaymentId, BankName, Amount, AccountName, AccountNo, InvoiceId,Date)" + "values(?,?,?,?,?,?,'"+sqldate+"')";
				PreparedStatement st2 = connect.prepareStatement(sql2);
				st2.setString(1, payId);
				st2.setString(2, bankName);
				st2.setDouble(3, amount);
				st2.setString(4, accountName);
				st2.setString(5, accountNo);
				st2.setString(6, invoiceId);
				st2.execute();
	
				rs.close();
				st.close();
				st2.close();
		
		    }catch (SQLException e1) {
		    	e1.printStackTrace();
		    }
		}
	
	public void getAllInvoiceId()
	{
		  String s1 = "select InvoiceId from invoicet where Payment_status = ?";
			try {
					PreparedStatement	st = connect.prepareStatement(s1);
					st.setString(1, "Pending");
					ResultSet rs = st.executeQuery();
				    while(rs.next())
					 {
				    	invoiceList.add(rs.getString(1));
				    	
					 } 
				    st.close();
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
	public  ArrayList<String> filledInvoice_Comboxbox()
	{
		return invoiceList;
	}
	
	public  ArrayList<String> filledBank_Comboxbox()
	{   
		    bankName.add("CIMB");
			bankName.add("MayBank");
			bankName.add("Bank Islam");
			bankName.add("Hong Leong");
			bankName.add("HSBC");
			return bankName;	
	}
	public void CreatePID()
	{
		 String sql = "select * from payment";
		  
			try {
					PreparedStatement st = connect.prepareStatement(sql);
					ResultSet rs = st.executeQuery();
					int count = 0;
		  
					while (rs.next()) {
				    count++;
				  }
					count = count + 100;
					String Id = Integer.toString(count);
					payId = 'P' + Id;
					rs.close();
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public void getAmountFromD(String InvoiceId)
	{
		try {
			String sq1 = "select Total from invoicet where InvoiceId = ?";
			PreparedStatement st = connect.prepareStatement(sq1);
			st.setString(1, InvoiceId);
			ResultSet rs = st.executeQuery();

			while(rs.next())
			{
				amount = rs.getDouble(1);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public double returnAmount()
	{
		return amount;
	}
	public void updatePaymentStatus(String id)
	{
		try {
			String sq1 = "update invoicet set Payment_status = ?  where InvoiceId = ?";
			PreparedStatement st = connect.prepareStatement(sq1);
			st.setString(1, "Paid");
			st.setString(2, id);
			st.execute();
			st.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
