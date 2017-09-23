package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Hall;


public interface HallDao {
	public void save (Hall hall);
	
	public Hall findById(String hid);

	public List find();
	
	public String getHidByName(String name);
}
