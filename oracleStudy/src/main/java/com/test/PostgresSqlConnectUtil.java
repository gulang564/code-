package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresSqlConnectUtil {
    public static Connection  getConnection(){
        Connection conn=null    ;
        try {
             conn = DriverManager.getConnection(
                    "jdbc:postgresql://192.168.152.128:5432/testdb", "postgres", "123456");

            if (conn != null) {
                System.out.println("Connected to the database!");
                return conn;
            } else {
                System.out.println("Failed to make connection!");
            }
        }catch (Exception e)  {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
