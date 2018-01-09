/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dbconnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ss
 */
public class HiveDBConnection {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");
            con = DriverManager.getConnection("jdbc:hive2://1.1.1.110:10000/lemonsoft", "hive", "hive");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
