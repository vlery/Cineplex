package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Recharge;

public interface RechargeDao {
	public  void save(Recharge recharge);
	
	public 	List find(String memberId);
	
	public List find();
	
	
	
}


