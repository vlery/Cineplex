package net.cineplex.model;
/*
 * �����ѡ�
 * 	cid��id
 * qid:����id
 * answer��ѡ������
 * vote����ѡ��Ĵ���
 * 
 * 
 */


public class Choice {

	private int cid;
	private String qid;
	private String answer;
	private int vote;
	
	
	public void setCid(int cid){
		this.cid=cid;
	}
	public void setQid(String qid){
		this.qid=qid;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}
	public void setVote(int vote){
		this.vote =vote;
	}
	
	public int getCid(){
		return cid;
	}
	
	public String getQid(){
		return qid;
	}
	public String getAnswer(){
		return answer;
	}
	public int getVote(){
		return vote;
	}
	
}
