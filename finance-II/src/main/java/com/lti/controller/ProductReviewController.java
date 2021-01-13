package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.ProductReview;
import com.lti.service.ProductReviewService;

@RestController
@CrossOrigin
public class ProductReviewController {
	
	@Autowired
	private ProductReviewService productReviewService;
	
	@GetMapping("/product-review-by-user")
	public List<ProductReview> fetchbyUser(int userId){
		return productReviewService.fetchbyUser(userId);
	}
	@DeleteMapping("/delete-review")
	public void deleteUserReview(int userId) {
		productReviewService.deleteUserReview(userId);
	}
	@GetMapping("/product-review-by-productId")
	public List<ProductReview> fetchbyProduct(int productId){
		return productReviewService.fetchbyProduct(productId);
	}
	
	}
	
	


