package com.mogul.controller;


import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogul.entity.Member;
import com.mogul.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource
	private MemberService memberServiceImpl;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
//	@RequestMapping("/list")
//	public String findMemberAll(Model model){
//		List<Member> member=memberServiceImpl.findMemberAll();
//		model.addAttribute("member", member);
//		return "/member/list";
//	}
	@RequestMapping("/list")
	public String findMemberNoCriteria(Model model,@RequestParam(value="page",defaultValue="0")Integer page,
			@RequestParam(value="size",defaultValue="3")Integer size){
		Page<Member> member = memberServiceImpl.findMemberNoCriteria(page, size);
		model.addAttribute("member", member);
		return "member/list";
	}
	@RequestMapping("/toAddMember")
	public String toAddMember(){
		return "member/addMember";
	}
	@RequestMapping("/addMember")
	public String addMember(Member member){
		memberServiceImpl.addMember(member);
		return "redirect:/member/list";
	}
	@RequestMapping("toEditMember")
	public String editMember(Model model,Integer id){
		Member member = memberServiceImpl.findMemberById(id);
		model.addAttribute("member", member);
		return "member/editMember";
	}
	@RequestMapping("/editMember")
	public String editMember(Member member){
		memberServiceImpl.editMember(member);
		return "redirect:/member/list";
	}
	@RequestMapping("/deleteMember")
    public String deleteUser(Integer id) {
        memberServiceImpl.deleteMemberById(id);
        return "redirect:/member/list";
    }
}
