package com.davidalejo.app.domain;

import javax.persistence.Column;
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
	
	@Column()
	private String name;

	@Column()
	private double quantity;

	@Column()
	private double price;

	@Column()
	private double total;
	
	@OneToOne
	private Order order;
	
	@ManyToOne
	private Product product;

	
	
	public OrderDetail() {

	}



	public OrderDetail(Integer id, String name, double quantity, double price, double total, Order order,
			Product product) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.order = order;
		this.product = product;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getQuantity() {
		return quantity;
	}



	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", total="
				+ total + ", order=" + order + ", product=" + product + "]";
	}



	
	
}
