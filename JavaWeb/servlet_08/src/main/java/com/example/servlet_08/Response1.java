package com.example.servlet_08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1");
//设置响应状态码302,表示重定向
        resp.setStatus(302);
//设置响应头,说明新的地址在哪里
        resp.setHeader("location","http://localhost:8080/servlet_08_war_exploded/rs2");

//        方式二(推荐)
        resp.sendRedirect("http://localhost:8080/servlet_08_war_exploded/rs2");
    }
}
