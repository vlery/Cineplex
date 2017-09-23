
package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.ManagerDao;
import net.cineplex.model.Manager;
import net.cineplex.model.Member;

public class ManagerDaoImpl implements ManagerDao{
	private static	ManagerDaoImpl managerDao=new ManagerDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

	public static ManagerDaoImpl getInstance()
	{
		return managerDao;
	}
	
	@Override
	public Manager findById(int id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Manager manager=null;
		try 
		{
			stmt=con.prepareStatement("select * from manager");
			result=stmt.executeQuery();
			while(result.next())
			{
				int db_id=result.getInt(1);
				if(db_id==id){
					manager=new Manager();
					manager.setId(db_id);
					
					manager.setName(result.getString(2));
					manager.setPassword(result.getString(3));
					manager.setType(result.getInt(4));
					
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
		
		return manager;
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
			stmt=con.prepareStatement("select * from manager");
			result=stmt.executeQuery();
			while(result.next())
			{
				    Manager manager=new Manager();
					manager.setId(result.getInt(1));
					manager.setName(result.getString(2));
					manager.setPassword(result.getString(3));
					manager.setType(result.getInt(4));
					list.add(manager);
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

//	@Override
//	public boolean checkName(String name) {
//		// TODO Auto-generated method stub
//		Connection con=daoHelper.getConnection();
//		PreparedStatement stmt=null;
//		ResultSet result=null;
//		boolean ifExist=false;
//		try 
//		{
//			stmt=con.prepareStatement("select * from manager");
//			result=stmt.executeQuery();
//			while(result.next())
//			{
//				String name_temp=result.getString(2);
//				if(name_temp.equals(name)){
//					ifExist=true;
//					break;
//				}			
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			daoHelper.closeConnection(con);
//			daoHelper.closePreparedStatement(stmt);
//			daoHelper.closeResult(result);
//		}	
//		
//		return ifExist;
//	}
//
//	@Override
//	public boolean checkPassword(String name, String password) {
//		// TODO Auto-generated method stub
//		Connection con=daoHelper.getConnection();
//		PreparedStatement stmt=null;
//		ResultSet result=null;
//		boolean ifRight=false;
//		try 
//		{
//			stmt=con.prepareStatement("select * from manager");
//			result=stmt.executeQuery();
//			while(result.next())
//			{
//				String name_temp=result.getString(2);
//				String psw_temp=result.getString(3);
//				if(name_temp.equals(name)&&psw_temp.equals(password)){
//					ifRight=true;
//					break;
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			daoHelper.closeConnection(con);
//			daoHelper.closePreparedStatement(stmt);
//			daoHelper.closeResult(result);
//		}	
//		
//		return ifRight;
//	}

	@Override
	public Manager findByName(String name) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Manager manager=null;
		try 
		{
			stmt=con.prepareStatement("select * from manager");
			result=stmt.executeQuery();
			while(result.next())
			{
				String db_name=result.getString(2);
				if(db_name.equals(name)){
					manager=new Manager();
					manager.setName(db_name);
					
					manager.setId(result.getInt(1));
					manager.setPassword(result.getString(3));
					manager.setType(result.getInt(4));
					
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
		
		return manager;
	}
	

}
