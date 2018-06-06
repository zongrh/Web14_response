package com.itzon.content;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Zon on 2018/6/5.
 */
@WebServlet("/downloadservlet2")
public class MyDownloadServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获得要下载的文件的名称
        String filename = request.getParameter("filename");//a.flv

        //要下载的这个文件的类型-----客户端通过文件的MIME类型去区分类型
        response.setContentType(this.getServletContext().getMimeType(filename));
        //告诉客户端该文件不是直接解析 而是以附件形式打开(下载)
        response.setHeader("Content-Disposition", "attachment;filename="+filename);

        //获取文件的绝对路径
        String path = this.getServletContext().getRealPath("download/"+filename);
        //获得该文件的输入流
        InputStream in = new FileInputStream(path);
        //获得输出流---通过response获得的输出流 用于向客户端写内容
        ServletOutputStream out = response.getOutputStream();
        //文件拷贝的模板代码
        int len = 0;
        byte[] buffer = new byte[1024];
        while((len=in.read(buffer))>0){
            out.write(buffer, 0, len);
        }

        in.close();
        //out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
