package PurchaseReq;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VendorMain extends JFrame {

	private JFrame frmVendorMainScreen;
	private Vendor Vendor;

	/**
	 * Create the application.
	 */
	public VendorMain(Vendor VN) {
		this.Vendor=VN;
		initialize();
		frmVendorMainScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVendorMainScreen = new JFrame();
		frmVendorMainScreen.setTitle("Vendor Main Screen");
		frmVendorMainScreen.setBounds(100, 100, 489, 298);
		frmVendorMainScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVendorMainScreen.getContentPane().setLayout(null);

		JLabel lblWelcomeVendor = new JLabel("Welcome, "+Vendor.getName());
		lblWelcomeVendor.setBounds(10, 11, 113, 14);
		frmVendorMainScreen.getContentPane().add(lblWelcomeVendor);
		
		JButton btnRequestForQuotation = new JButton("Request For Quotation");
		btnRequestForQuotation.setBounds(24, 112, 195, 105);
		btnRequestForQuotation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        	 RequestForQuotation window = new RequestForQuotation(Vendor);
		        	 window.setSize(290,315);
		        	 frmVendorMainScreen.dispose();
				
				
			}
		});
		frmVendorMainScreen.getContentPane().add(btnRequestForQuotation);
		
		JButton btnPurchaseOrder = new JButton("Purchase Order");
		btnPurchaseOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				POScreen window = new POScreen(Vendor);
			}
		});
		btnPurchaseOrder.setBounds(251, 112, 195, 105);
		frmVendorMainScreen.getContentPane().add(btnPurchaseOrder);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(10, 36, 89, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login window = new Login();
				frmVendorMainScreen.dispose();

				
			}
		});
		frmVendorMainScreen.getContentPane().add(btnLogout);
	}
}
