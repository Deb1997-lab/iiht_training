package org.example.jpaRepo;

import java.util.List;

import org.example.composite.ProjectMemberComposite;
import org.example.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberComposite> {
	
	@Query("Select pm from ProjectMember pm join Employee e on e.employeeId=pm.employeeId where e.employeeId=:employeeId and pm.authority=true")
	List<ProjectMember> findByEmployeeIdAndAuthority(Long employeeId);
	
	@Query("Select pm from ProjectMember pm join Project p on p.projectId=pm.projectId where p.projectId=:projectId")
    List<ProjectMember> findByProjectId(Long projectId);
}
