package com.cybertek.jdbc.day2;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DB_Utility {
    // adding static field so we can access in all static methods
    private static Connection conn;
    private static ResultSet rs;
    /*
     * a method to display all the data in the result set
     *
     * */
    public static void displayAllData() {
        // get the first row data  | without knowing the column names
        int colCount = DB_Utility.getColumnCNT();
        // in order to get whole result cursor must be at before first location !
        try {
            // in order to start from beginning , we should be at beforefirst location
            rs.beforeFirst(); // this is for below loop to work
            while (rs.next() == true) { // row iteration
                for (int i = 1; i <= colCount; i++) { // column iteration
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println(); /// adding a blank line for next line
            }
            // now the cursor is at after last location
            // move it back to before first location so we can have no issue calling the method again
            rs.beforeFirst(); // this is for next method that might need to be at before first location
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ALL DATA");
            e.printStackTrace();
        }
    }
    /*
     * a method to get the column count of the current ResultSet
     *
     *   getColumnCNT()
     *
     * */
    public static int getColumnCNT() {
        int colCount = 0;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE COUNTING THE COLUMNS");
            e.printStackTrace();
        }
        return colCount;
    }
    /*
     * a static method to create connection
     * with valid url and username password
     * */
    public static void createConnection() {
        String connectionStr = "jdbc:oracle:thin:@54.144.140.185:1521:XE";
        String username = "hr";
        String password = "hr";
        try {
            conn = DriverManager.getConnection(connectionStr, username, password);
            System.out.println("CONNECTION SUCCESSFUL");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED!");
            e.printStackTrace();
        }
    }
    /*
     * a static method to get the ResultSet object
     * with valid connection by executing query
     * */
    public static ResultSet runQuery(String query) {
        try {
            Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    /**
     * @return Row number of the resultset
     */
    public static int getRowCount() {
        int rowCount = 0;
        try {
            rs.last();
            rowCount = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW COUNT !");
            e.printStackTrace();
        }
        return rowCount;
    }
    public static List<String> getColumnDataAsList(int columnIndex) {
        List<String> colDataLst = new ArrayList<>();
        try {
            while( rs.next() ) {
                colDataLst.add( rs.getString(columnIndex) ) ;
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING THE COLUMN DATA");
            e.printStackTrace();
        }
        return colDataLst;
    }
    public static List<String> getColumnDataAsList(String columnName) {
        List<String> colDataLst = new ArrayList<>();
        try {
            while( rs.next() ) {
                colDataLst.add( rs.getString(columnName) ) ;
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING THE COLUMN DATA");
            e.printStackTrace();
        }
        return colDataLst;
    }
    public static List<String> getRowDataAsList(int rowNum) {
        List<String> rowDataLst = new ArrayList<>();
        try {
            rs.absolute(rowNum);
            for (int i = 1; i <= getColumnCNT(); i++) {
                rowDataLst.add(rs.getString(i));
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getRowDataAsList");
            e.printStackTrace();
        }
        return rowDataLst;
    }
    public static  Map<String,String> getRowDataAsMap(int rowNum) {
        Map<String,String> rowMap = new HashMap<>();
        try {
            rs.absolute(rowNum);
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i = 1; i <= getColumnCNT(); i++) {
                rowMap.put(rsmd.getColumnName(i), rs.getString(i));
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getRowDataAsList");
            e.printStackTrace();
        }
        return rowMap;
    }
    public static List<Map<String,String> > getAllDataAsListOfMap(){
        List<Map<String,String> > rowMapList = new ArrayList<>();
        for (int i = 0; i < getRowCount(); i++) {
            rowMapList.add(   getRowDataAsMap(i)    ) ;
        }
        return rowMapList ;

    }


    public static List<String> getColumnNameList() {
        List<String> colLst = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                colLst.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING THE COLUMN NAMES");
            e.printStackTrace();
        }
        return colLst;

    }



    public static String getColumnDataAtRow (int rowNum , int columnIndex){
        String result = "" ;
        try {
            rs.absolute( rowNum ) ;
            result = rs.getString( columnIndex ) ;
        } catch (SQLException e) {
            System.out.println("ERROR WHILE getColumnDataAtRow ");
            e.printStackTrace();
        }
        return result ;
    }




}
///54.144.140.185 my ip