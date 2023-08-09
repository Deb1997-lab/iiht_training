package org.example.service;

import java.util.List;

import org.example.entity.ProjectMember;
import org.example.exception.RecordNotFoundException;
import org.example.jpaRepo.ProjectMemberRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {
	
	private final ProjectMemberRepository projMemRepo;
	
	@Override
	public List<ProjectMember> getByEmployeeId(long empId) {
		// TODO Auto-generated method stub
		List<ProjectMember> proj =  projMemRepo.findByEmployeeIdAndAuthority(empId);
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No results");
		}else {
			return proj;
		}
	}

	@Override
	public List<ProjectMember> getByProjectId(long projId) {
		// TODO Auto-generated method stub
		List<ProjectMember> proj =  projMemRepo.findByProjectId(projId);
		if(proj.isEmpty()) {
			throw new RecordNotFoundException("No results");
		}else {
			return proj;
		}
	}

	@Override
	public List<ProjectMember> getAllProjects() {
		// TODO Auto-generated method stub
		return projMemRepo.findAll();
	}
	
	

}
