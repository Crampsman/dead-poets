package com.DeadPoets.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.DeadPoets.DAO.WriterDao;
import com.DeadPoets.domain.Writer;

@Component
public class WriterServiceImpl implements WriterService {

	@Autowired
	private WriterDao writerDao;

	@Override
	public Writer getWriterById(Long id) {
		
		return writerDao.getWriterById(id);
		
	}
	
	public Writer getWriterByName(String username) {
	
		return writerDao.getWriterByName(username);
	}

	@Override
	public void updateWriter(Writer writer) {
	
		writerDao.updateWriter(writer);
		
	}

	@Override
	public void addWriter(Writer writer) {
	
		writerDao.addWriter(writer);
		
	}

	@Override
	public List<Writer> getAllWriter() {
		
		return writerDao.getAllWriter();
	}

	@Override
	public void deleteWriter(Long id) {
		
		writerDao.deleteWriter(id);
		
	}

	@Override
	public void disableWriter(boolean check, Long id) {
		
		writerDao.disableWriter(check, id);
	}

}
