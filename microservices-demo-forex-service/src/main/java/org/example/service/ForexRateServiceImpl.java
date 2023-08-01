package org.example.service;

import java.util.Optional;

import org.example.model.ForexRateModel;
import org.example.repo.ForexRateRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ForexRateServiceImpl implements ForexRateService {
	
	private final ForexRateRepository forexRepo;
	
	@Override
	public Optional<ForexRateModel> findByFromAndTo(String from, String to) {
		// TODO Auto-generated method stub
		return forexRepo.findByFromAndTo(from, to);
	}

}
