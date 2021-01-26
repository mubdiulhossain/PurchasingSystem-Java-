package PurchaseReq;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewRFQ {

	private JFrame frmViewRfq;
	private JTable table;
	private Vendor Vendor;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ViewRFQ(RFQ rfq, Vendor VN) {
		this.Vendor = VN;
		initialize(rfq);
		this.frmViewRfq.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(RFQ rfq) {
		frmViewRfq = new JFrame();
		frmViewRfq.setTitle("View RFQ");
		frmViewRfq.setBounds(100, 100, 452, 546);
		frmViewRfq.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewRfq.getContentPane().setLayout(null);
		
		JLabel lblRfqid = new JLabel("RFQID:");
		lblRfqid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRfqid.setBounds(22, 11, 55, 30);
		frmViewRfq.getContentPane().add(lblRfqid);
		
		JLabel label_1 = new JLabel(rfq.getCompanyInfo("name"));
		label_1.setBounds(22, 52, 95, 14);
		frmViewRfq.getContentPane().add(label_1);
		
		JTextArea label_2 = new JTextArea(rfq.getCompanyInfo("address"));
		label_2.setBackground(Color.WHITE);
		label_2.setEnabled(false);
		label_2.setEditable(false);
		label_2.setBounds(22, 77, 141, 88);
		label_2.setDisabledTextColor(new Color(0, 0, 0));
		label_2.setOpaque(false);
		frmViewRfq.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(rfq.getFinanceStaffInfo("name"));
		label_3.setBounds(22, 199, 180, 14);
		frmViewRfq.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel(rfq.getFinanceStaffInfo("email"));
		label_4.setBounds(22, 224, 180, 14);
		frmViewRfq.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(rfq.getFinanceStaffInfo("hphone"));
		label_5.setBounds(22, 249, 121, 14);
		frmViewRfq.getContentPane().add(label_5);
		
		JFormattedTextField label_6 = new JFormattedTextField(rfq.getDate());
		label_6.setEditable(false);
		label_6.setEnabled(false);
		label_6.setBounds(255, 52, 95, 14);
		label_6.setBorder(null);
		label_6.setDisabledTextColor(new Color(0, 0, 0));
		frmViewRfq.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Date:");
		label_7.setBounds(216, 52, 29, 14);
		frmViewRfq.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Due Date:");
		label_8.setBounds(216, 77, 55, 14);
		frmViewRfq.getContentPane().add(label_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 283, 381, 155);
		frmViewRfq.getContentPane().add(scrollPane);
		
		String col[] = {"Item No.","Item","Quantity"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		for(int i = 0 ; i < rfq.getSizeOFItemsAndQuantity(); i++) {
			Object[] objs = {i+1+".",rfq.getItem(i).getName(),rfq.getQuantity(i)};
			tableModel.addRow(objs);
		}
		
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		
		JButton button = new JButton("Cancel");
		button.setBounds(74, 460, 89, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RequestForQuotation window = new RequestForQuotation(Vendor);
				window.setSize(290,315);
				frmViewRfq.dispose();
			}
		});
		frmViewRfq.getContentPane().add(button);
		
		JButton btnCreateQuotation = new JButton("+ Create Quotation");
		btnCreateQuotation.setBounds(187, 460, 163, 23);
		btnCreateQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					rfq.createQuotation(Vendor);
					frmViewRfq.dispose();
				
				
			}
		});
		frmViewRfq.getContentPane().add(btnCreateQuotation);
		
		JLabel lblNewLabel = new JLabel(rfq.getRFQID());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(69, 19, 95, 14);
		frmViewRfq.getContentPane().add(lblNewLabel);
		
		JFormattedTextField lblDuedate = new JFormattedTextField(rfq.getDueDate());
		lblDuedate.setBounds(281, 77, 89, 14);
		lblDuedate.setEditable(false);
		lblDuedate.setEnabled(false);
		lblDuedate.setBorder(null);
		lblDuedate.setDisabledTextColor(new Color(0, 0, 128));
		frmViewRfq.getContentPane().add(lblDuedate);
		
		
	}

}
