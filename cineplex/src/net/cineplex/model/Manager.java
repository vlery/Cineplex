package net.cineplex.model;
/*管理员表：
 * 
 * 
 * 
 * 
 */

public class Manager {
	private int id;
	private String name;
	private String password;
	private int type;
	
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setType(int type){
		this.type=type;
	}
	public int getId(){
		return id;
	}
	public String getName(){
		return name;
		
	}
	public String getPassword(){
		return password;
	}
	public int getType(){
		return type;
	}
}

