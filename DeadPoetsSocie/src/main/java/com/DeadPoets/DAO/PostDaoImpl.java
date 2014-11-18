package com.DeadPoets.DAO;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.DeadPoets.domain.Post;
import com.DeadPoets.util.HibernateUtil;


@Component
public class PostDaoImpl implements PostDao {
	
	 
	@Override
	public Post getPost(Long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Post) session.load(Post.class, id);
	}
	
	
	

	@Override
	public void updatePost(Post post) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(post);
		session.getTransaction().commit();		
	}
	
	@Override
	public void approvedPost(boolean check, Long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Post post = (Post) session.load(Post.class, id);
		post.setShowPost(check);
		session.beginTransaction();
		session.update(post);
		session.getTransaction().commit();
	}

	@Override
	public void addPost(Post post) {
	
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(post);
			session.getTransaction().commit();	
	}


	@Override
	public void deletePost(Long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Post post = (Post) session.load(Post.class, id);
		session.beginTransaction();
		session.delete(post);
		session.getTransaction().commit();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllApprovedPost() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createSQLQuery("Select*from post where showPost = true;").addEntity(Post.class).list();
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllPost(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery("SELECT * FROM Post WHERE writer_id like :id").addEntity(Post.class);
		return query.setLong("id", id).list();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getSomeKindPost() {
		
		List<Post> postList = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		postList = session.createSQLQuery("select * from post where curdate >= date_sub(current_date, interval 3 day) and showPost = true group by writer_id limit 5;").addEntity(Post.class).list();
		if(!postList.isEmpty()){
		  return postList;
		}else
		  return session.createSQLQuery("Select*from post where showPost = true group by writer_id limit 5;").addEntity(Post.class).list();
		 
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllApprovedPost(Long id) {
		
		String sqlAsk = "SELECT * FROM Post WHERE showPost = true and writer_id like :id ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery(sqlAsk).addEntity(Post.class);
		return query.setLong("id", id).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllBanPost(Long id) {
		
		String sqlAsk = "SELECT * FROM Post WHERE showPost = false and writer_id like :id ";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery(sqlAsk).addEntity(Post.class);
		return query.setLong("id", id).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllBanPost() {
		
		String sqlAsk = "SELECT * FROM Post WHERE showPost = false";
		Session session = HibernateUtil.getSessionFactory().openSession();
		return session.createSQLQuery(sqlAsk).addEntity(Post.class).list();
		
	}
	
}
