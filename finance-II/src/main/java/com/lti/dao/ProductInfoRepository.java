package com.lti.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductInfoRepository extends GenericRepository {
    
	@SuppressWarnings("unchecked")
	public Product fetchProductInfo(int productId){
		
		return (Product) entityManager.createQuery("select p from Product p where p.productId =: productId")
				.setParameter("productId", productId)
				.getSingleResult();
	}
	
	
}
