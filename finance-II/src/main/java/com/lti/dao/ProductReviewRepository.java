package com.lti.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.ProductReview;
import com.lti.entity.Registration;
@Repository
public class ProductReviewRepository extends GenericRepository{

		@PersistenceContext
		EntityManager entityManager;
		
		@SuppressWarnings("unchecked")
		public List<ProductReview> fetchAllReviews(){		
			return entityManager.createQuery("select pr from ProductReview pr").getResultList();
		}
		
		@Transactional
		public void deleteReview(int reviewId) {
			entityManager.createQuery("delete from ProductReview pr where pr.reviewId = :reviewId").setParameter("reviewId", reviewId).executeUpdate();
	
	
		}
		@SuppressWarnings("unchecked")
		public List<ProductReview> fetchReviewbyUser(int userId) {
			return entityManager.createNamedQuery("select ur from ProductReview where review(ur.userId)=: rt").setParameter("rt",userId).getResultList();
			
		}
		@SuppressWarnings("unchecked")
		public List<ProductReview> fetchReviewbyProduct(int productId){
			return entityManager.createNamedQuery("select por from ProductReview where review(ur.productId)= :rm").setParameter("rm",productId).getResultList();
			
		}

}
