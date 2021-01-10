package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Product;
import com.lti.service.ProductInfoService;

@RestController
@CrossOrigin
public class ProductInfoController {

	@Autowired
	private ProductInfoService productInfoService;
	
	@GetMapping("/product-info")
	public List<Product> fetchProductDetails(){
		
		return productInfoService.fetchProductdetails();
	}
}
