package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Student;

public interface StudentService {
	public List<Student> getList() throws SQLException;
	
	public Student findbyId(int id) throws SQLException;
	
	public void addStudent(Student student) throws SQLException;
	
	public void updateStudent(Student student) throws SQLException;
	
	public void deleteStudent(Student student) throws SQLException;
}
