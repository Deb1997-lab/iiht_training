package org.example.service;

import org.example.model.Tutorial;
import org.example.repo.TutorialRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TutorialServiceImpl implements TutorialService {
	
	private final TutorialRepository tutorialRepo;
	
	@Override
	public Tutorial addNewTutorial(Tutorial tutorial) {
		// TODO Auto-generated method stub
		return tutorialRepo.save(tutorial);
	}

}
