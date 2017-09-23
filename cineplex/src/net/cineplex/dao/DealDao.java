package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Deal;

public interface DealDao {

	
	public void save(Deal deal);
	
	public List findByMember(String id);
	
	public List findByType(int type);
	
	
}
