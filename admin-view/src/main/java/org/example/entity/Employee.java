package org.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@SuppressWarnings("serial")
@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;
	
	@NonNull
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@NonNull
	@Column(name = "user_type")
	private String userType;
	
	@NonNull
	@Column(name = "username", unique = true)
	private String username;
	
	@NonNull
	@Column(name = "password")
	private String password;
	
	@Column(name = "skills")
	@NonNull
	private String[] skills;
	

	@Column(name = "availability", columnDefinition="boolean default 1")
	private boolean availability;
	
	@Column(name = "eul_agreement", columnDefinition="boolean default 0")
	private boolean eulAgreement;
}
