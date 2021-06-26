package com.miniProjet.ecommerce.service.UserServices;

import java.util.HashMap;

import com.miniProjet.ecommerce.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	User findByMobile(String mobile) throws Exception;
	User getUserDetailById(long userId) throws Exception;
	User signUpUser(HashMap<String,String> signupRequest) throws Exception;
	
}
