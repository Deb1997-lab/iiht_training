package org.example.jpaRepo;

import java.util.List;

import org.example.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	@Query("select t from Task t join Project p on p.projectId=t.projectId where p.projectId=:projectId")
	List<Task> getTasksByProjectId(long projectId);
}

