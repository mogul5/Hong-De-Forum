package com.mogul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mogul.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer>,CrudRepository<News, Integer>,PagingAndSortingRepository<News, Integer>,JpaSpecificationExecutor<News>{

}
