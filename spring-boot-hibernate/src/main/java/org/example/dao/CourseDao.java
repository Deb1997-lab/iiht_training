package org.example.dao;

import java.util.List;

import org.example.model.Course;

public interface CourseDao {
	public List<Course> getCourses();
	
	public Course findById(String id);
	
	public void addCourse(Course course);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(Course course);
}
