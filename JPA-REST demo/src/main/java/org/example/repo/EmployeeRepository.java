package org.example.repo;
import java.util.List;

import org.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	@Query
	List<Employee> findByFirstName(String firstName);
	
	@Query("SELECT e FROM Employee e WHERE e.salary >= :minSalary AND e.salary <= :maxSalary")
	List<Employee> findBySalaryRange(int minSalary, int maxSalary);
	
	@Query("SELECT e FROM Employee e WHERE e.firstName LIKE %:keyWord% OR e.lastName LIKE %:keyWord%")
	List<Employee> findByKeyword(String keyWord);
	
	
};
