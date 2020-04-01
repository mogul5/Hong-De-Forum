package com.mogul.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mogul.entity.News;
import com.mogul.repository.NewsRepository;
import com.mogul.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	@Resource
	private NewsRepository newsRepository;
	@Override
	public List<News> findNewsAll() {
		return newsRepository.findAll();
	}
	@Override
	public Page<News> findNewsNoCriteria(Integer page, Integer size) {
		Pageable pageable=new PageRequest(page,size,Sort.Direction.ASC,"id");
		return newsRepository.findAll(pageable);
	}
	@Override
	public News findNewsById(Integer id) {
		return newsRepository.findOne(id);
	}

	@Override
	public void addNews(News news) {
		newsRepository.save(news);
		
	}

	@Override
	public void editNews(News news) {
		newsRepository.save(news);
		
	}

	@Override
	public void deleteNewsById(Integer id) {
		newsRepository.delete(id);
		
	}

	

}
