package com.itzon.header;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
//        设置响应头
        response.setHeader("name", "zhangsan");

        //设置响应头
        response.addHeader("name", "zhangsan");
        //response.addIntHeader("age", 28);
        response.addDateHeader("birthday", date.getTime());

        response.addHeader("name", "lisi");

        response.setHeader("age", "28");
        response.setHeader("age", "50");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
