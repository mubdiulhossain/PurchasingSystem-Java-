package PurchaseReq;



public class Invoice_Item {
	private String itemName;
	private int quantity;
	private double unitPrice;
	private double totalPrice;
	
	public Invoice_Item(String itemName, int quantity,double unitPrice,double totalPrice)
	{
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
	}
	public String getName()
	{
		return itemName;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public double getunitPrice()
	{
		return unitPrice;
	}
	public double gettotalPrice()
	{
		return totalPrice;
	}
		
}
