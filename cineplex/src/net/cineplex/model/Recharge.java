package net.cineplex.model;

import java.sql.Date;


/*
 * ��Ա��ֵ��¼��
 * rid:��¼id
 * id����Աid
 * type:��ֵ����
 * amount����ֵ���
 * time����ֵ����
 *
 */
public class Recharge {
	private int rid;
	private String id;
	private double amount;
	private Date time;
	private int type;
	
	
	public void setRid(int rid){
		this.rid=rid;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setAmount(double amount){
		this.amount=amount;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public void setType(int type){
		this.type=type;
	}
		
	
	public int getRid(){
		return rid;
	}
	public String getId(){
		return id;
	}
	public double getAmount(){
		return amount;
	}
	public Date getTime(){
		return time;
	}
	public int getType(){
		return type;
	}
	
}
