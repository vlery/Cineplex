package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.HallDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Manager;

public class HallDaoImpl implements HallDao{

	private static HallDaoImpl hallDao=new HallDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static HallDaoImpl getInstance(){
		return hallDao;
	}
	
	
	@Override
	public void save(Hall hall) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into hall(name,row) "
							+ "values(?,?)");
			
			
			stmt.setString(1,hall.getName());
			stmt.setInt(2,hall.getRow());
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
	public Hall findById(String hid) {
		// TODO Auto-generated method stub
		hid=hid.trim();
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Hall hall=null;
		try 
		{
			stmt=con.prepareStatement("select * from hall");
			result=stmt.executeQuery();
			while(result.next())
			{
					int hid_db= result.getInt(1);
//				   System.out.println(String.valueOf(hid_db));
//				   System.out.println(hid);
//				   System.out.println(hid.equals(String.valueOf(hid_db)));
					if(hid.equals(String.valueOf(hid_db))){
				    	hall=new Hall();
				    	hall.setHid(result.getInt(1));
				    	hall.setName(result.getString(2));
				    	hall.setRow(result.getInt(3));
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
		
		return hall;
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
			stmt=con.prepareStatement("select * from hall");
			result=stmt.executeQuery();
			while(result.next())
			{
				    Hall hall=new Hall();
					hall.setHid(result.getInt(1));
					hall.setName(result.getString(2));
					hall.setRow(result.getInt(3)); 
					list.add(hall);
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
	public String getHidByName(String name) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		String hid="";
		try 
		{
			stmt=con.prepareStatement("select * from hall");
			result=stmt.executeQuery();
			while(result.next())
			{
				
				if(result.getString(2).equals(name)){
					hid=String.valueOf(result.getInt(1));
					break;
				};
				 
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
		
		return hid;
	}

}
