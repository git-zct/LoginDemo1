package com.zr.web.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 *
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {
        public int count=0;
    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        //又触发执行了session的属性的添加方法
        if(arg0.getName().equals("user")){
            count++;
            //将系统的登录用户的个数放到全局域对象sevletContext里面
            arg0.getSession().getServletContext().setAttribute("count",count);
            System.out.println("现在系统人数为"+count);
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        if(arg0.getName().equals("user")){
            arg0.getSession().getServletContext().setAttribute("count",count);
            System.out.println("现在系统人数为"+count);
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
