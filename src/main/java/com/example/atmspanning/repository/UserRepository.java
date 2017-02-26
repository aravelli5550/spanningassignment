package com.example.atmspanning.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.atmspanning.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	User findByUserNameAndPin(String userName, Integer pin);
}
