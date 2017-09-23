package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.QuizHistory;

public interface QuizHistoryDao {

	public void save(QuizHistory quizHistory);
	
	public List  findByMember(String id);

	public QuizHistory findByIdAndCid(String qid, String cid);

	public void update(QuizHistory rs_qh);
	
	public List findByChoice(String cid);

	public void deleteByMember(String id);

}
