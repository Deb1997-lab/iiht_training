package org.example.controller;

import org.example.client.RateClient;
import org.example.exception.RateNotFoundException;
import org.example.model.ConversionUIModel;
import org.example.service.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/convert")
@AllArgsConstructor
public class ConversionController {
	
	private final ConversionService convService;
	private final RateClient rateClient;
	
	@GetMapping("/status")
	public String status() {
		return "The page is up and running!";
	}
	
	@GetMapping
	public ResponseEntity<?> convert(@RequestBody ConversionUIModel convModel){
		String from = convModel.getConvertedFrom();
		String to = convModel.getConvertedTo();
		Double rate = rateClient.getRate(from, to);
		if(rate==0) {
			throw new RateNotFoundException("The conversion rate from "+from+" to "+to+" does not exist");
		}else {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(convService.convert(convModel, rate));
		}
	}
}
