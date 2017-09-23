package net.cineplex.model;

import java.sql.Date;

public class Deal {
/*
 *买票消费记录表：
 *
 *did：id
 *id:会员id
 *mid：电影id
 *type：付款类型   :0 在线： 1 现金
 *amount:消费金额
 *time：消费日期
 * 
 */
	
	private  int did;
 	private String id;
 	private  String mid;
 	private int type;
 	private double amount;
 	private Date time;
	
 	
 	public void setDid(int did){
 		this.did=did;
 	}
 	public void setId(String id){
 		this.id=id;
 	}
 	public void setMid(String mid){
 		this.mid=mid;
 	}
 	public void setAmount(double amount){
 		this.amount=amount;
 	}
 	public void setType(int type){
 		this.type=type;
 	}
 	public void setTime(Date time){
 		this.time=time;
 	}
 	
 	public int getDid(){
 		return did;
 	}
 	
 	public String getId(){
 		return id;
 	}
 	public String getMid(){
 		return mid;
 	}
 	public int getType(){
 		return type;
 	}
 	public Date getTime(){
 		return time;	
 	}
 	public double getAmount(){
 		return amount;
 	}
}
