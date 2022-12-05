package com.davidalejo.app.service;

import java.util.Optional;

import com.davidalejo.app.domain.Product;

public interface ProductService {
	
	public Product save(Product product);
	
	public Optional<Product> get(Integer id);
	
	public void update(Product product);
	
	public void delete(Integer id);

}
