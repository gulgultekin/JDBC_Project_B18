package com.cybertek.jdbc.day2;

import java.sql.ResultSet;

public class DB_Practice3 {


    public static void main(String[] args) {


        DB_Utility.createConnection();
       ResultSet rs =  DB_Utility.runQuery( "SELECT *FROM REGIONS" );








    }


}
