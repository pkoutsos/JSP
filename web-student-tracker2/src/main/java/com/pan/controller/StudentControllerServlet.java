package com.pan.controller;

import com.pan.model.Student;
import com.pan.service.StudentService;
import com.pan.utils.StudentDbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

//This class implements above interface. This class is responsible to get data from a data source which can be database
@WebServlet(name = "StudentControllerServlet", value = "/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

    Connection connection;

    @Override
    public void init() throws ServletException {
        super.init();

        //create our student db util ... and pass in the conn pool / datasource
        try {
            connection = StudentDbUtil.getConnection();
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        StudentService studentService = new StudentService();

        //Step 1 : Set up the printwriter
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        try {
            out.println(studentService.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }


       /* // list the students ... in MVC fashion
        try {
            liststudents(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


   /* private void liststudents(HttpServletRequest request, HttpServletResponse response)  throws Exception {

        // get students from db util
        //List<Student> students = studentDbUtil.getStudents();

        // add students to the request
        //request.setAttribute("STUDENT_LIST",students);

        //send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request,response);
    }*/
}
