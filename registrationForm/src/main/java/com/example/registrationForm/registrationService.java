package com.example.registrationForm;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class registrationService {
    @Autowired
    userRepository userRepo;
    
    public List<userEntity> getAllUsers(){
    	return userRepo.findAll();
    }
    
    public String addUser(userEntity user) {
    	boolean emailFlag=true;
    	boolean numberFlag=true;
    	ObjectMapper mapper = new ObjectMapper();
    	HashMap<String,HashMap<String,String>> result =new HashMap<String,HashMap<String,String>> ();
    	userEntity savedUser;    	HashMap<String, String> errorCodes = new HashMap<String, String>();
    	if(!Pattern.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$", user.getEmailId())) {
    	        emailFlag=false;
    	        errorCodes.put("emailId", "Enter valid emailID");
    	}
    	if(!Pattern.matches("^\\d{10}$", user.getPhoneNo())) {
        	numberFlag=false;
	        errorCodes.put("phoneNo", "Enter valid mobile number");

    	}
    	if(emailFlag&&numberFlag) {
try {
    	savedUser = userRepo.save(user);
    	HashMap<String, String> usermap = mapper.convertValue(savedUser, HashMap.class);
    	result.put("userData",usermap);
}
catch(Exception e) {
	errorCodes.put("dbError", "some error occouted in db");
}
    	}
    	result.put("errorData", errorCodes);
   	 String finalResult="";
	try {
		finalResult = mapper.writeValueAsString(result);
	} catch (JsonProcessingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	return finalResult;
    }
}
