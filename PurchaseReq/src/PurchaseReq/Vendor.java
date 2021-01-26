package PurchaseReq;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class Vendor {
	private String VendorID;
	private String name;
	private String address;
	private String email;
	private String hphone;
	
	public Vendor() {
		
	}
	public String getVendorID() {
		return VendorID;
	}
	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		address=address.replaceAll(", ", ",\n");
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	
	public Vendor(ArrayList<String> data){
		VendorID = data.get(0);
		name = data.get(1);
		address = data.get(2);
		email = data.get(3);
		hphone = data.get(4);
	}
	
	@Override
	public String toString() {
		return "Vendor [VendorID=" + VendorID + ", name=" + name + ", address=" + address + ", email=" + email + ","
				+ " hphone=" + hphone + "]";
	}
	
	public String getVendorAddress()
	{
		return address;
	}
}