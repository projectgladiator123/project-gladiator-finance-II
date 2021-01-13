package com.lti.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.ProductReview;
import com.lti.entity.Registration;
@Repository
public class ProductReviewRepository extends GenericRepository{

		@PersistenceContext
		EntityManager entityManager;
		
		@Autowired
		GenericRepository genericRepository;
		
		@Transactional
		public void deleteReview(int reviewId) {
			entityManager.createQuery("delete from ProductReview pr where pr.reviewId = :reviewId").setParameter("reviewId", reviewId).executeUpdate();
	
		}
		
		@SuppressWarnings("unchecked")
		public List<ProductReview> fetchReviewbyUser(int userId) {
			return entityManager.createQuery("select p from ProductReview p where p.registration.userId =: rt").setParameter("rt",userId).getResultList();
			
		}
		@SuppressWarnings("unchecked")
		public List<ProductReview> fetchReviewbyProduct(int productId){
			return entityManager.createQuery("select p from ProductReview p where p.product.productId = :productId").setParameter("productId",productId)
					.getResultList();
			
		}
		
		
		public ProductReview addReview(ProductReview productReview) {
			
			return (ProductReview) genericRepository.store(productReview);
		}

}
