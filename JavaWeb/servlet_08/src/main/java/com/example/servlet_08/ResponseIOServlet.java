package com.example.servlet_08;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        System.out.println(resp.getCharacterEncoding());
//        设置服务器字符集为UTF-8
        resp.setCharacterEncoding("GBK");

//        通过响应头,设置浏览器也使用UTF-8字符集
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");

//        它会同时设置服务器和客户端都使用UTF-8字符集,还设置了响应头
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        writer.write("response's content!!");
        writer.write("操作成功");
    }
}
