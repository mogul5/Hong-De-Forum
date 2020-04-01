package com.mogul.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.mogul.entity.Member;

public interface MemberService {
	List<Member> findMemberAll();
	Member findMemberById(Integer id);
	void addMember(Member member);
	void editMember(Member member);
	void deleteMemberById(Integer id);
	Page<Member> findMemberNoCriteria(Integer page,Integer size);
}
