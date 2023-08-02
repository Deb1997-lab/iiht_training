package org.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("employee_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public Employee(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
}
