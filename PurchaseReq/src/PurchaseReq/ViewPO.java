package PurchaseReq;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "deprecation", "unused" })
public class ViewPO {

	private JFrame frmViewPO;
	private Vendor VN;
	private PO po;
	private JTable table_1;
	private FinanceStaff fstaff = new FinanceStaff();

	/**
	 * Create the application.
	 */
	public ViewPO(PO po,Vendor VN) {
		this.po = po;
		this.VN = VN;
		for(int i = 0; i < PurchaseReqSystem.financestaff.size(); i++) {
			if(po.getStaffID().equals(PurchaseReqSystem.financestaff.get(i).getFinanceStaffID()))
				fstaff = PurchaseReqSystem.financestaff.get(i);
		}
		initialize();
		this.frmViewPO.setVisible(true);
		
	}
	private String formatDate(Date date) {
		String day = makeDoubleDigit(date.getDate());
		String month = makeDoubleDigit(date.getMonth()+1);
		String year = new String(Integer.toString(date.getYear()+1900));
		String fdate = year +"/"+ month +"/"+ day ;
		return fdate;
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
		frmViewPO = new JFrame();
		frmViewPO.setTitle("Vendor - View PO");
		frmViewPO.setBounds(100, 100, 760, 830);
		frmViewPO.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmViewPO.getContentPane().setLayout(null);
		
		/**
		 * 
		 * FRAME & COMPONENTS
		 * 
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 358, 728, 367);
		frmViewPO.getContentPane().add(scrollPane);
		
		JLabel lblPurchaseOrder = new JLabel("PURCHASE ORDER");
		lblPurchaseOrder.setBounds(10, 12, 200, 15);
		lblPurchaseOrder.setFont(new Font("Times", Font.BOLD, 18));
		frmViewPO.getContentPane().add(lblPurchaseOrder);
		
		JLabel labelCname = new JLabel("<dynamic company>");
		labelCname.setBounds(12, 51, 145, 15);
		frmViewPO.getContentPane().add(labelCname);
		
		JLabel labelCAddress = new JLabel("<Address>");
		labelCAddress.setBounds(12, 78, 149, 15);
		frmViewPO.getContentPane().add(labelCAddress);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(524, 12, 47, 15);
		frmViewPO.getContentPane().add(lblDate);
		
		JLabel labelDDATE = new JLabel(formatDate(po.getDate()));
		labelDDATE.setBounds(570, 13, 78, 15);
		frmViewPO.getContentPane().add(labelDDATE);
		
		JPanel panelVendor = new JPanel();
		panelVendor.setBounds(12, 226, 359, 115);
		frmViewPO.getContentPane().add(panelVendor);
		panelVendor.setLayout(null);
		
		JLabel lblVendorName = new JLabel("Vendor Name:");
		lblVendorName.setBounds(17, 12, 100, 15);
		panelVendor.add(lblVendorName);
		
		JLabel labelVname = new JLabel("<dynamic>");
		labelVname.setBounds(119, 12, 78, 15);
		panelVendor.add(labelVname);
		
		JLabel lblVendorAddress = new JLabel("Vendor Address:");
		lblVendorAddress.setBounds(0, 50, 129, 15);
		panelVendor.add(lblVendorAddress);
		
		JLabel labelVAddress = new JLabel("<dynamic>");
		labelVAddress.setBounds(119, 50, 78, 15);
		panelVendor.add(labelVAddress);
		
		JLabel lblVendorPhone = new JLabel("Vendor Phone:");
		lblVendorPhone.setBounds(12, 88, 122, 15);
		panelVendor.add(lblVendorPhone);
		
		JLabel labelVHphone = new JLabel("<dynamic>");
		labelVHphone.setBounds(119, 88, 78, 15);
		panelVendor.add(labelVHphone);
		
		JPanel panelShipTo = new JPanel();
		panelShipTo.setBounds(383, 39, 357, 302);
		frmViewPO.getContentPane().add(panelShipTo);
		panelShipTo.setLayout(null);
		
		JLabel lblShipTo = new JLabel("SHIP TO");
		lblShipTo.setBounds(151, 27, 60, 15);
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
		
		JLabel lblCName = new JLabel("<Dynamic>");
		lblCName.setBounds(141, 66, 145, 15);
		panelShipTo.add(lblCName);
		
		JLabel lblCAddress = new JLabel("<Dynamic>");
		lblCAddress.setBounds(151, 93, 79, 15);
		panelShipTo.add(lblCAddress);
		
		JLabel lblCPhone = new JLabel("<Dynamic>");
		lblCPhone.setBounds(141, 268, 79, 15);
		panelShipTo.add(lblCPhone);
		
		JPanel panelCompany = new JPanel();
		panelCompany.setBounds(12, 39, 357, 178);
		frmViewPO.getContentPane().add(panelCompany);
		panelCompany.setLayout(null);
		
		JLabel labelCHphone = new JLabel("<Hphone>");
		labelCHphone.setBounds(0, 151, 75, 15);
		panelCompany.add(labelCHphone);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(575, 737, 47, 15);
		frmViewPO.getContentPane().add(lblTotal);
		
		JLabel labelDTotal = new JLabel(String.valueOf(po.getTotal()));
		labelDTotal.setBounds(634, 737, 79, 15);
		frmViewPO.getContentPane().add(labelDTotal);
		
		/**
		 * 
		 * TABLE STRUCTURE
		 * 
		 */
        
		Object col[] = {"Item No.","Item","Quantity", "Price"};
		Object[][] row = new Object[po.getSizeOFItemsAndQuantity()][col.length];
		System.out.println(po.getItemsAndQuantity());
		for(int i = 0 ; i < po.getSizeOFItemsAndQuantity(); i++) {
			row[i] = new Object[col.length];
			row[i][0] = i+1+".";
			row[i][1] = po.getItem(i).getName();
			row[i][2] = po.getQuantity(i);
			row[i][3] = po.getItem(i).getPrice();
		}	
		DefaultTableModel tableModel = new DefaultTableModel(row, col);
		
		table_1 = new JTable(tableModel);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(320, 760, 117, 25);
		frmViewPO.getContentPane().add(btnClose);
		
		
		
		/**
		 * 
		 * ACTION LISTENERS
		 * 
		 */
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					POScreen pos = new POScreen(VN);
					frmViewPO.dispose();
				}
			});
		
		
		/**
		 * 
		 * DYNAMIC FILLING
		 * 
		 * 
		 */
		
		// Company details
		for(int i = 0; i < PurchaseReqSystem.company.size(); i++) {
			if(fstaff.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID())) {
				labelCname.setText(PurchaseReqSystem.company.get(i).getName());
				labelCAddress.setText("<html>" + "<body >" + "<p>" + PurchaseReqSystem.company.get(i).getAddress() + "<p>" +"</body>"+"</html>");
				labelCHphone.setText(PurchaseReqSystem.company.get(i).getPhone());
			}
		}
		for(int i = 0; i < PurchaseReqSystem.company.size(); i++) {
			if(po.getStaffID().equals(fstaff.getFinanceStaffID()) && fstaff.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID())) {
				lblCName.setText(PurchaseReqSystem.company.get(i).getName());
				lblCAddress.setText("<html>" + "<body >" + "<p>" + PurchaseReqSystem.company.get(i).getAddress() + "<p>" +"</body>"+"</html>");
				lblCPhone.setText(PurchaseReqSystem.company.get(i).getPhone());
			}
		}
		
		
		// Vendor details
		for(int i = 0; i < PurchaseReqSystem.vendor.size(); i++) {
			if(VN.getVendorID().equals(PurchaseReqSystem.vendor.get(i).getVendorID())) {
				labelVname.setText(PurchaseReqSystem.vendor.get(i).getName());
				labelVAddress.setText(PurchaseReqSystem.vendor.get(i).getVendorAddress());
				labelVHphone.setText(PurchaseReqSystem.vendor.get(i).getHphone());
			}
		}
		
	}
}
