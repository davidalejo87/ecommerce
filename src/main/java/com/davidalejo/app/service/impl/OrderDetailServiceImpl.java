package com.davidalejo.app.service.impl;

import org.springframework.stereotype.Service;

import com.davidalejo.app.dao.OrderDetailRepository;
import com.davidalejo.app.domain.OrderDetail;
import com.davidalejo.app.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public OrderDetail save(OrderDetail orderDetail) {
		
		return orderDetailRepository.save(orderDetail);
	}

}
