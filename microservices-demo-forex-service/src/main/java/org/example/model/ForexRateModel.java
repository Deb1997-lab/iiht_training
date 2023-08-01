package org.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("forex_rate")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ForexRateModel {
	
	private String from;
	private String to;
	private double rate;
	
}
