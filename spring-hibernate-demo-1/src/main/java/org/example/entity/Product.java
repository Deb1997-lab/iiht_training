package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="spring_hibernate_demo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	
	@Id
	private String prodId;
	private String prodName;
	
}
