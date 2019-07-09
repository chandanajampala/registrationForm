package com.example.registrationForm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class registrationService {
    @Autowired
    userRepository userRepo;
    
    public List<userEntity> getAllUsers(){
    	return userRepo.findAll();
    }
    
    public userEntity addUser(userEntity user) {
    	
    	return userRepo.save(user);
    }
}
