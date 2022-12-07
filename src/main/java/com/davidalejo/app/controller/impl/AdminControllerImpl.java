package com.davidalejo.app.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidalejo.app.controller.AdminController;
import com.davidalejo.app.domain.Product;
import com.davidalejo.app.service.ProductService;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/admin")
@Api(value = "admin")
public class AdminControllerImpl implements AdminController{
	
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public String home(Model model) {
		List<Product> products = productService.findAll();
		model.addAttribute("products", products);
		
		return "admin/home";
	}
}
