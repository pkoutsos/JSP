package com.example.servletdemo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Step 1: set the content type
        response.setContentType("text/html");

        //Step 2: get the printwriter
        PrintWriter out = response.getWriter();

        //Step 3: generate HTML Content
        // Hello
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<hr>");
        out.println("Time on the server is:" + new java.util.Date());
        out.println("</body></html>");
    }

    public void destroy() {
    }
}