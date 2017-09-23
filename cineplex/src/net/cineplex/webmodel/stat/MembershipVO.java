package net.cineplex.webmodel.stat;

public class MembershipVO {
	private String start;
	private String pause;
	private String cancel;
	public void setStart(String start){
		this.start=start;
	}
	public void setPause(String pause){
		this.pause=pause;
	}
	public void setCancel(String cancel){
		this.cancel=cancel;
	}
	public String getStart(){
		return start;
	}
	public String getPause(){
		return pause;
	}
	public String getCancel(){
		return cancel;
	}
}
