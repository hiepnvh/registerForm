package com.mitrais.registerformdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitrais.registerformdemo.model.User;
import com.mitrais.registerformdemo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
	public User findByEmail(String email){
    	return userRepository.findByEmail(email);
    }
    
    @Override
    public User findByMobileNumber(String mobileNumber){
    	return userRepository.findByMobileNumber(mobileNumber);
    }
    
}
