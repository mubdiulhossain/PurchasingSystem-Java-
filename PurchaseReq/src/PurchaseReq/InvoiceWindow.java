package PurchaseReq;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class InvoiceWindow {

	private JFrame frame;
	private JTable table;
	static int space = 170;
	ArrayList<String> invoicelist =  new ArrayList();
	ArrayList<String> statusList = new ArrayList();
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	Invoice invoice = new Invoice();
	private String financeStaffID;
	private FinanceStaff FinanceStaff;


	public InvoiceWindow(FinanceStaff financeStaff, String financeStaffID) {
		this.FinanceStaff = financeStaff;
		this.financeStaffID = financeStaffID;
		initialize();
		
	}

	    
	private void initialize() {
		invoice.updateInvoiceWindow();
		invoicelist = invoice.getInvoiceLst();
		statusList = invoice.getStatusList();
		
		frame = new JFrame("Finance - Invoice");
		frame.setBounds(100, 100, 526, 580);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton back_Button = new JButton("Back");
		back_Button.setForeground(new Color(46, 139, 87));
		back_Button.setBackground(Color.WHITE);
		back_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinanceMain window = new FinanceMain(FinanceStaff);
				frame.dispose();
			}
		});
		back_Button.setBounds(220, 507, 89, 23);
		frame.getContentPane().add(back_Button);
		
		JLabel lblInvoice = new JLabel("Invoice");
		lblInvoice.setForeground(new Color(0, 0, 0));
		lblInvoice.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInvoice.setBounds(20, 26, 99, 23);
		frame.getContentPane().add(lblInvoice);
		
		JButton create_Invoice = new JButton("+  New Invoice");
		create_Invoice.setForeground(new Color(46, 139, 87));
		create_Invoice.setBackground(Color.WHITE);
		create_Invoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateInvoice createInvoice = new CreateInvoice(financeStaffID);
				
			}
			
		});
		create_Invoice.setBounds(20, 80, 118, 23);
		frame.getContentPane().add(create_Invoice);
		
		JButton btnMakePayment = new JButton("$ Make Payment");
		btnMakePayment.setForeground(new Color(46, 139, 87));
		btnMakePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentWindow payment = new PaymentWindow();
				
			}
		});
		btnMakePayment.setBackground(Color.WHITE);
		btnMakePayment.setBounds(172, 80, 135, 23);
		frame.getContentPane().add(btnMakePayment);
		
		JLabel lblAction = new JLabel("ACTION");
		lblAction.setForeground(Color.BLACK);
		lblAction.setBackground(Color.WHITE);
		lblAction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAction.setBounds(322, 146, 98, 14);
		frame.getContentPane().add(lblAction);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 146, 256, 293);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Object[] column = {"INVOICE ID", "PAYMENT STATUS"};
		DefaultTableModel model = new DefaultTableModel();
	    model.setColumnIdentifiers(column);
	    table.setModel(model);
	    table.setRowHeight(30);
	    table.setBackground(Color.WHITE);
	    Object[]  row = new Object[2];
	    int i;
	    for(i = 0; i < invoicelist.size(); i++)
		{
			row[0] = invoicelist.get(i);
			row[1]=  statusList.get(i);
			model.addRow(row);
			JButton button = new JButton("View");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int buttonNumber = buttons.indexOf(e.getSource());
					String id = invoicelist.get(buttonNumber);
                    ViewInvoice Invoice = new ViewInvoice(id);
				}
			});
			button.setBounds(301, space, 99, 23);
			button.setBackground(Color.white);
			button.setForeground(Color.decode("#2e8b57"));
			buttons.add(button);
			frame.getContentPane().add(button);
			space = space + 30;
		}
	    
	    JButton btnRefresh = new JButton("Refresh");
	    btnRefresh.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		space = 170;
	    		frame.dispose();
	    		InvoiceWindow window = new InvoiceWindow(FinanceStaff,financeStaffID);
	    		
	    			}
	    });
	    btnRefresh.setForeground(new Color(46, 139, 87));
	    btnRefresh.setBackground(Color.WHITE);
	    btnRefresh.setBounds(399, 11, 89, 23);
	    frame.getContentPane().add(btnRefresh);
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	}
}
