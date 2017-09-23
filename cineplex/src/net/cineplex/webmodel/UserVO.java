package net.cineplex.webmodel;

public class UserVO {

	private String id;
	private String nickname;

	
	
	public void setId(String  id){
		this.id=id;
	}
	public void setNickname(String nickname){
		this.nickname=nickname;
	}


	public String getId(){
		return id;
	}
	public String getNickname(){
		return nickname;
	}
}
