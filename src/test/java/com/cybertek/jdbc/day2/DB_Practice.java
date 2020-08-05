package com.cybertek.jdbc.day2;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB_Practice {


    public static void main(String[] args) throws SQLException {

        //print out all data from jobs table

        DB_Utility.createConnection();
        ResultSet rs = DB_Utility.runQuery("SELECT *FROM JOBS");

        //Iterate over the ResultSet

      //  rs.next();
        //get first 2 column
       // System.out.println( rs.getString(1)+" " +rs.getString(2));

        while(rs.next() ){ // 1. columndaki hepsini yazdirmak icin
            System.out.println( rs.getString(1));
        }


        System.out.println("colCount = " + DB_Utility.getColumnCNT());


        // what if we want to print out everything in the resultset
        // without knowing the column names
        //   System.out.println( rs.getString(1)....2.3.4.5.6...);

        // get the first row data  | without knowing the column names
        int colCount = DB_Utility.getColumnCNT();

        rs.first();  // moving to the first row
        for (int i = 1; i <= colCount ; i++) {
            System.out.print( rs.getString( i ) + "\t" );   //AD_PRES	President	20080	40000

        }





        
    }

}
