package org.example.controller;

import org.example.entity.DepartmentEntity;
import org.example.service.DepartmentService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
	
	private final DepartmentService deptService;
	private final Environment environment;
	
	@GetMapping("/status")
	public String getStatus() {
		return ("Department service is up and running on port: "+environment.getProperty("local.server.port"));
	}
	
	@GetMapping("/find/{departmentName}")
	public DepartmentEntity findByName(@PathVariable("departmentName") String departmentName) {
		return deptService.findByDepartmentName(departmentName);
	}
	
}
