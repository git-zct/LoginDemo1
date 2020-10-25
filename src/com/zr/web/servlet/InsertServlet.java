package com.zr.web.servlet;

import com.zr.utils.JdbcUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       response.setCharacterEncoding("utf-8");
        int id=Integer.valueOf(request.getParameter("id"));
       int age=Integer.valueOf(request.getParameter("age"));
       String name=request.getParameter("name");
       String tel=request.getParameter("tel");

        Connection conn= JdbcUtils.getConn();
        String sql="insert into users values(?,?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(4,tel);
            ps.setString(2,name);
            ps.setInt(3,age);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            System.out.println("成功存入"+i);
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("FindServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
