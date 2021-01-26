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

public class Staff_View_PR_screen {

	private JFrame frmStaffViewPr;
	private JTable table;
	private PR pr;

	/**
	 * Create the application.
	 */
	public Staff_View_PR_screen(PR pr) {
		this.pr = pr;
		initialize();
		this.frmStaffViewPr.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffViewPr = new JFrame();
		frmStaffViewPr.setTitle("Staff View PR Screen");
		frmStaffViewPr.setVisible(true);
		frmStaffViewPr.setBounds(100, 100, 700, 599);
		frmStaffViewPr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
        
		String col[] = {"item No.","Item","Quantity", "Price"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		for(int i = 0 ; i < pr.getSizeOFItemsAndQuantity(); i++) {
			Object[] objs = {i+1,pr.getItem(i).getName(),pr.getQuantity(i),pr.getItem(i).getPrice()};
			tableModel.addRow(objs);
		}	
	
		
        
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PR INFO", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("Manager ID");
		label_2.setBounds(41, 144, 86, 17);
		panel.add(label_2);
		
		JLabel label = new JLabel("Status");
		label.setBounds(41, 218, 86, 17);
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
		label_6.setBounds(339, 218, 86, 17);
		panel.add(label_6);
		
		JFormattedTextField txtManagerName = new JFormattedTextField(pr.getManagerName());
		txtManagerName.setBounds(527, 143, 92, 20);
		panel.add(txtManagerName);
		txtManagerName.setEditable(false);
		txtManagerName.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtPRID = new JFormattedTextField(pr.getPRID());
		txtPRID.setBounds(139, 31, 92, 20);
		panel.add(txtPRID);
		txtPRID.setEnabled(false);
		txtPRID.setEditable(false);
		txtPRID.setDisabledTextColor(new Color(0, 0, 128));
		
		JLabel label_4 = new JLabel("Manager Name");
		label_4.setBounds(421, 144, 86, 17);
		panel.add(label_4);
		
		JFormattedTextField txtStaffID = new JFormattedTextField(pr.getStaffID());
		txtStaffID.setBounds(139, 92, 92, 20);
		panel.add(txtStaffID);
		txtStaffID.setEditable(false);
		txtStaffID.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtReason = new JFormattedTextField(pr.getReason());
		txtReason.setBounds(435, 204, 239, 44);
		panel.add(txtReason);
		txtReason.setEditable(false);
		txtReason.setDisabledTextColor(new Color(0, 0, 128));
		
		
		JFormattedTextField txtStaffName = new JFormattedTextField(pr.getStaffName());
		txtStaffName.setBounds(527, 90, 92, 20);
		panel.add(txtStaffName);
		txtStaffName.setEditable(false);
		txtStaffName.setDisabledTextColor(new Color(0, 0, 128));
		
		JFormattedTextField txtManagerID = new JFormattedTextField(pr.getManagerID());
		txtManagerID.setBounds(139, 145, 92, 20);
		panel.add(txtManagerID);
		txtManagerID.setEditable(false);
		txtManagerID.setDisabledTextColor(new Color(0, 0, 128));
		
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(tableModel);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffViewPr.dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frmStaffViewPr.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 684, GroupLayout.PREFERRED_SIZE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		JLabel txtStatus = new JLabel(pr.getColoredStatus());
		txtStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtStatus.setBounds(137, 207, 106, 44);
		panel.add(txtStatus);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblTotal = new JLabel("Total");
		panel_1.add(lblTotal);
		
		JFormattedTextField txtTotal = new JFormattedTextField(pr.getTotal().toString());
		txtTotal.setEditable(false);
		txtTotal.setDisabledTextColor(new Color(0, 0, 128));
		panel_1.add(txtTotal);
		frmStaffViewPr.getContentPane().setLayout(groupLayout);
	}
}
