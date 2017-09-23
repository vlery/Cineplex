package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Movie;

public interface MovieDao {
	public void save (Movie movie);
	
	public Movie findById(String mid);

	public void update(Movie movie);
	public List find();
	
	public List findOnline();
	
}
