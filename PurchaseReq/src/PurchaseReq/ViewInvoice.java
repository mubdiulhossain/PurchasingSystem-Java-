package PurchaseReq;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ViewInvoice extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel invoiceId;
	private JLabel vendorName;
	private JLabel vendorAddress;
	private JLabel vendorPhone;
	private JLabel totalPrice;
	private JLabel subTotal;
	private JLabel deliveryCost;
	private ArrayList<Invoice_Item>itemList = new ArrayList();
	private ArrayList<String>invoice = new ArrayList();
	
	public ViewInvoice(String id) {
		super("INVOICE");
		Invoice voice = new Invoice();
		setBackground(SystemColor.desktop);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel date_M = new JLabel("Date :");
		date_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date_M.setBounds(483, 41, 60, 14);
		contentPane.add(date_M);
		
		JLabel date = new JLabel();
		date.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date.setBounds(542, 41, 98, 14);
		contentPane.add(date);
		
		JLabel invoiceId_M = new JLabel("Invoice Id : ");
		invoiceId_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		invoiceId_M.setBounds(10, 11, 83, 14);
		contentPane.add(invoiceId_M);
		
		
		JLabel companyName = new JLabel("Multimedia University Sdn Bhd. ");
		companyName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyName.setBounds(10, 69, 427, 14);
		contentPane.add(companyName);
		
		JLabel companyAddress = new JLabel("<html>Persiaran Multimedia,<br> 63100, Cyberjaya, <br> Malaysia.</html>");
		companyAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyAddress.setBounds(10, 82, 452, 58);
		contentPane.add(companyAddress);
		
		JLabel companyPhone = new JLabel("0182137783");
		companyPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyPhone.setBounds(10, 140, 149, 25);
		contentPane.add(companyPhone);
		
		JLabel payTo = new JLabel("PAY TO");
		payTo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		payTo.setBounds(99, 183, 60, 14);
		contentPane.add(payTo);
		
		JLabel vendorName_M = new JLabel("Vendor Name :");
		vendorName_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorName_M.setBounds(10, 227, 102, 14);
		contentPane.add(vendorName_M);
		
		JLabel VendorAddress_M = new JLabel("Vendor Address : ");
		VendorAddress_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		VendorAddress_M.setBounds(10, 250, 102, 14);
		contentPane.add(VendorAddress_M);
		
		JLabel vendorPhone_M = new JLabel("Vendor Phone : ");
		vendorPhone_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorPhone_M.setBounds(10, 275, 102, 14);
		contentPane.add(vendorPhone_M);
		JLabel lblSubtotal = new JLabel("Subtotal :  ");
		lblSubtotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSubtotal.setBounds(366, 556, 108, 14);
		contentPane.add(lblSubtotal);
		JLabel lblDeliveryPrice = new JLabel("Delivery Cost :");
		lblDeliveryPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeliveryPrice.setBounds(366, 581, 102, 14);
		contentPane.add(lblDeliveryPrice);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTotal.setBounds(366, 606, 98, 14);
		contentPane.add(lblTotal);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 310, 630, 174);
		contentPane.add(scrollPane);
		
		
		invoiceId = new JLabel();
		invoiceId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		invoiceId.setBounds(103, 11, 274, 14);
		contentPane.add(invoiceId);
		invoiceId.setText(id);
		
		vendorName = new JLabel();
		vendorName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorName.setBounds(171, 227, 221, 14);
		contentPane.add(vendorName);
		
	    vendorAddress = new JLabel();
	    vendorAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorAddress.setBounds(171, 250, 266, 14);
		contentPane.add(vendorAddress);
		
		vendorPhone = new JLabel();
		vendorPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorPhone.setBounds(171, 275, 266, 14);
		contentPane.add(vendorPhone);
		
		totalPrice = new JLabel();
		totalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		totalPrice.setBounds(497, 606, 108, 14);
		contentPane.add(totalPrice);
		
		JLabel lblPaymentStatus = new JLabel("Payment Status :");
		lblPaymentStatus.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblPaymentStatus.setBounds(10, 36, 118, 14);
		contentPane.add(lblPaymentStatus);
		
		JLabel payment_Status = new JLabel("");
		payment_Status.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		payment_Status.setBounds(141, 37, 139, 14);
		contentPane.add(payment_Status);
		
		subTotal = new JLabel();
		subTotal.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		subTotal.setBounds(497, 556, 108, 14);
		contentPane.add(subTotal);
		JLabel lblDeliveryId = new JLabel("Delivery ID : ");
		lblDeliveryId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeliveryId.setBounds(407, 151, 83, 14);
		contentPane.add(lblDeliveryId);
		
		JLabel deliverId  = new JLabel("");
		deliverId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		deliverId.setBounds(500, 152, 127, 14);
		contentPane.add(deliverId);
		
		deliveryCost = new JLabel();
		deliveryCost.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		deliveryCost.setBounds(497, 581, 108, 14);
		contentPane.add(deliveryCost);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[] columns = {"Itm No", "item Name", "Quantity", "Unit Price", "Total Price"};
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    Object[] row = new Object[5];
	    int item_No1 = 1;
	    voice.retrieveItemFromDatabase(id);
		itemList = voice.getItemList();
	    for(Invoice_Item itemlist : itemList)
	    {
	    	String No = Integer.toString(item_No1);
	    	row[0] = No;
			row[1] = itemlist.getName();
			row[2] = itemlist.getQuantity();
			row[3] = itemlist.getunitPrice();
			row[4] = itemlist.gettotalPrice();
		    model.addRow(row);
		    item_No1++;
		   
	    }
		voice.retrieveVendorInvoiceFromDatabase(id);
		invoice = voice.getInvoice();
		String a = invoice.get(0);
		vendorName.setText(a);
		vendorAddress.setText(invoice.get(1));
		vendorPhone.setText(invoice.get(2));
		date.setText(invoice.get(3));
		subTotal.setText(invoice.get(4));
		deliveryCost.setText(invoice.get(5));
		totalPrice.setText(invoice.get(6));
		deliverId.setText(invoice.get(7));
		payment_Status.setText(invoice.get(8));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
}
