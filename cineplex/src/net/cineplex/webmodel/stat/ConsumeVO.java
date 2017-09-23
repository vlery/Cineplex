package net.cineplex.webmodel.stat;

public class ConsumeVO {

	private String total;
	private String online;
	private String cash;
	
	public void setTotal(String total){
		this.total=total;
	}
	public void setOnline(String online){
		this.online=online;
	}
	public void setCash(String cash){
		this.cash=cash;
	}
	public String getTotal(){
		return total;
	}
	public String getOnline(){
		return online;
	}
	public String getCash(){
		return cash;
	}
}
