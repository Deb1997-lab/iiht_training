package org.example;

import org.example.entity.DepartmentEntity;
import org.example.repo.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.AllArgsConstructor;

@SpringBootApplication
@EnableEurekaClient
@AllArgsConstructor
public class MicroservicesDemoDepartmentServiceApplication implements CommandLineRunner{
	
	private final DepartmentRepository deptRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDemoDepartmentServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		deptRepo.save(new DepartmentEntity("Sales","Kolkata"));
		deptRepo.save(new DepartmentEntity("IT","Bengaluru"));
		deptRepo.save(new DepartmentEntity("HR","Mumbai"));
		
		
	}

}
