package com.davidalejo.app.controller.impl;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidalejo.app.controller.ProductController;
import com.davidalejo.app.domain.Product;
import com.davidalejo.app.domain.User;
import com.davidalejo.app.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductControllerImpl{

	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("products", productService.findAll());
		
		return "products/show";
	}
	
	
	@GetMapping("/create")
	public String create() {
		
		return "products/create";
	}
	
	@PostMapping("/save")
	public String save(Product product) {
		LOGGER.info("Este es el objeto product {}", product);
		User u= new User(1,"","","","","","","");
		product.setUser(u);		
		productService.save(product);
		
		return "redirect:/products";
	}
	
}
