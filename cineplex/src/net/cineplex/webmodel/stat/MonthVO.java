package net.cineplex.webmodel.stat;

import java.util.List;

public class MonthVO {

	
	private String totalPeopleWatch;
	private String totalMemberWatch;
	private List movieWatchList;
	private String totalTicket;
	private String onlineTicket;
	private String cashTicket;
	private String hallName;
	private String hallUpper;
	private String movieName;
	private String movieUpper;
	
	public int getMovieWatchSize(){
		return movieWatchList.size();
	}
	public MovieWatchVO getMovieWatchItem(int i){
		return (MovieWatchVO) movieWatchList.get(i);
	}
	
	
	
	public String getTotalPeopleWatch(){
		return totalPeopleWatch;
	}
	public String getTotalMemberWatch(){
		return totalMemberWatch;
	}
	public List getMovieWatchList(){
		return movieWatchList;
	}
	public String getTotalTicket(){
		return totalTicket;
	}
	public String getOnlineTicket(){
		return onlineTicket;
	}
	public String getCashTicket(){
		return cashTicket;
	}
	public String getHallName(){
		return hallName;
	}
	public String getHallUpper(){
		return hallUpper;
	}
	public String getMovieName(){
		return movieName;
	}
	public String getMovieUpper(){
		return movieUpper;
	}
	
	public void setTotalPeopleWatch(String totalPeopleWatch){
		this.totalPeopleWatch=totalPeopleWatch;
	}
	public void setTotalMemberWatch(String totalMemberWatch){
		this.totalMemberWatch=totalMemberWatch;
	}
	public void setMovieWatchList(List movieWatchList){
		this.movieWatchList=movieWatchList;
	}
	public void setTotalTicket(String totalTicket){
		this.totalTicket=totalTicket;
	}
	public void setOnlineTicket(String onlineTicket){
		this.onlineTicket=onlineTicket;
	}
	public void setCashTicket(String cashTicket){
		this.cashTicket=cashTicket;
	}
	public void setHallName(String hallName){
		this.hallName=hallName;
	}
	public void setHallUpper(String hallUpper){
		this.hallUpper=hallUpper;
	}
	public void setMovieName(String movieName){
		this.movieName=movieName;
	}
	public void setMovieUpper(String movieUpper){
		this.movieUpper=movieUpper;
	}
	
	
}
