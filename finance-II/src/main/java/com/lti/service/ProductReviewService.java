package com.lti.service;

import java.util.List;

import com.lti.entity.ProductReview;


public interface ProductReviewService {
	public List<ProductReview> fetchbyUser(int userId);
	public List<ProductReview> fetchbyProduct(int productId);
	
	public void deleteUserReview(int userId);

}
