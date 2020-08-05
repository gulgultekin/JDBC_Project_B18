package com.cybertek.jdbc.day2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DB_Practice2 {


    public static void main(String[] args) throws SQLException {

        // print out all data from Jobs Table
        DB_Utility.createConnection();

        ResultSet rs = DB_Utility.runQuery("SELECT *FROM EMPLOYEES");

        // this method call is displaying the data of the resultset
        DB_Utility.displayAllData();

        //move resultset cursor to second row
       // rs.absolute(2);

       // DB_Utility.runQuery("SELECT *From Employees where salary >19000");
        DB_Utility.displayAllData();

        System.out.println(DB_Utility.getColumnDataAtRow(3,2));
        //.......
      //  System.out.println(DB_Utility.getColumnDataAtRow(3,"Region_name"));

        System.out.println(DB_Utility.getRowDataAsList(4)); // [4, Middle East and Africa]  // we get the entire data of row 4 as a list

       System.out.println( DB_Utility.getColumnDataAsList(2) );


        System.out.println( DB_Utility.getColumnDataAsList("FIRST_NAME") );






/*
        System.out.println("******************* DISPLAYING ALL DATA WITH LOOP ***********************");
        // get the first row data  | without knowing the column names
        int colCount = DB_Utility.getColumnCNT();

      //  in order to get whole .............
        while(rs.next() ){ // row iteration

            for (int i = 1; i <= colCount ; i++) { //column iteration
                System.out.print( rs.getString( i ) + "\t" );

            }
            System.out.println();//adding a blank line for next line
        }

*/





        
    }

}
