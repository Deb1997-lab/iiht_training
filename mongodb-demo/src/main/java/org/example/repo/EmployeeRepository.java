package org.example.repo;

import java.util.Optional;

import org.example.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
	
	public Optional<Employee> findByEmailAndPassword(String email, String password);
}
