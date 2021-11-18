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

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
    }

    public List<Student> getStudents() throws Exception {

        List<Student> students = new ArrayList<>();

        Connection myConn = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {

            // get a connection
            // myConn = dataSource.getConnection();
            myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            //create sql statement
            String sql = "SELECT * FROM student order by last_name";
            statement = myConn.createStatement();

            //execute query
            resultSet = statement.executeQuery(sql);

            //process result set
            while (resultSet.next()) {
                // retrieve data from result set row
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                //create new student object
                Student tempStudent = new Student(id, firstName, lastName, email);

                //add it to the list of students
                students.add(tempStudent);
            }


            return students;
        } finally {
            //close JDBC objects
            close(myConn, statement, resultSet);
        }
    }


    private void close(Connection myConn, Statement statement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (myConn != null) {
                myConn.close(); //does not really close it ... just puts back in connection pool
            }


        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }


    public void addStudent(Student theStudent) throws Exception {
        Connection myConn = null;
        PreparedStatement preparedStatement = null;

        try {
            //get db connection
            myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            // create sql for insert
            String sql = "insert into student "
                    + "(first_name, last_name, email)"
                    + "values (?, ?, ?)";

            preparedStatement = myConn.prepareStatement(sql);
            //set the param values for the student

            preparedStatement.setString(1, theStudent.getFirstName());
            preparedStatement.setString(2, theStudent.getLastName());
            preparedStatement.setString(3, theStudent.getEmail());

            //execute sql
            preparedStatement.execute();
        } finally {
            //clean up JDBC objects
            close(myConn, preparedStatement, null);


        }


    }

    public Student getStudent(String theStudentId) throws Exception {

        Student theStudent = null;

        Connection myConn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int studentId;

        try {
            //convert student id to int
            studentId = Integer.parseInt(theStudentId);

            //get connection to database
            myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            //create sql to get selected student
            String sql = "select * from student where id=?";

            //create prepared statement
            preparedStatement = myConn.prepareStatement(sql);

            //set params
            preparedStatement.setInt(1, studentId);

            //execute statement
            resultSet = preparedStatement.executeQuery();

            //retrieve data from result set row
            if (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                //use the studentId during construction
                theStudent = new Student(studentId, firstName, lastName, email);
            } else {
                throw new Exception("Could not find student id: " + studentId);
            }

            return theStudent;
        } finally {
            //clean up JDBC object
            close(myConn, preparedStatement, resultSet);

        }


    }

    public void updateStudent(Student theStudent) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {

            //get db connection
            myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            //create SQL update statement
            String sql = "UPDATE student SET first_name=?, last_name=? , email=? "
                    + "where id=?";


            //prepare statement
            myStmt = myConn.prepareStatement(sql);


            //set params
            myStmt.setString(1, theStudent.getFirstName());
            myStmt.setString(2, theStudent.getLastName());
            myStmt.setString(3, theStudent.getEmail());
            myStmt.setInt(4,theStudent.getId());

            //execute SQL statement
            myStmt.execute();
        }
        finally {
            close(myConn,myStmt,null);
        }

    }

    public void deleteStudent(String theStudentId) throws Exception {

        Connection myConn = null;
        PreparedStatement myStmt = null;

        try {
            //convert student id to int
            int studentId = Integer.parseInt(theStudentId);

            //get connection to database
            myConn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            //create sql to delete student
            String sql = "delete from student where id=?";

            //prepare statement
            myStmt = myConn.prepareStatement(sql);

            //set params
            myStmt.setInt(1,studentId);

            //execute sql statement
            myStmt.execute();

        } finally {
            //clean up JDBC code
            close(myConn,myStmt,null);
        }


    }
}
