/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myadressbookapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kapil.rawal
 */
public class DBUtil {

//1. Database and driver information collection
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String userName = "root";
    private static String pwd = "root";
    private static String url = "jdbc:mysql://localhost:3306/myaddressbookdb";
    static Connection con;

    // Connecting DB
    public static Connection connectDB() throws Exception {
        //2. Load Driver
        Class c = Class.forName(driverClassName);
        c.getDeclaredConstructor().newInstance();
        System.out.println("c==>" + c);
        con = DriverManager.getConnection(url, userName, pwd);
        return con;
    }

    // disconnecting the DB
    public static void disConnectDB() throws Exception {
        con.close();
    }

    // Update any DML (Insert, Update, Delete) statement
    public static void update(String sql) {
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Fetch data and return ResultSet object
    public static ResultSet select(String sql) {
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
