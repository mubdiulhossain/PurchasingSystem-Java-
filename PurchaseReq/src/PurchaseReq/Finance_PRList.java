package PurchaseReq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Finance_PRList extends JFrame {

	private JFrame frmPurchaseRequisition;
	private JTable table;
	private ArrayList<PR> approved_pr = new ArrayList<>();
	private FinanceStaff FinanceStaff;
	private Boolean RFQNtCreated;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Finance_PRList(FinanceStaff FS) {
		this.FinanceStaff=FS;
		initialize();
		frmPurchaseRequisition.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPurchaseRequisition = new JFrame();
		frmPurchaseRequisition.setTitle("Purchase Requisition");
		frmPurchaseRequisition.setBounds(100, 100, 417, 460);
		frmPurchaseRequisition.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPurchaseRequisition.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FinanceMain window = new FinanceMain(FinanceStaff);
				window.setSize(290,315);
				frmPurchaseRequisition.dispose();
			}
		});
		btnBack.setBounds(20, 11, 65, 23);
		frmPurchaseRequisition.getContentPane().add(btnBack);
		
		JLabel lblPurchaseRequisition = new JLabel("Purchase Requisition");
		lblPurchaseRequisition.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPurchaseRequisition.setBounds(20, 45, 201, 23);
		frmPurchaseRequisition.getContentPane().add(lblPurchaseRequisition);
		
		String col[] = {"PR ID"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		for(int i = 0; i < PurchaseReqSystem.pr.size(); i++) {
			RFQNtCreated = true;
			for(int j = 0; j < PurchaseReqSystem.rfq.size(); j++) {
				if (PurchaseReqSystem.rfq.get(j).getPRID().equals(PurchaseReqSystem.pr.get(i).getPRID())) {
					RFQNtCreated = false;
				}
				
			}
				if(PurchaseReqSystem.pr.get(i).getStatus().equals("approved") && RFQNtCreated) {		
					Object[] objs = {PurchaseReqSystem.pr.get(i).getPRID()};
					approved_pr.add(PurchaseReqSystem.pr.get(i));
			        tableModel.addRow(objs);
				}
			
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(20, 82, 76, 328);
		frmPurchaseRequisition.getContentPane().add(scrollPane);
		table = new JTable(tableModel);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		JLabel lblAction = new JLabel("ACTION");
		lblAction.setBounds(184, 83, 46, 14);
		frmPurchaseRequisition.getContentPane().add(lblAction);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 100, 285, 310);
		frmPurchaseRequisition.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ArrayList<JButton> viewButtons = new ArrayList();
		ArrayList<JButton> CreateRFQButtons = new ArrayList();
		
		for(int i = 0; i < approved_pr.size(); i++) {
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(10, 11, 129, 16);
			panel_3.setLayout(new GridLayout(0, 2, 0, 0));
			viewButtons.add(new JButton());
			viewButtons.get(i).setIcon(new ImageIcon("C:\\Users\\aayya\\eclipse-workspace\\PurchaseReq\\src\\PurchaseReq\\eye.png"));
			CreateRFQButtons.add(new JButton("+ Create RFQ"));
			panel_3.add(viewButtons.get(i));
			panel_3.add(CreateRFQButtons.get(i));
			panel.add(panel_3);
			
		}
		
		for(int i = 0 ; i < viewButtons.size(); i++) {
			
			final int final_i = i;
			viewButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					approved_pr.get(final_i).viewPR(FinanceStaff);
					frmPurchaseRequisition.dispose();
				}
			});
			
			CreateRFQButtons.get(final_i).addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0){
					approved_pr.get(final_i).createRFQ(FinanceStaff);
					frmPurchaseRequisition.dispose();
				}
			});
		}

	}
}
