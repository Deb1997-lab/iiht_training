package org.example.service;

import java.util.List;
import java.util.Optional;

import org.example.entity.Employee;
import org.example.exception.RecordNotFoundException;
import org.example.jpaRepo.EmployeeRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository empRepo;
	
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAllNonAdminEmployees();
	}

	@Override
	public List<Employee> findByKeyWord(String keyword) {
		// TODO Auto-generated method stub
		List<Employee> op = empRepo.findNonAdminEmployeesByKeyword(keyword);
		if(op.isEmpty()) {
			throw new RecordNotFoundException("No results");
		}else {
			return op;
		}
		
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

}
