package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;







import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.RechargeDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Recharge;

public class RechargeDaoImpl implements RechargeDao{

	private static	RechargeDaoImpl rechargeDao=new RechargeDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

	public static RechargeDaoImpl getInstance()
	{
		return rechargeDao;
	}
	
	@Override
	public void save(Recharge recharge) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into recharge(id,amount,time,type) "
							+ "values(?,?,?,?)");
			
			
			stmt.setString(1,recharge.getId());
			stmt.setDouble(2,recharge.getAmount());
			stmt.setDate(3,recharge.getTime());
			stmt.setInt(4,recharge.getType());
			
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
	public List find(String memberId) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from recharge");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(result.getString(2).equals(memberId)){
				    Recharge recharge=new Recharge();
					recharge.setRid(result.getInt(1));
					recharge.setId(result.getString(2));
					recharge.setAmount(result.getDouble(3));
					recharge.setTime(result.getDate(4));
					recharge.setType(result.getInt(5));
					list.add(recharge);
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
			stmt=con.prepareStatement("select * from recharge");
			result=stmt.executeQuery();
			while(result.next())
			{
				
				    Recharge recharge=new Recharge();
					recharge.setRid(result.getInt(1));
					recharge.setId(result.getString(2));
					recharge.setAmount(result.getDouble(3));
					recharge.setTime(result.getDate(4));
					recharge.setType(result.getInt(5));
					list.add(recharge);
				
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
