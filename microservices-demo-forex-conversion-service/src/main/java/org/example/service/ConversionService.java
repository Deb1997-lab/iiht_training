package org.example.service;

import org.example.model.ConversionUIModel;

public interface ConversionService {
	
	double convert(ConversionUIModel conversionModel, double rate);
	
	
}
