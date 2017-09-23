package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.MovieType;

public interface MovieTypeDao {

	public List findByMid(String mid);
	
	public void save(List mt);
	public void save(MovieType mt);

	public void deleteByMid(String mid);

	
}

