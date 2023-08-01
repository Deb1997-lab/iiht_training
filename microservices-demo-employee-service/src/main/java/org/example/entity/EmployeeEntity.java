package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employee_name")
	private String employeeName;
	
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="departmnet_name")
	private String departmentName;

	public EmployeeEntity(String employeeName, int departmentId, String departmentName) {
		super();
		this.employeeName = employeeName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}
	
	
	
	
}
