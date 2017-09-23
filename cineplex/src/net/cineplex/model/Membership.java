package net.cineplex.model;

import java.sql.Date;

public class Membership {

	private int membershipId;
	private String id;
	private int type;
	private Date time;
	public  void setMembershipId(int membershipId){
		this.membershipId=membershipId;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setType(int type){
		this.type=type;
	}
	public void setTime(Date time){
		this.time=time;
	}
	public int getMembershipId(){
		return membershipId;
	}
	public String getId(){
		return id;
	}
	public int getType(){
		return type;
	}
	public Date getTime(){
		return time;
	}
	
}
