package PurchaseReq;

import java.sql.*;


/**
 *
 * @author aayya
 */

public class MySQLAccess {
    private Connection connect = null;  

    public Connection getConn() {
        return connect;
    }
    
    
     public void conn() throws Exception {
        try {
            // This will load the MySQL driver, each DB has its own driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/purchasereq?useSSL=false","root","1234");
        }
        catch(Exception e){
           // throw e;
            System.out.println(e);
        }
        

    }
     
     
     public void close() throws Exception{
         connect.close();
     }
}

    