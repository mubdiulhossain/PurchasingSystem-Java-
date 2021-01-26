package PurchaseReq;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Manager {
	private String managerID;
	private String name;
	
	@Override
	public String toString() {
		return "Manager [managerID=" + managerID + ", name=" + name + "]";
	}
	/**
	 * @return the managerID
	 */
	public String getManagerID() {
		return managerID;
	}
	/**
	 * @param managerID the managerID to set
	 */
	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Manager(ArrayList<String> data){
		managerID = data.get(0);
		name = data.get(1);	
	}
	
	public boolean approvePR(int prIndex) {
		
		if(!PurchaseReqSystem.pr.get(prIndex).getStatus().equals("approved")){
			PurchaseReqSystem.pr.get(prIndex).setStatus("approved");
			PurchaseReqSystem.pr.get(prIndex).setManagerID(this.managerID);
			PurchaseReqSystem.pr.get(prIndex).setReason("");
			try {
				updatePRStatusDatabase(prIndex);
				return true;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null,"PR status is already " + PurchaseReqSystem.pr.get(prIndex).getStatus() + "! for PR id : " + PurchaseReqSystem.pr.get(prIndex).getPRID(),"Status is the same!",JOptionPane.INFORMATION_MESSAGE );
			return true;
		}
		
	}
	
	
	public boolean rejectPR(int prIndex, String reason) {
		
		if(!PurchaseReqSystem.pr.get(prIndex).getStatus().equals("rejected")){
			
			PurchaseReqSystem.pr.get(prIndex).setStatus("rejected");
			PurchaseReqSystem.pr.get(prIndex).setReason(reason);
			PurchaseReqSystem.pr.get(prIndex).setManagerID(this.managerID);


			try {
				updatePRStatusDatabase(prIndex);
				return true;
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}else {
			JOptionPane.showMessageDialog(null,"PR status is already " + PurchaseReqSystem.pr.get(prIndex).getStatus() + "! for PR id : " + PurchaseReqSystem.pr.get(prIndex).getPRID(),"Status is the same!",JOptionPane.INFORMATION_MESSAGE );
			return true;
		}
		
	}
	
	
	public boolean updatePRStatusDatabase(int prIndex) {

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
			updater.getStatement().execute("UPDATE `purchasereq`.`pr` SET `status` = '"+PurchaseReqSystem.pr.get(prIndex).getStatus()+"', `reason` = '"+PurchaseReqSystem.pr.get(prIndex).getReason()+"' , `managerID` = '"+PurchaseReqSystem.pr.get(prIndex).getManagerID()+"'  WHERE (`PRID` = '"+PurchaseReqSystem.pr.get(prIndex).getPRID()+"')");
			
			JOptionPane.showMessageDialog(null,"PR status is now " + PurchaseReqSystem.pr.get(prIndex).getStatus() + "! for PR id : " + PurchaseReqSystem.pr.get(prIndex).getPRID(),"Status changed succesfully!",JOptionPane.INFORMATION_MESSAGE );
			
			return true;
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"something went wrong , hopefully the following Error message help!" + "\n" + "Error : " + e.getMessage(),"Oops!",JOptionPane.ERROR_MESSAGE );
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
}
