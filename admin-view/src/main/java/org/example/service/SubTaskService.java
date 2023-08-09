package org.example.service;

import java.util.List;

import org.example.entity.SubTask;

public interface SubTaskService {
	
	List<SubTask> getAllSubTasks(long projectId, long taskId);
}
