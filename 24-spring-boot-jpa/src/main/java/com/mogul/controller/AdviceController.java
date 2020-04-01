package com.mogul.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogul.entity.Advice;
import com.mogul.entity.Member;
import com.mogul.service.AdviceService;

@Controller
@RequestMapping("/advice")
public class AdviceController {
	@Resource
	private AdviceService adviceServiceImppl;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
//	@RequestMapping("/list")
//	public String findAdviceAll(Model model){
//		List<Advice> advice=adviceServiceImppl.findAdviceAll();
//		model.addAttribute("advice", advice);
//		return "advice/list";
//	}
	
	@RequestMapping("/toAddAdvice")
	public String toAddAdvice(){
		return "advice/addAdvice";
	}
	@RequestMapping("/addAdvice")
	public String addAdvice(Advice advice){
		adviceServiceImppl.addAdvice(advice);
		return "redirect:/advice/list";
	}
	@RequestMapping("/toEditAdvice")
	public String toEditAdvice(Integer id,Model model){
		Advice advice = adviceServiceImppl.findAdvicdById(id);
		model.addAttribute("advice", advice);
		return "advice/editAdvice";
	}
	@RequestMapping("/editAdvice")
	public String editAdvice(Advice advice){
		adviceServiceImppl.editAdvicd(advice);
		return "redirect:/advice/list";
	}
	@RequestMapping("deleteAdvice")
	public String deleteAdvice(Integer id){
		adviceServiceImppl.deleteAdvice(id);
		return "redirect:/advice/list";
	}
}
