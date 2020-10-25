package com.zr.web.servlet;

import com.zr.user.User;
import com.zr.utils.JdbcUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@WebServlet("/FindServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn= JdbcUtils.getConn();
        String sql="select * from users";
        try {
            Statement stmt= (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<User> list=new ArrayList<User>();
            while(rs.next()){
                User user=new User();
                user.setName(rs.getString("name"));
                user.setTel(rs.getString("tel"));
                user.setAge(rs.getInt("age"));
                user.setId(rs.getInt("id"));
                list.add(user);
            }
            request.setAttribute("list",list);
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
