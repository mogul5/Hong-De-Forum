package com.mogul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mogul.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>,CrudRepository<Member, Integer>,PagingAndSortingRepository<Member, Integer>,JpaSpecificationExecutor<Member>{

}
