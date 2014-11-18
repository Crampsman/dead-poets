package com.DeadPoets.DAO;


import java.util.List;

import com.DeadPoets.domain.Post;

public interface PostDao {

	public Post getPost(Long id);
	
	public void updatePost(Post post);
	
	public void approvedPost(boolean check, Long id);
	
	public void addPost(Post post);
	
	public void deletePost(Long id);
	
	public List<Post> getAllApprovedPost();
	
	public List<Post> getAllApprovedPost(Long id);
	
	public List<Post> getAllBanPost();
	
	public List<Post> getAllBanPost(Long id);
	
	public List<Post> getAllPost(Long id);
	
	public List<Post> getSomeKindPost();
	
}
