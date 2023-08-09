package org.example.service;

import java.util.List;

import org.example.entity.Employee;

public interface EmployeeService {
	
	Employee addEmployee(Employee employee);
	
	List<Employee> findAll();
	
	List<Employee> findByKeyWord(String keyword);
	
}
