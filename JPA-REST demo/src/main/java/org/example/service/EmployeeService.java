package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.model.Employee;

public interface EmployeeService {
	Employee createEmployee(Employee employee);

	List<Employee> listEmployees();

	Optional<Employee> getEmployeeById(int employeeId);
	
	Employee updateEmployee(int id, Employee employee);
	
	boolean deleteEmployee(int id);
	
	List<Employee> findByFirstName(String firstName);
	
	List<Employee> findBySalaryRange(int minSalary, int maxSalary);
	
	List<Employee> findByKeyWord(String keyWord);
}
