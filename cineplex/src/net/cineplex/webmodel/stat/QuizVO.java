package net.cineplex.webmodel.stat;

public class QuizVO {
	String[] movie;
	int[]  choice;
	
	public void setMovie(String[] movie){
		this.movie=movie;
	}
	public void setChoice(int[] choice){
		this.choice=choice;
	}
	public String[] getMovie(){
		return movie;
	}
	public int[] getChoice(){
		return choice;
	}
	public String getMovieName(int i){
		return movie[i];
	}
	public int getChocieNum(int i){
		return choice[i];
	}
	
	public int getSize(){
		return choice.length;
	}
	
}
