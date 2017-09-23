package net.cineplex.webmodel.stat;

public class FavorTypeVO {

	String[] type;
	int[] count;
	
	public void setType(String[] type){
		this.type=type;
	}
	public String[] getType(){
		return type;
	}
	public void setCount(int []count){
		this.count=count;
	}
	public int[] getCount(){
		return count;
	}
	public int getSize(){
		return type.length;
	}
	public String getTypeItem(int i){
		return type[i];
	}
	public int getCountItem(int i){
		return count[i];
	}
}
