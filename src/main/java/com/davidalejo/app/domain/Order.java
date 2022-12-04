package com.davidalejo.app.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	private Integer id;
	
	private String number;
	
	private Date orderCreate;
	
	private Date orderReceived;
	
	private double total;
}
