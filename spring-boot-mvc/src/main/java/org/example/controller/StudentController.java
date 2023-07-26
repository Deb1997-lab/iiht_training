package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Student;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a student object
		Student theStudent = new Student();
		List<String> countries = new ArrayList<>();
		countries.add("Select");
		countries.add("India");
		countries.add("China");
		countries.add("Brazil");
		countries.add("Japan");
		// add student object to the model
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("countries", countries);

		return "student-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {

		try{
			studentService.addStudent(theStudent);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

		return "student-confirmation";
	}
}
