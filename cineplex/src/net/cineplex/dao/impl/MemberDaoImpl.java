package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MemberDao;
import net.cineplex.model.Member;

public class MemberDaoImpl implements MemberDao{

	private static	MemberDaoImpl memberDao=new MemberDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();

	public static MemberDaoImpl getInstance()
	{
		return memberDao;
	}
	
	
	@Override
	public Member findById(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Member member=null;
		try 
		{
			stmt=con.prepareStatement("select * from member");
			result=stmt.executeQuery();
			while(result.next())
			{
				String db_id=result.getString(1);
				if(db_id.equals(id)){
					member=new Member();
					member.setId(db_id);
					
					member.setNickName(result.getString(2));
					member.setPassword(result.getString(3));
					member.setName(result.getString(4));
					member.setBankID(result.getString(5));
					member.setBankPassword(result.getString(6));
					member.setDeposit(result.getDouble(7));
					member.setIntegral(result.getInt(8));
					member.setStartTime(result.getDate(9));
					member.setLevel(result.getInt(10));
					member.setForceful(result.getInt(11));
					
					//System.out.println(result.getString(6));
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
		
		return member;
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
			stmt=con.prepareStatement("select * from member");
			result=stmt.executeQuery();
			while(result.next())
			{
				Member member=new Member();
				member.setId(result.getString(1));
				member.setNickName(result.getString(2));
				member.setPassword(result.getString(3));
				member.setName(result.getString(4));
				member.setBankID(result.getString(5));
				member.setBankPassword(result.getString(6));
				member.setDeposit(result.getDouble(7));
				member.setIntegral(result.getInt(8));
				member.setStartTime(result.getDate(9));
				member.setLevel(result.getInt(10));
				member.setForceful(result.getInt(11));
				list.add(member);				
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
	public void save(Member member) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into member(id,nickName,password,name,bankID,bankPassword,"
							+ "deposit,integral,startTime,level,forceful) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			
			
			stmt.setString(1,member.getId());
			stmt.setString(2,member.getNickName());
			stmt.setString(3,member.getPassword());
			stmt.setString(4,member.getName());
			stmt.setString(5,member.getBankID());
			stmt.setString(6,member.getBankPassword());
			stmt.setDouble(7,member.getDeposit());
			stmt.setInt(8,member.getIntegral());
			stmt.setDate(9,member.getStartTime());
			stmt.setInt(10,member.getLevel());
			stmt.setInt(11,member.getForceful());
			
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
	public void updateById(Member member) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update member set password=?,nickName=?,name=?," +
						"bankID=?,bankPassword=?,deposit=?,integral=?,"
						+ "startTime=?,level=?,forceful=? where id=?");
			stmt.setString(1,member.getPassword());
			stmt.setString(2, member.getNickName());
			stmt.setString(3,member.getName());
			stmt.setString(4,member.getBankID());
			stmt.setString(5,member.getBankPassword());
			stmt.setDouble(6,member.getDeposit());
			stmt.setInt(7,member.getIntegral());
			stmt.setDate(8,member.getStartTime());
			stmt.setInt(9,member.getLevel());
			stmt.setInt(10,member.getForceful());
			stmt.setString(11,member.getId());
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


//	@Override
//	public boolean checkNickName(String nickName) {
//		// TODO Auto-generated method stub
//		Connection con=daoHelper.getConnection();
//		PreparedStatement stmt=null;
//		ResultSet result=null;
//		boolean ifExist=false;
//		try 
//		{
//			stmt=con.prepareStatement("select * from member");
//			result=stmt.executeQuery();
//			while(result.next())
//			{
//				String s=result.getString(2);
//				if(s.equals(nickName)){
//					ifExist=true;
//					break;
//				}			
//			}
//
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
//		return ifExist;
//	}


	@Override
	public void removeById(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{
			stmt=con.prepareStatement("delete from member where Id=?");
			stmt.setString(1, id);
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
	public Member findByName(String nickName) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Member member=null;
		try 
		{
			stmt=con.prepareStatement("select * from member");
			result=stmt.executeQuery();
			while(result.next())
			{
				String db_name=result.getString(2);
				if(db_name.equals(nickName)){
					member=new Member();
					member.setId(result.getString(1));
					member.setNickName(result.getString(2));
					member.setPassword(result.getString(3));
					member.setName(db_name);
					member.setBankID(result.getString(5));
					member.setBankPassword(result.getString(6));
					member.setDeposit(result.getDouble(7));
					member.setIntegral(result.getInt(8));
					member.setStartTime(result.getDate(9));
					member.setLevel(result.getInt(10));
					member.setForceful(result.getInt(11));
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
		
		return member;
	}


//	@Override
//	public boolean checkPassword(String nickName, String password) {
//		// TODO Auto-generated method stub
//		Connection con=daoHelper.getConnection();
//		PreparedStatement stmt=null;
//		ResultSet result=null;
//		boolean ifRight=false;
//		try 
//		{
//			stmt=con.prepareStatement("select * from member");
//			result=stmt.executeQuery();
//			while(result.next())
//			{
//				String s=result.getString(2);
//				String p=result.getString(3);
//				if(s.equals(nickName) && p.equals(password)){
//					ifRight=true;
//					break;
//				}	
//			}
//			
//			
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
//		return ifRight;
//	
//	}

	
}
