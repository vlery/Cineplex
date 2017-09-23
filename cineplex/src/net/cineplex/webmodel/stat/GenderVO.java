package net.cineplex.webmodel.stat;

public class GenderVO {

	String male;
	String female;
	String total;
	
	
	public void setMale(String male){
		this.male=male;
	}
	public void setFemale(String female){
		this.female=female;
	}
	public void setTotal(String total){
		this.total=total;
	}
	public String getMale(){
		return male;
	}
	public String getFemale(){
		return female;
	}
	public String getTotal(){
		return total;
	}
}
