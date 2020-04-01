package com.mogul.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mogul.entity.User;

public interface UserService {
	List<User> findUserAll();
	User findUserById(Integer id);
	void addUser(User user);
	void editUser(User user);
	void deleteUserById(Integer id);
	Page<User> findUserNoCriteria(Integer page,Integer size);
}
