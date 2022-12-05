package com.davidalejo.app.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.davidalejo.app.controller.AdminController;

import io.swagger.annotations.Api;

@Controller
@RequestMapping("/admin")
@Api(value = "admin")
public class AdminControllerImpl implements AdminController{

	@GetMapping("")
	public String home() {
		return "admin/home";
	}
}
