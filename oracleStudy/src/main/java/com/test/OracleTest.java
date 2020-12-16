package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest {


    public static void main(String[] args) throws SQLException {
       /* Insert();
        query();
        System.out.println("------------update-------------");
        Updata();
        System.out.println("------------query--------------");
        query();*/


        Delete();
        query();
    }


    public static void Updata() throws SQLException {
        JDBCUtil jdbcUtils=new JDBCUtil();
        Connection connection=jdbcUtils.getConnection();
        Statement st=null;
        try {
            st=connection.createStatement();
            String sql="update \"users\" set ID=1002 where name='古富升'";
            int result=st.executeUpdate(sql);
            if(result>0)
                System.out.println("更改成功");
            else
                System.out.println("更改失败");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void query() throws SQLException {
        JDBCUtil jdbcUtils=new JDBCUtil();
        Connection connection=jdbcUtils.getConnection();
        System.out.println(connection);
        if (connection!=null){
            System.out.println("success" );
            Statement statement = connection.createStatement();

            // oracle 对大小写有要求， 同样在引号里面的表，表 名称原本是 大写则在引号内可以直接使用例子如下
            // ResultSet resultSet = statement.executeQuery("select * from GOODS");
            //所以，建表的时候，还是以大写的表名为好，这样就不需要转义了 "users"
            ResultSet resultSet = statement.executeQuery("select * from \"users\"");

            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+"    " +resultSet.getString(2));
                //System.out.println(resultSet.getString(1));
            }

        }else
            System.out.println("fail");
    }

    public static void Insert(){
        Connection conn=null;
        Statement st=null;
        conn=JDBCUtil.getConnection();
        try {
            //获得连接
            st=conn.createStatement();
            //创建插入的sql语句
            String sql="insert into \"users\" values(1002,'大佬')";
            //返回一个进行此操作的结果，要么成功，要么失败，如果返回的结果>0就是成功，反之失败
            int result=st.executeUpdate(sql);
            if(result>0) {
                System.out.println("添加成功");
            }
            else {
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void Delete (){
        Connection conn=null;
        Statement st=null;
        conn=JDBCUtil.getConnection();
        try {
            st=conn.createStatement();
            String sql="DELETE FROM \"users\" WHERE \"USER_ID\"=1002";
            int result=st.executeUpdate(sql);

            System.out.println("result=====>"+result);

            //和插入一样，如果返回的结果大于0则操作成功
            if(result>0) {
                System.out.println("删除成功");
            }
            else{
                System.out.println("删除失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
