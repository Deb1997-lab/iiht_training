package org.example.service;


import java.util.List;
import java.util.Optional;

import org.example.entity.Project;
import org.example.exception.RecordNotFoundException;
import org.example.jpaRepo.ProjectRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository projRepo;
	
	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		return projRepo.findAllByOrderByStartDateAsc();
	}

	@Override
	public Project findById(long id) {
		// TODO Auto-generated method stub
		Optional<Project> op = projRepo.findById(id);
		if(op.isEmpty()) {
			throw new RecordNotFoundException("No records found");
		}else {
			return op.get();
		}
		
	}

	@Override
	public List<Project> findCompletedProjects() {
		// TODO Auto-generated method stub
		List<Project> proj = projRepo.getAllCompletedProjects();
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No records found");
		}else {
			return proj;
		}
		
	}

	@Override
	public List<Project> findOngoingProjects() {
		// TODO Auto-generated method stub
		List<Project> proj = projRepo.getAllOngoingProjects();
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No records found");
		}else {
			return proj;
		}
	}

	@Override
	public List<Project> findCompletedProjectsByStartDate(int year){
		// TODO Auto-generated method stub
		List<Project> proj = projRepo.getAllCompletedProjectsByStartYear(year);
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No records found");
		}else {
			return proj;
		}
	}

	@Override
	public List<Project> findOngoingProjectsByStartDate(int year) {
		// TODO Auto-generated method stub
		List<Project> proj = projRepo.getAllOngoingProjectsByStartYear(year);
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No records found");
		}else {
			return proj;
		}
	}

	@Override
	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return projRepo.save(project);
	}

}
