package org.example.service;

import org.example.entity.DepartmentEntity;
import org.example.repo.DepartmentRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepository deptRepo;
	@Override
	public DepartmentEntity findByDepartmentName(String departmentName) {
		// TODO Auto-generated method stub
		return deptRepo.findByDepartmentName(departmentName);
	}

}
