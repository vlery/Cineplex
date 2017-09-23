package net.cineplex.webmodel;

import java.util.List;

public class SeatListInHall {
	List list;
	public  List getList(){
		return list;
	}
	public void setList(List list){
		this.list=list;
	}
	public int getSize(){
		return list.size();
	}
	public SeatListInRow getItem(int i){
		return (SeatListInRow) list.get(i);
	}
}
