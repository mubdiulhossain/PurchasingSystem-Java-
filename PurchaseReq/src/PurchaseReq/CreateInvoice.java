package PurchaseReq;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class CreateInvoice extends JFrame {

	private JPanel contentPane;
	private JButton btnAddItem;
	private JTextField vendorName;
	private JTextField item_quantity;
	private JComboBox comboBox;
	private JComboBox deliverycomboBox;
	private JLabel subtotal;
	private JLabel Total_End;
	private JTextField deliveryCost;
	private String financeStaffID;
	
	Invoice voice = new Invoice();
	private ArrayList<Invoice_Item>Item = new ArrayList();
    private static int  item_No1 = 1;
 
    
    public CreateInvoice(String financeStaffID)
    {
    	super("CREATE INVOICE");
    	this.financeStaffID = financeStaffID;
    	createInvoiceWindow();
    	//getComboxItem();
    	getDeliveryId();
    	
    }
	public void createInvoiceWindow()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 659, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel date_M = new JLabel("Date : ");
		date_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date_M.setBounds(469, 21, 46, 14);
		contentPane.add(date_M);
		
		JLabel date = new JLabel("");
		date.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date.setBounds(539, 21, 80, 14);
		contentPane.add(date);
		
		JLabel companyAddress = new JLabel("<html>Persiaran Multimedia,<br> 63100, Cyberjaya, <br> Malaysia.</html>");
		companyAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyAddress.setBounds(10, 49, 352, 54);
		contentPane.add(companyAddress);
		
		JLabel companyPhone = new JLabel();
		companyPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyPhone.setText("0182137783");
		companyPhone.setBounds(10, 114, 236, 14);
		contentPane.add(companyPhone);
		
		JLabel payTo = new JLabel("PAY TO");
		payTo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		payTo.setBounds(87, 159, 80, 14);
		contentPane.add(payTo);
		
		JLabel vendorName_M = new JLabel("Vendor Name :");
		vendorName_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		vendorName_M.setBounds(10, 198, 116, 14);
		contentPane.add(vendorName_M);
		
		vendorName = new JTextField();
		vendorName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		vendorName.setBounds(138, 195, 154, 20);
		contentPane.add(vendorName);
		vendorName.setColumns(10);
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		date.setText(s.format(d));
		
		JLabel item_M = new JLabel("Item : ");
		item_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		item_M.setBounds(355, 136, 78, 14);
		contentPane.add(item_M);
		
		 comboBox = new JComboBox();
		 comboBox.setBackground(Color.WHITE);
		 comboBox.setForeground(new Color(0, 0, 0));
		 comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setBounds(466, 130, 137, 20);
		contentPane.add(comboBox);
		
		JLabel lblQuantity = new JLabel("Quantity : ");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblQuantity.setBounds(355, 167, 93, 14);
		contentPane.add(lblQuantity);
		
		item_quantity = new JTextField();
		item_quantity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		item_quantity.setBounds(466, 161, 137, 20);
		contentPane.add(item_quantity);
		item_quantity.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 262, 623, 237);
		contentPane.add(scrollPane);
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBackground(Color.WHITE);
		btnAddItem.setForeground(new Color(46, 139, 87));
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		Object[] columns = {"Item No", "item Name", "Quantity", "Unit Price", "Total Price"};
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(columns);
	    table.setModel(model);
	    Object[] row = new Object[5];
	    String No = Integer.toString(item_No1);
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String No = Integer.toString(item_No1);
				
				String quan =  item_quantity.getText();
				
				double price = 0;
				for(int i = 0; i < PurchaseReqSystem.item.size(); i++) {
					if(PurchaseReqSystem.item.get(i).getName().equals(comboBox.getSelectedItem())) {
						 price = PurchaseReqSystem.item.get(i).getPrice();
					}
				}
				
				
				String uprice =  String.valueOf(price);
				
				int quantity = Integer.parseInt(quan);
				double unit = Double.valueOf(uprice);
				
				voice.totalPrice(quantity, unit);
				double Total = voice.returntotalPrice();
				String tPrice = Double.toString(Total);
				
				row[0] = No;
				row[1] = comboBox.getSelectedItem();
				row[2] = item_quantity.getText();
				row[3] = uprice;
				row[4] = tPrice;
				model.addRow(row);
				Invoice_Item item = new Invoice_Item((String)comboBox.getSelectedItem(),quantity, unit,Total);
				Item.add(item);
				voice.Invoice_Item(Item);
				double sub = voice.getPrice();
				String subT = Double.toString(sub);
				subtotal.setText(subT);
				item_No1++;
			}
		
		});
		btnAddItem.setBounds(436, 228, 89, 23);
		contentPane.add(btnAddItem);
		
		JLabel subtotal_M = new JLabel("Subtotal : ");
		subtotal_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		subtotal_M.setBounds(391, 527, 72, 14);
		contentPane.add(subtotal_M);
		
		 subtotal = new JLabel();
		subtotal.setBounds(511, 527, 122, 14);
		contentPane.add(subtotal);
		
		JLabel deliveryCost_M = new JLabel("Delivery Cost : ");
		deliveryCost_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		deliveryCost_M.setBounds(390, 555, 93, 14);
		contentPane.add(deliveryCost_M);
		
		deliveryCost = new JTextField();
		deliveryCost.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				
					String delivery;
					double deliverycost = 0;
					delivery = deliveryCost.getText();
					deliverycost = Double.valueOf(delivery);
					voice.setTotalPrice(deliverycost);
					Total_End.setText(Double.toString(voice.getTotalPrice()));
					btnAddItem.setEnabled(false);
				
			}
		});
		deliveryCost.setBounds(511, 552, 122, 20);
		contentPane.add(deliveryCost);
		deliveryCost.setColumns(10);
		
		JLabel total_M = new JLabel("Total : ");
		total_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		total_M.setBounds(390, 583, 46, 14);
		contentPane.add(total_M);
		
		Total_End = new JLabel();
		Total_End.setText("");
		Total_End.setBounds(511, 583, 122, 14);
		contentPane.add(Total_End);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(512, 463, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton submit = new JButton("Submit");
		submit.setBackground(Color.WHITE);
		submit.setForeground(new Color(46, 139, 87));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = vendorName.getText();
				voice.getVendorDetails(Name);
				voice.getDeliveryId((String)deliverycomboBox.getSelectedItem());
				voice.updateInvoice(financeStaffID);
				voice.updateItem();
				JOptionPane.showMessageDialog(null, "New Invoice Created!");
			}
		});
		submit.setBounds(273, 630, 89, 23);
		contentPane.add(submit);
		
		deliverycomboBox = new JComboBox();
		deliverycomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getComboxItem();
			}
		});
		deliverycomboBox.setBounds(449, 83, 154, 20);
		contentPane.add(deliverycomboBox);
		
		JLabel lblDeliveryId = new JLabel("Delivery ID :");
		lblDeliveryId.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDeliveryId.setBounds(327, 89, 106, 14);
		contentPane.add(lblDeliveryId);
		
		JLabel companyName = new JLabel("Multimedia University Sdn Bhd. ");
		companyName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		companyName.setBounds(10, 21, 352, 29);
		contentPane.add(companyName);
		
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}
	
	public void getComboxItem() 
	{	
		comboBox.removeAllItems();
		ArrayList<Item>list;
	
		for(int i = 0; i < PurchaseReqSystem.DO.size(); i++) {
			if(PurchaseReqSystem.DO.get(i).getDOID().equals(deliverycomboBox.getSelectedItem())) {
				System.out.println("hi");

				list = new ArrayList<Item>(PurchaseReqSystem.DO.get(i).getItemsAndQuantity().keySet());
				for(int j = 0 ;j < list.size(); j++) {
					System.out.println(list.get(j).getName());
					comboBox.addItem(list.get(j).getName());
				}
			}
		}
		
		
		
	}
	public void getDeliveryId()
	{
		ArrayList<String>list = new ArrayList();
		list = voice.filledDelivery_Comboxbox();
		try {
			for(int i = 0; i < list.size(); i++)
			{
				deliverycomboBox.addItem(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

