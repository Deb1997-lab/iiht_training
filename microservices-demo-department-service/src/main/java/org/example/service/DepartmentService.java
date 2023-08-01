package org.example.service;

import org.example.entity.DepartmentEntity;

public interface DepartmentService {
	
	DepartmentEntity findByDepartmentName(String departmentName);
}
