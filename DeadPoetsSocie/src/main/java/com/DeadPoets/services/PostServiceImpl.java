package com.DeadPoets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.DeadPoets.DAO.PostDao;
import com.DeadPoets.domain.Post;

@Component
public class PostServiceImpl implements PostService {

	@Autowired
	private PostDao postDao;
	
	@Override
	public Post getPost(Long id) {
		
		return postDao.getPost(id);
	}

	@Override
	public void updatePost(Post post) {
		
		postDao.updatePost(post);
	}
	
	@Override
	public void approvedPost(boolean check, Long id){
		
		postDao.approvedPost(check, id);
	}

	@Override
	public void addPost(Post post) {
		
		postDao.addPost(post);
		
	}

	@Override
	public List<Post> getAllApprovedPost() {
	
		return postDao.getAllApprovedPost();
	}

	@Override
	public void deletePost(Long id) {

		postDao.deletePost(id);
		
	}

	@Override
	public List<Post> getSomeKindPost() {
		
		return postDao.getSomeKindPost(); 
	}

	@Override
	public List<Post> getAllPost(Long id) {
		
		return postDao.getAllPost(id);
	}

	@Override
	public List<Post> getAllApprovedPost(Long id) {
		
		return postDao.getAllApprovedPost(id);
	}

	@Override
	public List<Post> getAllBanPost() {
		
		return postDao.getAllBanPost();
	}

	@Override
	public List<Post> getAllBanPost(Long id) {
		
		return postDao.getAllBanPost(id);
	}

	@Override
	public List<Post> getChoicePost(String check, Long id) {
		
		List<Post> list = null;
		
		if(check.equals("app")){
			list = postDao.getAllApprovedPost(id);
		}
		else if(check.equals("ban")){
			list = postDao.getAllBanPost(id);
		}
		else if(check.equals("all")){
			list = postDao.getAllPost(id);
		}
			
		return list;
	}


	

}
