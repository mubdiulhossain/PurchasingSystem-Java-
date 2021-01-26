package PurchaseReq;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

public class ViewDO extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DeliveryOrder d;
	Object[][] object;
	@SuppressWarnings("serial")
	public ViewDO(DeliveryOrder d, DeliveryOrderMenu dom) {
		this.d = d;
		setTitle("View DO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoid = new JLabel("DOID:");
		lblDoid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoid.setBounds(10, 11, 38, 19);
		contentPane.add(lblDoid);
		
		JLabel lblTestdoidno = new JLabel(d.getDOID());
		lblTestdoidno.setBounds(54, 13, 79, 14);
		contentPane.add(lblTestdoidno);
		
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
		
		JLabel lblShippingAgency = new JLabel("Shipping Agency:");
		lblShippingAgency.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblShippingAgency.setBounds(256, 178, 112, 14);
		contentPane.add(lblShippingAgency);
		
		
		
		JLabel lblNewLabel = new JLabel(d.getVendor().getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(64, 67, 151, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(d.getVendor().getVendorAddress());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_1.setBounds(64, 92, 151, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(d.getVendor().getHphone());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(66, 127, 149, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(d.getFinanceStaff().getCompany().getName());
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setBounds(328, 67, 129, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(d.getFinanceStaff().getCompany().getAddress());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(328, 92, 129, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(d.getFinanceStaff().getCompany().getPhone());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(328, 127, 129, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(d.getPOID().getPOID());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBounds(67, 178, 64, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(d.getDate());
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_7.setBounds(178, 178, 64, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(d.getShippingAgency());
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_8.setBounds(366, 178, 128, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(314, 499, 80, 14);
		contentPane.add(lblSubtotal);
		
		JLabel lblNewLabel_9 = new JLabel(Double.toString(d.getSubTotal()));
		lblNewLabel_9.setBounds(426, 499, 79, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Delivery Fee:");
		lblNewLabel_10.setBounds(309, 524, 85, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel( Double.toString(d.getDeliveryFee()));
		lblNewLabel_11.setBounds(425, 524, 69, 14);
		contentPane.add(lblNewLabel_11);
		
		showTable();
	    
		table = new JTable();
		table.setModel(new DefaultTableModel(
			object,
			new String[] {
				"Item No", "Item Name", "Quantity", "Unit Price", "Total Price"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, Double.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(136);
		table.setRowSelectionAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 251, 505, 237);
		this.getContentPane().add(scrollPane);
		this.setResizable(false);
	}
	public void showTable()
	{
		ArrayList<Item> list = new ArrayList<Item>(d.getItemsAndQuantity().keySet());
		
		object = new Object[d.getItemsAndQuantity().size()][5];
		
		for(int i=0; i<d.getItemsAndQuantity().size(); i++)
		{
			for(int j=0; j<5; j++)
			{
				object[i][j] = new Object[i][j];
				if(j==0)
				{
					object[i][j] = (i+1);
				}
				else
				{
					if(j==1)
					{
						object[i][j] = list.get(i).getName();
					}
					else
					{
						if(j==2)
						{
							object[i][j] = d.getItemsAndQuantity().get(list.get(i));
						}
						else
						{
							if(j==3)
							{
								object[i][j] = list.get(i).getPrice();
							}
							else
							{
								if(j==4)
								{
									object[i][j] = list.get(i).getPrice()*d.getItemsAndQuantity().get(list.get(i));
								}
							}
						}
					}
				}
			}
		}
	}
}
