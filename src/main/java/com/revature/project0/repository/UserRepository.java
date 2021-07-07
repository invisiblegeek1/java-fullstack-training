package com.revature.project0.repository;

import java.util.List;

import com.revature.project0.entity.User;

public interface UserRepository {
	List <User> findUser(String column,int id);
	List<User> findByMobile(int mobile);
	List<User> findByAccNo(int accNo);
	List<User> createUser(String name,int mobile);
	
	

}
