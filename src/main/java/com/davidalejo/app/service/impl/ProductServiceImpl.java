package com.davidalejo.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidalejo.app.dao.ProductRepository;
import com.davidalejo.app.domain.Product;
import com.davidalejo.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired  // Inyectamos el objeto ProductRepository 
	private ProductRepository productRepository;
	
	
	// Método que muestra los productos
	
	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}
	
	
	// Método que guarda un producto
	
	@Override
	public Product save(Product product) {
		
		return productRepository.save(product);
	}

	
	// Buscar un producto
	
	@Override
	public Optional<Product> get(Integer id) {
		
		return productRepository.findById(id);
	}

	
	// Actualiza un producto
	
	@Override
	public void update(Product product) {
		
		productRepository.save(product);
		
		
	// Elimina un producto	
		
	}

	@Override
	public void delete(Integer id) {
		
		productRepository.deleteById(id);
	}



}
