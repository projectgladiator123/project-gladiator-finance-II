package com.lti.dao;

import java.util.List;



import org.springframework.stereotype.Repository;

import com.lti.entity.Product;

@Repository
public class ProductInfoRepository extends GenericRepository {
    
	@SuppressWarnings("unchecked")
	public List<Product> fetchProductInfo(){
		
		return entityManager.createQuery("select p.productImage,p.productName,p.productDetails,p.productPrice,p.maxTenure from Product p").getResultList();
	}
	
	
}
