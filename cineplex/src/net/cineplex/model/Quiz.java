package net.cineplex.model;

/*
 * ����⣺
 * qid:id
 * mid:��Ӱid
 * question:��������
 * 
 */
public class Quiz {

	private int qid;
	private String mid;
	private String  question;
	private String bestChoice;
	
	
	public void setQid(int qid){
		this.qid=qid;
	}
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setQuestion(String question){
		this.question=question;
	}
	public void setBestChoice(String bestChoice){
		this.bestChoice=bestChoice;
	}
	
	public String getBestChoice(){
		return bestChoice;
	}
	
	public int getQid(){
		return qid;
	}
	public String getMid(){
		return mid;
	}
	public String getQuestion(){
		return question;
	}
	
}
