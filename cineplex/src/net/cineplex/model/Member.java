package net.cineplex.model;

import java.sql.Date;
/*
 * ��Ա��Ϣ��
 *  id����Աid
 *  nickName:�ǳ�
 *  password������
 *  name����Ա����
 *  bankID�����п���
 *  bankPassword:��������
 *  deposit�������
 *  integral������
 *  startTime:��Чʱ��
 *  level����Ա�ȼ�
 *  forceful���Ƿ���Ч
 */

public class Member {
	private String id;
	private String nickName;
	private String password;
	private String name;
	private String bankID;
	private String bankPassword;
	private double deposit;
	private int integral;
	private Date startTime;
	private int	level;
	private int forceful;


	public void setId(String id){
		this.id=id;
	}
	public void setNickName(String nickName){
		this.nickName=nickName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setBankID(String bankID){
		this.bankID=bankID;
	}
	public void setBankPassword(String bankPassword){
		this.bankPassword=bankPassword;
	}
	public void setDeposit(double deposit){
		this.deposit=deposit;
	}
	public void setIntegral(int integral){
		this.integral=integral;
	}
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	public void setLevel(int level){
		this.level=level;
	}
	public void setForceful(int forceful){
		this.forceful=forceful;
	}

	
	public String getId(){
		return id;
	}
	public String getNickName(){
		return nickName;
	}
	public String getPassword(){
		return password;
	}
	public String getName(){
		return name;
	}
	public String getBankID(){
		return bankID;
	}
	public String getBankPassword(){
		return bankPassword;
	}
	public double getDeposit(){
		return deposit;
	}
	public int getIntegral(){
		return integral;
	}
	public Date getStartTime(){
		return startTime;
	}
	public int getLevel(){
		return level;
	}
	public int getForceful(){
		return forceful;
	}
}
