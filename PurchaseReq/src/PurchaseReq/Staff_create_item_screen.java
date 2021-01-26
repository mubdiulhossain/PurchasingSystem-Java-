package PurchaseReq;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Staff_create_item_screen {

	private JFrame frmCrreateItemScreen;

	public JFrame getFrmCrreateItemScreen() {
		return frmCrreateItemScreen;
	}

	/**
	 * Create the application.
	 */
	public Staff_create_item_screen() {
		initialize();
		frmCrreateItemScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrreateItemScreen = new JFrame();
		frmCrreateItemScreen.setTitle("Crreate Item screen");
		frmCrreateItemScreen.setBounds(100, 100, 286, 196);
		frmCrreateItemScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCrreateItemScreen.getContentPane().setLayout(null);
		
		JTextArea txtName = new JTextArea();
		txtName.setLineWrap(true);
		txtName.setBounds(132, 21, 125, 20);
		frmCrreateItemScreen.getContentPane().add(txtName);
		
		JTextArea txtPrice = new JTextArea();
		txtPrice.setLineWrap(true);
		txtPrice.setBounds(132, 64, 125, 20);
		frmCrreateItemScreen.getContentPane().add(txtPrice);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrreateItemScreen.dispose();
			}
		});
		btnNewButton.setBounds(10, 109, 125, 42);
		frmCrreateItemScreen.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CREATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id = PurchaseReqSystem.item.get(PurchaseReqSystem.item.size()-1).getItemID();
				Integer itemID = Integer.valueOf(id.substring(2, 6)) + 1;
				String newItemID = "IT" + itemID;
				Item newItem = new Item(newItemID, txtPrice.getText(),txtName.getText());
				if(newItem.updateDatabase() == true) {
					txtName.setText(null);
					txtPrice.setText(null);
					PurchaseReqSystem.item.add(newItem);
				}
				
				
			}
		});
		btnNewButton_1.setBounds(142, 109, 115, 42);
		frmCrreateItemScreen.getContentPane().add(btnNewButton_1);
		
		JLabel lblItemName = new JLabel("Item name");
		lblItemName.setBounds(10, 21, 86, 17);
		frmCrreateItemScreen.getContentPane().add(lblItemName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 64, 86, 17);
		frmCrreateItemScreen.getContentPane().add(lblPrice);
	}
}
