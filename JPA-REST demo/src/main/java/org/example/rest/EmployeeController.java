package org.example.rest;

import java.util.List;
import java.util.Optional;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.Employee;
import org.example.model.ErrorResponseModel;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	private final EmployeeService employeeService;
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleError(EmployeeNotFoundException e){
		ErrorResponseModel error = new ErrorResponseModel();
		error.setErrorTime(System.currentTimeMillis());
		error.setErrorMessage(e.getMessage());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees()
	{
		return ResponseEntity.ok(employeeService.listEmployees());
	}
	
	@GetMapping("/{employeeId}")
	public ResponseEntity<?> findEmployeeById(@PathVariable("employeeId") int employeeId)
	{
		Optional<Employee> optional=employeeService.getEmployeeById(employeeId);
		
		if(optional.isEmpty())
		{
			throw new EmployeeNotFoundException("Employee with given id: "+employeeId+" not found");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.FOUND).body(optional.get());
		}
	}
	
	@PatchMapping("/{employeeId}")
	public ResponseEntity<?> updateEmployeebyId(@PathVariable("employeeId") int employeeId, @RequestBody Employee employee )
	{
		Employee tempEmp = employeeService.updateEmployee(employeeId, employee);
		if (tempEmp==null) {
			throw new EmployeeNotFoundException("Employee with given id: "+employeeId+" not found");
		}else {
			return ResponseEntity.status(HttpStatus.CREATED).body(tempEmp);
		}
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<?> deleteEmployeebyId(@PathVariable("employeeId") int employeeId)
	{
		boolean flag = employeeService.deleteEmployee(employeeId);
		if(flag) {
			return ResponseEntity.status(HttpStatus.OK).body("employee with "+employeeId+" deleted");
		}else {
			throw new EmployeeNotFoundException("Employee with given id: "+employeeId+" not found");
		}
	}
	
	@PostMapping("/find/{firstName}")
	public ResponseEntity<?> findByFirstName(@PathVariable("firstName") String firstName)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.findByFirstName(firstName));
	}
	
	@PostMapping("/find/salary/{minSalary}&{maxSalary}")
	public ResponseEntity<?> findBySalaryRange(@PathVariable("minSalary") int minSalary, @PathVariable("maxSalary") int maxSalary)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.findBySalaryRange(minSalary, maxSalary));
		
	}
	
	@PostMapping("/find/key/{keyword}")
	public ResponseEntity<?> findByKeyWord(@PathVariable("keyword") String keyWord)
	{
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeService.findByKeyWord(keyWord));
	}
}
