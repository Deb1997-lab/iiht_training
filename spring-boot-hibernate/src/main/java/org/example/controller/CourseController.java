package org.example.controller;

import java.util.List;

import org.example.model.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/showCourses")
	public String getCourseList(Model theModel) {
		List<Course> clist = courseService.getCourses();
		theModel.addAttribute("courses",clist);
		
		return "course-list";
	}
	
}
