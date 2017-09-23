package net.cineplex.webmodel;

public class MovieVO {
	String mid;
	String name;
	String duration;
	String online;
	String downline;
	String introduction;
	MovieType type;
	
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDuration(String duration){
		this.duration=duration;
	}
	public void setOnline(String online){
		this.online=online;
	}
	public void setDownline(String downline){
		this.downline=downline;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	public String getMid(){
		return mid;
	}
	public String getName(){
		return name;
	}
	public String getDuration(){
		return duration;
	}
	public String getOnline(){
		return online;
	}
	public String getDownline(){
		return downline;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setType(MovieType mt) {
		// TODO Auto-generated method stub
		this.type=mt;
	}
	public MovieType getType(){
		return type;
	}
	
	
	
}
