package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Quiz;

public class MovieQuiz {
	String movie;
	List list;
	
	public Quiz getQuestion(int i){
		return (Quiz) list.get(i);
	}
	
	public String getMovie(){
		return movie;
	}
	public void setMovie(String movie){
		this.movie=movie;
	}
	
	public void setList(List list){
		this.list=list;
	}
	
	public List getList(){
		return list;
	}
	public int getQuestionNum(){
		return list.size();
	}
	
}
