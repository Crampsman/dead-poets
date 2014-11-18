package com.DeadPoets.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DeadPoets.domain.Post;
import com.DeadPoets.services.PostService;
import com.DeadPoets.services.WriterService;

@Controller
@RequestMapping(value = "/update/{userId}/{postId}", method = RequestMethod.GET)
public class UpdatePostController {
	
	@Autowired
	private WriterService writerService;
	
	@Autowired
	private PostService postService;

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String showUpdatePage(@PathVariable("postId")Long id, Map<String, Object> model){
		
		model.put("updatePost", postService.getPost(id));
		return "update-post";
	}
	
	@RequestMapping(value = "/updatePost", method = RequestMethod.POST)
	public String updatePost(@ModelAttribute("updatePost")Post post, @PathVariable("userId") String username,
			@PathVariable("postId") Long id){
		
		post.setWriter(writerService.getWriterByName(username));
		post.setPost_id(id);
		postService.updatePost(post);
		return "redirect:/add-post/"+username+"/edit";
	}
}
