package PurchaseReq;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

//

public class DeliveryOrderMenu {

	private JFrame frame;
	private JTable table;
	private MySQLAccess database;


	FinanceStaff loggedInFStaff;
	
	
	DefaultTableModel dm;
	/**
	 * Launch the application.
	 */

	public DeliveryOrderMenu(FinanceStaff financeStaff) {
		loggedInFStaff = financeStaff;
		database = new MySQLAccess();
		try {
			database.conn();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame("Deliver Order Menu");
		frame.setBounds(100, 100, 440, 391);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		JLabel lblDeliveryOrder = new JLabel("Delivery Order");
		lblDeliveryOrder.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDeliveryOrder.setBounds(10, 11, 153, 35);
		frame.getContentPane().add(lblDeliveryOrder);
		
		table = new JTable();
		updateTable();
		DeliveryOrderMenu dom =this;
		table.addMouseListener(new MouseAdapter() {
			  public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 1) {
			      JTable target = (JTable)e.getSource();
			      int row = target.getSelectedRow();
			      int column = target.getSelectedColumn();
			      if(column == 1)
			      {
			    	  System.out.println(row);
				      ViewDO secondFrame = new ViewDO(PurchaseReqSystem.DO.get(row), dom);
				      secondFrame.setVisible(true);
				     
			      }
			      
			    }
			  }
			});
		
		JButton btncreateDo = new JButton("+Create DO");
		btncreateDo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initiation<Object> doSave = new initiation<Object>();
				doSave.setConnection(database.getConn());
				
				SelectPOID spoid = new SelectPOID(PurchaseReqSystem.po, PurchaseReqSystem.DO,  loggedInFStaff, doSave, dom);
				spoid.setVisible(true);
			
			}
		});
		btncreateDo.setBounds(275, 60, 118, 23);
		frame.getContentPane().add(btncreateDo);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(42, 122, 342, 192);
		frame.getContentPane().add(scrollPane);
	}
	@SuppressWarnings("serial")
	public void updateTable()
	{
		
		dm = new DefaultTableModel()
		{
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			@SuppressWarnings({ "rawtypes", "unchecked" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		dm.getDataVector().removeAllElements();
		
		Object[][] object = new Object[PurchaseReqSystem.DO.size()][2];
		for(int i=0;i<PurchaseReqSystem.DO.size();i++)
		{
			for(int j=0;j<2;j++)
			{
				object[i][j] = new Object[i][j];
				if(j==0)
				{
					object[i][j] = PurchaseReqSystem.DO.get(i).getDOID();
				}
				else
				{
					object[i][j] = "";
				}
			}
		}
		dm.setDataVector(object , new String[] {"DOID","Action"});
	    
		table.setModel(dm); 
		
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		
		dm.fireTableDataChanged();
	}
}
