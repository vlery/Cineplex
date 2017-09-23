package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MembershipDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Membership;

public class MembershipDaoImpl implements MembershipDao{
	private static MembershipDaoImpl membershipDao=new MembershipDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MembershipDaoImpl getInstance(){
		return membershipDao;
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
			stmt=con.prepareStatement("select * from membership");
			result=stmt.executeQuery();
			while(result.next())
			{
				    Membership membership=new Membership();
				    membership.setMembershipId(result.getInt(1));
				    membership.setId(result.getString(2));
				    membership.setType(result.getInt(3));
				    membership.setTime(result.getDate(4));
				    
				   
					list.add(membership);
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
	public void save(Membership membership) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into membership(id,type,time) "
							+ "values(?,?,?)");
			
			
			stmt.setString(1,membership.getId());
			stmt.setInt(2,membership.getType());
			stmt.setDate(3,membership.getTime());
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
	public List findByType(int type) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from membership");
			result=stmt.executeQuery();
			while(result.next())
			{
				    if(result.getInt(3)==type){
						Membership membership=new Membership();
					    membership.setMembershipId(result.getInt(1));
					    membership.setId(result.getString(2));
					    membership.setType(result.getInt(3));
					    membership.setTime(result.getDate(4));
						list.add(membership);
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
