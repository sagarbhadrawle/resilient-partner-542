package com.sanjeevani.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.sanjeevani.exception.InvalidUserException;
import com.sanjeevani.model.User;



public interface UserService {

	
	public List<User> getAllUser(Pageable pageable);
	
	public User getUserById(Integer id) throws InvalidUserException;
	
	public User getUserByAadharNo(String aadharNo) throws InvalidUserException;
	
	public User getUserByPanNo(String panNo) throws InvalidUserException;
	
	public User addUser(User member);
	
	public User updateUser(Integer userId , User member) throws InvalidUserException;
	
	public Boolean deleteUser(Integer id) throws InvalidUserException;
	
}
