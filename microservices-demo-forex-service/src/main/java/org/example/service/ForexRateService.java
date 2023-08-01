package org.example.service;

import java.util.Optional;

import org.example.model.ForexRateModel;

public interface ForexRateService {
	
	public Optional<ForexRateModel> findByFromAndTo(String from, String to); 
}
