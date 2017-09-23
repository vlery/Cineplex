package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MailDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Mail;

public class MailDaoImpl implements MailDao{

	private static MailDaoImpl mailDao=new MailDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MailDaoImpl getInstance(){
		return  mailDao;
	}
	
	
	@Override
	public void save(Mail mail) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into mail(send,receive,content,mid,type,ifRead) "
							+ "values(?,?,?,?,?,?)");
			
			
			stmt.setString(1,mail.getSend());
			stmt.setString(2,mail.getReceive());
			stmt.setString(3,mail.getContent());
			stmt.setString(4,mail.getMid());
			stmt.setInt(5,mail.getType());
			stmt.setInt(6,mail.getIfRead());
			
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
	public List findByReceiveId(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from mail");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(result.getString(3).equals(id)){
				    Mail mail=new Mail();
					mail.setMailId(result.getInt(1));
					mail.setSend(result.getString(2));
					mail.setReceive(result.getString(3)); 
					mail.setContent(result.getString(4));
					mail.setMid(result.getString(5));
					mail.setType(result.getInt(6)); 
					mail.setIfRead(result.getInt(7));
					
					list.add(mail);
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
	public void update(Mail mail) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	

			stmt=con.prepareStatement("update mail set send=?,receive=?,content=?,mid=?,type=?,ifRead=? "
							+ "where mailId=?");
			
			
			stmt.setString(1,mail.getSend());
			stmt.setString(2,mail.getReceive());
			stmt.setString(3,mail.getContent());
			stmt.setString(4,mail.getMid());
			stmt.setInt(5,mail.getType());
			stmt.setInt(6,mail.getIfRead());
			stmt.setInt(7,mail.getMailId());
			
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
	public Mail findByMailId(int mailId) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Mail mail=null;
		try 
		{
			stmt=con.prepareStatement("select * from mail");
			result=stmt.executeQuery();
			while(result.next())
			{
				if(result.getInt(1)==mailId){
				    mail=new Mail();
					mail.setMailId(result.getInt(1));
					mail.setSend(result.getString(2));
					mail.setReceive(result.getString(3)); 
					mail.setContent(result.getString(4));
					mail.setMid(result.getString(5));
					mail.setType(result.getInt(6)); 
					mail.setIfRead(result.getInt(7));
					
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
		
		return mail;
	}
	
}
