package com.lti.service;

import java.util.List;
import com.lti.entity.Product;


public interface ProductInfoService {

	public Product fetchProductdetailsByProductId(int productId);
}
