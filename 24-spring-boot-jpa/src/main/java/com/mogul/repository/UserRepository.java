package com.mogul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mogul.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>,CrudRepository<User, Integer>,PagingAndSortingRepository<User, Integer>,JpaSpecificationExecutor<User>{
	
}
