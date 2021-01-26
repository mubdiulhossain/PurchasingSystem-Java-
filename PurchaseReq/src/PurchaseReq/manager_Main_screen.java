package PurchaseReq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class manager_Main_screen {

	private JFrame frame;
	private JTable table;
	private Manager manager;
	private ArrayList<PR> pending_pr = new ArrayList();
	private ArrayList<Integer> pending_pr_global_indexes = new ArrayList();

	public Manager getManager() {
		return manager;
	}

	/**
	 * Create the application.
	 */
	public manager_Main_screen(Manager manager) {
		this.manager = manager;
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 576);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Welcome, " + manager.getName());
		label.setBounds(10, 11, 105, 14);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(137, 108, 292, 378);
		frame.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblReasonifAppliable = new JLabel("Reason for rejection (if applicable)");
		lblReasonifAppliable.setBounds(208, 11, 199, 31);
		frame.getContentPane().add(lblReasonifAppliable);
		
		JTextPane txtReason = new JTextPane();
		txtReason.setToolTipText("Why not :( ?");
		txtReason.setBounds(206, 45, 201, 23);
		frame.getContentPane().add(txtReason);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 105, 388);
		frame.getContentPane().add(scrollPane);
		
		String col[] = {"PR ID"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		for(int i = 0; i < PurchaseReqSystem.pr.size(); i++) {
			
			if(PurchaseReqSystem.pr.get(i).getStatus().equals("pending")) {
				Object[] objs = {PurchaseReqSystem.pr.get(i).getPRID()};
				pending_pr.add(PurchaseReqSystem.pr.get(i));
				pending_pr_global_indexes.add(i);
		        tableModel.addRow(objs);
			}
		}
		
		
		table = new JTable(tableModel);
		table.setRowHeight(40);
		scrollPane.setViewportView(table);
		table.setEnabled(false);
				
				JLabel label_1 = new JLabel("Action");
				label_1.setBounds(239, 67, 48, 30);
				frame.getContentPane().add(label_1);
				
				JButton button = new JButton("LOGOUT");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login();
						frame.dispose();
					}
				});
				button.setBounds(10, 503, 89, 23);
				frame.getContentPane().add(button);
		
		ArrayList<JButton> viewButtons = new ArrayList();
		ArrayList<JButton> approveButtons = new ArrayList();
		ArrayList<JButton> rejectButtons = new ArrayList();

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(125, 497, 736, 44);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		for(int i = 0; i < pending_pr.size(); i++) {
			
			
			viewButtons.add(new JButton());
			viewButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\eye230x30.png"));
			
			approveButtons.add(new JButton());
			approveButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\accept30x30.png"));

			rejectButtons.add(new JButton());
			rejectButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\reject30x30.png"));

			panel_3.add(viewButtons.get(i));
			panel_3.add(approveButtons.get(i));
			panel_3.add(rejectButtons.get(i));
			JSeparator separator = new JSeparator();
			separator.setBounds(744, 296, 1, 2);
			separator.setOrientation(SwingConstants.VERTICAL);
			panel_3.add(separator);
			panel.add(panel_3);
			
		}
		
		
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
			final int final_i = i;
			viewButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					Manager_View_PR window = new Manager_View_PR(pending_pr.get(final_i), manager, pending_pr_global_indexes.get(final_i));				
				
				}
			});
		}
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
					
			final int final_i = i;
			approveButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					manager.approvePR(pending_pr_global_indexes.get(final_i));	
					frame.dispose();
					manager_Main_screen window = new manager_Main_screen(manager);
					
					
				}
			});
		}
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
			final int final_i = i;
			rejectButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					manager.rejectPR(pending_pr_global_indexes.get(final_i), txtReason.getText());
					frame.dispose();
					manager_Main_screen window = new manager_Main_screen(manager);
				}
			});
		}
		
	}
}
