package PurchaseReq;
import PurchaseReq.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import java.util.*;

public class PR {

	private String PRID;
	private Date date;
	private String status;
	private String reason;
	private String staffID;
	private String managerID;
	private ArrayList<Object[]> itemsAndQuantity = new ArrayList();
	
	

	public PR(String pRID, String staffID) {
		PRID = pRID;
		this.status = "pending";
		this.staffID = staffID;
	}


	@Override
	public String toString() {
		return "PR [PRID=" + PRID + ", date=" + date + ", status=" + status + ", reason=" + reason + ", staffID="
				+ staffID + ", managerID=" + managerID + "]";
	}


	public PR(ArrayList<String> data) {
		this.PRID = data.get(0);
		this.setDate(data.get(1));
		this.status = data.get(2);
		this.reason = data.get(3);
		this.staffID = data.get(4);
		this.managerID = data.get(5);
	}
	


	public void addToItemsAndQuantity(int quantity, Item item) {
		Object[] objs = {quantity, item};
		itemsAndQuantity.add(objs);
	}
	
	public void setItemsAndQuantity() {
		
		for(int i = 0; i < PurchaseReqSystem.item.size(); i++) {
			for(int j = 0; j < PurchaseReqSystem.pr_item.size(); j++) {
				if(PRID.equals(PurchaseReqSystem.pr_item.get(j).getPRID())
										&&
					PurchaseReqSystem.item.get(i).getItemID().equals(PurchaseReqSystem.pr_item.get(j).getItemID())) {
					this.addToItemsAndQuantity(PurchaseReqSystem.pr_item.get(j).getQuantity(),PurchaseReqSystem.item.get(i));
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
	
	public String getStaffName() {
		initiation<Staff> connector = new initiation();
		String staffName = null;
		try {
			connector.connect("purchasereq?useSSL=false", "root", "1234");
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
			connector.setResultSet(connector.getStatement().executeQuery("SELECT name FROM staff where staffID = '"+staffID+"'"));
				
				

				while (connector.getResultSet().next()) {
					staffName = connector.getResultSet().getString("name");
	            }
				
								
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		
		return staffName;
		
	}
	
	
	
	public String getManagerName() {
		initiation<Manager> connector = new initiation();
		String ManagerName = null;
		try {
			connector.connect("purchasereq?useSSL=false", "root", "1234");
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
			connector.setResultSet(connector.getStatement().executeQuery("SELECT name FROM manager where managerID = '"+managerID+"'"));
				
				

				while (connector.getResultSet().next()) {
					ManagerName = connector.getResultSet().getString("name");
	            }
				
				
				
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		
		return ManagerName;
		
	}


	public PR() {
		// TODO Auto-generated constructor stub
	}



	public String getPRID() {
		return PRID;
	}



	public void setPRID(String pRID) {
		PRID = pRID;
	}



	


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
	

	
	public Date getDate() {
		return date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getColoredStatus() {
			
			String redStatus = "<html><font color=\"red\"> " + status + "</font></html>";
			String greenStatus = "<html><font color=\"green\"> " + status + "</font></html>";
	
			
			if (status.equals("rejected"))
				return redStatus;
			else if (status.equals("approved"))
				return greenStatus;
			else 
				return status;
		}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}


	public String getManagerID() {
		return managerID;
	}


	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	
	public void viewPR() {
		Staff_View_PR_screen window = new Staff_View_PR_screen(this);
	}
	
	
	
	public boolean updateDatabase(String DATE) {

		initiation<PR> updater = new initiation();
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
			updater.getStatement().execute("INSERT INTO `purchasereq`.`pr` (`PRID`,`date`,`status`, `staffID`)" + 
			" VALUES ('"+PRID+"', '"+DATE+"', '"+status+"', '"+staffID+"')");
			
			JOptionPane.showMessageDialog(null,"well done, your PR was successfully created.  PR id : " + PRID ,"PR Creation successful",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {
			

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public void viewPR(FinanceStaff FS) {
		View_PR_screen window = new View_PR_screen(this, FS);
	}
	
	public void createRFQ(FinanceStaff FS) {
		CreateRFQ window = new CreateRFQ(this, FS);
	}

	public String getStaffInfo(String infoDetails) {
		initiation<Staff> connector = new initiation();
		String staffName = null;
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
			connector.setResultSet(connector.getStatement().executeQuery("SELECT "+infoDetails+" FROM staff where staffID = '"+staffID+"'"));
				
				

				while (connector.getResultSet().next()) {
					staffName = connector.getResultSet().getString(infoDetails);
	            }
				
								
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		
		return staffName;
		
	}

	
}
