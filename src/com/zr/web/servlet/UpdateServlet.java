package com.zr.web.servlet;

import com.zr.utils.JdbcUtils;
import com.mysql.jdbc.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");


        int id=Integer.valueOf(request.getParameter("id"));
        int age=Integer.valueOf(request.getParameter("age"));
        String name=request.getParameter("name");
        String tel=request.getParameter("tel");
        Connection connection=null;

        try {
            connection= JdbcUtils.getConn();
            String sql="update users set name=?,age=?,tel=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(4,id);
            ps.setInt(2,age);
            ps.setString(1,name);
            ps.setString(3,tel);
            int i = ps.executeUpdate();
            System.out.println("成功修改"+i);
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("FindServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
