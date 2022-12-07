package com.davidalejo.app.service;

import java.util.List;
import java.util.Optional;

import com.davidalejo.app.domain.Product;

public interface ProductService {
	
	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Optional<Product> get(Integer id);
	
	public void update(Product product);
	
	public void delete(Integer id);

}
