/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.hive;

import com.app.controller.BookDao;
import com.app.dao.SuperBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ss
 */
public class HiveCRUD {

    public boolean saveRecord(Connection con, BookDao beanObj) throws SQLException {

        boolean flag = true;

        PreparedStatement ps = con.prepareStatement("Insert into books(name,publisher,isbn)values(?,?,?)");

        // set the preparedstatement parameters
        ps.setString(1, beanObj.getName());
        ps.setString(2, beanObj.getPublisher());
        ps.setString(3, beanObj.getIsbn());

        // call executeUpdate to execute our sql update statement
        ps.executeUpdate();
        ps.close();
        return flag;
    }

    public SuperBean initUpdate(Connection con, int id) throws SQLException {

        BookDao bookdo =null;
        PreparedStatement ps = con.prepareStatement("select * from books where id=?");
        ps.setInt(1, id);
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            bookdo = new BookDao();
            bookdo.setId(res.getInt(0));
            bookdo.setName(res.getString(1));
            bookdo.setPublisher(res.getString(2));
            bookdo.setIsbn(res.getString(3));
            
        }
        return bookdo;
    }

    public boolean updateRecord(Connection con, BookDao beanObj) throws SQLException {

        boolean flag = true;
        String sql = "";
        Statement stmt = con.createStatement();
        int res = stmt.executeUpdate(sql);

        PreparedStatement ps = con.prepareStatement("UPDATE books SET name = ?, publisher = ? WHERE id = ?");

        // set the preparedstatement parameters
        ps.setString(1, beanObj.getName());
        ps.setString(2, beanObj.getPublisher());
        ps.setInt(3, beanObj.getId());
        // call executeUpdate to execute our sql update statement
        ps.executeUpdate();
        ps.close();
        return flag;
    }

    public boolean deleteRecord(Connection con, int id) throws SQLException {

        boolean flag = false;
        String sql = "Delete from books where id=" + id;
        Statement stmt = con.createStatement();
        int res = stmt.executeUpdate(sql);
        if (res == 1) {
            flag = true;
        }
        return flag;
    }

    public List<SuperBean> listRecord(Connection con) throws SQLException {

        ArrayList data = new ArrayList();
        String sql = "SELECT * FROM books";
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            BookDao bookdo = new BookDao();
            bookdo.setId(res.getInt(1));
            bookdo.setName(res.getString(2));
            bookdo.setPublisher(res.getString(3));
            bookdo.setIsbn(res.getString(4));
            data.add(bookdo);
        }
        return data;
    }
    public List<SuperBean> listRecordByName(Connection con,String name) throws SQLException {

        ArrayList data = new ArrayList();
        String sql = "SELECT * FROM books where name="+name;
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(sql);
        while (res.next()) {
            BookDao bookdo = new BookDao();
            bookdo.setId(res.getInt(1));
            bookdo.setName(res.getString(2));
            bookdo.setPublisher(res.getString(3));
            bookdo.setIsbn(res.getString(4));
            data.add(bookdo);
        }
        return data;
    }
}
