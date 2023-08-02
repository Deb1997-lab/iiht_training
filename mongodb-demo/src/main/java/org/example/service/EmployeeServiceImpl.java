package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.exception.EmployeeNotFoundException;
import org.example.model.Employee;
import org.example.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
		
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Employee findById(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = empRepo.findById(id);
		if(employee.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id: "+id+" does not exist");
		}else {
			return employee.get();
		}
		
		
	}

	@Override
	public Employee updateEmployeebyId(String id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> tempEmp = empRepo.findById(id);
		if(tempEmp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id: "+id+" does not exist");
		}
		else {
			Employee emp = tempEmp.get();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			emp.setPassword(employee.getPassword());
			return empRepo.save(emp);
		}
	}

	@Override
	public String deleteEmployeeById(String id) {
		// TODO Auto-generated method stub
		Optional<Employee> tempEmp = empRepo.findById(id);
		if(tempEmp.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with id: "+id+" does not exist");
		}else {
			empRepo.deleteById(id);
			return "Employee with id: "+id+" deleted successfully";
		}
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Optional<Employee> tempEmp = empRepo.findByEmailAndPassword(email, password);
		if(tempEmp.isEmpty()) {
			return null;
		}else {
			return tempEmp.get();
		}
	}

}
