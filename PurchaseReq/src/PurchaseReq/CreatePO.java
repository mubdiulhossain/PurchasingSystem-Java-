package PurchaseReq;


import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout.*;
import javax.swing.LayoutStyle.*;
import java.util.*;

@SuppressWarnings({ "deprecation", "unused" })
public class CreatePO {

	private JFrame frmCreatePo;
	
	private JTable table;
	private FinanceStaff finance;
	private JTable table_1;
	private String vendorID;
	private Vendor vendor = new Vendor();
	private PO po;
	private Quotation quotation;
	private JTextField textFieldCname;
	private JTextField textFieldCHphone;

	/**
	 * Create the application.
	 */
	public CreatePO(Quotation quotation , FinanceStaff finance) {
		this.finance = finance;
//		this.vendorID = (String)vendorID;
//	this.po = po;
		this.quotation = quotation;
		getVendor();
		initialize();
		this.frmCreatePo.setVisible(true);
	}
	
	private void getVendor() {
		
		for(Vendor r: PurchaseReqSystem.vendor) {
			if(r.getVendorID().equals(vendorID)) {
				vendor = r;
			}
		}
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCreatePo = new JFrame();
		frmCreatePo.setTitle("Finance - Create PO");
		frmCreatePo.setVisible(true);
		frmCreatePo.setBounds(100, 100, 760, 824);
		frmCreatePo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCreatePo.getContentPane().setLayout(null);
		
		
		/**
		 * 
		 * FRAME & COMPONENTS
		 * 
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 358, 728, 302);
		frmCreatePo.getContentPane().add(scrollPane);
		
		JLabel lblPurchaseOrder = new JLabel("PURCHASE ORDER");
		lblPurchaseOrder.setBounds(10, 12, 200, 15);
		lblPurchaseOrder.setFont(new Font("Times", Font.BOLD, 18));
		frmCreatePo.getContentPane().add(lblPurchaseOrder);
		
		JLabel labelCname = new JLabel("<dynamic company>");
		labelCname.setBounds(12, 51, 145, 15);
		frmCreatePo.getContentPane().add(labelCname);
		
		JLabel labelCAddress = new JLabel("<Address>");
		labelCAddress.setBounds(12, 78, 314, 89);
		frmCreatePo.getContentPane().add(labelCAddress);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(524, 12, 47, 15);
		frmCreatePo.getContentPane().add(lblDate);
		
		JLabel labelDDATE = new JLabel(getSystemDate());
		labelDDATE.setBounds(570, 13, 78, 15);
		frmCreatePo.getContentPane().add(labelDDATE);
		
		JPanel panelVendor = new JPanel();
		panelVendor.setBounds(12, 226, 359, 115);
		frmCreatePo.getContentPane().add(panelVendor);
		panelVendor.setLayout(null);
		
		JLabel lblVendorName = new JLabel("Vendor Name:");
		lblVendorName.setBounds(17, 12, 100, 15);
		panelVendor.add(lblVendorName);
		
		JLabel labelVname = new JLabel("<dynamic>");
		labelVname.setBounds(119, 12, 207, 15);
		panelVendor.add(labelVname);
		
		JLabel lblVendorAddress = new JLabel("Vendor Address:");
		lblVendorAddress.setBounds(0, 50, 129, 15);
		panelVendor.add(lblVendorAddress);
		
		JLabel labelVAddress = new JLabel("<dynamic>");
		labelVAddress.setBounds(119, 50, 207, 15);
		panelVendor.add(labelVAddress);
		
		JLabel lblVendorPhone = new JLabel("Vendor Phone:");
		lblVendorPhone.setBounds(12, 88, 122, 15);
		panelVendor.add(lblVendorPhone);
		
		JLabel labelVHphone = new JLabel("<dynamic>");
		labelVHphone.setBounds(119, 88, 207, 15);
		panelVendor.add(labelVHphone);
		
		JPanel panelShipTo = new JPanel();
		panelShipTo.setBounds(383, 39, 357, 302);
		frmCreatePo.getContentPane().add(panelShipTo);
		panelShipTo.setLayout(null);
		
		JLabel lblShipTo = new JLabel("SHIP TO");
		lblShipTo.setBounds(157, 0, 60, 15);
		panelShipTo.add(lblShipTo);
		
		JLabel lblCompanyName = new JLabel("Company Name:");
		lblCompanyName.setBounds(12, 66, 114, 15);
		panelShipTo.add(lblCompanyName);
		
		JLabel lblCompanyAddress = new JLabel("Company Address:");
		lblCompanyAddress.setBounds(12, 93, 137, 15);
		panelShipTo.add(lblCompanyAddress);
		
		JLabel lblCompanyPhone = new JLabel("Company Phone:");
		lblCompanyPhone.setBounds(12, 268, 127, 15);
		panelShipTo.add(lblCompanyPhone);
		
		textFieldCname = new JTextField();
		textFieldCname.setToolTipText("Address to be shipped to");
		textFieldCname.setBounds(135, 64, 210, 19);
		panelShipTo.add(textFieldCname);
		textFieldCname.setColumns(10);
		
		JTextArea textAreaCAddress = new JTextArea();
		textAreaCAddress.setBounds(157, 93, 188, 164);
		panelShipTo.add(textAreaCAddress);
		
		
		
		textFieldCHphone = new JTextField();
		textFieldCHphone.setBounds(135, 266, 210, 19);
		panelShipTo.add(textFieldCHphone);
		textFieldCHphone.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(547, 704, 47, 15);
		frmCreatePo.getContentPane().add(lblTotal);
		
		JLabel labelDTotal = new JLabel(String.valueOf(quotation.getTotalPrice()));
		labelDTotal.setBounds(606, 704, 79, 15);
		frmCreatePo.getContentPane().add(labelDTotal);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(254, 754, 117, 25);
		frmCreatePo.getContentPane().add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(383, 754, 117, 25);
		frmCreatePo.getContentPane().add(btnSubmit);
		
		/**
		 * 
		 * TABLE STRUCTURE
		 * 
		 */
        
		Object col[] = {"Item No.","Item","Quantity", "Price"};
		Object[][] row = new Object[quotation.getSizeOFItemsAndQuantity()][col.length];
		for(int i = 0 ; i < quotation.getSizeOFItemsAndQuantity(); i++) {
			row[i] = new Object[col.length];
			row[i][0] = i+1+".";
			row[i][1] = quotation.getItem(i).getName();
			row[i][2] = quotation.getQuantity(i);
			row[i][3] = quotation.getItem(i).getPrice();
		}	
		DefaultTableModel tableModel = new DefaultTableModel(row, col);
		
		table_1 = new JTable(tableModel);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table_1);
		
		JPanel panelCompany = new JPanel();
		panelCompany.setBounds(12, 39, 357, 178);
		frmCreatePo.getContentPane().add(panelCompany);
		panelCompany.setLayout(null);
		
		JLabel labelCHphone = new JLabel("<Hphone>");
		labelCHphone.setBounds(0, 151, 266, 15);
		panelCompany.add(labelCHphone);
		
		
		
		/**
		 * 
		 * ACTION LISTENERS
		 * 
		 */
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						QuotationScreen pos = new QuotationScreen(finance);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmCreatePo.dispose();
				}
			});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = PurchaseReqSystem.po.size() - 1;
				String id = PurchaseReqSystem.po.get(size).getPOID();
				Integer POID = Integer.valueOf(id.substring(2, 6)) + 1;
				String newPOID = "PO" + POID;
				
				//Setting up the date from the system				
				String date = getSystemDate();
				
				PO newPO = new PO();
				
				newPO.setDate(date);
				newPO.setPOID(newPOID);
				newPO.setStaffID(finance.getFinanceStaffID());
				newPO.setVendorID(quotation.getVendorID());

				
				
				Company shipto = new Company(textFieldCname.getText(),
						textAreaCAddress.getText(), textFieldCHphone.getText());
				Integer CID = Integer.valueOf(id.substring(2, 6)) + 1;
				String shiptoID = "C" + CID;
				
				newPO.setCompanyID(shiptoID);
				
				//setting items and quantity
				for(int i = 0; i < quotation.getSizeOFItemsAndQuantity(); i++ ) {
					newPO.addToItemsAndQuantity(quotation.getQuantity(i), quotation.getItem(i));
				}
				
				//Updating PR Table and global pr list
				//Relaunching main
				
				try{
					newPO.updateDatabase(date);
					PurchaseReqSystem.po.add(newPO);
					PurchaseReqSystem.company.add(shipto);
					frmCreatePo.dispose();	
					
					//relaunching our main
					QuotationScreen window = new QuotationScreen(finance);					
				}catch(Exception ex) {
					System.out.println(ex);
				}
				//updating the PR_Item bridge table
				
				for(int i = 0; i < quotation.getSizeOFItemsAndQuantity(); i++ ) {
					PO_Item new_po_item = new PO_Item(newPO.getPOID(),quotation.getItem(i),quotation.getQuantity(i));
					PurchaseReqSystem.po_item.add(new_po_item);
					try{
						new_po_item.updateDatabase();
					}catch(Exception ex) {
						System.out.println(ex);
					}
				}
			}
		});
		
		
		/**
		 * 
		 * DYNAMIC FILLING
		 * 
		 * 
		 */
		
		// Company details
//		for(int i = 0; i < PurchaseReqSystem.company.size(); i++) {
//			if(finance.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID())) {
//				labelCname.setText(PurchaseReqSystem.company.get(i).getName());
//				labelCAddress.setText("<html>" + "<body >" + "<p>" + PurchaseReqSystem.company.get(i).getAddress() + "<p>" +"</body>"+"</html>");
//				labelCHphone.setText(PurchaseReqSystem.company.get(i).getPhone());
//			}
//		}
		
		
		
		for(Company c: PurchaseReqSystem.company) {
			if(quotation.getCompanyID().equals(c.getCompanyID())) {
				labelCname.setText(c.getName());
				labelCAddress.setText("<html>" + "<body >" + "<p>" + c.getAddress() + "<p>" +"</body>"+"</html>");
				labelCHphone.setText(c.getPhone());
			}
		}
		// Vendor details
		
		for(int i = 0; i < PurchaseReqSystem.vendor.size(); i++) {
			if(quotation.getVendorID().equals(PurchaseReqSystem.vendor.get(i).getVendorID())) {
				labelVname.setText(PurchaseReqSystem.vendor.get(i).getName());
				labelVAddress.setText(PurchaseReqSystem.vendor.get(i).getAddress());
				labelVHphone.setText(PurchaseReqSystem.vendor.get(i).getHphone());
			}
		}
		
		
	}
}
