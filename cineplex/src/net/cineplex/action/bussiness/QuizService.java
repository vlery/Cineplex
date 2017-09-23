package net.cineplex.action.bussiness;

import java.util.List;

import net.cineplex.model.Movie;
import net.cineplex.model.Quiz;
import net.cineplex.webmodel.SelectList;


public interface QuizService {

	
	void create(Quiz quiz, SelectList sl);

	List getQuizList();

	void delete(String qid);

	List getQuizListById(String id);

	List getAvailableList(String id);

	void choose(String id, String cid);
	
	public double getScore(String mid);
	
	public void checkResult();

	public void addScoreQuiz(String mid);
}
