package PurchaseReq;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Staff_Create_PR {

	private JFrame frmStaffCreatePr;
	private JTable table;
	private DefaultTableModel tableModel;
	private JComboBox comboBox;
	private int comboBoxFlag;
	private ArrayList<Item> items = new ArrayList();
	private ArrayList<Integer> quantities = new ArrayList();
	private Staff staff;
	private int itemNo = 1;
	private String day;
	private String month;
	private String year;
	private Double total = new Double(0);
	private JTextArea txtQuantity;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Staff_Create_PR window = new Staff_Create_PR();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Staff_Create_PR(Staff staff) {
		this.staff = staff;
		initialize();
		this.frmStaffCreatePr.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStaffCreatePr = new JFrame();
		frmStaffCreatePr.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmStaffCreatePr.setTitle("Staff Create PR Screen");
		frmStaffCreatePr.setBounds(100, 100, 514, 622);
		frmStaffCreatePr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmStaffCreatePr.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(97, 33, 192, 31);
		frmStaffCreatePr.getContentPane().add(panel);
		panel.setLayout(null);
		
		///Comb Box
		initiateComboBox();
		comboBox.setBounds(0, 0, 192, 31);
		comboBox.setVisible(true);
		panel.add(comboBox);
			
		
		
		/////////
		
		txtQuantity = new JTextArea();
		txtQuantity.setLineWrap(true);
		txtQuantity.setBounds(97, 87, 125, 20);
		frmStaffCreatePr.getContentPane().add(txtQuantity);
		
		
		
		JButton btncreateItem = new JButton("+Create Item");
		btncreateItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_create_item_screen window = new Staff_create_item_screen();
			}
		});
		btncreateItem.setBounds(357, 22, 115, 42);
		frmStaffCreatePr.getContentPane().add(btncreateItem);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(39, 91, 86, 17);
		frmStaffCreatePr.getContentPane().add(lblQuantity);
		
		JLabel lblItem = new JLabel("item");
		lblItem.setBounds(39, 35, 86, 17);
		frmStaffCreatePr.getContentPane().add(lblItem);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 182, 478, 270);
		frmStaffCreatePr.getContentPane().add(scrollPane);
		
		
		////Table things
		
		String col[] = {"Item No.","Item","Quantity", "Price per unit"};
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		
		scrollPane.setViewportView(table);
		table.setEnabled(false);
				
		
		
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaffCreatePr.dispose();
				Staff_main_Screen window = new Staff_main_Screen(staff);
				
			}
		});
		button.setBounds(97, 530, 125, 42);
		frmStaffCreatePr.getContentPane().add(button);
		
		
		
		JLabel label = new JLabel("Total");
		label.setBounds(299, 463, 44, 28);
		frmStaffCreatePr.getContentPane().add(label);
		
		JFormattedTextField txtTotal = new JFormattedTextField(total.toString());
		txtTotal.setEditable(false);
		txtTotal.setDisabledTextColor(new Color(0, 0, 128));
		txtTotal.setBounds(352, 463, 136, 28);
		frmStaffCreatePr.getContentPane().add(txtTotal);
		
		
		JButton btnaddItemTo = new JButton("+Add Item");
		btnaddItemTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(quantityFieldIsValid()) {
					updateTable();	        
					//Adding total
			        Double price = new Double(PurchaseReqSystem.item.get(comboBox.getSelectedIndex()).getPrice());
			        Integer quantity = new Integer(txtQuantity.getText());
			        quantities.add(quantity);
			        total = total + (price*quantity);
			        
			        //setting fields appropriatly
			        txtTotal.setText(total.toString());
			        txtQuantity.setText("");
				}else {
					JOptionPane.showMessageDialog(null,"something went wrong , please specify the item with the quantity " ,"Oops!",JOptionPane.ERROR_MESSAGE );
				}
				
				
			}
		});
		btnaddItemTo.setBounds(97, 141, 183, 31);
		frmStaffCreatePr.getContentPane().add(btnaddItemTo);
		
		
		JButton button_1 = new JButton("CREATE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int size = PurchaseReqSystem.pr.size() - 1;
				String id = PurchaseReqSystem.pr.get(size).getPRID();
				Integer PRID = Integer.valueOf(id.substring(2, 6)) + 1;
				String newPRID = "PR" + PRID;
				
				//Setting up the date from the system				
				String date = getSystemDate();
				
				PR newPR = new PR(newPRID,staff.getStaffID());
				newPR.setDate(date);
				
				
				//setting items and quantity
				for(int i = 0; i < items.size(); i++ ) {
					newPR.addToItemsAndQuantity(quantities.get(i), items.get(i));
				}
				
				//Updating PR Table and global pr list
				//Relaunching main
				
				try{
					newPR.updateDatabase(date);
					PurchaseReqSystem.pr.add(newPR);
					frmStaffCreatePr.dispose();	
					
					//relaunching our main
					Staff_main_Screen window = new Staff_main_Screen(staff);					
				}catch(Exception ex) {
					System.out.println(ex);
				}
				//updating the PR_Item bridge table
				
				for(int i = 0; i < items.size(); i++ ) {
					PR_Item new_pr_item = new PR_Item(newPR.getPRID(),items.get(i).getItemID(),quantities.get(i));
					PurchaseReqSystem.pr_item.add( new_pr_item);
					try{
						new_pr_item.updateDatabase();
						System.out.println("succsess");
					}catch(Exception ex) {
						System.out.println(ex);
					}
				}
				
				
				
				
			}
		});
		
		button_1.setBounds(229, 530, 115, 42);
		frmStaffCreatePr.getContentPane().add(button_1);
		
	}
	
	private void initiateComboBox(){
		String[] names = new String[PurchaseReqSystem.item.size()];
		
		comboBoxFlag = PurchaseReqSystem.item.size();
		for(int i = 0; i < PurchaseReqSystem.item.size() ; i++) {
			names[i] = PurchaseReqSystem.item.get(i).getName();
		}
		
		comboBox = new JComboBox(names);
		
		comboBox.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				while(PurchaseReqSystem.item.size()-1 >= comboBoxFlag ) {
					updateComboBox(comboBoxFlag);
					comboBoxFlag++;
				}
			}
		});
		
		
		
	}
	
	private void updateComboBox(int i){	
		comboBox.addItem(PurchaseReqSystem.item.get(i).getName());
	}
	
	private void updateTable() {
		Object[] objs = {itemNo++, PurchaseReqSystem.item.get(comboBox.getSelectedIndex()).getName(), txtQuantity.getText(), PurchaseReqSystem.item.get(comboBox.getSelectedIndex()).getPrice()};
		items.add(PurchaseReqSystem.item.get(comboBox.getSelectedIndex()));
		tableModel.addRow(objs);
	}
	
	
	private String getSystemDate() {
		Date system_date = new Date();
		String day = makeDoubleDigit(system_date.getDate());
		String month = makeDoubleDigit(system_date.getMonth());
		String year = new String(Integer.toString(system_date.getYear()+1900));
		String date = year +"/"+ month +"/"+ day;

		return date;
	}
	
	private String makeDoubleDigit(int number) {
		
		if(number < 10) {
			return "0" + number;
		}
		
		return new String(Integer.toString(number));
	}
	
	
	private boolean quantityFieldIsValid() {
		if(intTest(txtQuantity.getText()) && !txtQuantity.getText().equals("") && !txtQuantity.getText().equals("0")) {
			return true;
		}
		return false;
	}
	private boolean intTest(String string) {
		 try {
	         Integer.parseInt(string);
	         return true;
	      } catch (NumberFormatException e) {
	         return false;
	      }
	}
	
	
}
