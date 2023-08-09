package org.example.service;

import java.util.List;

import org.example.entity.Task;

public interface TaskService {
	
	List<Task> getAllTasks();
	
	List<Task> getTasksByProjectId(long projectId);
}
