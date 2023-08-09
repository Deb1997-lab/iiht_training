package org.example.service;

import java.util.List;

import org.example.entity.SubTask;
import org.example.exception.RecordNotFoundException;
import org.example.jpaRepo.SubTaskRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTaskServiceImpl implements SubTaskService {
	
	private final SubTaskRepository subTaskRepo;
	
	@Override
	public List<SubTask> getAllSubTasks(long projectId, long taskId) {
		// TODO Auto-generated method stub
		List<SubTask> subtask = subTaskRepo.getAllSubTasks(projectId, taskId);
		if(subtask.isEmpty()) {
			throw new RecordNotFoundException("No results");
		}else {
			return subtask;
		}
	}

}
