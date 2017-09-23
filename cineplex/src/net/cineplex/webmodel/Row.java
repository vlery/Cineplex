package net.cineplex.webmodel;

public class Row {
	int index;
	int seats;
	public Row(){
		index=0;
		seats=0;
	}
	public Row(int index,int seats){
		this.index=index;
		this.seats=seats;
	}
	public void setIndex(int index){
		this.index=index;
	}
	public void setSeats(int seats){
		this.seats=seats;
	}
	public int getIndex(){
		return index;
	}
	public int getSeats(){
		return seats;
	}
}
