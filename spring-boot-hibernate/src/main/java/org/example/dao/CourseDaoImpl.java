package org.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.example.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
@EnableTransactionManagement
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Course> getCourses() {
		TypedQuery<Course> query = entityManager.createQuery("FROM Course C", Course.class);
		List<Course> courses = query.getResultList();
		return courses;
	}

	@Override
	public Course findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		entityManager.persist(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		
	}

}
