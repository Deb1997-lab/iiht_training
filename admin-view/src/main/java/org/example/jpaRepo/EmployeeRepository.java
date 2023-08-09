package org.example.jpaRepo;

import java.util.List;

import org.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.userType != 'ADMIN'")
	List<Employee> findAllNonAdminEmployees();
	
	@Query("SELECT e FROM Employee e WHERE (e.firstName LIKE %:keyword% OR " +
		       "e.middleName LIKE %:keyword% OR e.lastName LIKE %:keyword% OR " +
		       "e.username LIKE %:keyword%) AND e.userType != 'ADMIN'")
	List<Employee> findNonAdminEmployeesByKeyword(String keyword);
}
