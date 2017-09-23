package net.cineplex.webmodel;

import java.util.List;

public class QuizList {
	List list;
	public List getList(){
		return list;
	}
	public void setList(List list){
		this.list=list;
	}
	
	public int getSize(){
		return list.size();
	}
	public MovieQuiz getItem(int i){
		return (MovieQuiz) list.get(i);
	}
	
}
