package net.cineplex.model;

import java.sql.Date;

/*
 * �û�������Ϣ��
 * id���û�id
 * birthday������
 * tel���绰
 * gender���Ա�
 * mail������
 * registerTime:ע��ʱ��
 * province��ʡ
 * city����
 * 
 */

public class MemberInfo {
	private String id;
	private Date birthday;
	private String tel;
	private int gender;
	private String mail;
	private Date registerTime;
	private int province;
	private int city;

	public void setId(String id){
		this.id=id;
	}
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	public void setTel(String tel){
		this.tel=tel;
	}
	public void setGender(int gender){
		this.gender=gender;
	}
	public void setMail(String mail){
		this.mail=mail;
	}
	public void setRegisterTime(Date registerTime){
		this.registerTime=registerTime;
	}
	public void setProvince(int province){
		this.province=province;
	}
	public void setCity(int city){
		this.city=city;
	}

	public String getId(){
		return id;
	}
	public Date getBirthday(){
		return birthday;
	}
	public String getTel(){
		return tel;
	}
	public int getGender(){
		return gender;
	}
	public String getMail(){
		return mail;
	}
	public Date getRegisterTime(){
		return registerTime;
	}
	public int getProvince(){
		return province;
	}
	public int getCity(){
		return city;
	}











}
