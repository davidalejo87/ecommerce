package com.davidalejo.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidalejo.app.dao.OrderRepository;
import com.davidalejo.app.domain.Order;
import com.davidalejo.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order save(Order order) {
		
		return orderRepository.save(order);
		}

}
