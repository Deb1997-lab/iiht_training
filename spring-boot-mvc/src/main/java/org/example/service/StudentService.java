package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Student;

public interface StudentService {
	public void addStudent(Student student) throws SQLException;
    public List<Student> showStudent() throws SQLException;
}
