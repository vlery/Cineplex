package net.cineplex.webmodel;

public class MemberInfoVO {

	String registerTime;
	String dueTime;
	String level;
	String deposit;
	String score;
	
	
	public void setRegisterTime(String registerTime){
		this.registerTime=registerTime;
	}
	public void setDueTime(String dueTime){
		this.dueTime=dueTime;
	}
	public void setLevel(String level){
		this.level=level;
	}
	public void setDeposit(String deposit){
		this.deposit=deposit;
	}
	public void setScore(String score){
		this.score=score;
	}
	public String getRegisterTime(){
		return registerTime;
	}
	public String getDueTime(){
		return dueTime;
	}
	public String getLevel(){
		return level;
	}
	public String getDeposit(){
		return deposit;
	}
	public String getScore(){
		return score;
	}
}
