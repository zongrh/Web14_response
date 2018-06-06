package com.itzon.content;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/text")
public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        //设置response查询的码表
        //response.setCharacterEncoding("UTF-8");

        //通过一个头 Content-Type 告知客户端使用何种码表
        //response.setHeader("Content-Type", "text/html;charset=UTF-8");

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = response.getWriter();
        writer.write("你好啊！");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
