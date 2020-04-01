package com.mogul.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mogul.entity.Advice;
import com.mogul.entity.Member;
import com.mogul.entity.News;

public interface AdviceService {
	List<Advice> findAdviceAll();
	Page<Advice> findAdviceNoCriteria(Integer page,Integer size);
	Advice findAdvicdById(Integer id);
	void addAdvice(Advice advice);
	void editAdvicd(Advice advice);
	void deleteAdvice(Integer id);
}
