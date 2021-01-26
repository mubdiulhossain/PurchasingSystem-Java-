package PurchaseReq;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class View_PR_screen {

	private JFrame frmViewPr;
	private JTable table;
	private FinanceStaff FinanceStaff;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Staff_view_PR_screen window = new Staff_view_PR_screen();
//					window.frmViewPr.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public View_PR_screen(PR pr, FinanceStaff FS) {
		this.FinanceStaff = FS;
		initialize(pr);
		this.frmViewPr.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(PR pr) {
		frmViewPr = new JFrame();
		frmViewPr.setTitle("View PR");
		frmViewPr.setVisible(true);
		frmViewPr.setBounds(100, 100, 724, 669);
		frmViewPr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
        
		String col[] = {"Item No.","Item","Quantity", "Price"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		for(int i = 0 ; i < pr.getSizeOFItemsAndQuantity(); i++) {
			Object[] objs = {i+1+".",pr.getItem(i).getName(),pr.getQuantity(i),pr.getItem(i).getPrice()};
			tableModel.addRow(objs);
		}	
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("Manager ID:");
		label_2.setBounds(16, 144, 86, 17);
		panel.add(label_2);
		
		JLabel label = new JLabel("Status:");
		label.setBounds(40, 218, 86, 17);
		panel.add(label);
		
		JLabel lblStaffId = new JLabel("Staff ID:");
		lblStaffId.setBounds(33, 94, 86, 17);
		panel.add(lblStaffId);
		
		JFormattedTextField txtDate = new JFormattedTextField(pr.getDate());
		txtDate.setBorder(null);
		txtDate.setBounds(527, 29, 92, 20);
		panel.add(txtDate);
		txtDate.setEditable(false);
		txtDate.setDisabledTextColor(new Color(0, 0, 128));
		
		JLabel label_7 = new JLabel("Date:");
		label_7.setBounds(453, 34, 49, 17);
		panel.add(label_7);
		
		JLabel label_1 = new JLabel("PR ID:");
		label_1.setBounds(41, 31, 86, 17);
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("Staff Name:");
		label_5.setBounds(424, 95, 86, 17);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Reason:");
		label_6.setBounds(443, 218, 86, 17);
		panel.add(label_6);
		
		JFormattedTextField txtManagerName = new JFormattedTextField(pr.getManagerName());
		txtManagerName.setBorder(null);
		txtManagerName.setBounds(527, 143, 92, 20);
		panel.add(txtManagerName);
		txtManagerName.setEditable(false);
		txtManagerName.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtPRID = new JFormattedTextField(pr.getPRID());
		txtPRID.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtPRID.setBorder(null);
		txtPRID.setBounds(112, 29, 92, 20);
		panel.add(txtPRID);
		txtPRID.setEnabled(false);
		txtPRID.setEditable(false);
		txtPRID.setDisabledTextColor(new Color(0, 0, 0));
		
		JLabel label_4 = new JLabel("Manager Name:");
		label_4.setBounds(410, 144, 97, 17);
		panel.add(label_4);
		
		JFormattedTextField txtStaffID = new JFormattedTextField(pr.getStaffID());
		txtStaffID.setBorder(null);
		txtStaffID.setBounds(112, 92, 92, 20);
		panel.add(txtStaffID);
		txtStaffID.setEditable(false);
		txtStaffID.setDisabledTextColor(new Color(0, 0, 128));
		
		if(pr.getReason()==null) {
			JFormattedTextField txtReason = new JFormattedTextField("-");
			txtReason.setBorder(null);
			txtReason.setBounds(522, 204, 152, 44);
			panel.add(txtReason);
			txtReason.setEditable(false);
			txtReason.setDisabledTextColor(new Color(0, 0, 128));
		} else {
			JFormattedTextField txtReason = new JFormattedTextField(pr.getReason());
			txtReason.setBorder(null);
			txtReason.setBounds(522, 204, 152, 44);
			panel.add(txtReason);
			txtReason.setEditable(false);
			txtReason.setDisabledTextColor(new Color(0, 0, 128));
		}
		
		
		JFormattedTextField txtStaffName = new JFormattedTextField(pr.getStaffInfo("name"));
		txtStaffName.setBorder(null);
		txtStaffName.setBounds(526, 93, 92, 20);
		panel.add(txtStaffName);
		txtStaffName.setEditable(false);
		txtStaffName.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtManagerID = new JFormattedTextField(pr.getManagerID());
		txtManagerID.setBorder(null);
		txtManagerID.setBounds(112, 142, 92, 20);
		panel.add(txtManagerID);
		txtManagerID.setEditable(false);
		txtManagerID.setDisabledTextColor(new Color(0, 0, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JButton btnCreateRfq = new JButton("+ Create RFQ");
		btnCreateRfq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					pr.createRFQ(FinanceStaff);
		        	 frmViewPr.dispose();
				
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        	 Finance_PRList window = new Finance_PRList(FinanceStaff);
		        	 window.setSize(290,315);
		        	 frmViewPr.dispose();
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmViewPr.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(426, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(251, Short.MAX_VALUE)
					.addComponent(btnCancel)
					.addGap(54)
					.addComponent(btnCreateRfq)
					.addGap(237))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreateRfq)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		
		JLabel txtStatus = new JLabel(pr.getColoredStatus().toUpperCase());
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStatus.setBounds(112, 202, 106, 44);
		panel.add(txtStatus);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBorder(null);
		panel_1.add(lblTotal);
		
		JFormattedTextField txtTotal = new JFormattedTextField(pr.getTotal().toString());
		txtTotal.setEditable(false);
		txtTotal.setDisabledTextColor(new Color(0, 0, 128));
		panel_1.add(txtTotal);
		frmViewPr.getContentPane().setLayout(groupLayout);
	}
}
