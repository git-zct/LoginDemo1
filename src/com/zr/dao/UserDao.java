package com.zr.dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.zr.bean.User;
import com.zr.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class UserDao {
    //这里实现的是传入一个username和一个password，从数据库中查找是否存在这一对数据
    public User findUserByUserNameAndPassword(String username, String password){
        Connection connection= null;
        PreparedStatement statement=null;
        ResultSet resultSet =null;
        User user=null;
        try {
            //2.连接数据库
            connection = (Connection) DBUtil.getConnection();
            //3.写sql语句
            String sql="select * from tb_user where username=? and password=?";
            //4.获得statement对象
            statement= (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            //5.执行sql 得到结果集
            resultSet = statement.executeQuery();
            //6.处理结果集
            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //7.关闭资源
            try {
                DBUtil.closeAll(resultSet,statement,connection);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user;
    }

}
