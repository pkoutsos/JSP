package com.pan.utils;

import com.pan.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDbUtil {

    private static final String USERNAME = "webstudent";
    private static final String PASSWORD = "webstudent";
    private static final String CONN_STRING =
            "jdbc:mysql://localhost:3306/web_student_tracker";

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
    }
}
