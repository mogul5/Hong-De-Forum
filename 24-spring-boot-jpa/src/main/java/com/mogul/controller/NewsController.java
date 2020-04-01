package com.mogul.controller;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogul.entity.News;
import com.mogul.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Resource
	private NewsService newsServiceImpl;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
//	@RequestMapping("/list")
//	public String findNewsAll(Model model){
//		List<News> news = newsServiceImpl.findNewsAll();
//		model.addAttribute("news", news);
//		return "news/list";
//	}
	@RequestMapping("/list")
	public String findNewsNoCriteria(Model model,@RequestParam(value="page",defaultValue="0")Integer page,
			@RequestParam(value="size",defaultValue="3")Integer size){
		Page<News> news=newsServiceImpl.findNewsNoCriteria(page, size);
		model.addAttribute("news",news);
		return  "news/list";
	}
	@RequestMapping("/toAddNews")
	public String toAddNews(){
		return "news/addNews";
	}
	@RequestMapping("/addNews")
	public String addNews(News news){
		newsServiceImpl.addNews(news);
		return "redirect:/news/list";
	}
	@RequestMapping("/toEditNews")
	public String toEditNews(Integer id,Model model){
		News news = newsServiceImpl.findNewsById(id);
		model.addAttribute("news", news);
		return "news/editNews";
	}
	@RequestMapping("/editNews")
	public String editNews(News news){
		newsServiceImpl.editNews(news);
		return "redirect:/news/list";
	}
	@RequestMapping("/deleteNews")
    public String deleteUser(Integer id) {
       newsServiceImpl.deleteNewsById(id);
        return "redirect:/news/list";
    }
}
