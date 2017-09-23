package net.cineplex.webmodel.stat;

public class MovieWatchVO {
	String movie;
	String count;
	public void setMovie(String movie){
		this.movie=movie;
	}
	public void setCount(String count){
		this.count=count;
	}
	public String getMovie(){
		return movie;
	}
	public String getCount(){
		return count;
	}

}
