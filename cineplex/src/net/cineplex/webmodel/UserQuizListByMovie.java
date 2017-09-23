package net.cineplex.webmodel;

import java.util.List;

public class UserQuizListByMovie {

	String movie;
	List list;
	
	public void setMovie(String movie){
		this.movie=movie;
	}
	public String getMovie(){
		return movie;
	}
	public List getList(){
		return list;
	}
	public void setList(List list){
		this.list=list;
	}
	
	public int getSize(){
		return list.size();
	}
	public UserQuizVO getItem(int i){
		return (UserQuizVO) list.get(i);
	}
}
