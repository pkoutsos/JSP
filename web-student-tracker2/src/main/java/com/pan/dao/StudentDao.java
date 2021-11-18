package com.pan.dao;

import com.pan.model.Student;
import com.pan.utils.StudentDbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {


    Statement statement = null;
    ResultSet resultSet = null;


    public List<Student> findAll() throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        //create sql statement
        String sql = "SELECT * FROM student";
        statement = connection.createStatement();

        //execute query
        resultSet = statement.executeQuery(sql);

        List<Student> studentList = new ArrayList<>();

        //process result set
        while (resultSet.next()) {
            Student student = new Student();

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));

            studentList.add(student);
        }

        return studentList;
    }

    public Student findById(Long id) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        //create sql statement
        String sql = "SELECT * FROM student WHERE id =" + id;
        statement = connection.createStatement();

        //execute query
        resultSet = statement.executeQuery(sql);

        Student student = new Student();

        //process result set
        while (resultSet.next()) {

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));

        }

        return student;
    }

    public Student findByFirstName(String firstName) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        //create sql statement
        String sql = "SELECT * FROM student WHERE first_name=" + firstName;
        statement = connection.createStatement();

        //execute query
        resultSet = statement.executeQuery(sql);

        Student student = new Student();

        //process result set
        while (resultSet.next()) {

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));

        }

        return student;
    }

    public Student findByLastName(String lastName) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        //create sql statement
        String sql = "SELECT * FROM student WHERE last_name=" + lastName;
        statement = connection.createStatement();

        //execute query
        resultSet = statement.executeQuery(sql);

        Student student = new Student();

        //process result set
        while (resultSet.next()) {

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));

        }

        return student;
    }

    public Student findByEmail(String email) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        //create sql statement
        String sql = "SELECT * FROM student WHERE email=" + email;
        statement = connection.createStatement();

        //execute query
        resultSet = statement.executeQuery(sql);

        Student student = new Student();

        //process result set
        while (resultSet.next()) {

            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("first_name"));
            student.setLastName(resultSet.getString("last_name"));
            student.setEmail(resultSet.getString("email"));

        }

        return student;
    }

    public void update(List<Student> studentList) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        String sql = null;
        statement = connection.createStatement();

        for (Student student : studentList) {
            sql = "UPDATE student SET (first_name,last_name,email) values (" +
                    student.getFirstName() + "," + student.getLastName() + "," + student.getEmail() + ")";

            statement.executeQuery(sql);
        }
    }

    public void insert(List<Student> studentList) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        String sql = null;
        statement = connection.createStatement();

        for (Student student : studentList) {
            sql = "INSERT INTO student (id,first_name,last_name,email) values (" + student.getId() + "," +
                    student.getFirstName() + "," + student.getLastName() + "," + student.getEmail() + ")";

            statement.executeQuery(sql);
        }
    }

    public void delete(Long id) throws SQLException {
        Connection connection = StudentDbUtil.getConnection();

        String sql = null;
        statement = connection.createStatement();

        sql = "DELETE FROM student WHERE id = " + id;

        statement.executeQuery(sql);
    }
}
