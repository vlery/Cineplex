package net.cineplex.dao;

import java.sql.Date;
import java.util.List;

import net.cineplex.model.Plan;

public interface PlanDao {

	
	public void save(Plan plan);
	
	public List findByMovie(String mid);
	
	public List findByDay(Date day);
	
	public List find();
	
	public void updateById(Plan plan);
	
	public Plan findByPid(String pid);

	public void deleteById(int pid);

	public List findByDayAndHall(Date dayCount, String hid);

	public List fingByDayAndMovie(Date day,String mid);
}
