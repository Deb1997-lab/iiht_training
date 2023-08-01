package org.example.service;

import org.example.model.ConversionUIModel;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

	@Override
	public double convert(ConversionUIModel conversionModel, double rate) {
		// TODO Auto-generated method stub
		
		return conversionModel.getValue()*rate;
	}

}
