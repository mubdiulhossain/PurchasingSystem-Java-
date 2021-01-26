package PurchaseReq;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

@SuppressWarnings({"serial", "unused" })
public class POScreen {

	private JFrame frmPOScreen;
	public  Vendor VN;
	private JTable table;
	private JTable table_2;

	/**
	 * Create the application.
	 */
	public POScreen(Vendor VN) {
		this.VN = VN;
		try {
			initialize();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.frmPOScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frmPOScreen = new JFrame();
		frmPOScreen.setTitle("Vendor - View PO");
		frmPOScreen.setBounds(100, 100, 481, 515);
		frmPOScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPOScreen.getContentPane().setLayout(null);
		
		/**
		 * 
		 * FRAME & COMPONENTS
		 * 
		 */
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 87, 218, 391);
		frmPOScreen.getContentPane().add(scrollPane);
		
		Object[] title = {"POID"}; // Table column titles
		Object[] titleAction = {"View Purchase Order"};
		
		Object[][] contentAction = new Object[PurchaseReqSystem.po.size()][titleAction.length];
		Object[][] content = new Object[PurchaseReqSystem.po.size()][title.length];
		for(int i = 0; i < PurchaseReqSystem.po.size(); i++) {
			content[i] = new Object[title.length];

			content[i][0] = PurchaseReqSystem.po.get(i).getPOID();
			
			System.out.println(content[i][0]);
		}
		
		AbstractAction view = new AbstractAction()
		{
		    @Override
			public void actionPerformed(ActionEvent e)
		    {

		    	JTable table1 = (JTable)e.getSource();
		    	PO poview = new PO();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        System.out.println(content[modelRow][0]);
		        for(int i = 0; i < PurchaseReqSystem.po.size(); i++) {
		        	if(PurchaseReqSystem.po.get(i).getPOID().equals(content[modelRow][0])) {
		        		poview = PurchaseReqSystem.po.get(i);
		        	}
		        }
		        
		        ViewPO po = new ViewPO(poview, VN);
		    }
		};
		
		
				
        DefaultTableModel model = new DefaultTableModel(content, title);
		table = new JTable(model);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(230, 87, 231, 391);
		frmPOScreen.getContentPane().add(scrollPane_1);
		
		DefaultTableModel model_2 = new DefaultTableModel(contentAction, titleAction);
		table_2 = new JTable(model_2);
		scrollPane_1.setViewportView(table_2);
		table_2.setRowHeight(35);
		try {
			ButtonColumn btnView = new ButtonColumn("POScreen" ,table_2, view, 0);
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 12, 117, 25);
		frmPOScreen.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					VendorMain pos = new VendorMain(VN);
					frmPOScreen.dispose();
				}
			});
		
		JLabel lblPurchaseOrder = new JLabel("Purchase Order");
		lblPurchaseOrder.setBounds(12, 49, 111, 15);
		frmPOScreen.getContentPane().add(lblPurchaseOrder);
		
	}
}
