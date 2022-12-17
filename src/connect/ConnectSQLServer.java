/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 84392
 */
public class ConnectSQLServer {
    public static Connection getConnection(String dbURL, String userName, String password) throws SQLException {
            Connection conn = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(dbURL, userName, password);
                System.out.println("connect successfully!");
            } catch (ClassNotFoundException  ex ) {
                System.out.println("connect failure!");
                 ex.printStackTrace();
            } catch (SQLException ex) {
            Logger.getLogger(ConnectSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
            return conn; 
       }

}