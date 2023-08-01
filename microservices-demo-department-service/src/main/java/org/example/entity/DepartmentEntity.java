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
@Table(name="department_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="department_location")
	private String departmentLocation;

	public DepartmentEntity(String departmentName, String departmentLocation) {
		super();
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	
	
}
