package net.cineplex.model;

/*
 * �����¼��
 * qhid��id
 * id����Աid
 * cid��ѡ��id
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
