package com.lvym.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvym.dao.UserRepository;
import com.lvym.pojo.User;
import com.lvym.service.UserService;
import com.lvym.util.MD5Utils;
@Service
public class UserServiceimpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User checkUser(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username,MD5Utils.code(password));
		
		return user;
	}

}
