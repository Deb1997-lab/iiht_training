package org.example.controller;

import org.example.dto.UserDto;
import org.example.exception.EmployeeNotFoundException;
import org.example.model.Tutorial;
import org.example.service.TutorialService;
import org.example.ui.TutorialRequestUi;
import org.example.ui.TutorialResponseUi;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;


@RepositoryRestController
@AllArgsConstructor
public class TutorialController {
	
	private final TutorialService tutorialService;
	private final RestTemplate restTemplate;
	private final ModelMapper modelMapper;
	
	@PostMapping("/tutorials")
	public ResponseEntity<?> addTutorial(@RequestBody TutorialRequestUi tutorialRequest){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		String email = tutorialRequest.getEmail();
		String password = tutorialRequest.getPassword();
		Object obj = restTemplate.getForObject("http://localhost:8888/employees/find/"+email+"/"+password, UserDto.class);
		if(obj==null) {
			throw new EmployeeNotFoundException("Wrong credentials. Please try again!");
		}else {
			UserDto dto = (UserDto)obj;
			Tutorial tutorial = modelMapper.map(tutorialRequest, Tutorial.class);
			tutorial.setFirstName(dto.getFirstName());
			tutorial.setLastName(dto.getLastName());
			Tutorial tutorialOut = tutorialService.addNewTutorial(tutorial);
			TutorialResponseUi tutorialResponse = modelMapper.map(tutorialOut, TutorialResponseUi.class);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(tutorialResponse);
		}
		
		
		
	}
	
	
	
	
	
}
