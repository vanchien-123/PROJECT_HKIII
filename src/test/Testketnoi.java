/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import test.*;
import connect.ConnectSQLServer;
import constance.Constance;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author 84392
 */
public class Testketnoi {
     public static void main(String a[]) throws SQLException {
        Connection conn = ConnectSQLServer.getConnection(Constance.DB_URL, Constance.USER_NAME, Constance.PASSWORD);
        if (conn != null) {
            
            System.out.println("Connect susecess");
            
        } else {
            System.out.println("Connect not susecess");
        }
    }
}
