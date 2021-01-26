package PurchaseReq;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.sql.ResultSet;
public class FinanceMain extends JFrame{

	private JFrame frmFinanceMainScreen;
	private FinanceStaff FinanceStaff;
	

	/**
	 * Create the application.
	 */
	public FinanceMain(FinanceStaff FS) {
		this.FinanceStaff = FS;
		initialize();
		frmFinanceMainScreen.setVisible(true);
	}
	
	public FinanceStaff getFinanceStaff() {
		return FinanceStaff;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFinanceMainScreen = new JFrame();
		frmFinanceMainScreen.setTitle("Finance Main Screen");
		frmFinanceMainScreen.setBounds(100, 100, 452, 408);
		frmFinanceMainScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFinanceMainScreen.getContentPane().setLayout(null);
		
		JLabel lblWelcomeFinanceStaff = new JLabel("Welcome, "+FinanceStaff.getName());
		lblWelcomeFinanceStaff.setBounds(10, 11, 434, 14);
		frmFinanceMainScreen.getContentPane().add(lblWelcomeFinanceStaff);
		
		JButton btnPurchaseRequisition = new JButton("Purchase Requisition");
		btnPurchaseRequisition.setBounds(30, 99, 156, 105);
		btnPurchaseRequisition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        	 Finance_PRList window = new Finance_PRList(FinanceStaff);
		        	 window.setSize(290,315);
		        	 frmFinanceMainScreen.dispose();
				
				
			}
		});
		frmFinanceMainScreen.getContentPane().add(btnPurchaseRequisition);
		
		JButton btnQuotation = new JButton("Quotation");
		btnQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					QuotationScreen window = new QuotationScreen(FinanceStaff);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnQuotation.setBounds(239, 100, 156, 105);
		frmFinanceMainScreen.getContentPane().add(btnQuotation);
		
		JButton btnInvoice = new JButton("Invoice");
		btnInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InvoiceWindow window = new InvoiceWindow(FinanceStaff, FinanceStaff.getFinanceStaffID());
				frmFinanceMainScreen.dispose();

			}
		});
		btnInvoice.setBounds(27, 228, 156, 105);
		frmFinanceMainScreen.getContentPane().add(btnInvoice);
		
		JButton btnNewButton = new JButton("Delivery Order");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeliveryOrderMenu window = new DeliveryOrderMenu(FinanceStaff);
			}
		});
		btnNewButton.setBounds(239, 228, 156, 105);
		frmFinanceMainScreen.getContentPane().add(btnNewButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 36, 89, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				frmFinanceMainScreen.dispose();

			}
		});
		frmFinanceMainScreen.getContentPane().add(btnLogout);
	}
}
