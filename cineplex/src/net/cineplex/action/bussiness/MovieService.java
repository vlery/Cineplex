package net.cineplex.action.bussiness;

import java.util.List;

import net.cineplex.model.Movie;
import net.cineplex.model.Plan;

import net.cineplex.webmodel.MovieType;
import net.cineplex.webmodel.MovieVO;


public interface MovieService {

	public void addMovie(Movie movie);
	
	public Movie scanInfo(String mid);
	public List getDisplayList();
	
	public boolean testDeposit(String id,double amount);
	public void buyTicket(String id,int type,double amount,String mid);
	
	public void watchMovie(String id,String sid,String pid);
	
	public void selectSeat(String pid);
	
	public MovieVO getMovieByMid(String mid);
	
	public List getTypeListByMid(String mid);
	
	public List getModifiableList();
	
	public MovieVO getMovie(String mid);

	public void modify(String mid, String name, String duration, String online,
			String downline, String introduction, MovieType type);

	public String add(String name, String duration, String online,
			String downline, String introduction, MovieType type);
	
	public void createPlan(String mid,String hid,String day,String time,String price);

	public List getPlanList();

	public Plan getPlan(String pid);

	public void updatePlan(Plan plan);

	public void deletePlan(int pid);
	
	public List getPlanListByMovie(MovieVO movie);
	
	public List getMovieHistoryByPid(String pid);

	public List getMovieHistoryById(String id);
	
	
	

}
