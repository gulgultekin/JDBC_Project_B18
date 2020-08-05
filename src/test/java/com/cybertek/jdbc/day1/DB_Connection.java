package com.cybertek.jdbc.day1;

import java.sql.*;

public class DB_Connection {

    public static void main(String[] args) throws SQLException {

        // CONNECTION -->> STATEMENT --->> RESULTSET
        // Driver manager is used to get the connection
        // The IP address is the IP address of EC2 instance that have Oracle database
        // This is mine , so yours will your EC2 instance IP
        // This is known as connection string or url
        // it has few part
        // "jdbc:   making jdbc connection , always start with this
        // oracle:  the database vendor (RDBMS) name we are trying to connect
        // thin:    1 type of oracle driver we are using ( downloaded using pom dependency)
        // @52.71.242.164: IP address of your database server
        // 1521:    port number of your database server ,  usually 1521 for oracle , 3306 for MySql Database
        // XE  :   SID name  unique identifier for the database we are connecting
        //  In a nutshell , see it as a full address of your database you can use to make connection


        String connectionStr = "jdbc:oracle:thin:@54.144.140.185:1521:XE";  //54.144.140.185 --> my ip
        String username = "hr";
        String password = "hr";

        // JDBC ship with JDK , and has a lot of pre-wirtten codes to work with database
        // everything we do below comes from java.sql package

        // creating connection object using DriverManager's static method Connection ;
        Connection conn = DriverManager.getConnection(connectionStr,username,password);

        // creating statement object using the connection we have established
        Statement stmnt = conn.createStatement();

        // ResultSet object is what we use to store the actual result we get from query
        ResultSet rs = stmnt.executeQuery("SELECT *From REGIONS");

        // ResultSet comes with a cursor used to navigate between rows
        // initially the cursor is at before first location (right before the first row)
        // in order to come to the first row we need to move the cursor
        // next() method is used to move the cursor and return the result as boolean
        rs.next();    // currently we are at the very first row

        // getting the column data  we use multiple get methods available in ResultSet
        //  print out region id and region name  , both as String
        System.out.println("First row First column value using index: --> "+ rs.getString(1));
        System.out.println("First column value using column_name: --> "+ rs.getString("Region_id"));

        // printing out second column data
        System.out.println("Second column value using index: --> "+ rs.getString(2));
        System.out.println("Second column value using column_name: --> "+ rs.getString("Region_name"));

        rs.next();    // currently we are at the  second row
        System.out.println("Second row First column value using index: --> "+ rs.getString(1));
        System.out.println("Second row First column value using column_name: --> "+ rs.getString("Region_id"));

        System.out.println("Second row Second column value using index: --> "+ rs.getString(2));
        System.out.println("Second row Second column value using column_name: --> "+ rs.getString("Region_name"));

        rs.next();    // currently we are at the  third row
        System.out.println("Third row First column value using index: --> "+ rs.getString(1));
        System.out.println("Third row First column value using column_name: --> "+ rs.getString("Region_id"));

        System.out.println("Third row Second column value using index: --> "+ rs.getString(2));
        System.out.println("Third row Second column value using column_name: --> "+ rs.getString("Region_name"));

        rs.next();    // currently we are at the  fourth row
        System.out.println("Fourth row First column value using index: --> "+ rs.getString(1));
        System.out.println("Fourth row First column value using column_name: --> "+ rs.getString("Region_id"));

        System.out.println(" Fourth row Second column value using index: --> "+ rs.getString(2));
        System.out.println("Fourth row Second column value using column_name: --> "+ rs.getString("Region_name"));



        // ORDER WE CREATED
        // CONNECTION -->> STATEMENT --->> RESULTSET

        // ORDER WHEN WE CLOSE
        // RESULTSET -->> STATEMENT --> CONNECTION
        /// IT'S ALWAYS GOOD PRACTICE TO CLOSE THE RESOURCES ONCE FINISH USING THEM
        // TO AVOID ISSUES LATER.

//------ cleaning up -----
        rs.close();
        stmnt.close();
        conn.close();



        System.out.println("THE END ");


    }

}
