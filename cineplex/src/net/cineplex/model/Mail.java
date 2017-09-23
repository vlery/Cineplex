package net.cineplex.model;

/*
 * 邮件
 * mailId：mail id									new mail:0				handle:3
 * 													pass mail:1  fail:2
 * send:发件人id（staff manager）
 * receive:收件人
 * content:内容
 */
public class Mail {
	private int mailId;
	private String send;
	private String receive;
	private String content;
	private String mid;
	private int type;
	private int ifRead;
	public void setMailId(int mailId){
		this.mailId=mailId;
		
	}
	public void setSend(String send){
		this.send=send;
	}
	public void setReceive(String receive){
		this.receive=receive;
		
	}
	public void setContent(String content){
		this.content=content;
		
	}
	public void setMid(String mid){
		this.mid=mid;
	}
	public void setType(int type){
		this.type=type;
	}
	public void setIfRead(int ifRead){
		this.ifRead=ifRead;
	}
	public int getIfRead(){
		return ifRead;
	}
	
	public String getMid(){
		return mid;
	}
	public int getType(){
		return type;
	}
	
	
	
	public int getMailId(){
		return mailId;
	}
	public String getSend(){
		return send;
	}
	public String getReceive(){
		return receive;
		
	}
	public String getContent(){
		return content;
	}
}
