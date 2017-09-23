package net.cineplex.webmodel;

import java.util.List;

public class UserQuizList {

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
	
	public UserQuizListByMovie getItem(int i){
		return (UserQuizListByMovie) list.get(i);
	}
}
