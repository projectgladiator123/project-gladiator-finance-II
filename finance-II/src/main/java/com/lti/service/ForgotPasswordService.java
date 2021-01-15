package com.lti.service;

import com.lti.entity.Registration;

public interface ForgotPasswordService {

	public Registration getPasswordThroughEmail(String username);
}
