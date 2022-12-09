package com.davidalejo.app.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.davidalejo.app.controller.HomeController;
import com.davidalejo.app.domain.Order;
import com.davidalejo.app.domain.OrderDetail;
import com.davidalejo.app.domain.Product;
import com.davidalejo.app.domain.User;
import com.davidalejo.app.service.ProductService;
import com.davidalejo.app.service.UserService;

@Controller
@RequestMapping("/")
public class HomeControllerImpl implements HomeController{
	
	private final Logger log= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	
	List<OrderDetail> details = new ArrayList<OrderDetail>();
	
	Order order = new Order();
	
	// 
	@GetMapping("")
	public String home(Model model) {
		
		model.addAttribute("products", productService.findAll());
		
		return "user/home";
	}
	
	// Método para cuando haces click en ver producto, te lleve a la vista del producto
	
	@GetMapping("product_view/{id}")
	public String product_view(@PathVariable Integer id, Model model) {
		log.info("Id product enviado como parámetro {} ",id);
		
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();
		
		model.addAttribute("product", product );
		
		return "user/product_view";
	}
	
	
	@PostMapping("/car")
	public String addProductCar(@RequestParam Integer id, @RequestParam Integer quantity, Model model) {
		OrderDetail orderDetail = new OrderDetail();
		Product product = new Product();
		double sumTotal = 0;
		
		Optional<Product> optionalProduct = productService.get(id);
		log.info("Producto añadido: {}", optionalProduct.get());
		log.info("Cantidad: {}", quantity);
		product = optionalProduct.get();
		
		orderDetail.setQuantity(quantity);
		orderDetail.setPrice(product.getPrice());
		orderDetail.setName(product.getName());
		orderDetail.setTotal(product.getPrice()*quantity);
		orderDetail.setProduct(product);
		
		// Validar que el producto no se repita en el carrito
		Integer productId = product.getId();
		boolean joined = details.stream().anyMatch(p -> p.getProduct().getId() == productId);
		
		if(!joined) {
			details.add(orderDetail);
		}
		
		

		
		// Sumar el total de lo que añada el usuario al carrito
		sumTotal = details.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		order.setTotal(sumTotal);
		model.addAttribute("car", details);
		model.addAttribute("order", order);
		
		
		
		return "user/shopping_car";
	}
	
	// Borrar un producto del carrito
	@GetMapping("delete/car/{id}")
	public String deleteProductCar(@PathVariable Integer id, Model model) {
		// Lista nueva de productos
		List<OrderDetail> newOrder = new ArrayList<OrderDetail>();
		
		for(OrderDetail orderDetail: details){
			if(orderDetail.getProduct().getId() !=id) {
				newOrder.add(orderDetail);
			}
		}
		
		// poner los productos restantes en la nueva lista
		details = newOrder;
		
		double sumTotal=0;
		
		sumTotal = details.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		order.setTotal(sumTotal);
		model.addAttribute("car", details);
		model.addAttribute("order", order);
		
		
		return "user/shopping_car";
	}
	
	
	@GetMapping("/getCar")
	public String getCar(Model model) {
		
		model.addAttribute("car", details);
		model.addAttribute("order", order);
		
		return "/user/shopping_car";
	}
	
	
	
	@GetMapping("/order")
	public String order(Model model) {
		
		User user = userService.findById(1).get();
		
		model.addAttribute("car", details);
		model.addAttribute("order", order);
		
		model.addAttribute("user", user);
		
		return "user/order_summary";
	}
	
	
	
}

