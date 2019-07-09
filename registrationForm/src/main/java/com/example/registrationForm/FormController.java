package com.example.registrationForm;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)

@RestController
@RequestMapping("/regForm")
public class FormController {
    @Autowired
	registrationService regService;
 
    @GetMapping("/getUsers")
    public List<userEntity> getUsers() {
        return regService.getAllUsers();
    }
    @PostMapping("/addUsers")
    public String createUser(@Valid @RequestBody userEntity user) {
        return regService.addUser(user);
        
    }
	  
}
