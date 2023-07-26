package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.example.factory.JDBCConnection;
import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JDBCConnection jdbcon;
	
	
	@Override
	public void addStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = jdbcon.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement("INSERT INTO student_table(first_name,last_name,country) VALUES(?,?,?)");
			pst.setString(1, student.getFirstName());
			pst.setString(2, student.getLastName());
			pst.setString(3, student.getCountry());
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> showStudent() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
