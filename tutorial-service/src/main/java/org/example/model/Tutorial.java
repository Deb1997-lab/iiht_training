package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tutorial_table")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tutorial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tutorialId;
	private String description;
	@JsonProperty
	private boolean isActive;
	private String firstName;
	private String lastName;
	private String email;
	
}
