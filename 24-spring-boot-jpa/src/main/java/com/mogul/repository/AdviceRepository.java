package com.mogul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mogul.entity.Advice;

public interface AdviceRepository extends JpaRepository<Advice, Integer>,CrudRepository<Advice, Integer>,PagingAndSortingRepository<Advice, Integer>,JpaSpecificationExecutor<Advice>{

}
