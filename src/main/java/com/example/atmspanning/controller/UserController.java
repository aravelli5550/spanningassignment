package com.example.atmspanning.controller;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmspanning.entity.User;
import com.example.atmspanning.model.InputDto;
import com.example.atmspanning.service.UserService;

@RestController
@RequestMapping(value = "/userName/{userName}")
public class UserController {
	
	 private final UserService userService;
	 
	 @Autowired
	 public UserController(UserService userService) {
	        this.userService = userService;
	    }
	 
	 @RequestMapping(value = "/balance", method = RequestMethod.POST)
	    public Long getUserBalance(@PathVariable String userName, @RequestBody Integer pin) {
	        User user = userService.validateUser(userName, pin);
	        return userService.getBalance(user);
	    }
	 
	 @RequestMapping(value = "/deposit", method = RequestMethod.POST)
	    public Long deposit(@PathVariable String userName, @RequestBody InputDto depositDto) {

	        if(depositDto.getAmount() == null || depositDto.getAmount() <=0){
	            throw new InvalidParameterException("Deposit amount not valid");
	        }

	        User user = userService.validateUser(userName, depositDto.getPin());
	        return userService.deposit(user, depositDto.getAmount());
	    }
	 
	 @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	    public Long withdraw(@PathVariable String userName, @RequestBody InputDto withdrawDto) {

	        if(withdrawDto.getAmount() == null || withdrawDto.getAmount() <=0){
	            throw new InvalidParameterException("Withdraw amount not valid");
	        }

	        User user = userService.validateUser(userName, withdrawDto.getPin());
	        return userService.withdraw(user, withdrawDto.getAmount());
	    }
	 

}
