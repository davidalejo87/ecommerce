package com.davidalejo.app.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private String image;
	
	private double price;
	
	private Integer quantity;
}
