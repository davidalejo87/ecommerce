package com.davidalejo.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidalejo.app.controller.ProductController;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/products")
@Api(value = "products")
public class ProductControllerImpl implements ProductController{

	@GetMapping("")
	public String show() {
		
		return "products/show";
	}
}
