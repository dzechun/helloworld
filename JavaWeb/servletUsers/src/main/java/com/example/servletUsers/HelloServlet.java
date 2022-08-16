package com.example.servletUsers;

import javax.servlet.*;
import javax.servlet.Servlet;
import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet(){
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init初始化方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }



    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet 被访问了");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
