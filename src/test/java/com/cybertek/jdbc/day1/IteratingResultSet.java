package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultSet {

    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@54.144.140.185:1521:XE";  //54.144.140.185 --> my ip
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT *From REGIONS");

        //
        //

        while(rs.next()==true){  //while (rs.next() )
            System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );
        }

//        rs.next();   //  currently we are at the very first row
//       // System.out.println(rs.getString(1)+ " "+rs.getString(2));
//        System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );
//
//        rs.next();  // curseri next rowa getiriyor -->currently we are at the second row
//        System.out.println(rs.getString(1)+ " "+rs.getString(2));
//
//        rs.next(); // currently we are at the third row
//        System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );
//
//        rs.next();// currently we are at the forth row
//        System.out.println( rs.getString(1) + " " + rs.getString(2) );
//
//       // rs.next();// sadece 4 row var hata veriyor  //Result set after last row
//       // System.out.println( rs.getString(1) + " " + rs.getString(2) );
//        System.out.println(rs.next());  // false cunku baska row yok
//       // System.out.println(rs.next());  //true cikarsa hala baska row var demek





    }
}
