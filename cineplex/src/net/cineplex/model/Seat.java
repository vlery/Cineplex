package net.cineplex.model;

/*
 * ��λ��
 * sid��id
 * hid:���ڲ�������id
 * row���ڵڼ��ţ���ǰ����
 * index�������еڼ���
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
