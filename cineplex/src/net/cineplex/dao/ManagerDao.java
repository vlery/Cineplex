package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Manager;

public interface ManagerDao {

	public Manager findById(int id);
	
	public List find();
	
	public Manager findByName(String name);

}
