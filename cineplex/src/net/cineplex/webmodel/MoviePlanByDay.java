package net.cineplex.webmodel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoviePlanByDay {
	String day;
	List list;
	public void setDay(String day){
		this.day=day;
	}
	public String getDay(){
		return day;
	}
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public int getSize(){
		return list.size();
	}
	public PlanVO getItem(int i){
		return (PlanVO) list.get(i);
	}
	public void sortByTime() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator() {
		      @Override
		      public int compare(Object o1, Object o2) {
		    	  PlanVO pv1=(PlanVO)o1;
		    	  PlanVO pv2=(PlanVO)o2;
		    	  String[] sp1=pv1.getTime().split(":");
		    	  String[]	sp2=pv2.getTime().split(":");
		    	  if(sp1[0].equals(sp2[0])){
		    		  return new Integer(Integer.parseInt(sp1[1])-Integer.parseInt(sp2[2]));
		    	  }else{
		    		  return new Integer(Integer.parseInt(sp1[0])-Integer.parseInt(sp2[0]));
		    	  }
		    	  // System.out.println(pv1.getTime());
		    	  
		      }
		    });
	}
	
}
