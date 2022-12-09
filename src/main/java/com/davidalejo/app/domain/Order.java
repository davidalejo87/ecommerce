package com.davidalejo.app.domain;

import java.util.Date;

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
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column()
	private String number;
	
	@Column()
	private Date orderCreate;
	
	@Column()
	private Date orderReceived;
	
	@Column()
	private double total;
	
	@ManyToOne
	private User user;
	
	@OneToOne(mappedBy = "order")
	private OrderDetail detail;

	
	
	public Order() {
		
	}



	public Order(Integer id, String number, Date orderCreate, Date orderReceived, double total, User user,
			OrderDetail detail) {
		super();
		this.id = id;
		this.number = number;
		this.orderCreate = orderCreate;
		this.orderReceived = orderReceived;
		this.total = total;
		this.user = user;
		this.detail = detail;
	}




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public Date getOrderCreate() {
		return orderCreate;
	}



	public void setOrderCreate(Date orderCreate) {
		this.orderCreate = orderCreate;
	}



	public Date getOrderReceived() {
		return orderReceived;
	}



	public void setOrderReceived(Date orderReceived) {
		this.orderReceived = orderReceived;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public OrderDetail getDetail() {
		return detail;
	}



	public void setDetail(OrderDetail detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", orderCreate=" + orderCreate + ", orderReceived="
				+ orderReceived + ", total=" + total + "]" ;
	}



	
	
	
	
}
