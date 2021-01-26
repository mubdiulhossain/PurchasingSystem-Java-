package PurchaseReq;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreateDO extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField doIDTextField;
	private JTextField shippingAgencyTF;
	private JTextField dfTF;
	private JLabel subtotallbl;
	private ArrayList<Item> itemList;
	private DeliveryOrder deliveryOrder;
	private ArrayList<Item> list;
	private Object[][] object;
	private Map<Item,Integer> copy;
	DeliveryOrderMenu dom;
	private Vendor vendor = new Vendor();
	private PO po;

	
	public CreateDO(PO po, ArrayList<DeliveryOrder> dO, FinanceStaff loggedIn, initiation db, DeliveryOrderMenu dom) {
		deliveryOrder = new DeliveryOrder();
		this.po = po;
		this.dom=dom;
		setTitle("Create DO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoid = new JLabel("DOID:");
		lblDoid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoid.setBounds(10, 11, 38, 19);
		contentPane.add(lblDoid);
		String dOidLabel = "DO000"+(dO.size()+1);
		if(dO.size()>9)
		{
			dOidLabel = "DO00"+(dO.size()+1);
		}
		else
		{
			if(dO.size()>99)
			{
				dOidLabel = "DO0"+(dO.size()+1);
			}
		}
		
		copy = new HashMap<Item, Integer>();
		
		for(int i = 0 ; i < po.getSizeOFItemsAndQuantity(); i++) {
			copy.put(po.getItem(i), po.getQuantity(i));
		}
		
		
		itemList = new ArrayList<Item>(copy.keySet());
		
		doIDTextField = new JTextField(dOidLabel);
		doIDTextField.setEditable(false);
		doIDTextField.setBounds(58, 10, 151, 20);
		contentPane.add(doIDTextField);
		doIDTextField.setColumns(10);
		this.setResizable(false);
		
		JLabel lblVendor = new JLabel("Vendor");
		lblVendor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVendor.setBounds(10, 42, 46, 14);
		contentPane.add(lblVendor);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblName.setBounds(10, 67, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblAddress.setBounds(10, 92, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPhone.setBounds(10, 127, 46, 14);
		contentPane.add(lblPhone);
		
		JLabel lblBuyer = new JLabel("Buyer");
		lblBuyer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBuyer.setBounds(272, 43, 46, 14);
		contentPane.add(lblBuyer);
		
		JLabel label = new JLabel("Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 10));
		label.setBounds(272, 67, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Address:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_1.setBounds(272, 92, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Phone:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_2.setBounds(272, 127, 46, 14);
		contentPane.add(label_2);
		
		JLabel lblPoid = new JLabel("POID:");
		lblPoid.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblPoid.setBounds(29, 178, 46, 14);
		contentPane.add(lblPoid);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDate.setBounds(141, 178, 38, 14);
		contentPane.add(lblDate);
		
		for(Vendor v: PurchaseReqSystem.vendor) {
			if(v.getVendorID().equals(po.getVendorID())) {
				vendor = v;
			}
		}
		
		JLabel lblVname = new JLabel(vendor.getName());
		lblVname.setBounds(58, 67, 151, 14);
		contentPane.add(lblVname);
		
		JLabel lblVaddress = new JLabel(vendor.getAddress());
		lblVaddress.setBounds(58, 92, 151, 14);
		contentPane.add(lblVaddress);
		
		JLabel lblVPhone = new JLabel(vendor.getHphone());
		lblVPhone.setBounds(58, 127, 151, 14);
		contentPane.add(lblVPhone);
		
		JLabel lblBname = new JLabel(loggedIn.getCompany().getName());
		lblBname.setBounds(328, 67, 151, 14);
		contentPane.add(lblBname);
		
		JLabel lblBAdd = new JLabel(loggedIn.getCompany().getAddress());
		lblBAdd.setBounds(328, 92, 151, 14);
		contentPane.add(lblBAdd);
		
		JLabel lblbPhone = new JLabel(loggedIn.getCompany().getPhone());
		lblbPhone.setBounds(328, 127, 151, 14);
		contentPane.add(lblbPhone);
		
		
		JLabel lblShippingAgency = new JLabel("Shipping Agency:");
		lblShippingAgency.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblShippingAgency.setBounds(256, 178, 112, 14);
		contentPane.add(lblShippingAgency);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		JLabel lbldate = new JLabel(timeStamp);
		lbldate.setFont(new Font("Tahoma", Font.BOLD, 10));
		lbldate.setBounds(141, 203, 94, 19);
		contentPane.add(lbldate);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(314, 499, 80, 14);
		contentPane.add(lblSubtotal);
		
		subtotallbl = new JLabel("");
		subtotallbl.setBounds(420, 499, 85, 20);
		contentPane.add(subtotallbl);
		
		JLabel lblNewLabel_10 = new JLabel("Delivery Fee:");
		lblNewLabel_10.setBounds(309, 524, 85, 14);
		contentPane.add(lblNewLabel_10);
		
		//ArrayList<Item> list = new ArrayList<Item>(d.getItemsAndQuantity().keySet());
		
		setTable();
		table = new JTable();
		table.setModel(new DefaultTableModel(
			object,
			new String[] {
				"Action","Item No", "Item Name", "Quantity", "Unit Price", "Total Price"
			}
		) {
			Class[] columnTypes = new Class[] {
					Object.class, Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.setRowSelectionAllowed(false);
		table.getColumn("Action").setCellRenderer(new ButtonRendererCreate());
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			    	JTable target = (JTable)e.getSource();
				     int row = target.getSelectedRow();
				     if(target.getSelectedColumn() == 0)
				     {
				    	 copy.remove(itemList.get(row));
					     ((DefaultTableModel) table.getModel()).removeRow(row);
					     setTable();
				     }
			    }
			  }
			});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 251, 495, 237);
		this.getContentPane().add(scrollPane);
		
		shippingAgencyTF = new JTextField();
		shippingAgencyTF.setBounds(256, 202, 166, 20);
		contentPane.add(shippingAgencyTF);
		shippingAgencyTF.setColumns(10);
		
		dfTF = new JTextField("0.0");
		dfTF.setBounds(419, 524, 86, 20);
		contentPane.add(dfTF);
		dfTF.setColumns(10);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(328, 13, 166, 20);
		contentPane.add(lblError);
		
		JLabel lblPoid_1 = new JLabel(po.getPOID());
		lblPoid_1.setBounds(29, 203, 85, 19);
		contentPane.add(lblPoid_1);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				{
					
					if(shippingAgencyTF.getText().equals(""))
					{
						lblError.setText("Fill in empty field(s)");
					}
					else
					{
						
						deliveryOrder.setDate(lbldate.getText());
						deliveryOrder.setDOID(doIDTextField.getText());
						deliveryOrder.setFinanceStaff(loggedIn);
						deliveryOrder.setPOID(po);
						deliveryOrder.setVendor(vendor);
						deliveryOrder.setShippingAgency(shippingAgencyTF.getText());
						deliveryOrder.setSubTotal(Double.parseDouble(subtotallbl.getText()));
						for(int i=0;i<copy.size();i++)
						{
							copy.replace(list.get(i), (Integer) table.getValueAt(i, 3));	
						}
						deliveryOrder.setItemsAndQuantity(copy);
						deliveryOrder.setDeliveryFee(Double.parseDouble(dfTF.getText()));
						int count =0;
						for(int i=0;i<dO.size();i++)
						{
							if(dO.get(i)==deliveryOrder)
							{
								count++;
								break;
							}
						}
						if(count==0)
						{
							try {
								
								 Connection conn = db.getConnection();
							      
							      //Statement st = conn.createStatement();
							      String queryDO = " insert into delivery_order (do_id, finance_staffID, date, subtotal, poid, vendor_id, shipping_agency, delivery_fee)"
							    	        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
							      String queryDOItem = "INSERT INTO do_item (do_id, itemID, quantity, subTotal)"
							    	        + " values (?, ?, ?, ?)";
							      PreparedStatement preparedStmt = conn.prepareStatement(queryDO);
							      PreparedStatement preparedStmt1 = conn.prepareStatement(queryDOItem);
							      preparedStmt.setString (1, deliveryOrder.getDOID());
					    	      preparedStmt.setString (2, deliveryOrder.getFinanceStaff().getFinanceStaffID());
					    	      preparedStmt.setString (3, deliveryOrder.getDate());
					    	      preparedStmt.setDouble (4, deliveryOrder.getSubTotal());
					    	      preparedStmt.setString (5, deliveryOrder.getPOID().getPOID());
					    	      preparedStmt.setString (6, deliveryOrder.getVendor().getVendorID());
					    	      preparedStmt.setString (7, deliveryOrder.getShippingAgency());
					    	      preparedStmt.setDouble (8, deliveryOrder.getDeliveryFee() );
					    	      
					    	      preparedStmt.execute();
					    	      
					    	      for(int i=0;i<copy.size();i++)
					    	      {
					    	    	  preparedStmt1.setString (1, deliveryOrder.getDOID());
						    	      preparedStmt1.setString (2, list.get(i).getItemID());
						    	      preparedStmt1.setInt (3, deliveryOrder.getItemsAndQuantity().get(list.get(i)));
						    	      preparedStmt1.setDouble (4, list.get(i).getPrice()*deliveryOrder.getItemsAndQuantity().get(list.get(i)));
						    	      preparedStmt1.execute();
					    	      }
					    	      dispose();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								lblError.setText("Failed to save in database");
								e.printStackTrace();
							}
							//"INSERT INTO `delivery_order` (`do_id`, `finance_staffID`, `date`, `subtotal`, `poid`, `vendor_id`, `shipping_agency`, `delivery_fee`
							dO.add(deliveryOrder);
							dom.updateTable();
						}
						
						System.out.println(dO.get(dO.size()-1).getDOID());
						
					}
				}
			}
		});
		btnOk.setBounds(420, 570, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(305, 570, 89, 23);
		contentPane.add(btnCancel);
	}
	private void setTable()
	{
		list = new ArrayList<Item>(copy.keySet());
		object = new Object[copy.size()][6];
		double subtotal = 0;
		for(int i=0; i<copy.size(); i++)
		{
			for(int j=0; j<6; j++)
			{
				object[i][j] = new Object[i][j];
				if(j==0)
				{
					object[i][j] = "";
				}
				else
				{
					if(j==1)
					{
						object[i][j] = (i+1);
					}
					else
					{
						if(j==2)
						{
							object[i][j] = list.get(i).getName();;
						}
						else
						{
							if(j==3)
							{
								object[i][j] = copy.get(list.get(i));
							}
							else
							{
								if(j==4)
								{
									object[i][j] = list.get(i).getPrice();
								}
								else
								{
									if(j==5)
									{
										object[i][j] = list.get(i).getPrice()*copy.get(list.get(i));
										subtotal = subtotal+list.get(i).getPrice()*copy.get(list.get(i));
										
									}
								}
							}
						}
					}
				}
			}
		}
		subtotallbl.setText(""+subtotal);
	}
	
}
