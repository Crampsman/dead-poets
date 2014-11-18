package com.DeadPoets.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.DeadPoets.domain.Role;
import com.DeadPoets.domain.Writer;
import com.DeadPoets.exceptions.ImageUploadException;
import com.DeadPoets.services.RoleService;
import com.DeadPoets.services.WriterService;



@Controller
public class SignController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private WriterService writerService;
	
	private void validateImage(MultipartFile image) {
		
		if(!image.getContentType().equals("image/jpeg")) {
			try {
				throw new ImageUploadException("Only JPG images accepted");
			} catch (ImageUploadException e) {
			e.printStackTrace();
			}
	    }
	}
	
	private void saveImage(String filename, MultipartFile image) throws ImageUploadException{
		String rootPath = System.getProperty("catalina.home");
		try{
			File serverFile = new File( rootPath + "/webapps/DeadPoetsSocie/resources/avatar/" + filename);
			FileUtils.writeByteArrayToFile(serverFile, image.getBytes());
		}catch(IOException e){
			throw new ImageUploadException("Unable ti save image", e);
		}
	}
	
	@RequestMapping(value = "/add-to-society", method = RequestMethod.GET)
	public String toRegistrationPage(Map<String, Object> model){
		model.put("writer", new Writer());
		return "registration";
		
	}
	
	@RequestMapping(value = "/addWriter", method = RequestMethod.POST)
	public String addNewWriter(@ModelAttribute("writer")@Valid Writer writer, BindingResult bindingResult,
		@RequestParam(value = "image", required = false)MultipartFile image	){
		
		if (bindingResult.hasErrors()){
			return "registration";
		}
		
		
		writer.setEnable(true);
		writer.setAvatar("resources/avatar/" + writer.getUsername()+ ".jpeg");
		writerService.addWriter(writer);
		Role role = new Role("ROLE_USER", writer);
		roleService.addRole(role);
		
	try{
		if(!image.isEmpty()){
			validateImage(image);
			saveImage(writer.getUsername() + ".jpeg", image);
		}
	}catch(ImageUploadException e){
		bindingResult.reject(e.getMessage());
		return "registration";
	}
	return "home";
	}
}
	
