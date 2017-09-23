package net.cineplex.dao;

import java.sql.Date;
import java.util.List;

import net.cineplex.model.MovieHistory;

public interface MovieHistoryDao {

	public void save(MovieHistory movieHistory);
	
	public List findByMember(String id);
	
	public List findByPlan(String pid);
	
	public List find();
	public List findByDay(Date day);

	public List findByPidAndDay(String pid, Date dayCount);

	public void deleteByMember(String id);

}
