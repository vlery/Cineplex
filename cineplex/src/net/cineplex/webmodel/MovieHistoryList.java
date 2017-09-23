package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.MovieHistory;

public class MovieHistoryList {

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
	public MovieHistoryVO getItem(int i){
		return (MovieHistoryVO) list.get(i);
	}
	
}
