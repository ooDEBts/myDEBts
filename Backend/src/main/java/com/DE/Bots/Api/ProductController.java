package com.DE.Bots.Api;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DE.Bots.Repository.ProductRepo;
import com.DE.Bots.core.Model.Product;

@RestController
public class ProductController {

	@Autowired
	ProductRepo productRepo;

	@RequestMapping(value = "/saveProduct", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
	public String saveBook(@RequestBody Product product) {
		product.setAddOn(new Date().getTime());
		productRepo.save(product);
		return "Product Added Sucessfully"; 
	}

	@RequestMapping(value = "/findProduct", produces = "application/json", method = RequestMethod.GET)
	public List<Product> getProduct(@RequestParam("name") String name) {
		return productRepo.findByName(name);
	}
}
