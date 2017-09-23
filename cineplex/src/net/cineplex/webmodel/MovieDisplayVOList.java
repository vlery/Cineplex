package net.cineplex.webmodel;

import java.util.List;

public class MovieDisplayVOList {

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
	public MovieDisplayVO getItem(int i){
		return (MovieDisplayVO)list.get(i);
	}
}
