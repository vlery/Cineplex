package net.cineplex.factory;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import net.cineplex.dao.MemberDao;
import net.cineplex.exception.IDGenerateException;
import net.cineplex.exception.IDRecoveryException;
import net.cineplex.model.Member;
import net.cineplex.model.Movie;


public class MemberIDFactory extends IDFactory{
	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	MemberDao memberDao=daoFactory.getMemberDao();
	private static int count;
	private static Stack<String> reserve=new Stack<String>();
	public MemberIDFactory(){
		super();
		//3  5   6
		//
		if(count==0){
			List list=memberDao.find();
			
			
			Collections.sort(list, new Comparator() {
			      @Override
			      public int compare(Object o1, Object o2) {
			    	  Member m1=(Member)o1;
			    	  Member m2=(Member)o2;
			    	  int i=Integer.parseInt(m1.getId());
			    	  int j=Integer.parseInt(m2.getId());
			    	  return new Integer(i-j);
			      }
			    });
			int num=1;
			for(int i=0;i<list.size();i++){
				Member member=(Member) list.get(i);
				if(member.getId().equals(getString(num))){
					num++;
					count++;
				}else{
					if(Integer.valueOf(member.getId())<num){
					}else{
						int count_temp=num;
						for(int j=count_temp;j<Integer.valueOf(member.getId());j++){
							reserve.push(getString(j));
							count++;
						}
						count++;
					}
				}
			}
			
		}
	}
	
	private  String  getString(int id){
		String s=String.valueOf(id);
		int len=s.length();
		for(int i=0;i<7-len;i++){
			s="0"+s;
		}
		return s;
	}
	
	@Override
	public String generate() throws IDGenerateException {
		// TODO Auto-generated method stub
		if(reserve.size()>0){
			return reserve.pop();
		}
		
		if(count>9999999){
			throw new IDGenerateException();
		}
		
		
		String s=String.valueOf(++count);
		int len=s.length();
		for(int i=0;i<7-len;i++){
			s="0"+s;
		}
		return s;
	}
	
	
	@Override
	public void recovery(String id) throws IDRecoveryException {
		// TODO Auto-generated method stub
		if(Integer.parseInt(id)<=count){
			reserve.push(id);
		}else{
			 throw new IDRecoveryException();
		}
	}

	
	

	
}
