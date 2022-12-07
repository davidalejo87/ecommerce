package com.davidalejo.app.controller.impl;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.davidalejo.app.controller.ProductController;
import com.davidalejo.app.domain.Product;
import com.davidalejo.app.domain.User;
import com.davidalejo.app.service.ProductService;
import com.davidalejo.app.service.impl.UploadFileService;


@Controller
@RequestMapping("/products")
public class ProductControllerImpl implements ProductController{

	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UploadFileService upload;
	
	
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
	public String save(Product product,@RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Este es el objeto product {}", product);
		User u= new User(1,"","","","","","","");
		product.setUser(u);
		
		//image
		if(product.getId()==null) { 
			// cuando se crea un producto
			String imageName = upload.saveImage(file);
			product.setImage(imageName);			
		}		
		
		productService.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Product product = new Product();
		Optional<Product> optionalProduct = productService.get(id);
		product = optionalProduct.get();
		
		LOGGER.info("Producto buscado: {}",product);
		model.addAttribute("product", product);
		
		return "products/edit";
	}
	
	@PostMapping("/update")
	public String update(Product product,@RequestParam("img") MultipartFile file) throws IOException {
		Product p = new Product();
		p = productService.get(product.getId()).get();
		
		if(file.isEmpty()) {
			//Cuando se modifica el producto pero no cambiamos la imagen
			
			product.setImage(p.getImage());
		}else {
			// Cuando se modifica la imagen con el producto
			
			
			// Eliminar cuando la imagen no sea por defecto
			if(p.getImage().equals("defaul.jpeg")) {
				upload.deleteImage(p.getImage());
			}
			
			String imageName = upload.saveImage(file);
			product.setImage(imageName);
		}
		product.setUser(p.getUser());
		productService.update(product);		
		return "redirect:/products";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Product p = new Product();
		p = productService.get(id).get();
		
		// Eliminar cuando la imagen no sea por defecto
		if(p.getImage().equals("defaul.jpeg")) {
			upload.deleteImage(p.getImage());
		}
		
		productService.delete(id);
		return "redirect:/products";
	}
	
}
