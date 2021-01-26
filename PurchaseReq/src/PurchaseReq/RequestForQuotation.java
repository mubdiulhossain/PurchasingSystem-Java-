package PurchaseReq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class RequestForQuotation extends JFrame {

	private JFrame frmRequestForQuotation;
	private JTable table_1;
	private ArrayList<RFQ> RFQs = new ArrayList();
	private Vendor Vendor;
	private Boolean QuotationNtCreated;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RequestForQuotation(Vendor VN) {
		this.Vendor= VN;
		initialize();
		frmRequestForQuotation.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRequestForQuotation = new JFrame();
		frmRequestForQuotation.setTitle("Request For Quotation");
		frmRequestForQuotation.setBounds(100, 100, 414, 331);
		frmRequestForQuotation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRequestForQuotation.getContentPane().setLayout(null);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VendorMain window = new VendorMain(Vendor);
				window.setSize(290,315);
				frmRequestForQuotation.dispose();
			}
		});
		button.setBounds(22, 15, 73, 23);
		frmRequestForQuotation.getContentPane().add(button);
		
		JLabel lblRequestForQuotation = new JLabel("Request For Quotation");
		lblRequestForQuotation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRequestForQuotation.setBounds(22, 53, 216, 23);
		frmRequestForQuotation.getContentPane().add(lblRequestForQuotation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 99, 73, 170);
		frmRequestForQuotation.getContentPane().add(scrollPane);
		
		String col[] = {"RFQ ID"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		for(int i = 0; i < PurchaseReqSystem.rfq.size(); i++) {
			QuotationNtCreated = true;
			for(int j = 0; j < PurchaseReqSystem.quotation.size(); j++) {
				if (PurchaseReqSystem.quotation.get(j).getRFQID().equals(PurchaseReqSystem.rfq.get(i).getRFQID())) {
					QuotationNtCreated = false;
				}
			}
			
			if(QuotationNtCreated) {
				Object[] objs = {PurchaseReqSystem.rfq.get(i).getRFQID()};
				RFQs.add(PurchaseReqSystem.rfq.get(i));
			    tableModel.addRow(objs);
			}
			
		}
		
		table_1 = new JTable(tableModel);
		table_1.setEnabled(false);
		scrollPane.setViewportView(table_1);
		table_1.setRowHeight(30);
		
		JLabel lblAction = new JLabel("ACTION");
		lblAction.setBounds(106, 102, 46, 14);
		frmRequestForQuotation.getContentPane().add(lblAction);
		
		JPanel panel = new JPanel();
		panel.setBounds(105, 119, 283, 150);
		frmRequestForQuotation.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ArrayList<JButton> viewButtons = new ArrayList();
		ArrayList<JButton> CreateQuotationButtons = new ArrayList();
		
		for(int i = 0; i < RFQs.size(); i++) {
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 11, 129, 16);
			panel_3.setLayout(new GridLayout(0, 2, 0, 0));
			viewButtons.add(new JButton());
			viewButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\eye.png"));
			CreateQuotationButtons.add(new JButton("+ Create Quotation"));
			panel_3.add(viewButtons.get(i));
			panel_3.add(CreateQuotationButtons.get(i));
			panel.add(panel_3);	
		}
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
			
			final int final_i = i;
			viewButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					RFQs.get(final_i).viewRFQ(Vendor);
					frmRequestForQuotation.dispose();
				}
			});
			
			CreateQuotationButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					RFQs.get(final_i).createQuotation(Vendor);
					frmRequestForQuotation.dispose();
				}
			});			
			
		}
		
	}

}
