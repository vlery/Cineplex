package net.cineplex.model;

/*
 * 电影类型表：
 * mvid：主键
 * mid：电影id
 * type：类型
 */
public class MovieType {
	private  int  mvid;
	private  String  mid;
	private int type;
	
	
	public void setMvid(int mvid){
		this.mvid=mvid;
	}
	
	public void setMid(String mid){
		this.mid=mid;
	}
	
	public void setType(int type){
		this.type=type;
	}
	
	public int getMvid(){
		return mvid;
	}
	public String getMid(){
		return mid;
	}
	public int getType(){
		return type;
	}
	
	
	
	
	
	
	
	
}
