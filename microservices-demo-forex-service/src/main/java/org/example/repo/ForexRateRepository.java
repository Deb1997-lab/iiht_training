package org.example.repo;

import java.util.Optional;

import org.example.model.ForexRateModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ForexRateRepository extends MongoRepository<ForexRateModel, String> {
	
	public Optional<ForexRateModel> findByFromAndTo(String from, String to);
}
