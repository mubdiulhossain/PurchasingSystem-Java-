package PurchaseReq;



import java.util.ArrayList;
import java.util.Map;

public class DeliveryOrder
{
	private PO purchaseOrder; // this will be changed to PurchaseOrder when i will have the purchase order class
	private String financeStaff;
	private FinanceStaff fs;
	private String date;
	private Double subTotal;
	private Map<Item, Integer> itemsAndQuantity;
	private String vendor;
	private Vendor v;
	private String doID;
	private String shippingAgency;
	private Double deliveryFee;
	private String poID;
	
	public DeliveryOrder()
	{
		
	}
	
	public DeliveryOrder(ArrayList<String> s)
	{
		this.doID = s.get(0);
		this.financeStaff = s.get(1);
		this.date = s.get(2);
		this.subTotal = Double.parseDouble(s.get(3));
		this.poID = s.get(4);
		this.vendor = s.get(5);
		this.shippingAgency = s.get(6);
		this.deliveryFee = Double.parseDouble(s.get(7));
	}
	public void setInformations(ArrayList<FinanceStaff> f, ArrayList<Vendor> v, ArrayList<PO> po)
	{
		for(int i = 0;i<f.size();i++)
		{
			if(financeStaff.equals(f.get(i).getFinanceStaffID()))
			{
				this.fs = f.get(i);
				break;
			}
					
		}
		for(int i = 0;i<v.size();i++)
		{
			if(vendor.equals(v.get(i).getVendorID()))
			{
				this.v = v.get(i);
			}
		}
		for(int i = 0;i<po.size();i++)
		{
			if(poID.equals(po.get(i).getPOID()))
			{
				this.purchaseOrder = po.get(i);
			}
		}
	}
	public String getDOID()
	{
		return doID;
	}
	public void setDOID(String doID)
	{
		this.doID = doID;
	}
	public FinanceStaff getFinanceStaff()
	{
		return fs;
	}
	public void setFinanceStaff(FinanceStaff fs)
	{
		this.fs = fs;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public double getSubTotal()
	{
		return subTotal;
	}
	public void setSubTotal(Double subTotal)
	{
		this.subTotal = subTotal;
	}
	public Vendor getVendor()
	{
		return v;
	}
	public void setVendor(Vendor v)
	{
		this.v = v;
	}
	public String getShippingAgency()
	{
		return shippingAgency;
	}
	public void setShippingAgency(String shippingAgency)
	{
		this.shippingAgency = shippingAgency;
	}
	public Double getDeliveryFee()
	{
		return deliveryFee;
	}
	public void setDeliveryFee(Double deliveryFee)
	{
		this.deliveryFee = deliveryFee;
	}
	public PO getPOID()
	{
		return purchaseOrder;
	}
	public void setPOID(PO purchaseOrder)
	{
		this.purchaseOrder = purchaseOrder;
	}
	
	public void setItemsAndQuantity(Map<Item, Integer> itemsAndQuantity)
	{
		this.itemsAndQuantity=itemsAndQuantity;
	}
	public Map<Item, Integer> getItemsAndQuantity()
	{
		return itemsAndQuantity;
	}
}
