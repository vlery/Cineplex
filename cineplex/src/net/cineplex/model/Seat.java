package net.cineplex.model;

/*
 * 座位表：
 * sid：id
 * hid:所在播放厅的id
 * row：在第几排（从前往后）
 * index：在排中第几座
 * 
 */

public class Seat {
	private int sid;
	private String hid;
	private int row;
	private int seatIndex;
	
	
	public void setSid(int sid){
		this.sid=sid;
	}
	public void setHid(String hid){
		this.hid=hid;
	}
	public void setRow(int row){
		this.row=row;
	}
	public void setSeatIndex(int index){
		this.seatIndex=index;
	}
	
	public int getSid(){
		return sid;
	}
	public String getHid(){
		return hid;
	}
	public int getRow(){
		return row;
	}
	public int getSeatIndex(){
		return seatIndex;
	}
	
	
}
