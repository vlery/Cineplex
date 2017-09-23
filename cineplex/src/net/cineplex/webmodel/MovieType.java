package net.cineplex.webmodel;

import java.util.List;

public class MovieType {

	List list;
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public boolean ifIn(String index){
		for(int i=0;i<list.size();i++){
			
			if(((String)list.get(i)).equals(index)){
				return true;
			}
			
		}
		return false;
	}
	public void add(String i){
		list.add(i);
	}
}
