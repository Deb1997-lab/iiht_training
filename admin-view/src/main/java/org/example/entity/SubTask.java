package org.example.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="subtasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class SubTask implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_task_id")
	private Long subTaskId;
	
	@NonNull
	@ManyToOne(optional=true,targetEntity = Task.class)
    @JoinColumn(name="task_id")
	private Task taskId;	
	
	@ManyToOne(optional=false,targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employeeId;
	
	@Column(name = "sub_task_title")
	private String subTaskTitle;
	
	@Column(name = "sub_task_description")
	private String subTaskDescription;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "progress_percentage",columnDefinition = "bigint default 0")
	private Long progressPercentage;
	
	@Column(name = "comment")
	private String comment;
}
