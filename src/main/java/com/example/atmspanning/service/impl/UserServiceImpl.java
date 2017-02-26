package com.example.atmspanning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atmspanning.entity.User;
import com.example.atmspanning.repository.UserRepository;
import com.example.atmspanning.service.UserService;
import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
    @Override
    public User validateUser(String userName, Integer pin) {
        User user = userRepository.findByUserNameAndPin(userName, pin);
        if (user == null) {
            throw new EntityNotFoundException("User not valid");
        }
        return user;
    }
    
    @Override
    public Long getBalance(User user) {
        return user.getAccount().getBalance();
    }
    
    @Override
    public Long deposit(User user, Long depositAmount) {
        Long currentBalance = getBalance(user);
        currentBalance += depositAmount;
        user.getAccount().setBalance(currentBalance);

        User updatedUser = userRepository.save(user);
        return updatedUser.getAccount().getBalance();
    }
    
    @Override
    public Long withdraw(User user, Long withdrawAmount) {
        Long currentBalance = getBalance(user);
        
        if(currentBalance<withdrawAmount)
        {
        	throw new EntityNotFoundException("Low Balance cannot withdraw");
        }
        
        else{
        currentBalance -= withdrawAmount;
        }
        user.getAccount().setBalance(currentBalance);

        User updatedUser = userRepository.save(user);
        return updatedUser.getAccount().getBalance();
    }

}
