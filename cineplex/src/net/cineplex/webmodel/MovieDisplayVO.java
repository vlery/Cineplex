package net.cineplex.webmodel;

public class MovieDisplayVO {
	String mid;
	String name;
	String simpleInfo;
	String score;


	public void setMid(String mid){
		this.mid=mid;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setSimpleInfo(String simpleInfo){
		this.simpleInfo=simpleInfo;
	}
	public void setScore(String score){
		this.score=score;
	}
	public String getMid(){
		return mid;
	}
	public String getName(){
		return name;
	}
	public String getSimpleInfo(){
		return simpleInfo;
	}
	public String getScore(){
		return score;
	}

}
