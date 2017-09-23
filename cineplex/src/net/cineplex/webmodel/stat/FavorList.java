package net.cineplex.webmodel.stat;

import java.util.List;

public class FavorList {

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
	public MovieVO getItem(int i){
		return (MovieVO) list.get(i);
	}
	public void addItem(MovieVO mv){
		list.add(mv);
	}
}
