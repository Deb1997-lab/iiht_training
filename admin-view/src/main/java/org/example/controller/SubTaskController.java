package org.example.controller;

import java.util.List;

import org.example.entity.SubTask;
import org.example.service.SubTaskService;
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
public class SubTaskController {
	
	private final SubTaskService subTaskService;
	private final Environment env;
	
	@GetMapping("/subtasks/status")
	public String getStatus() {
		return env.getProperty("server.port");
	}
	
	@GetMapping("/subtasks/{projectId}/{taskId}")
	public ResponseEntity<List<SubTask>> getAllSubTasks(@PathVariable("projectId") long projectId, @PathVariable("taskId") long taskId){
		
		return ResponseEntity.status(HttpStatus.FOUND).body(subTaskService.getAllSubTasks(projectId, taskId));
	}
	
	
	
}
