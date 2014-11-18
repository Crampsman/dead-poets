package com.DeadPoets.DAO;

import java.util.List;
import com.DeadPoets.domain.Writer;

public interface WriterDao {
	
	public Writer getWriterById(Long id);
	
	public Writer getWriterByName(String username);
	
	public void updateWriter(Writer writer);
	
	public void disableWriter(boolean check, Long id);
	
	public void addWriter(Writer writer);
	
	public List<Writer> getAllWriter();
	
	public void deleteWriter(Long id);
	
	
}
