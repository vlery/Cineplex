package net.cineplex.model;

import java.sql.Date;

/*
 * ��Ӱ��
 * mid����Ӱid
 * name����Ӱ��
 * downline������ʱ��
 * online������ʱ��
 * duration����Ӱʱ��
 * introduction����Ӱ����
 * 
 * ps.�п�ʵ������ ͼƬ - -
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
