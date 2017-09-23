package net.cineplex.webmodel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlanListVO {

	List list;
	
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	
	public MoviePlanVO getPlanByMovie(String mid){
		for(int i=0;i<list.size();i++){
			MoviePlanVO mpv=(MoviePlanVO)list.get(i);
			if(mpv.getMid().equals(mid)){
				return mpv;
			}
		}
		return null;
	}
	
	
	public MoviePlanByDay  getItemByTime(int i){
		return (MoviePlanByDay) list.get(i);
		
	}
	
	public int getSize(){
		return list.size();
	}
	
	public MoviePlanVO getItem(int i){
		return (MoviePlanVO) list.get(i);
	}
	public void sortByDay() {
		// TODO Auto-generated method stub
		Collections.sort(list, new Comparator() {
		      @Override
		      public int compare(Object o1, Object o2) {
		    	  MoviePlanByDay plan1=(MoviePlanByDay)o1;
		    	  MoviePlanByDay plan2=(MoviePlanByDay)o2;
		    	  System.out.println(plan1.getDay()+"!!!");
		    	  String[] sp1=plan1.getDay().split("-");
		    	  String year1=sp1[0];
		    	  String month1=sp1[1];
		    	  
		    	  String day1=sp1[2];
		    	  
		    	  String[] sp2=plan2.getDay().split("-");
		    	  
		    	  String year2=sp2[0];
		    	  String month2=sp2[1];
		    	  
		    	 
		    	  String day2=sp2[2];
		    	  if(year1.equals(year2)){
		    		  if(month1.equals(month2)){
		    			  return new Integer(Integer.parseInt(day1)-Integer.parseInt(day2));
		    		  }else{
		    			  return new Integer(Integer.parseInt(month1)-Integer.parseInt(month2));
		    		  }
		    	  }else{
		    		  
		    		 
		    	 
		    	  
		    		  return new Integer(Integer.parseInt(year1)-Integer.parseInt(year2));
		      
		    	  }
		      }
		    });
	}
	
}
