package org.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private final StudentService studentService;
	
	
	@GetMapping("/showList")
	public String showList(Model theModel) {
		try {
			List<Student> stud_list = studentService.getList();
			theModel.addAttribute("student_list",stud_list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "student-list";
	}
	
	@GetMapping("/addStudentForm")
	public String showAddForm(Model theModel) {
		Student student = new Student();
		theModel.addAttribute(student);
		return "add-student-form";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		try {
			studentService.addStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/student/showList";
	}
	
	@GetMapping("/updateStudentForm")
	public String showUpdateForm(@RequestParam("studentId") int id, Model theModel) {
		Student student;
		try {
			student = studentService.findbyId(id);
			theModel.addAttribute(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "update-student-form";
	}
	
	@PostMapping("/update")
	public String updateStudent(@ModelAttribute("student") Student student) {
		try {
			studentService.updateStudent(student);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/student/showList";
	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("studentId") int id) {
		Student student;
		try {
			student = studentService.findbyId(id);
			studentService.deleteStudent(student);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:/student/showList";
	}
	
}
