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
public class ViewQ {

	private JFrame frmViewQ;
	private FinanceStaff finance;
	private Quotation quotation;
	private JTable table_1;

	/**
	 * Create the application.
	 */
	public ViewQ(Quotation quot, FinanceStaff finance) {
		this.quotation = quot;
		this.finance = finance;
		initialize();
		this.frmViewQ.setVisible(true);
		
	}
	
//	private RFQ getRFQ() {
//		for(RFQ r: PurchaseReqSystem.rfq) {
//			if(quot.getRFQID().equals(r.getRFQID())) {
//				return rfq;
//			}
//		}
//		System.out.println("RFQ not found");
//		return null;
//	}
	
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
		frmViewQ = new JFrame();
		frmViewQ.setTitle("Finance Staff - View Quotation");
		frmViewQ.setBounds(100, 100, 760, 830);
		frmViewQ.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmViewQ.getContentPane().setLayout(null);
		
		/**
		 * 
		 * FRAME & COMPONENTS
		 * 
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 358, 728, 367);
		frmViewQ.getContentPane().add(scrollPane);
		
		JLabel lblPurchaseOrder = new JLabel("QuotationID:");
		lblPurchaseOrder.setBounds(10, 12, 98, 17);
		lblPurchaseOrder.setFont(new Font("Dialog", Font.BOLD, 14));
		frmViewQ.getContentPane().add(lblPurchaseOrder);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(524, 12, 47, 15);
		frmViewQ.getContentPane().add(lblDate);
		
		JLabel labelDDATE = new JLabel(quotation.getDate());
		labelDDATE.setBounds(570, 13, 79, 15);
		frmViewQ.getContentPane().add(labelDDATE);
		
		JPanel panelVendor = new JPanel();
		panelVendor.setBounds(12, 41, 359, 81);
		frmViewQ.getContentPane().add(panelVendor);
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
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(575, 737, 47, 15);
		frmViewQ.getContentPane().add(lblTotal);
		
		JLabel txtTotal = new JLabel();
		txtTotal.setBounds(634, 737, 79, 15);
		frmViewQ.getContentPane().add(txtTotal);
		
		/**
		 * 
		 * TABLE STRUCTURE
		 * 
		 */
        double total = 0;
		Object col[] = {"Item No.","Item","Quantity", "Price"};
		Object[][] row = new Object[quotation.getSizeOFItemsAndQuantity()][col.length];
		//System.out.println(quotation.getItemsAndQuantity());
		for(int i = 0 ; i < quotation.getSizeOFItemsAndQuantity(); i++) {
			row[i] = new Object[col.length];
			row[i][0] = i+1+".";
			row[i][1] = quotation.getItem(i).getName();
			row[i][2] = quotation.getQuantity(i);
			row[i][3] = quotation.getItem(i).getPrice();
//			row[i][4] = (double)row[i][2] * (double)row[i][3];
			total += (Integer)row[i][2] * (double)row[i][3];
		}	
		quotation.setTotalPrice(total);
		DefaultTableModel tableModel = new DefaultTableModel(row, col);
		txtTotal.setText(String.valueOf(total));
		table_1 = new JTable(tableModel);
		table_1.getTableHeader().setReorderingAllowed(false);
		table_1.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(320, 760, 117, 25);
		frmViewQ.getContentPane().add(btnClose);
		
		JLabel label = new JLabel(quotation.getQuotationID());
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(111, 13, 98, 17);
		frmViewQ.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(12, 144, 722, 203);
		frmViewQ.getContentPane().add(panel);
		
		JLabel lblBuyerName = new JLabel("Buyer Name:");
		lblBuyerName.setBounds(17, 12, 100, 15);
		panel.add(lblBuyerName);
		
		JLabel labelBName = new JLabel("<dynamic>");
		labelBName.setBounds(119, 12, 78, 15);
		panel.add(labelBName);
		
		JLabel lblBuyerAddress = new JLabel("Buyer Address:");
		lblBuyerAddress.setBounds(10, 114, 129, 15);
		panel.add(lblBuyerAddress);
		
		JLabel labelBAddress = new JLabel("<dynamic>");
		labelBAddress.setBounds(119, 49, 593, 143);
		panel.add(labelBAddress);
		
		JLabel lblValidity = new JLabel("Validity:");
		lblValidity.setBounds(493, 39, 70, 15);
		frmViewQ.getContentPane().add(lblValidity);
		
		JLabel lblValidty = new JLabel(quotation.getValidity());
		lblValidty.setBounds(570, 39, 79, 15);
		frmViewQ.getContentPane().add(lblValidty);
		
		
		/**
		 * 
		 * ACTION LISTENERS
		 * 
		 */
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						QuotationScreen pos = new QuotationScreen(finance);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frmViewQ.dispose();
				}
			});
		
		
		/**
		 * 
		 * DYNAMIC FILLING
		 * 
		 * 
		 */
		
		//Buyer details
//		for(FinanceStaff f: PurchaseReqSystem.financestaff) {
//			for(Company c: PurchaseReqSystem.company) {
//				if(rfq.getFinanceStaffID().equals(f.getFinanceStaffID())) {
//					if(f.getcompanyID().equals(c.getCompanyID()))// RFQ instead of FS
//						labelBName.setText(c.getName());
//						labelBAddress.setText(c.getAddress());
//				}
//			}
//		}
		
		
		for(Company c: PurchaseReqSystem.company) {
			if(quotation.getCompanyID().equals(c.getCompanyID())) {
				labelBName.setText(c.getName());
				labelBAddress.setText(c.getAddress());
			}
		}
		
		
		// Vendor details
		for(int i = 0; i < PurchaseReqSystem.vendor.size(); i++) {
			if(quotation.getVendorID().equals(PurchaseReqSystem.vendor.get(i).getVendorID())) {
				labelVname.setText(PurchaseReqSystem.vendor.get(i).getName());
				labelVAddress.setText(PurchaseReqSystem.vendor.get(i).getVendorAddress());
			}
		}
		
	}
}
