package com.mogul.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mogul.entity.User;
import com.mogul.repository.UserRepository;
import com.mogul.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserRepository userRepository;
	@Override
	public List<User> findUserAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(Integer id) {
		return userRepository.findOne(id);
	}

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void editUser(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUserById(Integer id) {
		userRepository.delete(id);
	}

	@Override
	public Page<User> findUserNoCriteria(Integer page, Integer size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.ASC, "id");
        return userRepository.findAll(pageable);

	}
	
}
