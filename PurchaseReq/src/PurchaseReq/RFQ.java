package PurchaseReq;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.*;

public class RFQ extends JFrame {
	
	private String RFQID;
	private String PRID;
	private String CompanyID;
	private String Finance_StaffID;
	private String date;
	private String duedate;
	private ArrayList<Object[]> itemsAndQuantity = new ArrayList();
	
	@Override
	public String toString() {
		return "RFQ [RFQID=" + RFQID + ", PRID=" + PRID + ", CompanyID=" + CompanyID + ", Finance_StaffID =" + Finance_StaffID +", "
				+ "date=" + date + ", duedate=" + duedate + "]";
	}
	
	public RFQ(ArrayList<String> data) {
		this.RFQID = data.get(0);
		this.PRID = data.get(1);
		this.CompanyID = data.get(2);
		this.Finance_StaffID = data.get(3);
		this.setDate(data.get(4), data.get(5));
	}
	
	public void setDate(String date, String date2) {
		String year = date.substring(0, 4);
		String month = date.substring(5, 7);
		String day = date.substring(8, 10);
		
		this.date = year+"-"+month+"-"+day;
		
		String year2 = date2.substring(0, 4);
		String month2 = date2.substring(5, 7);
		String day2 = date2.substring(8, 10);

		this.duedate = year2+"-"+month2+"-"+day2;
	}
	
	public void addToItemsAndQuantity(int quantity, Item item) {
		Object[] objs = {quantity, item};
		itemsAndQuantity.add(objs);
	}
	
	public void setItemsAndQuantity() {
		
		for(int i = 0; i < PurchaseReqSystem.item.size(); i++) {
			for(int j = 0; j < PurchaseReqSystem.rfq_item.size(); j++) {
				if(RFQID.equals(PurchaseReqSystem.rfq_item.get(j).getRFQID())
										&&
					PurchaseReqSystem.item.get(i).getItemID().equals(PurchaseReqSystem.rfq_item.get(j).getItemID())) {
					this.addToItemsAndQuantity(PurchaseReqSystem.rfq_item.get(j).getQuantity(),PurchaseReqSystem.item.get(i));
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
	
	public String getFinanceStaffInfo(String infoDetails) {
		initiation<FinanceStaff> connector = new initiation();
		String FinanceStaffDetails = null;
		try {
			connector.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		
		try {
			connector.setStatement(connector.getConnection().createStatement() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connector.setResultSet(connector.getStatement().executeQuery("SELECT "+infoDetails+" FROM finance_staff where finance_StaffID = '"+Finance_StaffID+"'"));
				while (connector.getResultSet().next()) {
					FinanceStaffDetails = connector.getResultSet().getString(infoDetails);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return FinanceStaffDetails;
	}
	
	
	public String getCompanyInfo(String infoDetails) {
		initiation<FinanceStaff> connector = new initiation();
		String CompanyInfo = null;
		try {
			connector.connect("purchasereq?serverTimezone=UTC&useSSL=false", "root", "1234");
		} catch (Exception ex) {
			System.out.println(ex); 
		}
		
		try {
			connector.setStatement(connector.getConnection().createStatement() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connector.setResultSet(connector.getStatement().executeQuery("SELECT "+infoDetails+" FROM company where companyID = '"+CompanyID+"'"));
				while (connector.getResultSet().next()) {
					CompanyInfo = connector.getResultSet().getString(infoDetails);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		if (infoDetails=="address") {
			CompanyInfo=CompanyInfo.replaceAll(", ", ",\n");
		}
		return CompanyInfo;
	}
	
	
	public RFQ() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getRFQID() {
		return RFQID;
	}



	public void setRFQID(String RFQID) {
		this.RFQID = RFQID;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getDueDate() {
		return duedate;
	}
	
	public String getFinanceStaffID() {
		return Finance_StaffID;
	}

	public void setFinanceStaffID(String FinanceStaffID) {
		this.Finance_StaffID = FinanceStaffID;
	}
	
	public String getPRID() {
		return PRID;
	}

	public void setPRID(String PRID) {
		this.PRID = PRID;
	}
	
	public String getCompanyID() {
		return CompanyID;
	}

	
	public void setCompanyID(String CompanyID) {
		this.CompanyID = CompanyID;
	}
	
	public void viewRFQ(Vendor VN) {
		ViewRFQ window = new ViewRFQ(this, VN);
	}
	
	public void createQuotation(Vendor VN) {
		CreateQuotation window = new CreateQuotation(this, VN);
	}
	
	public boolean updateDatabase() {

		initiation<RFQ> updater = new initiation();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`rfq` (`rfqID`,`PRID`,`companyID`, `finance_StaffID`, `date`, `due_date`)" + 
			" VALUES ('"+RFQID+"', '"+PRID+"', '"+CompanyID+"', '"+Finance_StaffID+"','"+date+"', '"+duedate+"')");			
			JOptionPane.showMessageDialog(null,"Success! Your RFQ was successfully created.  RFQ ID : " + RFQID ,"RFQ Creation successful",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}			
		
	}
}