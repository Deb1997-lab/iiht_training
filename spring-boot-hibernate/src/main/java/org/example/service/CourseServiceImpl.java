package org.example.service;

import java.util.List;

import org.example.dao.CourseDao;
import org.example.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.getCourses();
	}

	@Override
	public Course findById(String id) {
		// TODO Auto-generated method stub
		return courseDao.findById(id);
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.addCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.updateCourse(course);
	}

	@Override
	public void deleteCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.deleteCourse(course);
	}

}
