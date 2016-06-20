package com.niklaus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by NiklausGeisser on 6/16/16.
 */
public class Testjdbc {
    public static void main(String[]args){
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("Connecting to Database"+jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
            System.out.println("Connection Successful");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
