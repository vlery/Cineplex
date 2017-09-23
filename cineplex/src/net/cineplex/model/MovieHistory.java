package net.cineplex.model;

import java.sql.Date;

/*
 * 观影记录：
 * mhid:id
 * id:会员id
 * pid:场次id(即电影播放计划)
 * sid:座位id
 * day：观影日期
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
