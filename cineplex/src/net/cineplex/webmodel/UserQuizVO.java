package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Choice;
import net.cineplex.model.Quiz;

public class UserQuizVO {

	Quiz quiz;
	List choiceList;
	public void setQuiz(Quiz quiz){
		this.quiz=quiz;
	}
	public Quiz getQuiz(){
		return quiz;
	}
	public void setChoiceList(List choiceList){
		this.choiceList=choiceList;
	}
	public List getChoiceList(){
		return choiceList;
	}
	public int getChoiceNum(){
		return choiceList.size();
	}
	public Choice getItem(int i){
		return (Choice) choiceList.get(i);
	}
	
}
