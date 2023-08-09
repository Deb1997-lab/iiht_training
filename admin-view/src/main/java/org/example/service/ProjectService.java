package org.example.service;

import java.util.List;

import org.example.entity.Project;

public interface ProjectService {
	
	List<Project> getAllProjects();
	
	Project findById(long id);
	
	List<Project> findCompletedProjects();
	
	List<Project> findOngoingProjects();
	
	List<Project> findCompletedProjectsByStartDate(int year);
	
	List<Project> findOngoingProjectsByStartDate(int year);
	
	Project addProject(Project project);
	
	
	
	
	
}
