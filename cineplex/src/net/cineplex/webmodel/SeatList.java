package net.cineplex.webmodel;

import java.util.List;

public class SeatList {

	List list;
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public int getSize(){
		return list.size();
	}
	
	public String getItem(int i){
		return (String) list.get(i);
	}
	
	public void addItem(String seat){
		list.add(seat);
	}
}
