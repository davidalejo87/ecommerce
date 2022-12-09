package com.davidalejo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidalejo.app.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
