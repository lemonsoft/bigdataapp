/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dbconnection;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ss
 */
public class CreateDB {

    public void createDBTables(Connection con) throws Exception {

        Statement stmt = con.createStatement();

        // execute statement
        stmt.executeQuery("CREATE TABLE IF NOT EXISTS "
                + " books ( id int, name String, "
                + " publisher String, isbn String)"
                + " COMMENT ‘Book details’"
                + " ROW FORMAT DELIMITED"
                + " FIELDS TERMINATED BY ‘\t’"
                + " LINES TERMINATED BY ‘\n’"
                + " STORED AS TEXTFILE;");

        System.out.println("Table books created.");
        con.close();

    }

    public void loadData(Connection con) throws Exception {
        Statement stmt = con.createStatement();

        // execute statement
        stmt.executeQuery("LOAD DATA LOCAL INPATH '/home/user/sample.txt'" + "OVERWRITE INTO TABLE books;");
        System.out.println("Load Data into books successful");

        con.close();

    }
}
