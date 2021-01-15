package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Product;
import com.lti.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@GetMapping("/productlist-info")
	public List<Product> fetchProductDetails(){
		
		return productservice.fetchProductdetails();
	}

}
