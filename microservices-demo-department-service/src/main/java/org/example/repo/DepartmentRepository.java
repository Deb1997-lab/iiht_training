package org.example.repo;

import org.example.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer>{
	
	@Query
	DepartmentEntity findByDepartmentName(String departmentName);
}
