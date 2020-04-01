package com.mogul.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mogul.entity.News;

public interface NewsService {
	List<News> findNewsAll();
	News findNewsById(Integer id);
	void addNews(News news);
	void editNews(News news);
	void deleteNewsById(Integer id);
	Page<News> findNewsNoCriteria(Integer page,Integer size);
}
