package com.test;

import java.sql.*;
import java.util.List;

public class PostgresSqlTest {
    public static void main(String[] args) throws SQLException {
        selectAll();

    }

    public static List selectAll() throws SQLException {
        String sql="select * from test_ser ";
        Connection connection = PostgresSqlConnectUtil.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println( resultSet.getInt(1)+"---"+
                     resultSet.getInt(1)+"---"+ resultSet.getInt(3));
        }
        return  null;
    }


}
