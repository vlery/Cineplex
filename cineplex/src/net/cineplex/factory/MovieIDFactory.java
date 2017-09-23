package net.cineplex.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.exception.IDRecoveryException;
import net.cineplex.model.Member;
import net.cineplex.model.Movie;
import net.cineplex.webmodel.Row;

public class MovieIDFactory  {

	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	MovieDao movieDao=daoFactory.getMovieDao();
	
	private static int count;
	private static Stack<String> reserve=new Stack<String>();
	public MovieIDFactory(){
		super();
		//3  5   6
		//
		
		if(count==0){
			List list=movieDao.find();
			
			int num=1;
			Collections.sort(list, new Comparator() {
			      @Override
			      public int compare(Object o1, Object o2) {
			    	  Movie m1=(Movie)o1;
			    	  Movie m2=(Movie)o2;
			    	  int i=Integer.parseInt(m1.getMid());
			    	  int j=Integer.parseInt(m2.getMid());
			    	  return new Integer(i-j);
			      }
			    });
			
			
			for(int i=0;i<list.size();i++){
				
				Movie movie=(Movie) list.get(i);

			
				if(movie.getMid().equals(getString(num))){
					//System.out.println("split:"+getString(num));
					num++;
					count++;
				}else{
					if(Integer.valueOf(movie.getMid())<num){
					}else{
						int count_temp=num;
						for(int j=count_temp;j<Integer.valueOf(movie.getMid());j++){
						//	System.out.println(getString(j));
							reserve.push(getString(j));
							count++;
						}
						count++;
					}
				}
				
			}
			
		}
	//	System.out.println(count);
		
	}
	
	private  String  getString(int id){
		String s=String.valueOf(id);
		return s;
	}

	public String generate()  {
		// TODO Auto-generated method stub
		System.out.println("????:"+count);
		System.out.println("!!!!:"+reserve.size());
		if(reserve.size()>0){
			return reserve.pop();
		}
		String s=String.valueOf(++count);
		return s;
	}


	public void recovery(String id) throws IDRecoveryException {
		// TODO Auto-generated method stub
		if(Integer.parseInt(id)<count){
			reserve.push(id);	
		}else{
			throw new IDRecoveryException();
		}
		
		
	}

}
