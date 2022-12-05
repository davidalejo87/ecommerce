package com.davidalejo.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private double quantity;

	private double price;

	private double total;
	
	@OneToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
}
