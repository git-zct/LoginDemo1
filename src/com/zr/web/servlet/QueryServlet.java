package com.zr.web.servlet;

import com.zr.user.User;
import com.zr.utils.JdbcUtils;
import com.mysql.jdbc.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));

        try {
            Connection conn= JdbcUtils.getConn();
            String sql="select * from users where id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            User user=new User();
            while(rs.next()){
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                user.setTel(rs.getString("tel"));
                user.setId(rs.getInt("id"));
            }
            request.setAttribute("user",user);
            rs.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("ShowQuery.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
