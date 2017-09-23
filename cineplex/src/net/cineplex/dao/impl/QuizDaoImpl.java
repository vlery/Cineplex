package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.QuizDao;
import net.cineplex.model.Hall;
import net.cineplex.model.Quiz;

public class QuizDaoImpl implements QuizDao{

	private static QuizDaoImpl quizDao=new QuizDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static QuizDaoImpl getInstance(){
		return quizDao;
	}
	
	
	@Override
	public void save(Quiz quiz) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		
		try 
		{	
			stmt=con.prepareStatement("insert into quiz(mid,question) "
							+ "values(?,?)");
			
			
			stmt.setString(1,quiz.getMid());
			stmt.setString(2,quiz.getQuestion());
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
	public List findByMovie(String mid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		
		try 
		{
			stmt=con.prepareStatement("select * from quiz");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(mid.equals(result.getString(2))){
				    	Quiz quiz=new Quiz();
				    	quiz.setQid(result.getInt(1));
				    	quiz.setMid(result.getString(2));
				    	quiz.setQuestion(result.getString(3));
				    	quiz.setBestChoice(result.getString(4));
				    	list.add(quiz);
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
			stmt=con.prepareStatement("select * from quiz");
			result=stmt.executeQuery();
			while(result.next())
			{
					
				    	Quiz quiz=new Quiz();
				    	quiz.setQid(result.getInt(1));
				    	quiz.setMid(result.getString(2));
				    	quiz.setQuestion(result.getString(3));
				    	quiz.setBestChoice(result.getString(4));
				    	list.add(quiz);
				    
					
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
	public int getQidByQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		int qid=-1;
		
		try 
		{
			stmt=con.prepareStatement("select * from quiz");
			result=stmt.executeQuery();
			while(result.next())
			{
				String mid=result.getString(2);
				String question=result.getString(3);
					if(mid.equals(quiz.getMid())&&question.equals(quiz.getQuestion())){
				    	qid=result.getInt(1);
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
		
		return qid;
	}


	@Override
	public void deleteByQid(String qid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from quiz where qid=?");
			stmt.setInt(1,Integer.parseInt(qid));
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
	public void update(Quiz quiz) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update quiz set mid=?,question=?,bestChoice=?" +
						" where qid=? ");
//			System.out.println("update quiz set mid="+quiz.getMid()+",question="+quiz.getQuestion()
//						+",bestChoice="+quiz.getBestChoice()+"," +
//					" where qid="+quiz.getQid());
			stmt.setString(1,quiz.getMid());
			stmt.setString(2, quiz.getQuestion());
			stmt.setString(3,quiz.getBestChoice());
			stmt.setInt(4,quiz.getQid());
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
	public Quiz findByQid(String qid) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		Quiz quiz=null;
		
		try 
		{
			stmt=con.prepareStatement("select * from quiz");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(qid.equals(String.valueOf(result.getInt(1)))){
				    	quiz=new Quiz();
				    	quiz.setQid(result.getInt(1));
				    	quiz.setMid(result.getString(2));
				    	quiz.setQuestion(result.getString(3));
				    	quiz.setBestChoice(result.getString(4));
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
		
		return quiz;
	}


	@Override
	public List findUnResulted() {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		List list=new ArrayList();
		
		try 
		{
			stmt=con.prepareStatement("select * from quiz");
			result=stmt.executeQuery();
			while(result.next())
			{
					if(result.getString(4)==null){
				    	Quiz quiz=new Quiz();
				    	quiz.setQid(result.getInt(1));
				    	quiz.setMid(result.getString(2));
				    	quiz.setQuestion(result.getString(3));
				    	quiz.setBestChoice(result.getString(4));
				    	list.add(quiz);
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
