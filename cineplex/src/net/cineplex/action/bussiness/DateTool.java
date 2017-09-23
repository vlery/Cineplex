package net.cineplex.action.bussiness;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class DateTool {

	
	public  Date getNowDate(){
		
		Date  date=new Date(new java.util.Date().getTime());
		
		return date;
	}
	
	public Date getDefaultDate(){
		return new Date(0,0,1);
	}
	
	public Date stringToDate(String s){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date d=sdf.parse(s);
			return new Date(d.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean ifDownLine(Date date) {
		// TODO Auto-generated method stub
		return date.before(getNowDate())||date.equals(getNowDate());
	}

	//舍去年份
	public String dateToShortString(Date online) {
		// TODO Auto-generated method stub
		String s=String.valueOf(online);
		String[] temp=s.split("-");
		return (temp[1]+" 月 "+temp[2]+" 日");
	}
	
	public Time stringToTime(String s){
		String sp[]=s.split(":");
		Time time=new Time(Integer.parseInt(sp[0]),Integer.parseInt(sp[1]),0);
		return time;
	}
	public String timeToString(Time time){
		String s="";
		String hour=String.valueOf(time.getHours());
		String minute=String.valueOf(time.getMinutes());
		s=hour+":"+minute;
		return s;
	}

	public String getDueTime(Date startTime) {
		// TODO Auto-generated method stub
		String year=String.valueOf(startTime.getYear()+1900+1);
		String month=String.valueOf(startTime.getMonth()+1);
		String day=String.valueOf(startTime.getDate());
		return year+"-"+month+"-"+day;
	}
	
	public boolean ifThisMonth(Date start,Date end){

		Date today=new DateTool().getNowDate();
		Date firstDayThisMonth=new Date(0, 0, 0);
		firstDayThisMonth.setYear(today.getYear());
		firstDayThisMonth.setMonth(today.getMonth());
		firstDayThisMonth.setDate(1);
		Date firstDayNextMonth=new Date(0, 0, 0);
		if(today.getMonth()==12){
			firstDayNextMonth.setYear(today.getYear()+1);
			firstDayNextMonth.setMonth(1);
			firstDayNextMonth.setDate(1);
		}else{
			firstDayNextMonth.setYear(today.getYear());
			firstDayNextMonth.setMonth(today.getMonth()+1);
			firstDayNextMonth.setDate(1);
		}
		if(end.before(firstDayThisMonth)){
			return false;
		}else if(start.before(firstDayNextMonth)){
			return true;
		}else{
			return false;
		}
	}
	
}
