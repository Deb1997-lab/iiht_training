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
	
	private final EmployeeRepository empRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> emOptional = empRepo.findById(employeeId);
		return emOptional;
	}

	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeOp = empRepo.findById(id);
		if(!employeeOp.isEmpty()) {
			Employee tempEmp = employeeOp.get();
			tempEmp.setFirstName(employee.getFirstName());
			tempEmp.setLastName(employee.getLastName());
			tempEmp.setSalary(employee.getSalary());
			return empRepo.save(tempEmp);
		}else {
			return null;
		}
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Optional<Employee> employeeOp = empRepo.findById(id);
		if(!employeeOp.isEmpty()) {
			empRepo.delete(employeeOp.get());
			flag = true;
		}
		return flag;
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		
		List<Employee> empList = empRepo.findByFirstName(firstName);
		if(!empList.isEmpty()) {
			return empList;
		}else {
			throw new EmployeeNotFoundException("Employee with first name "+firstName+" not found");
		}
		
	}

	@Override
	public List<Employee> findBySalaryRange(int minSalary, int maxSalary) {
		List<Employee> empList = empRepo.findBySalaryRange(minSalary, maxSalary);
		if(!empList.isEmpty()) {
			return empList;
		}else {
			throw new EmployeeNotFoundException("No employees found within this salary range");
		}
	}

	@Override
	public List<Employee> findByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		List<Employee> empList = empRepo.findByKeyword(keyWord);
		if(!empList.isEmpty()) {
			return empList;
		}else {
			throw new EmployeeNotFoundException("No search results found");
		}
	}

}
