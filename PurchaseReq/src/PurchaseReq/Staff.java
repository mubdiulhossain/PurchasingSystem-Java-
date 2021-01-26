package PurchaseReq;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Staff {
	private String staffID;
	private String name;
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
	
	public Staff(ArrayList<String> data){
		staffID = data.get(0);
		name = data.get(1);
	}
	
	@Override
	public String toString() {
		return "Staff [staffID=" + staffID + ", name=" + name + "]";
	}
	
	
}
