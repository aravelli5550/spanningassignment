package com.example.atmspanning.controller;



import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.atmspanning.entity.Account;
import com.example.atmspanning.entity.User;
import com.example.atmspanning.model.InputDto;
import com.example.atmspanning.service.UserService;
import com.example.atmspanning.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	private MockMvc mvc;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		this.mvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void depositsuccess() throws Exception{
		 MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

		User user = new User();
		user.setUserName("user1");
		user.setPin(1234);
		Account account = new Account();
		account.setBalance(1000);
		user.setAccount(account);
		
		InputDto input = new InputDto();
		input.setPin(1234);
		long amount = 1000;
		input.setAmount(amount);
		
		ObjectMapper mapper = new ObjectMapper();
	    mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	    ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	    String requestJson=ow.writeValueAsString(input);
	    
		when(userService.validateUser(anyString(), anyInt())).thenReturn(user);
         when(userService.deposit(any(User.class), anyLong())).thenReturn(2000L);
	    
	 		
		mvc.perform(post("/userName/user1/deposit").accept(MediaType.APPLICATION_JSON)
				.contentType(APPLICATION_JSON_UTF8)
	            .content(requestJson))
	            .andExpect(status().isOk());


	   
	}

}
