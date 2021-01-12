package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductInfoRepository;
import com.lti.entity.Product;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {

	@Autowired
	ProductInfoRepository productInfoRepository;
	
	public Product fetchProductdetailsByProductId(int productId) {
		
		return productInfoRepository.fetchProductInfoByProductId(productId);
	}

}
