package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Plan;

public class MoviePlanVO {

	String mid;
	String name;
	List list;
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setList(List list){
		this.list=list;
	}
	public String getMid(){
		return mid;
	}
	public String getName(){
		return name;
	}
	public List getList(){
		return list;
	}
	
	public int getListSize(){
		return list.size();
	}
	
	public PlanVO getPlanItem(int i){
		return (PlanVO) list.get(i);
	}

	public void add(PlanVO plan){
		list.add(plan);
	}
}
