package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Movie;

public class MovieModifiableList {
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
	public Movie getItem(int i){
		return (Movie) list.get(i);
	}
}
