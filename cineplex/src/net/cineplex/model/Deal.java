package net.cineplex.model;

import java.sql.Date;

public class Deal {
/*
 *��Ʊ���Ѽ�¼��
 *
 *did��id
 *id:��Աid
 *mid����Ӱid
 *type����������   :0 ���ߣ� 1 �ֽ�
 *amount:���ѽ��
 *time����������
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
