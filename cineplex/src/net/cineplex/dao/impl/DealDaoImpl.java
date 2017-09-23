package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.DealDao;
import net.cineplex.model.Deal;
import net.cineplex.model.Hall;

public class DealDaoImpl implements DealDao{

	
	private static DealDaoImpl dealDao=new DealDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static DealDaoImpl getInstance(){
		return dealDao;
	}
	
	@Override
	public void save(Deal deal) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into deal(id,mid,type,time,amount) "
							+ "values(?,?,?,?,?)");
			
			
			stmt.setString(1,deal.getId());
			stmt.setString(2,deal.getMid());
			stmt.setInt(3,deal.getType());
			stmt.setDate(4,deal.getTime());
			stmt.setDouble(5, deal.getAmount());
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
			stmt=con.prepareStatement("select * from deal");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(result.getString(2).equals(id)){
					Deal deal=new Deal();
					deal.setDid(result.getInt(1));
					deal.setId(result.getString(2));
					deal.setMid(result.getString(3));
					deal.setType(result.getInt(4));
					deal.setTime(result.getDate(5));
					deal.setAmount(result.getDouble(6));
					list.add(deal);
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
	public List findByType(int type) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from deal");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(result.getInt(4)==type){
					Deal deal=new Deal();
					deal.setDid(result.getInt(1));
					deal.setId(result.getString(2));
					deal.setMid(result.getString(3));
					deal.setType(result.getInt(4));
					deal.setTime(result.getDate(5));
					deal.setAmount(result.getDouble(6));
					list.add(deal);
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
