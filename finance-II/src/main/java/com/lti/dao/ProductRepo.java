package com.lti.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductRepo extends GenericRepository {
    
	@SuppressWarnings("unchecked")
	public List<Product> fetchProductInfo(){
		
		return entityManager.createQuery("select p from Product p").getResultList();
	}
	
	
}
