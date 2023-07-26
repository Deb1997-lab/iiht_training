package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Student;

public interface StudentDao {
	public void addStudent(Student student) throws SQLException;
    public List<Student> showStudent() throws SQLException;
}
