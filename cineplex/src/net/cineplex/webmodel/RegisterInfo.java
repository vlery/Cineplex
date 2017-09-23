package net.cineplex.webmodel;

import java.util.ArrayList;

public class RegisterInfo {
	
	private  String name;
	private String gender;
	private String birthday;
	private String mail;
	private String tel;
	private String bankID;
	private String province;
	private String city;
	
//	private String[] p_list;
//	private String[]  c_list;
	
	
	public void setName(String name){
		this.name=name;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public void setBirthday(String birthday){
		this.birthday=birthday;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public void setBankID(String bankID){
		this.bankID=bankID;
	}
	public String  getName(){
		return name;
	}
	public String getGender(){
		return gender;
	}
	public String getBirthday(){
		return birthday;
	}
	public String getMail(){
		return mail;
	}
	public String getTel(){
		return tel;
	}
	public String getBankID(){
		return bankID;
	}
	public String getCity(){
		return city;
	}
	public String getProvince(){
		return province;
	}
	
	public void setProvince(String province){
		this.province=province;
		//p_list=new LocalDivision().getProvinceList();
	}
	
	public void setCity(String city){
		this.city=city;
		//c_list=new LocalDivision().getCityList(province);
	}
	
//	public int getProvinceTotal(){
//		return p_list.length;
//	}
//	
//	public int getCityTotal(){
//		return c_list.length;
//	}
//	
	
	
	
//	public String getCity(int i){
//		return c_list[i];
//	}
	
	
	
//	public String getProvince(int i){
//		return p_list[i];
//	}
	public boolean checkGender(String gender){
		if(this.gender.equals(gender)){
			return true;
		}
		return false;
	}


}

