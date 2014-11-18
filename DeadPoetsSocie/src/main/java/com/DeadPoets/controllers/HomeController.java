package com.DeadPoets.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.DeadPoets.services.PostService;
import com.DeadPoets.services.WriterService;


@Controller
public class HomeController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private WriterService writerService;
	
	
	
	@RequestMapping(value = {"/","/home"}, method=RequestMethod.GET)
	public String showHomePage(Map<String, Object> model){
		
		model.put("postList", postService.getSomeKindPost());
		return "home";
	}
	
	@RequestMapping(value = {"/writers"}, method=RequestMethod.GET)
	public String showAllWriters(Map <String, Object> model){
		model.put("writerList", writerService.getAllWriter());
		return "writers_table";
	}
	
	
	
}
