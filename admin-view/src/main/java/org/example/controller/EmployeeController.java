package org.example.controller;

import java.util.List;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService empService;
	private final Environment env;
	
	@GetMapping("/employees/status")
	public String getStatus() {
		return env.getProperty("server.port");
	}
	
	
	@GetMapping("/employees/findAll")
	public ResponseEntity<List<Employee>> findAll(){
		return ResponseEntity.ok(empService.findAll());
	}
	
	@GetMapping("/employees/find/{keyword}")
	public ResponseEntity<List<Employee>> findByKeyword(@PathVariable("keyword") String keyword){
		return ResponseEntity.status(HttpStatus.FOUND).body(empService.findByKeyWord(keyword));
	}
	
	@PostMapping("/employees/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(empService.addEmployee(employee));
	}
	
	
}
