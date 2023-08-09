package org.example.controller;

import java.util.List;

import org.example.entity.Task;
import org.example.service.TaskService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TaskController {
	
	private final TaskService taskService;
	private final Environment env;
	
	@GetMapping("/tasks/status")
	public String getStatus() {
		return env.getProperty("server.port");
	}
	
	@GetMapping("/tasks/getAll")
	public ResponseEntity<List<Task>> getAllTasks(){
		return ResponseEntity.ok(taskService.getAllTasks());
	}
	
	@GetMapping("/tasks/{projectId}")
	public ResponseEntity<?> getTasksByProjectId(@PathVariable("projectId") long projectId){
		return ResponseEntity.status(HttpStatus.FOUND).body(taskService.getTasksByProjectId(projectId));
	}
	
	
	
}
