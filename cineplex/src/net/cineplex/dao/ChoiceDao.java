package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Choice;

public interface ChoiceDao {

	public void save(Choice choice);
	
	public List findByQuestion(String qid);
	
	public List find();

	public void deleteByQuestion(String qid);

	public Choice findByCid(String cid);

	public void update(Choice rs_c1);
}
