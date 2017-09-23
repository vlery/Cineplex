package net.cineplex.webmodel.stat;

import java.util.List;

public class AddressVO {

	List list;
	String otherPercent;
	public void setList(List list){
		this.list=list;
	}
	public void setOtherPercent(String otherPercent){
		this.otherPercent=otherPercent;
	}
	public List getList(){
		return list;
	}
	public String getOtherPercent(){
		return otherPercent;
	}
	
	public String getCity(int i){
		CityVO city=(CityVO) list.get(i);
		return city.getCity();
	}
	public String getPercent(int i){
		CityVO city=(CityVO) list.get(i);
		return city.getPercent();
	}
	public CityVO getItem(int i){
		return (CityVO) list.get(i);
	}
	public int getSize(){
		return list.size();
	}
}
