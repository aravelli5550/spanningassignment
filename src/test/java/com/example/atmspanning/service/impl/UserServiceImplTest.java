package com.example.atmspanning.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.atmspanning.entity.Account;
import com.example.atmspanning.entity.User;
import com.example.atmspanning.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void validateUserReturnSuccess() {
		 
		String userName= "1234";
		Integer pin = 1234; 
		User user= new User();
		user.setPin(1234);
		user.setUserName("user1");
		User usermain = new User();
		 
		(when(userRepository.findByUserNameAndPin(anyString(),anyInt()))).thenReturn(user);
		
		usermain = userServiceImpl.validateUser(userName, pin);
	 
	 assertEquals("user1", usermain.getUserName());
		
	}
	

	
	@Test
	public void validategetBalanceSuccess(){
		String userName= "1234";
		Integer pin = 1234; 
		
		User user= new User();
		user.setPin(1234);
		user.setUserName("user1");
		Account account = new Account();
		account.setBalance(1000);
		user.setAccount(account);
		
		(when(userRepository.findByUserNameAndPin(anyString(),anyInt()))).thenReturn(user);
		(when(userServiceImpl.validateUser(anyString(), anyInt()))).thenReturn(user);
		
		Long balance = userServiceImpl.getBalance(user);
		assertNotNull(balance);
		
	}
	
	@Test
	public void depositSuccess(){
		
		String userName= "1234";
		Integer pin = 1234; 
		
		User user= new User();
		user.setPin(1234);
		user.setUserName("user1");
		Account account = new Account();
		account.setBalance(1000);
		user.setAccount(account);
		Long balance = (long) 1000;
		
		User updatedUser = new User();
		updatedUser.setPin(1234);
		updatedUser.setUserName("user1");
		Account accounts = new Account();
		accounts.setBalance(2000);
		updatedUser.setAccount(accounts);
		
		(when(userRepository.findByUserNameAndPin(anyString(),anyInt()))).thenReturn(user);
		(when(userServiceImpl.validateUser(anyString(), anyInt()))).thenReturn(user);
		(when(userRepository.save(any(User.class)))).thenReturn(updatedUser);

		
		
		Long depositAmount = (long)100;
		Long deposit = (long)userServiceImpl.deposit(user, depositAmount);
		assertNotNull(deposit);

		
		
	}
	
	@Test
	public void withdrawSuccess(){
		
		String userName= "1234";
		Integer pin = 1234; 
		
		User user= new User();
		user.setPin(1234);
		user.setUserName("user1");
		Account account = new Account();
		account.setBalance(1000);
		user.setAccount(account);
		Long balance = (long) 1000;
		
		User updatedUser = new User();
		updatedUser.setPin(1234);
		updatedUser.setUserName("user1");
		Account accounts = new Account();
		accounts.setBalance(900);
		updatedUser.setAccount(accounts);
		
		(when(userRepository.findByUserNameAndPin(anyString(),anyInt()))).thenReturn(user);
		(when(userServiceImpl.validateUser(anyString(), anyInt()))).thenReturn(user);
		(when(userRepository.save(any(User.class)))).thenReturn(updatedUser);

		
		Long withdrawAmount = (long)100;
		Long withdraw = (long)userServiceImpl.deposit(user, withdrawAmount );
		assertNotNull(withdraw);

		
		
	}

}
