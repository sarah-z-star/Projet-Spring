package com.miniProjet.ecommerce.service.UserServices.impl;

import java.util.HashMap;

import com.miniProjet.ecommerce.Repository.UserRepository;
import com.miniProjet.ecommerce.model.User;
import com.miniProjet.ecommerce.service.UserServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByMobile(String mobile) throws Exception {
		return userRepo.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
		try {
			if(userRepo.findByMobile(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			User user = new User();
			user.setName(signupRequest.get("name"));
			user.setEmail(signupRequest.get("email"));
			user.setMobile(signupRequest.get("mobile"));
			user.setPassword(signupRequest.get("password"));
			userRepo.save(user);
			return user;
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
}
