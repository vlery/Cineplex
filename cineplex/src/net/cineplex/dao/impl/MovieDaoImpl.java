package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






import net.cineplex.action.bussiness.DateTool;
import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MovieDao;
import net.cineplex.model.Member;
import net.cineplex.model.Movie;

public class MovieDaoImpl implements MovieDao{

	private static MovieDaoImpl movieDao=new MovieDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MovieDaoImpl getInstance(){
		return movieDao;
	}
	
	
	
	@Override
	public void save(Movie movie) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into movie(mid,name,duration,online,downline,introduction,ifCheck) "
							+ "values(?,?,?,?,?,?,?)");
			
			
			stmt.setString(1,movie.getMid());
			stmt.setString(2,movie.getName());
			stmt.setInt(3,movie.getDuration());
			stmt.setDate(4,movie.getOnline());
			stmt.setDate(5,movie.getDownline());
			stmt.setString(6,movie.getIntroduction());
			stmt.setInt(7, movie.getIfCheck());
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
	public Movie findById(String mid) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Movie movie=null;
		try 
		{
			stmt=con.prepareStatement("select * from movie");
			result=stmt.executeQuery();
			while(result.next())
			{
				String db_id=result.getString(1);
				if(db_id.equals(mid)){
					movie=new Movie();
					movie.setMid(db_id);
					movie.setName(result.getString(2));
					movie.setDuration(result.getInt(3));
					movie.setOnline(result.getDate(4));
					movie.setDownline(result.getDate(5));
					movie.setIntroduction(result.getString(6));
					movie.setIfCheck(result.getInt(7));				
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
		
		return movie;
		
		
		
	}

	@Override
	public List find() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		ArrayList list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movie");
			result=stmt.executeQuery();
			while(result.next())
			{
					Movie movie=new Movie();
					movie.setMid(result.getString(1));
					movie.setName(result.getString(2));
					movie.setDuration(result.getInt(3));
					movie.setOnline(result.getDate(4));
					movie.setDownline(result.getDate(5));
					movie.setIntroduction(result.getString(6));
					movie.setIfCheck(result.getInt(7));
					list.add(movie);
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
	public List findOnline() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		ArrayList list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movie");
			result=stmt.executeQuery();
			while(result.next())
			{
				
				if(!new DateTool().ifDownLine((result.getDate(5)))&&result.getInt(7)==1){
					Movie movie=new Movie();
					movie.setMid(result.getString(1));
					movie.setName(result.getString(2));
					movie.setDuration(result.getInt(3));
					movie.setOnline(result.getDate(4));
					movie.setDownline(result.getDate(5));
					movie.setIntroduction(result.getString(6));
					movie.setIfCheck(result.getInt(7));
					list.add(movie);
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
	public void update(Movie movie) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update movie set name=?,duration=?,online=?," +
						"downline=?,introduction=?,ifCheck=? where mid=?");
			stmt.setString(1,movie.getName());
			stmt.setInt(2, movie.getDuration());
			stmt.setDate(3,movie.getOnline());
			stmt.setDate(4,movie.getDownline());
			stmt.setString(5,movie.getIntroduction());
			stmt.setDouble(6,movie.getIfCheck());
			stmt.setString(7,movie.getMid());

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
