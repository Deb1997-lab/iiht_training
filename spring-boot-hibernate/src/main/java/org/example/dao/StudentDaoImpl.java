package org.example.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
@EnableTransactionManagement
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private final EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Student> getList() throws SQLException {
		TypedQuery<Student> query = entityManager.createQuery("FROM Student S", Student.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void addStudent(Student student) throws SQLException {
		
		entityManager.persist(student);
	}

	@Override
	@Transactional
	public void updateStudent(Student student) throws SQLException {
		
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public Student findbyId(int id) throws SQLException {
		
		return entityManager.find(Student.class, id);
	}

	@Override
	@Transactional
	public void deleteStudent(Student student) throws SQLException {
		// TODO Auto-generated method stub
		entityManager.remove(student);
	}

}
