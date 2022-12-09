package com.davidalejo.app.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidalejo.app.controller.HomeController;
import com.davidalejo.app.service.ProductService;

@Controller
@RequestMapping("/")
public class HomeControllerImpl {
	
	private final Logger log= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;
	
	// 
	
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("products", productService.findAll());
		
		return "user/home";
	}
	
	// Método para cuando haces click en ver producto, te lleve a la vista del producto
	
	@GetMapping("product_view/{id}")
	public String product_view(@PathVariable Integer id) {
		log.info("Id product enviado como parámetro {} ",id);
		
		return "user/product_view";
	}
}

