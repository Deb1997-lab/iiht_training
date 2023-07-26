package org.example.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="course_list")
public class Course {
	@Id
	private String courseId;
	@Column(name="course_name")
	private String courseName;
	@Column(name="course_price")
	private double coursePrice;
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "course")
	private Collection<Student> students;
	
	
}
