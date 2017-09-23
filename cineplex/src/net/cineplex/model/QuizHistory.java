package net.cineplex.model;

/*
 * 答题记录：
 * qhid：id
 * id：会员id
 * cid：选项id
 */

public class QuizHistory {

	private  int qhid;
	private String id;
	private String cid;
 		

	public void setQhid(int qhid){
		this.qhid=qhid;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setCid(String cid){
		this.cid=cid;
	}
	
	public int getQhid(){
		return qhid;
	}
	public String getId(){
		return id;
	}
	public String getCid(){
		return cid;
	}
 	
	
}
