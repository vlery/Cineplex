package net.cineplex.webmodel;

import java.util.List;

public class QuizHistoryList {
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
	public QuizVO getItem(int i){
		return (QuizVO) list.get(i);
	}
}
