package net.cineplex.action.bussiness;

public class MemberShip {
	String[] type={"ĞÂÔö","ÔİÍ£","×¢Ïú"};
	
	public int getType(String t){
		
		for(int i=0;i<type.length;i++){
			if(type[i].equals(t)){
				return i;
			}
		}
		return -1;
	}
	public String getType(int i){
		return type[i];
	}
}


