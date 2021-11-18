package com.luv2code.web.jdbc;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestServlet extends HttpServlet {

    private static final String USERNAME = "webstudent";
    private static final String PASSWORD = "webstudent";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost:3306/web_student_tracker";


    //Define datasource/connection pool for Resource Injection
//    @Resource(name = "jdbc/web_student_tracker")
//    private DataSource dataSource;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Step 1 : Set up the printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        // Step 2: Get a connection to the database
        Connection myConn;
        Statement statement;
        ResultSet resultSet;

        try {
          myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
          //   myConn = dataSource.getConnection();

            //Step 3 : Create a SQL statements
            String sql = "SELECT * FROM student";
            statement = myConn.createStatement();

            //Step 4: Execute SQL query
            resultSet = statement.executeQuery(sql);

            //Step 5 : Process the result set
            while (resultSet.next()){
                String email = resultSet.getString("email");
                out.println("*********");
                out.println(email);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }



    }

}

