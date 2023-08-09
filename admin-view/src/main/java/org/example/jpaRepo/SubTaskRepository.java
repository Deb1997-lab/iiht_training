package org.example.jpaRepo;

import java.util.List;

import org.example.entity.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
	
	@Query("SELECT sb " +
	           "FROM SubTask sb " +
	           "JOIN Task t ON sb.taskId = t.taskId " +
	           "JOIN Project p ON p.projectId = t.projectId " +
	           "JOIN Employee e ON e.employeeId = sb.employeeId " +
	           "WHERE p.projectId = :projectId " +
	           "AND t.taskId = :taskId")
	    List<SubTask> getAllSubTasks(long projectId, long taskId);
}
