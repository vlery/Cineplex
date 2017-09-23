package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.MemberInfo;

public interface MemberInfoDao {

	public MemberInfo findById(String id);
	
	public  List find();
	
	public void save(MemberInfo memberInfo);
	
	public void updateById(MemberInfo memberInfo);

	public void removeById(String id);
}
