package net.cineplex.webmodel;

public class QuizVO {

	String movie;
	String question;
	String result;
	public void setMovie(String movie){
		this.movie=movie;
	}
	public void setQuestion(String question){
		this.question=question;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String getMovie(){
		return movie;
	}
	public String getQuestion(){
		return question;
	}
	public String getResult(){
		return result;
	}
}
