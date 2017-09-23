package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Hall;

public class HallList {

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
	public String getNameByIndex(int i){
		Hall hall=(Hall) list.get(i);
		return hall.getName();
	}
	public int getHidByIndex(int i){
		Hall hall=(Hall) list.get(i);
		return hall.getHid();
	}
}
