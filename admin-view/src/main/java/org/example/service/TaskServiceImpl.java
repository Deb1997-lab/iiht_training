package org.example.service;

import java.util.List;

import org.example.entity.Task;
import org.example.exception.RecordNotFoundException;
import org.example.jpaRepo.TaskRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	
	private final TaskRepository taskRepo;
	
	
	@Override
	public List<Task> getAllTasks() {
		// TODO Auto-generated method stub
		return taskRepo.findAll();
	}

	@Override
	public List<Task> getTasksByProjectId(long projectId) {
		// TODO Auto-generated method stub
		List<Task> task = taskRepo.getTasksByProjectId(projectId);
		if(task.isEmpty()) {
			throw new RecordNotFoundException("No results");
		}else {
			return task;
		}
	}

}
