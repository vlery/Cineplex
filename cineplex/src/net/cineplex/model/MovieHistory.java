package net.cineplex.model;

import java.sql.Date;

/*
 * ��Ӱ��¼��
 * mhid:id
 * id:��Աid
 * pid:����id(����Ӱ���żƻ�)
 * sid:��λid
 * day����Ӱ����
 */

public class MovieHistory {
	
		private int mhid;
		private String id;
		private String pid;
		private String sid;
		private Date day;

		
		
		public void setMhid(int mhid){
			this.mhid=mhid;
		}
		public void setId(String id){
			this.id=id;
		}
		public void setPid(String pid){
			this.pid=pid;
		}
		public void setSid(String sid){
			this.sid=sid;
		}
		public void setDay(Date day){
			this.day=day;
		}
		
		public int getMhid(){
			return mhid;
		}
		public String getId(){
			return id;
		}
		public String getPid(){
			return pid;
		}
		
		public String getSid(){
			return sid;
		}
		
		public Date getDay(){
			return day;
		}
}
