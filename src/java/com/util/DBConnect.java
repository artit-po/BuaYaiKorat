/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author BeebyThailand
 */

public class DBConnect {
    public Connection openNewConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        String jdbc = "jdbc:mysql://127.0.0.1:8889/db_buayai?user=root&password=root";
        String jdbcutf8 = "&useUnicode=true&characterEncoding=UTF-8";
        conn = DriverManager.getConnection(jdbc+jdbcutf8);
        
        //conn = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        if (conn == null) {
            throw new SQLException("Cannot initail database connection, because it's NULL.");
        }
        return conn;
    }

    public void closeConnection(Connection conn) throws Exception {
        if (conn != null) {
            System.out.println("#: mySQL connection {" + conn + "} has been droped.");
            conn.close();
        }
    }

    public static void main(String args[]) {
        DBConnect dbConnect = new DBConnect();
        try {
            System.out.println("#: mySQL connection opened :=  " + dbConnect.openNewConnection());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}