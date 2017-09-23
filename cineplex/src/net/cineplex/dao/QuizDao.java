package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Quiz;

public interface QuizDao {

	
	public void save(Quiz quiz);
	
	public List findByMovie(String mid);
	
	public List find();

	public int getQidByQuiz(Quiz quiz);

	public void deleteByQid(String qid);
	public void update(Quiz quiz);

	public Quiz findByQid(String qid);
	public List findUnResulted();
}
