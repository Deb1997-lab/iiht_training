package org.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@SuppressWarnings("serial")
@Entity
@Table(name="projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Project implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long projectId;
	
	@NonNull
	@Column(name = "project_name")
	private String name;
	
	
	@NonNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NonNull
	@Column(name = "end_date")
	private Date endDate;
	
	@NonNull
	@Column(name="githubLink")
	private String githubLink;
	
	@NonNull
	@Column(name="budget")
	private Long budget;
	
	@Column(name = "is_completed", columnDefinition = "boolean default 0")
	private boolean isCompleted;
	
	@ManyToOne(optional=false,targetEntity = Employee.class)
    @JoinColumn(name="manager_id")
	private Employee managerId;
}
