package com.lti.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductReviewRepository;
import com.lti.dto.Review;
import com.lti.entity.ProductReview;

@Service
public class ProductReviewImpl implements ProductReviewService {
	
	@Autowired
	ProductReviewRepository productReviewRepository;

	public List<ProductReview> fetchbyUser(int userId) {
		
		return productReviewRepository.fetchReviewbyUser(userId);
	}

	public List<ProductReview> fetchbyProduct(int productId) {
		
		return productReviewRepository.fetchReviewbyProduct(productId);
	}

	public void deleteUserReview(int userId) {
		productReviewRepository.deleteReview(userId);
		
		
	}


	public void addNewReview(Review review) {
		productReviewRepository.addReview(review);
	}


}
	
	

	


