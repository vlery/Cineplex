package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Seat;

public class SeatListInRow {
	int row;
	List list;
	public  void setRow(int row){
		this.row=row;
	}
	public void setList(List list){
		this.list=list;
	}
	public int getRow(){
		return row;
	}
	public List getList(){
		return list;
	}
	public int getSeatNum(){
		return list.size();
	}
	public Seat getSeat(int i){
		return (Seat) list.get(i);
	}
}
