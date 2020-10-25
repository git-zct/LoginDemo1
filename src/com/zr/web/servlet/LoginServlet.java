package com.zr.web.servlet;

import com.zr.service.UserService;
import com.zr.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 */
public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {
        String username=req.getParameter("username"); //获取jsp中的username值
        String password=req.getParameter("password");//获取jsp中的password值
        if(userService.login(username,password)){
            //登陆成功
            resp.getWriter().write("success");
            //创建session对象
            HttpSession session = req.getSession();
            //把用户数据保存在session域对象中
            session.setAttribute("user", username);
            //跳转到用户主页
           // resp.sendRedirect(req.getContextPath()+"hello.jsp");

            resp.sendRedirect("hello.jsp");
        }else {
            resp.getWriter().write("failure");
            resp.sendRedirect("faillogin.jsp");
        }
    }
}