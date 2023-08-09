package org.example.composite;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ProjectMemberComposite implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private long employeeId;
	private long projectId;
	
}
