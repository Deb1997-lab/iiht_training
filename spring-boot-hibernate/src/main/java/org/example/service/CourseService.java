package org.example.service;

import java.util.List;

import org.example.model.Course;

public interface CourseService {
public List<Course> getCourses();
	
	public Course findById(String id);
	
	public void addCourse(Course course);
	
	public void updateCourse(Course course);
	
	public void deleteCourse(Course course);
}
