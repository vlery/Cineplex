package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Member;

public interface MemberDao {
	//��ѯһ���û�
	public Member findById(String id);
	//��ѯ�����û�
	public List find();
	//����һ���û�
	public void save(Member member);
	
	public void updateById(Member member);

	public void removeById(String id);
	
	public Member findByName(String nickName);
	
	
}
