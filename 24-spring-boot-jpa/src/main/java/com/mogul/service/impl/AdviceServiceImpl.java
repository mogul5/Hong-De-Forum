package com.mogul.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.mogul.entity.Advice;
import com.mogul.entity.Member;
import com.mogul.entity.News;
import com.mogul.repository.AdviceRepository;
import com.mogul.service.AdviceService;

@Service
public class AdviceServiceImpl implements AdviceService{
	@Resource
	private AdviceRepository adviceRepository;
	@Override
	public List<Advice> findAdviceAll() {
		return adviceRepository.findAll();
	}
	
	@Override
	public Page<Advice> findAdviceNoCriteria(Integer page, Integer size) {
		Pageable pageable=new PageRequest(page, size,Sort.Direction.ASC,"id");
		return adviceRepository.findAll(pageable);
	}
	@Override
	public Advice findAdvicdById(Integer id) {
		return adviceRepository.findOne(id);
	}

	@Override
	public void addAdvice(Advice advice) {
		adviceRepository.save(advice);
	}

	@Override
	public void editAdvicd(Advice advice) {
		adviceRepository.save(advice);
	}

	@Override
	public void deleteAdvice(Integer id) {
		adviceRepository.delete(id);
	}




}
