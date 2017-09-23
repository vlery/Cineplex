package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.PlanDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Plan;

public class PlanDaoImpl implements PlanDao{

	private static PlanDaoImpl planDao=new PlanDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static PlanDaoImpl getInstance(){
		return planDao;
	}
	
	@Override
	public void save(Plan plan) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into plan(mid,hid,day,time,price)" 
							+ "values(?,?,?,?,?)");
			
			
			stmt.setString(1,plan.getMid());
			stmt.setString(2,plan.getHid());
			stmt.setDate(3,plan.getDay());
			stmt.setTime(4,plan.getTime());
			stmt.setInt(5,plan.getPrice());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}
		
	}

	@Override
	public List findByMovie(String mid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
					int mid_db= result.getInt(2);
				    if(mid_db==Integer.valueOf(mid)){
				    	Plan plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(mid);
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	list.add(plan);
				    }
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		
		return list;
	}

	@Override
	public List findByDay(Date day) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
					
				if(result.getDate(4).equals(day)){
				    	Plan plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(result.getString(2));
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	list.add(plan);
				}
				   
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		
		return list;
	}

	@Override
	public List find() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
					
				    	Plan plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(result.getString(2));
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	list.add(plan);
				   
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		
		return list;
	}

	@Override
	public void updateById(Plan plan) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update plan set mid=?,hid=?,day=?," +
						"time=?,price=? where pid=?");
			stmt.setString(1,plan.getMid());
			stmt.setString(2, plan.getHid());
			stmt.setDate(3,plan.getDay());
			stmt.setTime(4,plan.getTime());
			stmt.setInt(5,plan.getPrice());
			stmt.setInt(6,plan.getPid());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}		
	}

	@Override
	public Plan findByPid(String pid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Plan plan=null;
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(result.getInt(1)==Integer.parseInt(pid)){
				        plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(result.getString(2));
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	break;
					}
				   
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		
		return plan;
		
	}

	@Override
	public void deleteById(int pid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from plan where pid=?");
			stmt.setInt(1,pid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
		}	
		
		
	}

	@Override
	public List findByDayAndHall(Date day, String hid) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
		
					
					Date day_db= result.getDate(4);

					String hid_db=result.getString(3);

					if(day_db.equals(day) &&hid_db.equals(hid)){
				    	Plan plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(result.getString(2));
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	list.add(plan);
				    }
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		System.out.println(list.size());
		return list;
	}

	@Override
	public List fingByDayAndMovie(Date day, String mid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from plan");
			result=stmt.executeQuery();
			while(result.next())
			{
					Date day_db= result.getDate(4);
					String mid_db=result.getString(2);
				    if(day_db.equals(day)&&mid_db.equals(mid)){
				    	Plan plan=new Plan();
				    	plan.setPid(result.getInt(1));
				    	plan.setMid(result.getString(2));
				    	plan.setHid(result.getString(3));
				    	plan.setDay(result.getDate(4));
				    	plan.setTime(result.getTime(5));
				    	plan.setPrice(result.getInt(6));
				    	list.add(plan);
				    }
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			daoHelper.closeConnection(con);
			daoHelper.closePreparedStatement(stmt);
			daoHelper.closeResult(result);
		}	
		
		return list;
	}

}
