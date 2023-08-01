package org.example.controller;

import org.example.dto.DepartmentDto;
import org.example.entity.EmployeeEntity;
import org.example.exception.DepartmentNotFoundException;
import org.example.service.EmployeeService;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {
	
	private final EmployeeService empService;
	private final Environment environment;
	private final RestTemplate restTemplate;
	
	@GetMapping("/status")
	public ResponseEntity<?> getStatus(){
		return ResponseEntity.ok("Employee service is up and running on port: "+environment.getProperty("local.server.port"));
	}
	
	@PostMapping("/save/{departmentName}")
	public ResponseEntity<?> createEmployee(@PathVariable("departmentName") String departmentName,@RequestBody EmployeeEntity employee){
		Object obj = restTemplate.getForObject("http://localhost:9999/department-service/departments/find/" + departmentName,
				DepartmentDto.class);
		if(obj==null) {
			throw new DepartmentNotFoundException("Department with name: "+departmentName+" does not exist");
		}else {
			DepartmentDto dto = (DepartmentDto)obj;
			employee.setDepartmentId(dto.getDepartmentId());
			employee.setDepartmentName(dto.getDepartmentName());
			return ResponseEntity.ok(empService.addEmployee(employee));
		}
		
	}
	
}
