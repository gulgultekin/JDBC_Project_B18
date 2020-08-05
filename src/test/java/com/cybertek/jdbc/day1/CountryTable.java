package com.cybertek.jdbc.day1;

import java.sql.*;

public class CountryTable {

    public static void main(String[] args) throws SQLException {
        String connectionStr = "jdbc:oracle:thin:@54.144.140.185:1521:XE";  //54.144.140.185 --> my ip
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr,username,password);
        Statement stmnt = conn.createStatement();
       // ResultSet rs = stmnt.executeQuery("SELECT *From Countries");
        ResultSet rs = stmnt.executeQuery("SELECT *From Countries Where Region_id = 1"); //sadece region 1 dekileri verir

        // as long as rs.next() return true I know I have next row to print the data
        // we will keep looping as long as rs.next() return true

        while(rs.next()==true){
            // System.out.println( rs.getString("Country_id") + "  " + rs.getString("Country_NAME") +"  REGION_ID :  "+rs.getString("region_id") );

             System.out.println(rs.getString(1)+ " "+rs.getString(2) + " "+rs.getInt(3));// this is getting region id as number instead of String

        }
        rs.previous(); //hata veriyor burada cunku sadece ileri gidiyor
       // Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        //bunu tanimlamamiz lazimdi yukarida geri gidebilmesi icin
    }
}
