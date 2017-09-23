package net.cineplex.webmodel;

import java.util.List;

public class UsedSeatList {
	List list;
	public  void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public void addSeat(String sid){
		list.add(sid);
	}
	public boolean ifUsed(String sid){
		
		for(int i=0;i<list.size();i++){
			if(((String)list.get(i)).equals(sid)){
				return true;
			}
		}
		return false;
	}
}
