package net.cineplex.webmodel.stat;

import java.util.List;

public class DayVO {

	String day;
	String totalUpper;
	String people;
	List movieList;
	List hallList;
	public void setDay(String day){
		this.day=day;
		
	}
	public void setTotalUpper(String totalUpper){
		this.totalUpper=totalUpper;
	}
	public void setPeople(String people){
		this.people=people;
	}
	
	public void setMovieList(List movieList){
		this.movieList=movieList;
	}
	public void setHallList(List hallList){
		this.hallList=hallList;
	}
	
	
	
	public String getDay(){
		return day;
	}
	public String getTotalUpper(){
		return totalUpper;
	}
	public String getPeople(){
		return people;
	}
	public List getMovieList(){
		return movieList;
	}
	public List getHallList(){
		return hallList;
	}
	
	public int getMovieSize(){
		return movieList.size();
	}
	public MovieUpperByDayVO getMovieItem(int i){
		return (MovieUpperByDayVO) movieList.get(i);
	}
	public HallUpperByDayVO getHallItem(int i){
		return (HallUpperByDayVO) hallList.get(i);
	}
	
	public int getHallSize(){
		return hallList.size();
	}
}
