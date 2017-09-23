package net.cineplex.webmodel;

import java.util.List;

import net.cineplex.model.Mail;

public class MailList {
	List list;
	public void setList(List list){
		this.list=list;
	}
	public List getList(){
		return list;
	}
	public int getSize(){
		return list.size();
	}
	public Mail getItem(int i){
		return (Mail) list.get(i);
	}
}
