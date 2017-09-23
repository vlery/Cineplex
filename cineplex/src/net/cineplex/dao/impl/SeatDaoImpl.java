package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.SeatDao;
import net.cineplex.model.MovieHistory;
import net.cineplex.model.Seat;

public class SeatDaoImpl implements SeatDao{

	private static SeatDaoImpl seatDao=new SeatDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static SeatDaoImpl getInstance(){
		return seatDao;
	}
	
	
	@Override
	public void save(Seat seat) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into seat(hid,row,seatIndex) "
							+ "values(?,?,?)");
			
			
			stmt.setString(1,seat.getHid());
			stmt.setInt(2,seat.getRow());
			stmt.setInt(3,seat.getSeatIndex());
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
	public List find() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from seat");
			result=stmt.executeQuery();
			while(result.next())
			{
				
					Seat seat=new Seat();
					seat.setSid(result.getInt(1));
					seat.setHid(result.getString(2));
					seat.setRow(result.getInt(3));
					seat.setSeatIndex(result.getInt(4));
					
					list.add(seat);
				
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
	public List findByHall(String hid) {
		// TODO Auto-generated method stub
		hid=hid.trim();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from seat");
			result=stmt.executeQuery();
			while(result.next())
			{
//				System.out.println("hid:"+hid);
//				System.out.println("hid_db:"+result.getString(2));
//				System.out.println(hid.equals(result.getString(2)));
				if(hid.equals(result.getString(2))){
					Seat seat=new Seat();
					seat.setSid(result.getInt(1));
					seat.setHid(result.getString(2));
					seat.setRow(result.getInt(3));
					seat.setSeatIndex(result.getInt(4));
					
					list.add(seat);
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
	public Seat findById(String sid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Seat seat=null;
		try 
		{
			stmt=con.prepareStatement("select * from seat");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(String.valueOf(result.getInt(1)).equals(sid.trim())){
						seat=new Seat();
						seat.setSid(result.getInt(1));
						seat.setHid(result.getString(2));
						seat.setRow(result.getInt(3));
						seat.setSeatIndex(result.getInt(4));
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
		
		return seat;
	}

}
