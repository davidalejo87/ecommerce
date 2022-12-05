package com.davidalejo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidalejo.app.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product , Integer>{

	
}
