package PurchaseReq;


import java.util.ArrayList;
import java.util.Map;

public class Purchase_Order {
	//By Mubdiul: FinanceStaff, Vendor object added. getter and setter added for them
	private String POID;
	private FinanceStaff finance_staffID; 
	private String date;
	private double total_price;
	private Map<Item, Integer> ItemAndQuantity;
	private Vendor vendor; 
	
	private String financeStaff;
	private String vendorID;
	
	public Purchase_Order(ArrayList<String> data) {
		POID = data.get(0);
		this.date = data.get(1);
		this.total_price = Double.parseDouble(data.get(2));
		this.financeStaff = data.get(3);
		this.vendorID = data.get(4);
	}
	public void setInformations(ArrayList<FinanceStaff> f, ArrayList<Vendor> v) //Added by Mubdiul
	{
		for(int i = 0;i<f.size();i++)
		{
			if(financeStaff.equals(f.get(i).getFinanceStaffID()))
			{
				this.finance_staffID = f.get(i);
				break;
			}
					
		}
		for(int i = 0;i<v.size();i++)
		{
			if(vendorID.equals(v.get(i).getVendorID()))
			{
				this.vendor = v.get(i);
			}
		}
	}
	public String getPOID() {
		return POID;
	}
	/**
	 * @param pOID the pOID to set
	 */
	public void setPOID(String pOID) {
		POID = pOID;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the total_price
	 */
	public double getTotal_price() {
		return total_price;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	/**
	 * @return the itemAndQuantity
	 */
	public Map<Item, Integer> getItemAndQuantity() {
		return ItemAndQuantity;
	}
	/**
	 * @param itemAndQuantity the itemAndQuantity to set
	 */
	public void setItemAndQuantity(Map<Item, Integer> itemAndQuantity) {
		this.ItemAndQuantity = itemAndQuantity;
	}
	/**
	 * @return the vendor
	 */
	public Vendor getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	public FinanceStaff getFinance_staffID() {
		return finance_staffID;
	}


	/**
	 * @param finance_staffID the finance_staffID to set
	 */
	public void setFinance_staffID(FinanceStaff finance_staffID) {
		this.finance_staffID = finance_staffID;
	}
	public void Generate() {
		
	}
}
