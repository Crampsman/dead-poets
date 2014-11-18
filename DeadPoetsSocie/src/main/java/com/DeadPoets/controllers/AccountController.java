package com.DeadPoets.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.DeadPoets.domain.Post;
import com.DeadPoets.domain.Role;
import com.DeadPoets.domain.Writer;
import com.DeadPoets.services.PostService;
import com.DeadPoets.services.WriterService;

@Controller
@RequestMapping(value = "/account/{nameId}", method =RequestMethod.GET)
public class AccountController {

	@Autowired
	private WriterService writerService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String showPersonalAccount(Map<String,Object> model, @PathVariable("nameId") String username, 
			                              @RequestParam(value = "show", required = false) String check){
		String viewPage = null;
		String params = null;
		if(check != null)
			params = check;
		else
			params = "all";
		Writer writer = writerService.getWriterByName(username);
		List<Role> role = writer.getRoles();
		Long id = writer.getId();
		model.put("post", new Post());
		model.put("writers", writerService.getAllWriter());
		model.put("posts", postService.getChoicePost(params, id));
		model.put("allPosts", postService.getAllBanPost());
		for(Role ob : role){
			if(ob.getRole().equals("ROLE_ADMIN"))
				viewPage = "admin-account";
			else
				viewPage = "user-account";
			}
		return viewPage;
	}
	
	
	@RequestMapping(value = "/addPost", method = RequestMethod.POST)
	public String addNewPost(@ModelAttribute("post")Post post, @PathVariable("nameId") String username){
		post.setWriter(writerService.getWriterByName(username));
		postService.addPost(post);
		return "redirect:/account/"+username+"/edit";
		
	}
	
	@RequestMapping(value = "/choice-post/{writerId}", method = RequestMethod.POST)
	public String choicePostList(@PathVariable("writerId") Long id, @RequestParam("show") String check, 
			 @PathVariable("nameId") String username, Map<String, Object> model){
	    if(check.equals("app"))
			model.put("posts", postService.getAllApprovedPost(id));
		else if(check.equals("ban"))
			model.put("posts", postService.getAllBanPost(id));
		return "redirect:/account/"+username+"/edit";
	}
	
	@RequestMapping(value = "/deletePost/{postId}", method = RequestMethod.GET)
	public String deletePost(@PathVariable("postId") Long id, @PathVariable("nameId") String username){
		postService.deletePost(id);
		return "redirect:/account/"+username+"/edit";
	}
	
	@RequestMapping(value = "/approved/{postId}", method = RequestMethod.GET)
	public String approvedPost(@PathVariable("nameId") String username, @PathVariable("postId") Long id, 
	                          @RequestParam("check") boolean check) throws InterruptedException{
		postService.approvedPost(check, id);
		return "redirect:/account/"+username+"/edit";
	}
	
	@RequestMapping(value = "/deleteWriter/{writerId}", method = RequestMethod.GET)
	public String deleteWriter(@PathVariable("writerId") Long id, @PathVariable("nameId") String username){
		writerService.deleteWriter(id);;
		return "redirect:/account/"+username+"/edit";
	}
	
	@RequestMapping(value = "/disable/{writerId}", method = RequestMethod.GET)
	public String disableWriter(@PathVariable("writerId") Long id, @PathVariable("nameId") String username,
								@RequestParam boolean check){
		writerService.disableWriter(check, id);;
		return "redirect:/account/"+username+"/edit";
	}
}
