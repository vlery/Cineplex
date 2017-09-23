package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Membership;

public interface MembershipDao {

	public List find();
	public void save(Membership membership);
	public List findByType(int type);
}
