package net.cineplex.model;

import java.sql.Date;
import java.sql.Time;


/*
 * ��ӳ�ƻ���
 * pid��id
 * mid����Ӱid
 * hid��Ӱ��id
 * day: ��ӳ����
 * time�����ſ�ʼʱ��
 */

public class Plan {

	private int pid;
	private String mid;
	private String hid;
	private Date day;
	private Time time;
	private int price;
	
	
	public void setPid(int pid){
		this.pid=pid;
	}
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setHid(String hid){
		this.hid=hid;
	}
	public void setDay(Date day){
		this.day=day;
	}
	public void setTime(Time time){
		this.time=time;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public int getPrice(){
		return price;
	}
	
	public int getPid(){
		return pid;
	}
	public String getMid(){
		return mid;
	}
	public String getHid(){
		return hid;
	}
	public Date getDay(){
		return day;
	}
	public Time getTime(){
		return time;
	}

}	

