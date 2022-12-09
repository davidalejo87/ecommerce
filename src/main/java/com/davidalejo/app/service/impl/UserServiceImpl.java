package com.davidalejo.app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidalejo.app.dao.UserRepository;
import com.davidalejo.app.domain.User;
import com.davidalejo.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> findById(Integer id) {
		
		return userRepository.findById(id);
	}
	


}
