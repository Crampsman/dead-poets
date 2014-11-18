package com.DeadPoets.controllers;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DeadPoets.services.WriterService;

@Controller
@RequestMapping("")
public class WriterController {
	
	@Autowired
	private  WriterService writerService;
	
	@RequestMapping(value = "{writerId}", method = RequestMethod.GET)
	public String listPostForWriter(@PathVariable("writerId") Long id, Map<String, Object> model ) {
		
		model.put("writer", writerService.getWriterById(id));
		return "all-posts";
	}
	
	
}
	

	
	
	

