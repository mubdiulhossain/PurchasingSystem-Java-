package PurchaseReq;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;

public class Staff_main_Screen {

	private JFrame frmStaffMainScreen;
	private JTable table;
	private JScrollPane scrollPane;
	private ArrayList<PR> staffPRs = new ArrayList();
	private String col[] = {"PR ID","Staus","Reason"};
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	private JTable table_1;
	private Staff staff;
	

	
	/**
	 * Create the application.
	 */
	public Staff_main_Screen(Staff staff) {
		
		this.staff = staff;
		initialize();
		this.frmStaffMainScreen.setVisible(true);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffMainScreen = new JFrame();
		frmStaffMainScreen.setTitle("Staff Main Screen");
		frmStaffMainScreen.setBounds(100, 100, 450, 563);
		frmStaffMainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStaffMainScreen.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 122, 24);
		frmStaffMainScreen.getContentPane().add(panel);
		
		JLabel lblWelcomeStaff = new JLabel("Welcome, " + staff.getName());
		panel.add(lblWelcomeStaff);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(132, 34, 292, 33);
		frmStaffMainScreen.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btn_create_Item = new JButton("create item");
		btn_create_Item.setIcon(null);
		btn_create_Item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_create_item_screen window = new Staff_create_item_screen();
			}
		});
		
		panel_1.add(btn_create_Item);
		
		JButton btn_create_PR = new JButton("create PR");
		btn_create_PR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_Create_PR window = new Staff_Create_PR(staff);
				frmStaffMainScreen.dispose();
				
			}
		});
		panel_1.add(btn_create_PR);
		
		scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 92, 312, 374);
		frmStaffMainScreen.getContentPane().add(scrollPane);
        
        
		initializeTable();
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.setRowHeight(30);
		
        
		
		scrollPane.setViewportView(table);
		
		///////////////////////
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(339, 108, 58, 358);
		frmStaffMainScreen.getContentPane().add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAction = new JLabel("Action");
		lblAction.setBounds(339, 78, 48, 30);
		frmStaffMainScreen.getContentPane().add(lblAction);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				frmStaffMainScreen.dispose();
				
			}
		});
		btnNewButton.setBounds(10, 490, 89, 23);
		frmStaffMainScreen.getContentPane().add(btnNewButton);
		
		//Dynamically adding buttons as per table rows
		ArrayList<JButton> viewButtons = new ArrayList();
		
		for(int i = 0; i < tableModel.getRowCount(); i++) {
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 11, 129, 16);
			panel_3.setLayout(new GridLayout(1, 0, 0, 0));
			viewButtons.add(new JButton());
			viewButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\eye.png"));

			panel_3.add(viewButtons.get(i));
			panel_2.add(panel_3);
			
		}
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
			
			final int final_i = i;
			viewButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					staffPRs.get(final_i).viewPR();
				}
			});
		}
		
		
		
	}
	
	private void initializeTable() {		
		for(int i = 0; i < PurchaseReqSystem.pr.size(); i++) {
			if(staff.getStaffID().equals(PurchaseReqSystem.pr.get(i).getStaffID())) {
				staffPRs.add(PurchaseReqSystem.pr.get(i));				
				Object[] objs = {PurchaseReqSystem.pr.get(i).getPRID(),PurchaseReqSystem.pr.get(i).getColoredStatus(),PurchaseReqSystem.pr.get(i).getReason()};
		        tableModel.addRow(objs);
			}
		}
	}
}
