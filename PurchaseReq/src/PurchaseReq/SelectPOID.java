package PurchaseReq;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SelectPOID extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public SelectPOID(ArrayList<PO> po, ArrayList<DeliveryOrder> dO, FinanceStaff loggedIn, initiation db, DeliveryOrderMenu dom) {
		setTitle("Enter PO ID");
		setBounds(100, 100, 409, 253);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		ArrayList<String>POLIST = new ArrayList();
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblEnterPoId = new JLabel("Enter PO ID:");
			contentPanel.add(lblEnterPoId);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			contentPanel.add(horizontalStrut);
		}
		
			
			{
				
				for(int i = 0; i < PurchaseReqSystem.po.size(); i++)
				{
					comboBox.addItem(PurchaseReqSystem.po.get(i).getPOID());
				}
				contentPanel.add(comboBox);
			}
	
			JLabel lblNewLabel = new JLabel("");
			contentPanel.add(lblNewLabel);
		{
			
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int count = 0;
						
						for(int i=0;i<po.size();i++)
						{
							if(comboBox.getSelectedItem().equals(po.get(i).getPOID()))
							{
								CreateDO cdo = new CreateDO(po.get(i), dO, loggedIn, db, dom);
								dispose();
								cdo.setVisible(true);
								break;
							}
						}
						if(count==0)
						{
							lblNewLabel.setText("Not Found");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
