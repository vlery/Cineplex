package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.QuizHistoryDao;
import net.cineplex.model.Hall;
import net.cineplex.model.QuizHistory;

public class QuizHistoryDaoImpl implements QuizHistoryDao{

	private static QuizHistoryDaoImpl quizHistoryDao=new QuizHistoryDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static QuizHistoryDaoImpl getInstance(){
		return quizHistoryDao;
	}
	
	
	@Override
	public void save(QuizHistory quizHistory) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into quizHistory(id,cid) "
							+ "values(?,?)");
			
			
			stmt.setString(1,quizHistory.getId());
			stmt.setString(2,quizHistory.getCid());
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
			stmt=con.prepareStatement("select * from quizHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
					String id_db= result.getString(2);

					if(id_db.equals(id)){
				    	QuizHistory quizHistory=new QuizHistory();
				    	quizHistory.setQhid(result.getInt(1));
				    	quizHistory.setId(result.getString(2));
				    	quizHistory.setCid(result.getString(3));
				    	list.add(quizHistory);
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
	public QuizHistory findByIdAndCid(String id, String cid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		QuizHistory quizHistory=null;
		try 
		{
			stmt=con.prepareStatement("select * from quizHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
					String id_db= result.getString(2);
					String cid_db=result.getString(3);
					if(id_db.equals(id)&&cid_db.equals(cid)){
				    	quizHistory=new QuizHistory();
				    	quizHistory.setQhid(result.getInt(1));
				    	quizHistory.setId(result.getString(2));
				    	quizHistory.setCid(result.getString(3));
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
		
		return quizHistory;
	}


	@Override
	public void update(QuizHistory quizHistory) {
		// TODO Auto-generated method stub
		
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update quizHistory set id=?,cid=?  where qhid=?");
			stmt.setString(1,quizHistory.getId());
			stmt.setString(2,quizHistory.getCid());
			stmt.setInt(3,quizHistory.getQhid());

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
	public List findByChoice(String cid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		try 
		{
			stmt=con.prepareStatement("select * from quizHistory");
			result=stmt.executeQuery();
			while(result.next())
			{
					String cid_db= result.getString(3);

					if(cid_db.equals(cid)){
				    	QuizHistory quizHistory=new QuizHistory();
				    	quizHistory.setQhid(result.getInt(1));
				    	quizHistory.setId(result.getString(2));
				    	quizHistory.setCid(result.getString(3));
				    	list.add(quizHistory);
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
	public void deleteByMember(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from quizHistory where id=?");
			stmt.setString(1,id);
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
