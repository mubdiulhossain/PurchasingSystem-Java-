package PurchaseReq;


import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
public class DatabaseConnection {
	 
     public   Connection conn() {
    	 	 Connection connect = null; 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/purchasereq?useSSL=false","root","1234");
            return connect;
        }
        catch(Exception e){
            return null;
        }
		
    }
     
     
}


