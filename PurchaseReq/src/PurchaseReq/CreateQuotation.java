package PurchaseReq;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;


public class CreateQuotation {

	private JFrame frmCreateQuotation;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private Vendor Vendor;
	private RFQ RFQ;
	private int itemNo = 1;
	private ArrayList<Item> items = new ArrayList();
	private ArrayList<Integer> quantities = new ArrayList();
	private ArrayList<Double> unitprice = new ArrayList();
	private double subtotal=0 ,overalltotal=0;
	DecimalFormat twoZeroes = new DecimalFormat("#,###.00");
	DecimalFormat noComma = new DecimalFormat("##.00");
	/**
	 * Create the application.
	 */
	public CreateQuotation(RFQ rfq, Vendor VN) {
		this.Vendor = VN;
		this.RFQ = rfq;
		initialize(rfq);
		this.frmCreateQuotation.setVisible(true);
	}
	
	private String getSystemDate() {
		Date system_date = new Date();
		String day = makeDoubleDigit(system_date.getDate());
		String month = makeDoubleDigit(system_date.getMonth()+1);
		String year = new String(Integer.toString(system_date.getYear()+1900));
		String date = year +"/"+ month +"/"+ day ;
		return date;
	}
	
	private String makeDoubleDigit(int number) {		
		if(number < 10) {
			return "0" + number;
		}
		
		return new String(Integer.toString(number));
	}
	
	private String getCompanyInfo(String info) {
		String CompanyInfo=null;
		for (int i = 0; i < PurchaseReqSystem.company.size(); i++) {
			if (RFQ.getCompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("name")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getName();
			} else if (RFQ.getCompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("address")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getAddress().replaceAll(", ", ",\n");
				CompanyInfo=CompanyInfo.replaceAll(", ", ",\n");
			} else if (RFQ.getCompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("phone")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getPhone();
			} else {
				CompanyInfo=PurchaseReqSystem.company.get(i).getCompanyID();
			}
		}
		return CompanyInfo;

	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(RFQ rfq) {
		frmCreateQuotation = new JFrame();
		frmCreateQuotation.setTitle("Create Quotation");
		frmCreateQuotation.setBounds(100, 100, 738, 709);
		frmCreateQuotation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCreateQuotation.getContentPane().setLayout(null);
		
		JLabel lblQuotation = new JLabel("QUOTATION");
		lblQuotation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuotation.setBounds(22, 11, 268, 30);
		frmCreateQuotation.getContentPane().add(lblQuotation);
		
		JLabel lblVendorname = new JLabel(Vendor.getName());
		lblVendorname.setBounds(132, 52, 95, 14);
		frmCreateQuotation.getContentPane().add(lblVendorname);
		
		JTextArea lblVendoraddress = new JTextArea(Vendor.getAddress());
		lblVendoraddress.setBounds(132, 77, 148, 125);
		lblVendoraddress.setEnabled(false);
		lblVendoraddress.setEditable(false);
		lblVendoraddress.setDisabledTextColor(new Color(0, 0, 0));
		lblVendoraddress.setOpaque(false);
		frmCreateQuotation.getContentPane().add(lblVendoraddress);
		
		JLabel label_3 = new JLabel(getSystemDate());
		label_3.setBounds(409, 52, 116, 14);
		frmCreateQuotation.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Date:");
		label_4.setBounds(355, 52, 29, 14);
		frmCreateQuotation.getContentPane().add(label_4);
		
		JLabel lblValidity = new JLabel("Validity:");
		lblValidity.setBounds(345, 82, 55, 14);
		frmCreateQuotation.getContentPane().add(lblValidity);
		
		textField = new JTextField();
		textField.setToolTipText("yyyy/mm/dd");
		textField.setColumns(10);
		textField.setBounds(410, 79, 86, 20);
		frmCreateQuotation.getContentPane().add(textField);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 356, 663, 143);
		frmCreateQuotation.getContentPane().add(scrollPane);
		
		String col[] = {"Item No.","Item","Quantity", "Unit Price (RM)", "Total Price (RM)"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setEnabled(false);

		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);		
		scrollPane.setViewportView(table);
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        	 RequestForQuotation window = new RequestForQuotation(Vendor);
		        	 window.setSize(290,315);
		        	 frmCreateQuotation.dispose();
				
			}
		});
		button.setBounds(233, 618, 100, 35);
		frmCreateQuotation.getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Vendor Name:");
		lblNewLabel.setBounds(36, 52, 86, 14);
		frmCreateQuotation.getContentPane().add(lblNewLabel);
		
		JLabel lblCompanyAddress = new JLabel("Vendor Address:");
		lblCompanyAddress.setBounds(27, 77, 95, 14);
		frmCreateQuotation.getContentPane().add(lblCompanyAddress);
		
		JLabel label = new JLabel(getCompanyInfo("name"));
		label.setBounds(132, 195, 95, 14);
		frmCreateQuotation.getContentPane().add(label);
		
		JTextArea label_1 = new JTextArea(getCompanyInfo("address"));
		label_1.setBounds(132, 213, 148, 125);
		label_1.setEnabled(false);
		label_1.setEditable(false);
		label_1.setDisabledTextColor(new Color(0, 0, 0));
		label_1.setOpaque(false);
		frmCreateQuotation.getContentPane().add(label_1);
		
		JLabel lblBuyerName = new JLabel("Buyer Name:");
		lblBuyerName.setBounds(47, 195, 75, 14);
		frmCreateQuotation.getContentPane().add(lblBuyerName);
		
		JLabel lblNewLabel_1 = new JLabel("Buyer Address:");
		lblNewLabel_1.setBounds(35, 218, 100, 14);
		frmCreateQuotation.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSubtotal = new JLabel("Subtotal:");
		lblSubtotal.setBounds(422, 505, 100, 33);
		frmCreateQuotation.getContentPane().add(lblSubtotal);
		
		JLabel lblDeliveryCost = new JLabel("Delivery Cost:");
		lblDeliveryCost.setBounds(422, 549, 100, 14);
		frmCreateQuotation.getContentPane().add(lblDeliveryCost);
		
		textField_1 = new JTextField();
		textField_1.setBounds(509, 546, 86, 20);
		frmCreateQuotation.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTotal.setBounds(422, 574, 100, 33);
		frmCreateQuotation.getContentPane().add(lblTotal);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(309, 139, 348, 143);
		frmCreateQuotation.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(10, 11, 99, 14);
		panel.add(lblItemName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 36, 99, 14);
		panel.add(lblQuantity);
		
		JLabel lblUnitPricerm = new JLabel("Unit Price (RM):");
		lblUnitPricerm.setBounds(10, 61, 99, 14);
		panel.add(lblUnitPricerm);
		
		textField_3 = new JTextField();
		textField_3.setBounds(119, 33, 75, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(119, 58, 99, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		String[] names = new String[rfq.getSizeOFItemsAndQuantity()];

		for(int i = 0; i < rfq.getSizeOFItemsAndQuantity() ; i++) {
			names[i] = rfq.getItem(i).getName();
		}
		
		JComboBox comboBox = new JComboBox(names);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(119, 7, 208, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(510, 513, 82, 14);
		frmCreateQuotation.getContentPane().add(lblNewLabel_2);
		
		JButton btnAddItem = new JButton("+ Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Double price = new Double(textField_4.getText());
			     Integer quantity = new Integer(textField_3.getText());
				double totalprice=price*quantity;
				Object[] objs = {itemNo+++".", rfq.getItem(comboBox.getSelectedIndex()).getName(), textField_3.getText(), textField_4.getText(),twoZeroes.format(totalprice)};
				items.add(rfq.getItem(comboBox.getSelectedIndex()));
				tableModel.addRow(objs);
		        quantities.add(quantity);
		        unitprice.add(price);	
		        subtotal=subtotal+totalprice;
		        lblNewLabel_2.setText("RM"+twoZeroes.format(subtotal));
			}
		});
		btnAddItem.setBounds(74, 101, 114, 23);
		panel.add(btnAddItem);
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(509, 583, 86, 14);
		frmCreateQuotation.getContentPane().add(lblNewLabel_3);
		
		JButton btnSet = new JButton("SET");
		btnSet.setBounds(617, 545, 69, 23);
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableModel.getRowCount()>0) {
					double Delivery = new Double(textField_1.getText());
					overalltotal=subtotal+Delivery;
					lblNewLabel_3.setText("RM"+twoZeroes.format(overalltotal));
				} else {
					JOptionPane.showMessageDialog(null,"Please insert items first before setting the Delivery Cost." , "Quotation Creation Error",JOptionPane.ERROR_MESSAGE );
					
				}
			}
		});
		frmCreateQuotation.getContentPane().add(btnSet);
		
		
		JButton button_1 = new JButton("Submit");
		button_1.setBounds(396, 618, 100, 35);
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")||tableModel.getRowCount()==0||textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Please fill in all information!" ,"Quotation Creation Failed",JOptionPane.ERROR_MESSAGE );
				} else if (textField.getText().length()!=10) {
					JOptionPane.showMessageDialog(null,"Please fill in the Validity with format yyyy/mm/dd." ,"Quotation Creation Failed",JOptionPane.ERROR_MESSAGE );
				} else if(!textField.getText().substring(4,5).equals("/") || !textField.getText().substring(7,8).equals("/")) {
					JOptionPane.showMessageDialog(null,"Please fill in the Validity with format yyyy/mm/dd." ,"Quotation Creation Failed",JOptionPane.ERROR_MESSAGE );
				} else {
				
					int size = PurchaseReqSystem.quotation.size() - 1;
					String id = PurchaseReqSystem.quotation.get(size).getQuotationID();
					Integer QuotationID = Integer.valueOf(id.substring(2, 6)) + 1;
					String newQuotationID = "QT" + QuotationID;
					
					//Setting up the date from the system				
					String date = getSystemDate();
					
					Quotation newQuotation = new Quotation();
					newQuotation.setDate(date,textField.getText());
					newQuotation.setQuotationID(newQuotationID);
					newQuotation.setCompanyID(getCompanyInfo("CompanyID"));
					newQuotation.setVendorID(Vendor.getVendorID());
					newQuotation.setRFQID(RFQ.getRFQID());
					String formattedTotalPrice = lblNewLabel_3.getText().substring(2).replaceAll(",", "");
					newQuotation.setTotalPrice(Double.parseDouble(formattedTotalPrice));
					
					newQuotation.setDelivery(Double.parseDouble(textField_1.getText()));
					//setting items and quantity
					for(int i = 0; i < items.size(); i++ ) {
						newQuotation.addToItemsAndQuantity(quantities.get(i), items.get(i));
					}
					
					//Updating PR Table and global pr list
					//Relaunching main
					
					try{
						newQuotation.updateDatabase();
						PurchaseReqSystem.quotation.add(newQuotation);
						frmCreateQuotation.dispose();	
						
						//relaunching our main
						RequestForQuotation window = new RequestForQuotation(Vendor);					
					}catch(Exception ex) {
						System.out.println(ex);
					}
					//updating the PR_Item bridge table
					
					for(int i = 0; i < items.size(); i++ ) {
						Quotation_Item new_quotation_item = new Quotation_Item(newQuotation.getQuotationID(),items.get(i).getItemID(),quantities.get(i),unitprice.get(i));
						PurchaseReqSystem.quotation_item.add(new_quotation_item);
						try{
							new_quotation_item.updateDatabase();
						}catch(Exception ex) {
							System.out.println(ex);
						}
					}				
				}
			}
		
		});
		frmCreateQuotation.getContentPane().add(button_1);		
		
	}
}
