package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductRepo;
import com.lti.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo productrepo;
	
	public List<Product> fetchProductdetails() {
		
		return productrepo.fetchProductInfo();
	}


}