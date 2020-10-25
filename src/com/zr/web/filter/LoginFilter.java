package com.zr.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *完成登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
       //1.强制转换
        HttpServletRequest request=(HttpServletRequest) req;

        //2. 获取资源请求路径
        String uri=request.getRequestURI();
        //3.判断是否包含登录相关资源路径
        if(uri.contains("/loginPage.jsp")||uri.contains("/LoginServlet")||uri.contains("faillogin.jsp")||uri.contains("login")){
            //包含，证明用户就是想登录

            chain.doFilter(req, resp);
        }else {
            //判断用户是否登录
            //3.从session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user!=null){
                //登录了，放行
                chain.doFilter(req,resp);
            }else{
                //没登录
                request.setAttribute("login_msg","您尚未登录，请先登录");
                request.getRequestDispatcher("loginPage.jsp").forward(request,resp);
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
