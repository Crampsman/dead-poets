package com.DeadPoets.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.DeadPoets.domain.Writer;
import com.DeadPoets.util.HibernateUtil;


@Component
public class WriterDaoImpl implements WriterDao  {

	@Override
	public Writer getWriterById(Long id) {
		
	   Session session = HibernateUtil.getSessionFactory().openSession();
		return (Writer) session.load(Writer.class, new Long(id));
		
	}
	
	@Override
	public Writer getWriterByName(String username) {
		
		String sqlAsk = "SELECT * FROM Writer where username like :name";
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query =  (Query) session.createSQLQuery(sqlAsk).addEntity(Writer.class);
		return (Writer) query.setString("name", username).uniqueResult();

	}

	@Override
	public void updateWriter(Writer writer) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(writer);
			session.getTransaction().commit();
		
		}
	
	@Override
	public void disableWriter(boolean check, Long id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Writer writer = (Writer) session.load(Writer.class, id);
		writer.setEnable(check);
		session.beginTransaction();
		session.update(writer);
		session.getTransaction().commit();
		
	}
		
	
	@Override
	public void addWriter(Writer writer) {
	
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(writer);
			session.getTransaction().commit();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Writer> getAllWriter() {
		
		List<Writer> list = new ArrayList<Writer>();
			
		Session session = HibernateUtil.getSessionFactory().openSession();
		list = session.createCriteria(Writer.class).list();
		
		return list;
	}

	@Override
	public void deleteWriter(Long id) {
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			Writer writer = (Writer) session.load(Writer.class, id);
			session.beginTransaction();
			session.delete(writer);
			session.getTransaction().commit();	
	}

	

	
}
