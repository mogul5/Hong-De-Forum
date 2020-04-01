package com.mogul.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mogul.entity.Member;
import com.mogul.repository.MemberRepository;
import com.mogul.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService{
	@Resource
	private MemberRepository memberRepository;
	@Override
	public List<Member> findMemberAll() {
		return memberRepository.findAll();
	}

	@Override
	public Page<Member> findMemberNoCriteria(Integer page, Integer size) {
		Pageable pageable=new PageRequest(page, size,Sort.Direction.ASC,"id");
		return memberRepository.findAll(pageable);
	}
	@Override
	public Member findMemberById(Integer id) {
		return memberRepository.getOne(id);
	}

	@Override
	public void addMember(Member member) {
		memberRepository.save(member);
		
	}

	@Override
	public void editMember(Member member) {
		memberRepository.save(member);
		
	}

	@Override
	public void deleteMemberById(Integer id) {
		memberRepository.delete(id);
		
	}


}
