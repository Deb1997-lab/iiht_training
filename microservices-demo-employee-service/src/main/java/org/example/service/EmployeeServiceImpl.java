package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository empRepo;
	
	@Override
	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

}
