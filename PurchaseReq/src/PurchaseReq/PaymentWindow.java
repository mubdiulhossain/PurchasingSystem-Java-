package PurchaseReq;


import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.Font;
public class PaymentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField accountName;
	private JTextField accountNo;
	private JComboBox bankNamecomboBox;
	private JComboBox invoicIdcomboBox;
	Payment payment = new Payment();
	java.sql.Date sqldate;
	
	public PaymentWindow() {
		super("PAYMENT WINDOW");
    	Payment();	
    	getKInvoiceComboxItem();
    	getBankComboxItem();
    }
	
	public void Payment()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 480, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel date_M = new JLabel("Date : ");
		date_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date_M.setBounds(10, 11, 59, 14);
		contentPane.add(date_M);
		
		JLabel date = new JLabel();
		date.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		date.setBounds(133, 11, 153, 14);
		contentPane.add(date);
		
		JLabel invoiceId_M = new JLabel("InvoiceId : ");
		invoiceId_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		invoiceId_M.setBounds(10, 55, 99, 14);
		contentPane.add(invoiceId_M);
		
		JLabel bankName_M = new JLabel("Bank Name :");
		bankName_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bankName_M.setBounds(10, 86, 76, 14);
		contentPane.add(bankName_M);
		
		JLabel accountName_M = new JLabel("Account Name :");
		accountName_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountName_M.setBounds(10, 124, 99, 14);
		contentPane.add(accountName_M);
		
		JLabel accountNo_M = new JLabel("Account No : ");
		accountNo_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		accountNo_M.setBounds(10, 151, 99, 14);
		contentPane.add(accountNo_M);
		
		JLabel amount_M = new JLabel("Amount :");
		amount_M.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		amount_M.setBounds(10, 176, 76, 14);
		contentPane.add(amount_M);
		
		accountName = new JTextField();
		accountName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		accountName.setBounds(133, 121, 153, 20);
		contentPane.add(accountName);
		accountName.setColumns(10);
		
		JLabel amountL = new JLabel();
		amountL.setBounds(133, 176, 153, 14);
		contentPane.add(amountL);
		
		accountNo = new JTextField();
		accountNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		accountNo.setBounds(133, 148, 153, 20);
		contentPane.add(accountNo);
		accountNo.setColumns(10);
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		date.setText(s.format(d));
		JButton pay = new JButton("Pay");
		pay.setBackground(Color.WHITE);
		pay.setForeground(new Color(46, 139, 87));
		pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payment.UpdatePayment((String)invoicIdcomboBox.getSelectedItem(), (String)bankNamecomboBox.getSelectedItem(), accountNo.getText(), accountName.getText());
				payment.updatePaymentStatus((String)invoicIdcomboBox.getSelectedItem());
			    JOptionPane.showMessageDialog(null, "Payment Succesfully Done!");

			    
			}
		});
		pay.setBounds(186, 257, 89, 23);
		contentPane.add(pay);
		
		bankNamecomboBox = new JComboBox();
		bankNamecomboBox.setMaximumRowCount(20);
		bankNamecomboBox.setBackground(Color.WHITE);
		bankNamecomboBox.setForeground(Color.BLACK);
		bankNamecomboBox.setBounds(133, 83, 153, 20);
		contentPane.add(bankNamecomboBox);
		
		invoicIdcomboBox = new JComboBox();
		invoicIdcomboBox.setMaximumRowCount(1000);
		invoicIdcomboBox.setForeground(Color.BLACK);
		invoicIdcomboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				payment.getAmountFromD((String)invoicIdcomboBox.getSelectedItem());
				double amount = payment.returnAmount();
				String amountF = Double.toString(amount);
				amountL.setText(amountF);
			}
		});
		invoicIdcomboBox.setBounds(133, 53, 153, 20);
		contentPane.add(invoicIdcomboBox);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void getBankComboxItem() 
	{
		ArrayList<String>list = new ArrayList();
		list = payment.filledBank_Comboxbox();
		try {
			for(int i = 0; i < list.size(); i++)
			{
				bankNamecomboBox.addItem(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void getKInvoiceComboxItem() 
	{
		ArrayList<String>list = new ArrayList();
		payment.getAllInvoiceId();
		list = payment.filledInvoice_Comboxbox();
		try {
			for(int i = 0; i < list.size(); i++)
			{
				invoicIdcomboBox.addItem(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	    
}
