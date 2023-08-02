package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.model.Employee;

public interface EmployeeService {
	
	List<Employee> showAll();
	
	Employee addEmployee(Employee employee);
	
	Employee findById(String id);
	
	Employee updateEmployeebyId(String id, Employee employee);
	
	String deleteEmployeeById(String id);
	
	Employee findByEmailAndPassword(String email, String password);
	
	
}
