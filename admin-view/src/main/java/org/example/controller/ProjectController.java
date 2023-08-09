package org.example.controller;

import java.util.List;

import org.example.entity.Project;
import org.example.service.ProjectService;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ProjectController {
	
	private final ProjectService projService;
	private final Environment env;
	
	@GetMapping("/projects/status")
	public String getStatus() {
		return env.getProperty("server.port");
	}
	
	@GetMapping("/projects/findAll")
	public ResponseEntity<List<Project>> getAllProjects(){
		return ResponseEntity.ok(projService.getAllProjects());
	}
	
	@GetMapping("/projects/findById/{id}")
	public ResponseEntity<?> getProjectById(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(projService.findById(id));
	}
	
	@GetMapping("/projects/completed")
	public ResponseEntity<?> getCompletedProjects(){
		return ResponseEntity.status(HttpStatus.FOUND).body(projService.findCompletedProjects());
	}
	
	@GetMapping("/projects/ongoing")
	public ResponseEntity<?> getOngoingProjects(){
		return ResponseEntity.status(HttpStatus.FOUND).body(projService.findOngoingProjects());
	}
	
	@GetMapping("/projects/completed/{year}")
	public ResponseEntity<?> getCompletedProjectsByStartingYear(@PathVariable("year") int year){
		return ResponseEntity.status(HttpStatus.FOUND).body(projService.findCompletedProjectsByStartDate(year));
	}
	
	@GetMapping("/projects/ongoing/{year}")
	public ResponseEntity<?> getOngoingProjectsByStartingYear(@PathVariable("year") int year){
		return ResponseEntity.status(HttpStatus.FOUND).body(projService.findOngoingProjectsByStartDate(year));
	}
	
	@PostMapping("/projects/save")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		return ResponseEntity.ok(projService.addProject(project));
	}
}
