package com.lti.service;

import java.util.List;

import com.lti.entity.ProductReview;


public interface ProductReviewService {
	public List<ProductReview> showAllR();
	public List<ProductReview> fetchReviewbyUser();
	public List<ProductReview> fetchReviewbyProduct();
	
	public void deleteUserReview(int userId);

}
