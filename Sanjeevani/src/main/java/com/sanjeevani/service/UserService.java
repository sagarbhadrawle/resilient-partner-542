package com.sanjeevani.service;

import com.sanjeevani.model.User;

public interface UserService {
	
	public User addUser(User member);
	
	public User getUserByAadharNo(String aadharNo);
	
}
