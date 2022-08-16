package com.example.servletTest1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取对象
        ServletContext servletContext = getServletContext();

        servletContext.setAttribute("key1","value1");

        Object attribute = servletContext.getAttribute("key1");

        System.out.println(attribute);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
