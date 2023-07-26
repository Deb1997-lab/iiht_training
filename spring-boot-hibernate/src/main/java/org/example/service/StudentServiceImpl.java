package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private final StudentDao studentDao;
	
	@Override
	public List<Student> getList() throws SQLException {
		return studentDao.getList();
	}

	@Override
	public Student findbyId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.findbyId(id);
	}

	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
		
	}

	@Override
	public void updateStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		studentDao.deleteStudent(student);
	}

}
