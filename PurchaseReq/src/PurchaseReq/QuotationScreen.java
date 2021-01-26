package PurchaseReq;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.Action;

@SuppressWarnings( {"serial","unused"} )
public class QuotationScreen {

	private JFrame FinanceQuotation;
	private FinanceStaff FS;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public QuotationScreen(FinanceStaff FS) throws Exception {
		this.FS = FS;
		initialize();
		this.FinanceQuotation.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		FinanceQuotation = new JFrame();
		FinanceQuotation.setTitle("Finance Staff - Quotation");
		FinanceQuotation.setBounds(100, 100, 693, 596);
		FinanceQuotation.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		FinanceQuotation.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 53, 414, 498);
		FinanceQuotation.getContentPane().add(scrollPane);
		
		// Table properties
		Object[] title = {"QuotationID", "VendorID", "Vendor Name"}; // Table column titles
		Object[] titleAction = {"View Qoutation", "Create PO"};
		
		Object[][] contentAction = new Object[PurchaseReqSystem.quotation.size()][titleAction.length];
		Object[][] content = new Object[PurchaseReqSystem.quotation.size()][title.length];
		for(int i = 0; i < PurchaseReqSystem.quotation.size(); i++) {
			content[i] = new Object[title.length];
			content[i][0] = PurchaseReqSystem.quotation.get(i).getQuotationID();
			content[i][1] = PurchaseReqSystem.quotation.get(i).getVendorID();
			
			for(int j = 0; j < PurchaseReqSystem.vendor.size(); j++){
				if(PurchaseReqSystem.quotation.get(i).getVendorID().equals(PurchaseReqSystem.vendor.get(j).getVendorID()))
				content[i][2] = PurchaseReqSystem.vendor.get(j).getName();
			}
			
			System.out.println(content[i][0]);
			System.out.println(content[i][1]);
			System.out.println(content[i][2]);
		}
				
        DefaultTableModel model = new DefaultTableModel(content, title);
		table = new JTable(model);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setRowHeight(35);
		
		/**
		 *  Back button
		 */
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 13, 128, 26);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						FinanceMain window = new FinanceMain(FS);
						FinanceQuotation.dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
		FinanceQuotation.getContentPane().add(btnBack);
		
		/**
		 *  Quotation Label
		 */
		JLabel lblQuotation = new JLabel("Quotation");
		lblQuotation.setBounds(582, 19, 91, 15);
		FinanceQuotation.getContentPane().add(lblQuotation);
		lblQuotation.setFont(new Font("Times", Font.BOLD, 16));		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(426, 53, 247, 498);
		FinanceQuotation.getContentPane().add(scrollPane_1);
		
		DefaultTableModel model1 = new DefaultTableModel(contentAction, titleAction);
		table_1 = new JTable(model1);
		scrollPane_1.setViewportView(table_1);
		table_1.setRowHeight(35);
		
		AbstractAction view = new AbstractAction()
		{
		    @Override
			public void actionPerformed(ActionEvent e)
		    {

//		    	JTable table1 = (JTable)e.getSource();
		    	for(RFQ rfq: PurchaseReqSystem.rfq) {
		    		//if(rfq.getRFQID().equals()) {}
		    	}
		    	
		        int modelRow = Integer.valueOf( e.getActionCommand() );
		        System.out.println(table.getModel().getValueAt(modelRow, 0));
		        for(Quotation r: PurchaseReqSystem.quotation) {
		        	if(r.getQuotationID().equals(((DefaultTableModel)table.getModel()).getValueAt(modelRow, 0))){
		        			ViewQ window = new ViewQ(r, FS);
		        	} 
		        }
		        FinanceQuotation.dispose();
		        
		    }
		};
		
		AbstractAction create = new AbstractAction()
		{
		    @Override
			public void actionPerformed(ActionEvent e)
		    {
		    	JTable table1 = (JTable)e.getSource();
		        int modelRow = Integer.valueOf( e.getActionCommand() );
//		        PO po = new PO();
//		        po.createPurchaseOrder(FS, ((DefaultTableModel)table.getModel()).getValueAt(modelRow, 1));
		        for(Quotation r: PurchaseReqSystem.quotation) {
		        	if(r.getQuotationID().equals(((DefaultTableModel)table.getModel()).getValueAt(modelRow, 0))){
		    			CreatePO window = new CreatePO(r, FS);
		        	} 
		        }
		        FinanceQuotation.dispose();
		    }
		};
		try {
		ButtonColumn btnView = new ButtonColumn("QuotationScreen", table_1, view, 0);
		ButtonColumn btnCreate = new ButtonColumn("QuotationScreen", table_1, create, 1);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
