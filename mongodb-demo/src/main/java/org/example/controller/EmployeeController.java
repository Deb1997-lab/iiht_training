package org.example.controller;

import java.util.List;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService empService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return ResponseEntity.ok(empService.showAll());
	}
	
	@PostMapping("/save")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(empService.addEmployee(employee));
	}
	
	@GetMapping("/find/{empId}")
	public ResponseEntity<?> findById(@PathVariable("empId") String empId){
		return ResponseEntity.status(HttpStatus.FOUND).body(empService.findById(empId));
	}
	
	@GetMapping("/find/{email}/{password}")
	public Employee findByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
		return empService.findByEmailAndPassword(email, password);
	}
	
	@PatchMapping("/update/{empId}")
	public ResponseEntity<?> updateById(@PathVariable("empId") String empId, @RequestBody Employee employee){
		return ResponseEntity.ok(empService.updateEmployeebyId(empId, employee));
	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteById(@PathVariable("empId") String empId){
		return ResponseEntity.ok(empService.deleteEmployeeById(empId));
	}
}
