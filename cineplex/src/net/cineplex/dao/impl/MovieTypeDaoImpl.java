package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MovieTypeDao;
import net.cineplex.model.Member;
import net.cineplex.model.MovieType;

public class MovieTypeDaoImpl  implements MovieTypeDao{

	private static MovieTypeDaoImpl movieTypeDao=new MovieTypeDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MovieTypeDaoImpl getInstance(){
		return movieTypeDao;
	}
	@Override
	public List findByMid(String mid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		ArrayList list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from movietype");
			result=stmt.executeQuery();
			while(result.next())
			{
				String id=result.getString(2);
				if(id.equals(mid)){
					MovieType movieType=new MovieType();
					movieType.setMvid(result.getInt(1));
					movieType.setMid(id);
					movieType.setType(result.getInt(3));
					list.add(movieType);
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
		//System.out.println(list.size());
		return list;	
		
	}
	@Override
	public void save(List mt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void save(MovieType mt) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into movieType(mid,type) "
							+ "values(?,?)");
			
			
			stmt.setString(1,mt.getMid());
			stmt.setInt(2,mt.getType());
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
	public void deleteByMid(String mid) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from movieType where mid=?");
			stmt.setString(1,mid);
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
