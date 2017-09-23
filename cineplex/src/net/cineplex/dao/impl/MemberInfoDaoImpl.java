package net.cineplex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DaoHelper;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MemberInfoDao;
import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;

public class MemberInfoDaoImpl implements MemberInfoDao{

	private static MemberInfoDaoImpl memberInfoDao=new MemberInfoDaoImpl();
	private static DaoHelper daoHelper=DaoHelperImpl.getBaseDaoInstance();
	public static MemberInfoDaoImpl getInstance(){
		return memberInfoDao;
	}
	@Override
	public MemberInfo findById(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		ResultSet result=null;
		MemberInfo memberInfo=null;
		try 
		{
			stmt=con.prepareStatement("select * from memberinfo");
			result=stmt.executeQuery();
			while(result.next())
			{
				String db_id=result.getString(1);
				if(db_id.equals(id)){
					memberInfo=new MemberInfo();
					memberInfo.setId(db_id);
					memberInfo.setBirthday(result.getDate(2));
					memberInfo.setTel(result.getString(3));
					memberInfo.setGender(result.getInt(4));
					memberInfo.setMail(result.getString(5));
					memberInfo.setRegisterTime(result.getDate(6));
					memberInfo.setProvince(result.getInt(7));
					memberInfo.setCity(result.getInt(8));
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
		
		return memberInfo;
		
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
			stmt=con.prepareStatement("select * from memberinfo");
			result=stmt.executeQuery();
			while(result.next())
			{
				MemberInfo memberInfo=new MemberInfo();
				memberInfo.setId(result.getString(1));
				memberInfo.setBirthday(result.getDate(2));
				memberInfo.setTel(result.getString(3));
				memberInfo.setGender(result.getInt(4));
				memberInfo.setMail(result.getString(5));
				memberInfo.setRegisterTime(result.getDate(6));
				memberInfo.setProvince(result.getInt(7));
				memberInfo.setCity(result.getInt(8));
				list.add(memberInfo);				
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
	public void save(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{	
			stmt=con.prepareStatement("insert into memberinfo(id,birthday,tel,gender,mail,"
							+ "registerTime,province,city) "
							+ "values(?,?,?,?,?,?,?,?)");
			stmt.setString(1,memberInfo.getId());
			stmt.setDate(2,memberInfo.getBirthday());
			stmt.setString(3,memberInfo.getTel());
			stmt.setInt(4,memberInfo.getGender());
			stmt.setString(5,memberInfo.getMail());
			stmt.setDate(6,memberInfo.getRegisterTime());
			stmt.setInt(7,memberInfo.getProvince());
			stmt.setInt(8,memberInfo.getCity());			
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
	public void updateById(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("update memberinfo set birthday=?,tel=?,gender=?,mail=?,"
										+ "registerTime=?,province=?,city=? where id=?");
			
			stmt.setDate(1,memberInfo.getBirthday());
			stmt.setString(2,memberInfo.getTel());
			stmt.setInt(3,memberInfo.getGender());
			stmt.setString(4,memberInfo.getMail());
			stmt.setDate(5,memberInfo.getRegisterTime());
			stmt.setInt(6,memberInfo.getProvince());
			stmt.setInt(7,memberInfo.getCity());	
			stmt.setString(8,memberInfo.getId());
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
	public void removeById(String id) {
		// TODO Auto-generated method stub
		Connection con=daoHelper.getConnection();
		PreparedStatement stmt=null;
		try 
		{
			stmt=con.prepareStatement("delete from memberinfo where id=?");
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
}
