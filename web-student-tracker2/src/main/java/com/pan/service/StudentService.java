package com.pan.service;

import com.pan.dao.StudentDao;
import com.pan.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    StudentDao studentDao = new StudentDao();

    public List<Student> findAll() throws SQLException {
        return studentDao.findAll();
    }

    public Student findById(Long id) throws SQLException {
        return studentDao.findById(id);
    }

    public Student findByFirstName(String firstName) throws SQLException {
        return studentDao.findByFirstName(firstName);
    }

    public Student findByLastName(String lastName) throws SQLException {
        return studentDao.findByLastName(lastName);
    }

    public Student findByEmail(String email) throws SQLException {
        return studentDao.findByEmail(email);
    }

    public void update(List<Student> studentList) throws SQLException {
        studentDao.update(studentList);
    }

    public void insert(List<Student> studentList) throws SQLException {
        studentDao.insert(studentList);
    }

    public void delete(Long id) throws SQLException {
        studentDao.delete(id);
    }

}
