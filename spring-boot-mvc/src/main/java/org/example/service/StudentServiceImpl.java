package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.StudentDaoImpl;
import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDaoImpl studentDao;
	
	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
	}

	@Override
	public List<Student> showStudent() throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.showStudent();
	}

}
