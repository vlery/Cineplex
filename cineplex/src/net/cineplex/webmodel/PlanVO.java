package net.cineplex.webmodel;

public class PlanVO {
	String pid;
	String movie;
	String hall;
	String time;
	String day;
	String price;
	
	public void setPid(String pid){
		this.pid=pid;
	}
	public void setMovie(String movie){
		this.movie=movie;
	}
	
	public void setHall(String hall){
		this.hall=hall;
	}
	public void setTime(String time){
		this.time=time;
	}
	public void setDay(String day){
		this.day=day;
	}
	public void setPrice(String price){
		this.price=price;
	}
	
	public String getMovie(){
		return movie;
	}
	public String getHall(){
		return hall;
	}
	public String getTime(){
		return time;
		
	}
	public String getDay(){
		return day;
	}
	public String getPrice(){
		return price;
	}
	public String getPid(){
		return pid;
	}
}
