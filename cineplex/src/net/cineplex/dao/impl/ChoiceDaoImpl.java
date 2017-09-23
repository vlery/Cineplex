package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.ChoiceDao;
import net.cineplex.dao.DaoHelper;
import net.cineplex.model.Choice;
import net.cineplex.model.Hall;

public class ChoiceDaoImpl implements ChoiceDao{

	private static ChoiceDaoImpl choiceDao=new ChoiceDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static ChoiceDaoImpl getInstance(){
		return choiceDao;
	}
	
	
	@Override
	public void save(Choice choice) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into choice(qid,answer,vote) "
							+ "values(?,?,?)");
			
			
			stmt.setString(1,choice.getQid());
			stmt.setString(2,choice.getAnswer());
			stmt.setInt(3,choice.getVote());
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
	public List findByQuestion(String qid) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from choice");
			result=stmt.executeQuery();
			while(result.next())
			{
					
					if(qid.equals(result.getString(2))){
						Choice choice=new Choice();
				    	choice.setCid(result.getInt(1));
				    	choice.setQid(qid);
				    	choice.setAnswer(result.getString(3));
				    	choice.setVote(result.getInt(4));
				    	list.add(choice);
				    
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
			stmt=con.prepareStatement("select * from choice");
			result=stmt.executeQuery();
			while(result.next())
			{
						Choice choice=new Choice();
				    	choice.setCid(result.getInt(1));
				    	choice.setQid(result.getString(2));
				    	choice.setAnswer(result.getString(3));
				    	choice.setVote(result.getInt(4));
				    	list.add(choice);
				    	break;
				    
					
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
	public void deleteByQuestion(String qid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from choice where qid=?");
			stmt.setString(1,qid);
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
	public Choice findByCid(String cid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Choice choice=null;
		try 
		{
			stmt=con.prepareStatement("select * from choice");
			result=stmt.executeQuery();
			while(result.next())
			{
					
					if(cid.equals(String.valueOf(result.getInt(1)))){
					    choice=new Choice();
				    	choice.setCid(result.getInt(1));
				    	choice.setQid(result.getString(2));
				    	choice.setAnswer(result.getString(3));
				    	choice.setVote(result.getInt(4));
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
		
		return choice;
	}


	@Override
	public void update(Choice choice) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update choice set qid=?,answer=?,vote=?  where cid=?");
			stmt.setString(1,choice.getQid());
			stmt.setString(2,choice.getAnswer());
			stmt.setInt(3,choice.getVote());
			stmt.setInt(4,choice.getCid());
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
