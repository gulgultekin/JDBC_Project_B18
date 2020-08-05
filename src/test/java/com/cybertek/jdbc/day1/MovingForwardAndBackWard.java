package com.cybertek.jdbc.day1;

import java.sql.*;

public class MovingForwardAndBackWard {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.144.140.185:1521:XE";  //54.144.140.185 --> my ip
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);

        // if we create the Statement in this way , this will generate a forward only resultset
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultset readonly and that's what we need

        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); //
        //ResultSet rs   =   stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;
        ResultSet rs = stmnt.executeQuery("SELECT *From Countries");

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.next();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));
        // HOW DO I GO BACK TO PREVIOUS ROW
        rs.previous();
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));  //AR Argentina
        // MOVING THE CURSOR FREELY between rows

        //rs.previous();  //we are at ....
        //System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.last(); // en son datayi getiriyor
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));  //ZW Zimbabwe

        rs.first();  // this will move the cursor to the first row location
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));  //AR Argentina

        rs.absolute(5) ; // this will move the cursor directly to the 5 th row
        System.out.println(rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME")); //CA Canada


        //how to move to before first  row location
        rs.beforeFirst();

        //how to move to after last row location
        rs.afterLast();

        //----------cleaning up-----------------
        rs.close();
        stmnt.close();
        conn.close();


    }
}
