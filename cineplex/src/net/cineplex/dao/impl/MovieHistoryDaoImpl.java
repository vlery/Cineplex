package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MovieHistoryDao;
import net.cineplex.model.Hall;
import net.cineplex.model.MovieHistory;

public class MovieHistoryDaoImpl implements MovieHistoryDao{

	private static MovieHistoryDaoImpl movieHistoryDao=new MovieHistoryDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MovieHistoryDaoImpl getInstance(){
		return movieHistoryDao;
	}
	
	
	@Override
	public void save(MovieHistory movieHistory) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into movieHistory(id,pid,sid,day)"
							+ "values(?,?,?,?)");
			
			
			stmt.setString(1,movieHistory.getId());
			stmt.setString(2,movieHistory.getPid());
			stmt.setString(3,movieHistory.getSid());
			stmt.setDate(4,movieHistory.getDay());
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
	public List findByMember(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movieHistory order by day desc");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(id.equals(result.getString(2))){
					MovieHistory movieHistory=new MovieHistory();
					movieHistory.setMhid(result.getInt(1));
					movieHistory.setId(result.getString(2));
					movieHistory.setPid(result.getString(3));
					movieHistory.setSid(result.getString(4));
					movieHistory.setDay(result.getDate(5));
					list.add(movieHistory);
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
	public List findByPlan(String pid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movieHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(pid.equals(result.getString(3))){
					MovieHistory movieHistory=new MovieHistory();
					movieHistory.setMhid(result.getInt(1));
					movieHistory.setId(result.getString(2));
					movieHistory.setPid(result.getString(3));
					movieHistory.setSid(result.getString(4));
					movieHistory.setDay(result.getDate(5));
					list.add(movieHistory);
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
			stmt=con.prepareStatement("select * from movieHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
					MovieHistory movieHistory=new MovieHistory();
					movieHistory.setMhid(result.getInt(1));
					movieHistory.setId(result.getString(2));
					movieHistory.setPid(result.getString(3));
					movieHistory.setSid(result.getString(4));
					movieHistory.setDay(result.getDate(5));
					list.add(movieHistory);
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
			stmt=con.prepareStatement("select * from movieHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(result.getDate(5).equals(day)){
						MovieHistory movieHistory=new MovieHistory();
						movieHistory.setMhid(result.getInt(1));
						movieHistory.setId(result.getString(2));
						movieHistory.setPid(result.getString(3));
						movieHistory.setSid(result.getString(4));
						movieHistory.setDay(result.getDate(5));
						list.add(movieHistory);
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
	public List findByPidAndDay(String pid, Date dayCount) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movieHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
				String pid_db=result.getString(3);
				Date day_db=result.getDate(5);
				if(pid.equals(pid_db)&&dayCount.equals(day_db)){
					MovieHistory movieHistory=new MovieHistory();
					movieHistory.setMhid(result.getInt(1));
					movieHistory.setId(result.getString(2));
					movieHistory.setPid(result.getString(3));
					movieHistory.setSid(result.getString(4));
					movieHistory.setDay(result.getDate(5));
					list.add(movieHistory);
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
	public void deleteByMember(String id) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from movieHistory where id=?");
			stmt.setString(1,id);
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


	

	
}
