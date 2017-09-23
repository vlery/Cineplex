package net.cineplex.test;

import java.sql.Date;

import net.cineplex.action.bussiness.DateTool;

public class TT {

	public static void main(String []arg){
		Date startTime=new DateTool().getNowDate();
		String year=String.valueOf(startTime.getYear()+1900+1);
		String month=String.valueOf(startTime.getMonth()+1);
		String day=String.valueOf(startTime.getDate());
		String s= year+"-"+month+"-"+day;
		System.out.println(s);
	}
}
