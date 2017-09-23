package net.cineplex.model;

import java.sql.Date;

/*
 * 电影表：
 * mid：电影id
 * name：电影名
 * downline：下线时间
 * online：上线时间
 * duration：电影时长
 * introduction：电影介绍
 * 
 * ps.有空实现以下 图片 - -
 */
public class Movie {
	private String mid;
	private String name;
	private Date downline;
	private Date online;
	private int duration;
	private String introduction;
	private int ifCheck;
	
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDownline(Date downline){
		this.downline=downline;
	}
	public void setOnline(Date online){
		this.online=online;
	}
	public void setDuration(int duration){
		this.duration=duration;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	public void setIfCheck(int ifCheck){
		this.ifCheck=ifCheck;
	}
	
	public int getIfCheck(){
		return ifCheck;
	}
	public String getMid(){
		return mid;
	}
	public String getName(){
		return name;
	}
	public Date getDownline(){
		return downline;
	}
	public Date getOnline(){
		return online;
	}
	public int getDuration(){
		return duration;
	}
	public String getIntroduction(){
		return introduction;
	}
}
