package net.cineplex.webmodel;

import java.util.List;

public class SelectList {

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
	
	public void add(String item){
		list.add(item);
	}
	public void remove(int index) {
		// TODO Auto-generated method stub
		list.remove(index);
	}
	
}
