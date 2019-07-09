package com.example.registrationForm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regForm")
public class FormController {
	
	registrationService regService;
    
    @GetMapping("/grtUsers")
    public List<userEntity> getUsers() {
        return regService.getAllUsers();
    }
    @PostMapping("/addUsers")
    public userEntity createUser(@Valid @RequestBody userEntity user) {
    	
        return regService.addUser(user);
    }
	  
}
