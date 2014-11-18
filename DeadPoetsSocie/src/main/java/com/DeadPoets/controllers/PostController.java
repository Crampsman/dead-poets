package com.DeadPoets.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.DeadPoets.services.PostService;

@Controller
@RequestMapping("/writers")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/{writerId}")
	public String ListPostForWriters(@PathVariable("writerId") Long id, Map <String, Object> model){
		model.put("allPosts", postService.getAllApprovedPost(id) );
		return "posts-for-writers";
	}
	
	@RequestMapping("/all-posts")
	public String AllPostsFor( Map <String, Object> model){
		model.put("allPosts", postService.getAllApprovedPost());
		return "all-posts";
	}

}
