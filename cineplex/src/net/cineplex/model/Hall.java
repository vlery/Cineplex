package net.cineplex.model;

/*
 * 播放厅
 * hid：id
 * name：播放厅名字
 * row：一共多少排
 */


public class Hall {

	
	private int hid;
	private String name;
	private int  row;
	
	
	public void setHid(int hid){
		this.hid=hid;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setRow(int row){
		this.row=row;
	}
	
	public int getHid(){
		return hid;
	}
	public String getName(){
		return name;
	}
	
	public int getRow(){
		return row;
	}
	
}
