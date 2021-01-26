package PurchaseReq;

import java.util.ArrayList;

public class Company {
	public Company() {
	}

	private String companyID;
	private String name;
	private String address;
	private String phone;
	
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Company(ArrayList<String> data){
		companyID = data.get(0);
		address = data.get(1);
		name = data.get(2);
		phone = data.get(3);
	}
	
	public Company(String name, String Address, String phone){
		this.name = name;
		this.address = Address;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Company [CompanyID=" + companyID + ", address=" + address + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
}