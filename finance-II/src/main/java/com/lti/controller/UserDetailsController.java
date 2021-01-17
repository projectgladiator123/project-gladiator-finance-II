package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Product;
import com.lti.entity.Registration;
import com.lti.service.UserDetailsService;

@RestController
@CrossOrigin
public class UserDetailsController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/user-details")
	public List<Registration> showAll(){
		return  userDetailsService.showAll();		
	}
	
	@DeleteMapping("/user-delete")
	public void delete(int userId) {		
		userDetailsService.delete(userId);		
	}
	
	@DeleteMapping("/product-delete")
	public void deleteProduct(int productId) {		
		userDetailsService.deleteProduct(productId);		
	}
	
	@PostMapping("/product-update")
	public int updateProduct(@RequestBody Product product) {		
		return userDetailsService.updateProduct(product);		
	}
	
	@PostMapping("/save-product")
	public int saveProduct(@RequestBody Product product) {		
		return userDetailsService.saveProduct(product);		
	}
	
	@RequestMapping("/user-status-update")
	public void update(int userId) {		
		userDetailsService.updateStatus(userId);		
	}
	
	@GetMapping("/addCard")
	public long addCard(int userId, String cardType) {
		
		return userDetailsService.addCard(userId,cardType);
		
	}

}
