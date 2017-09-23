package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Seat;

public interface SeatDao {

	
	public void save(Seat seat);
	
	public List find();
	
	public List findByHall(String  hid);
	public Seat findById(String sid);
	
}
