package org.example.controller;

import java.util.Optional;

import org.example.model.ForexRateModel;
import org.example.service.ForexRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/rate")
@AllArgsConstructor
public class ForexRateController {
	
	private final ForexRateService forexRateService;
	
	@GetMapping("/{from}/{to}")
	public double getRate(@PathVariable("from") String from,@PathVariable("to") String to) {
		Optional<ForexRateModel> rate =  forexRateService.findByFromAndTo(from, to);
		if (rate.isEmpty()) {
			return 0;
		}else {
			return rate.get().getRate();
		}
	}
	
}
