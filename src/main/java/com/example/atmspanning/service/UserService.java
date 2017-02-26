package com.example.atmspanning.service;

import com.example.atmspanning.entity.User;

public interface UserService {
	User validateUser(String userName, Integer pin);
    Long getBalance(User user);

    Long deposit(User user, Long depositAmount);
    Long withdraw(User user, Long withdrawAmount);

}
