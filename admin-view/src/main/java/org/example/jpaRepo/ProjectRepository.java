package org.example.jpaRepo;

import java.util.List;

import org.example.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findAllByOrderByStartDateAsc();
	
	//completed projects
	@Query("SELECT p FROM Project p WHERE p.isCompleted=true")
	List<Project> getAllCompletedProjects();
	
	//ongoing projects
	@Query("SELECT p FROM Project p WHERE p.isCompleted=false")
	List<Project> getAllOngoingProjects();
	
	//ongoing projects by start year
	@Query("SELECT p FROM Project p WHERE p.isCompleted=false AND YEAR(p.startDate)=:year")
	List<Project> getAllOngoingProjectsByStartYear(int year);
	
	//completed projects by start year
	@Query("SELECT p FROM Project p WHERE p.isCompleted=true AND YEAR(p.startDate)=:year")
	List<Project> getAllCompletedProjectsByStartYear(int year);
}
