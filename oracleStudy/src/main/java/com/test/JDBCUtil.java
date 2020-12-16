package com.test;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public  class JDBCUtil {
    private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
    //jdbc:oracle:thin:@127.0.0.1:1521:test    后面的这个test指的就是 SID  也可以对应服务中的 一个OracleServiceTEST 这服务
    private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:test";
    private  static final String USER="system";  //对应navicat 中的一级目录，说明用户名称
    private static final String PWD="Txc15972879798";  //密码整个库都是一样的 至于不同用户名不同密码，应该也是可以设置的

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USER,PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public void close(Connection connection, PreparedStatement preparedStatement, Statement statement,ResultSet resultSet){
        if (resultSet!=null){
            try {
                resultSet.close();
                if (statement!=null){
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
