package com.zr.utils;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class JdbcUtils {
    public static Connection getConn(){
        String driver="com.mysql.jdbc.Driver";
        String name="root";
        String password="root";
        String url="jdbc:mysql:///m?useUnicode=true&characterEncoding=utf8";
        Connection conn=null;
        try {
            Class.forName(driver);
             conn= (Connection) DriverManager.getConnection(url, name, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
}
