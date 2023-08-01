package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="FOREX-RATE-SERVICE")
public interface RateClient {
	
	@GetMapping("/rate/{from}/{to}")
	double getRate(@PathVariable("from") String from,@PathVariable("to") String to);
}
