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
import javax.swing.ImageIcon;

public class Manager_View_PR {

	private JFrame frmManagerViewPr;
	private JTable table;
	private PR pr;
	private Manager manager;
	private int prIndex;

	/**
	 * Create the application.
	 */
	public Manager_View_PR(PR pr, Manager manager,int prIndex) {
		this.pr = pr;
		this.manager = manager;
		this.prIndex = prIndex;
		initialize();
		this.frmManagerViewPr.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagerViewPr = new JFrame();
		frmManagerViewPr.setTitle("Manager View PR Screen");
		frmManagerViewPr.setVisible(true);
		frmManagerViewPr.setBounds(100, 100, 700, 679);
		frmManagerViewPr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
        
		String col[] = {"item No.","Item","Quantity", "Price"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		for(int i = 0 ; i < pr.getSizeOFItemsAndQuantity(); i++) {
			Object[] objs = {i+1,pr.getItem(i).getName(),pr.getQuantity(i),pr.getItem(i).getPrice()};
			tableModel.addRow(objs);
		}	
	
		
        
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PR INFO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel label = new JLabel("Status");
		label.setBounds(41, 157, 86, 17);
		panel.add(label);
		
		JLabel lblStaffId = new JLabel("Staff ID");
		lblStaffId.setBounds(41, 94, 86, 17);
		panel.add(lblStaffId);
		
		JFormattedTextField txtDate = new JFormattedTextField(pr.getDate());
		txtDate.setBounds(527, 29, 92, 20);
		panel.add(txtDate);
		txtDate.setEditable(false);
		txtDate.setDisabledTextColor(new Color(0, 0, 128));
		
		JLabel label_7 = new JLabel("Date");
		label_7.setBounds(421, 31, 86, 17);
		panel.add(label_7);
		
		JLabel label_1 = new JLabel("PR ID");
		label_1.setBounds(41, 31, 86, 17);
		panel.add(label_1);
		
		JLabel label_5 = new JLabel("Staff Name");
		label_5.setBounds(421, 94, 86, 17);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Reason");
		label_6.setBounds(339, 157, 86, 17);
		panel.add(label_6);
		
		JFormattedTextField txtPRID = new JFormattedTextField(pr.getPRID());
		txtPRID.setBounds(139, 31, 92, 20);
		panel.add(txtPRID);
		txtPRID.setEnabled(false);
		txtPRID.setEditable(false);
		txtPRID.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtStaffID = new JFormattedTextField(pr.getStaffID());
		txtStaffID.setBounds(139, 92, 92, 20);
		panel.add(txtStaffID);
		txtStaffID.setEditable(false);
		txtStaffID.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtReason = new JFormattedTextField(pr.getReason());
		txtReason.setBounds(435, 143, 239, 44);
		panel.add(txtReason);
		txtReason.setEditable(false);
		txtReason.setDisabledTextColor(new Color(0, 0, 128));
		
		
		JFormattedTextField txtStaffName = new JFormattedTextField(pr.getStaffName());
		txtStaffName.setBounds(527, 90, 92, 20);
		panel.add(txtStaffName);
		txtStaffName.setEditable(false);
		txtStaffName.setDisabledTextColor(new Color(0, 0, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(tableModel);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmManagerViewPr.dispose();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		GroupLayout groupLayout = new GroupLayout(frmManagerViewPr.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(412, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(109)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE))
					.addGap(21))
		);
		
		JButton btnApprove = new JButton("");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.approvePR(prIndex);	
				frmManagerViewPr.dispose();
				manager_Main_screen window = new manager_Main_screen(manager);
				
			}
		});
		panel_2.add(btnApprove);
		btnApprove.setIcon(new ImageIcon(Manager_View_PR.class.getResource("/PurchaseReq/accept30x30.png")));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.rejectPR(prIndex, "");
				frmManagerViewPr.dispose();
				manager_Main_screen window = new manager_Main_screen(manager);
			}
		});
		panel_2.add(button);
		button.setIcon(new ImageIcon(Manager_View_PR.class.getResource("/PurchaseReq/reject30x30.png")));
		
		JLabel txtStatus = new JLabel(pr.getColoredStatus());
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStatus.setBounds(137, 146, 106, 44);
		panel.add(txtStatus);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblTotal = new JLabel("Total");
		panel_1.add(lblTotal);
		
		JFormattedTextField txtTotal = new JFormattedTextField(pr.getTotal().toString());
		txtTotal.setEditable(false);
		txtTotal.setDisabledTextColor(new Color(0, 0, 128));
		panel_1.add(txtTotal);
		frmManagerViewPr.getContentPane().setLayout(groupLayout);
	}
}
