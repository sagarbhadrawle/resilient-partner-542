package com.sanjeevani.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sanjeevani.exception.InvalidUserException;
import com.sanjeevani.model.User;
import com.sanjeevani.repositoy.UserRepository;
import com.sanjeevani.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 
	private UserRepository userRespoRepository;

	public UserServiceImpl(UserRepository userRespoRepository) {
	
		this.userRespoRepository = userRespoRepository;
	}

	public User addUser(User member) {
		
		return userRespoRepository.save(member);
	}


	@Override
	public User getUserByAadharNo(String aadharNo) {
		
		
		
		  User user = userRespoRepository.findByAadharNo(aadharNo).orElseThrow(()-> new  InvalidUserException("No user found with given addhaar no"+aadharNo));
		 
		 return user;
	}
	
	
	
	
	
}
