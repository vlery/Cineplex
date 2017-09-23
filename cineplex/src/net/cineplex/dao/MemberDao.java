package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Member;

public interface MemberDao {
	//查询一个用户
	public Member findById(String id);
	//查询所有用户
	public List find();
	//保存一个用户
	public void save(Member member);
	
	public void updateById(Member member);

	public void removeById(String id);
	
	public Member findByName(String nickName);
	
	
}
