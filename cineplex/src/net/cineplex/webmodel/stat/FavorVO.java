package net.cineplex.webmodel.stat;

public class FavorVO {

	String movieList;
	String scoreList;
	String peopleList;
	public void setMovieList(String movieList){
		this.movieList=movieList;
	}
	public void setScoreList(String scoreList){
		this.scoreList=scoreList;
	}
	public void setPeopleList(String voteList){
		this.peopleList=voteList;
	}
	public String getMovieList(){
		return movieList;
	}
	public String getScoreList(){
		return scoreList;
	}
	public String getPeopleList(){
		return  peopleList;
	}
	
}
