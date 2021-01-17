package com.lti.service;

import java.util.List;

import com.lti.entity.Product;
import com.lti.entity.Registration;

public interface UserDetailsService {
	
	public List<Registration> showAll();
	public void delete(int userId);
	public void updateStatus(int userId);
	public long addCard(int userId, String cardType);
	public void deleteProduct(int productId);
	public int updateProduct(Product product);
	public int saveProduct(Product product);

}
