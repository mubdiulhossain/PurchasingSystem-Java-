package PurchaseReq;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class CreateRFQ {

	private JFrame frmRequestForQuotation;
	private JTable table;
	private JTextField textField;
	private FinanceStaff FinanceStaff;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CreateRFQ(PR pr, FinanceStaff FS) {
		this.FinanceStaff = FS;
		initialize(pr);
		this.frmRequestForQuotation.setVisible(true);
	}
	
	private String getSystemDate() {
		Date system_date = new Date();
		String day = makeDoubleDigit(system_date.getDate());
		String month = makeDoubleDigit(system_date.getMonth()+1);
		String year = new String(Integer.toString(system_date.getYear()+1900));
		String date = year +"/"+ month +"/"+ day ;
		return date;
	}
	
	private String makeDoubleDigit(int number) {		
		if(number < 10) {
			return "0" + number;
		}
		
		return new String(Integer.toString(number));
	}
	/**
	 * Initialize the contents of the frame.
	 */

	
	private String getCompanyInfo(String info) {
		String CompanyInfo=null;
		for (int i = 0; i < PurchaseReqSystem.company.size(); i++) {
			if (FinanceStaff.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("name")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getName();
			} else if (FinanceStaff.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("address")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getAddress().replaceAll(", ", ",\n");
				CompanyInfo=CompanyInfo.replaceAll(", ", ",\n");
			} else if (FinanceStaff.getcompanyID().equals(PurchaseReqSystem.company.get(i).getCompanyID()) && info.equals("phone")) {
				CompanyInfo=PurchaseReqSystem.company.get(i).getPhone();
			} else {
				CompanyInfo=PurchaseReqSystem.company.get(i).getCompanyID();
			}
		}
		return CompanyInfo;

	}
	private void initialize(PR pr) {
		frmRequestForQuotation = new JFrame();
		frmRequestForQuotation.setTitle("Create RFQ");
		frmRequestForQuotation.setBounds(100, 100, 452, 547);
		frmRequestForQuotation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRequestForQuotation.getContentPane().setLayout(null);
		
		JLabel lblRequestForQuotation = new JLabel("REQUEST FOR QUOTATION");
		lblRequestForQuotation.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRequestForQuotation.setBounds(22, 11, 268, 30);
		frmRequestForQuotation.getContentPane().add(lblRequestForQuotation);
		
		JLabel lblCompanyname = new JLabel(getCompanyInfo("name"));
		lblCompanyname.setBounds(22, 52, 95, 14);
		frmRequestForQuotation.getContentPane().add(lblCompanyname);
		
		JTextArea lblCompanyaddress = new JTextArea(getCompanyInfo("address"));
		lblCompanyaddress.setEnabled(false);
		lblCompanyaddress.setEditable(false);
		lblCompanyaddress.setDisabledTextColor(new Color(0, 0, 0));
		lblCompanyaddress.setOpaque(false);
		lblCompanyaddress.setBounds(22, 77, 141, 116);
		frmRequestForQuotation.getContentPane().add(lblCompanyaddress);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(260, 52, 29, 14);
		frmRequestForQuotation.getContentPane().add(lblDate);
		
		JLabel lblDate_1 = new JLabel(getSystemDate());
		lblDate_1.setBounds(292, 52, 109, 14);
		frmRequestForQuotation.getContentPane().add(lblDate_1);
		
		JLabel lblDueDate = new JLabel("Due Date: ");
		lblDueDate.setBounds(260, 77, 66, 14);
		frmRequestForQuotation.getContentPane().add(lblDueDate);
		
		JLabel lblStaffname = new JLabel(FinanceStaff.getName());
		lblStaffname.setBounds(22, 204, 180, 14);
		frmRequestForQuotation.getContentPane().add(lblStaffname);
		
		JLabel lblStaffemail = new JLabel(FinanceStaff.getEmail());
		lblStaffemail.setBounds(22, 229, 180, 14);
		frmRequestForQuotation.getContentPane().add(lblStaffemail);
		
		JLabel lblStaff = new JLabel(FinanceStaff.getHPhone());
		lblStaff.setBounds(22, 254, 180, 14);
		frmRequestForQuotation.getContentPane().add(lblStaff);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 298, 387, 144);
		frmRequestForQuotation.getContentPane().add(scrollPane);
		
		String col[] = {"Item No.","Item","Quantity"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
		for(int i = 0 ; i < pr.getSizeOFItemsAndQuantity(); i++) {
			Object[] objs = {i+1+".",pr.getItem(i).getName(),pr.getQuantity(i)};
			tableModel.addRow(objs);
		}	
		
		table = new JTable(tableModel);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		scrollPane.setViewportView(table);
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        	 Finance_PRList window = new Finance_PRList(FinanceStaff);
		        	 window.setSize(290,315);
		        	 frmRequestForQuotation.dispose();
				
			}
		});
		btnCancel.setBounds(113, 463, 89, 23);
		frmRequestForQuotation.getContentPane().add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		
		
		btnSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length()!=10) {
					JOptionPane.showMessageDialog(null,"Please fill in the Due Date with format yyyy/mm/dd." ,"RFQ Creation Failed",JOptionPane.ERROR_MESSAGE );
				} else if(!textField.getText().substring(4,5).equals("/") || !textField.getText().substring(7,8).equals("/")) {
					JOptionPane.showMessageDialog(null,"Please fill in the Due Date with format yyyy/mm/dd." ,"RFQ Creation Failed",JOptionPane.ERROR_MESSAGE );
				} else {
					int size = PurchaseReqSystem.rfq.size() - 1;
					String id = PurchaseReqSystem.rfq.get(size).getRFQID();
					Integer RFQID = Integer.valueOf(id.substring(3, 7)) + 1;
					String newRFQID = "RFQ" + RFQID;
					
					//Setting up the date from the system				
					String date = getSystemDate();
					
					RFQ newRFQ = new RFQ();
					newRFQ.setDate(date,textField.getText());
					newRFQ.setRFQID(newRFQID);
					newRFQ.setCompanyID(getCompanyInfo("CompanyID"));
					newRFQ.setFinanceStaffID(FinanceStaff.getFinanceStaffID());
					newRFQ.setPRID(pr.getPRID());
					
					//setting items and quantity
					for(int i = 0; i < pr.getSizeOFItemsAndQuantity(); i++ ) {
						newRFQ.addToItemsAndQuantity(pr.getQuantity(i), pr.getItem(i));
					}
					
					//Updating PR Table and global pr list
					//Relaunching main
					
					try{
						newRFQ.updateDatabase();
						PurchaseReqSystem.rfq.add(newRFQ);
						frmRequestForQuotation.dispose();	
						
						//relaunching our main
						Finance_PRList window = new Finance_PRList(FinanceStaff);					
					}catch(Exception ex) {
						System.out.println(ex);
					}
					//updating the PR_Item bridge table
					
					for(int i = 0; i < pr.getSizeOFItemsAndQuantity(); i++ ) {
						RFQ_Item new_rfq_item = new RFQ_Item(newRFQ.getRFQID(),pr.getItem(i).getItemID(),pr.getQuantity(i));
						PurchaseReqSystem.rfq_item.add(new_rfq_item);
						try{
							new_rfq_item.updateDatabase();
						}catch(Exception ex) {
							System.out.println(ex);
						}
					}
				} 
			}
		
		
		});
		
		
		
		
		
		
		
		
		btnSubmit.setBounds(225, 463, 89, 23);
		frmRequestForQuotation.getContentPane().add(btnSubmit);
		
		textField = new JTextField();
		textField.setToolTipText("yyyy/mm/dd");
		textField.setBounds(318, 74, 86, 20);
		frmRequestForQuotation.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
