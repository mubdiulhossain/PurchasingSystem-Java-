package PurchaseReq;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class FinanceStaff {
	private String FinanceStaffID;
	private String name;
	private String email;
	private String hphone;
	private String companyID;
	private Company company;


	/**
	 * @return the staffID
	 */
	public String getFinanceStaffID() {
		return FinanceStaffID;
	}

	/**
	 * @param staffID
	 *            the staffID to set
	 */
	public void setFinanceStaffID(String FinanceStaffID) {
		this.FinanceStaffID = FinanceStaffID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHPhone() {
		return hphone;
	}

	public void setHPhone(String phone) {
		this.hphone = phone;
	}

	public String getcompanyID() {
		return companyID;
	}

	public void setcompanyID(String companyID) {
		this.companyID = companyID;
	}

	public FinanceStaff(ArrayList<String> data) {
		FinanceStaffID = data.get(0);
		name = data.get(1);
		email = data.get(3);
		hphone = data.get(4);
		companyID = data.get(5);
	}

	public FinanceStaff() {
		this.company = new Company();
	}

	@Override
	public String toString() {
		return "FinanceStaff [FinanceStaffID=" + FinanceStaffID + ", name=" + name + ", email=" + email + ", hphone="
				+ hphone + "," + " companyID=" + companyID + "]";
	}
	
	public void setCompany(ArrayList<Company> c)
	{
		for(int i=0;i<c.size();i++)
		{
			if(companyID.equals(c.get(i).getCompanyID()))
			{
				this.company = c.get(i);
				break;
			}
		}
	}
	public Company getCompany()
	{
		return company;
	}
	

}
