package org.example.service;

import java.util.List;

import org.example.entity.ProjectMember;

public interface ProjectMemberService {
	
	List<ProjectMember> getByEmployeeId(long empId);
	
	List<ProjectMember> getByProjectId(long projId);
	
	List<ProjectMember> getAllProjects();
	
	
}
