package net.cineplex.factory;

import net.cineplex.dao.ChoiceDao;
import net.cineplex.dao.DealDao;
import net.cineplex.dao.HallDao;
import net.cineplex.dao.MailDao;
import net.cineplex.dao.ManagerDao;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MemberInfoDao;
import net.cineplex.dao.MembershipDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.dao.MovieHistoryDao;
import net.cineplex.dao.MovieTypeDao;
import net.cineplex.dao.PlanDao;
import net.cineplex.dao.QuizDao;
import net.cineplex.dao.QuizHistoryDao;
import net.cineplex.dao.RechargeDao;
import net.cineplex.dao.SeatDao;
import net.cineplex.dao.impl.ChoiceDaoImpl;
import net.cineplex.dao.impl.DealDaoImpl;
import net.cineplex.dao.impl.HallDaoImpl;
import net.cineplex.dao.impl.MailDaoImpl;
import net.cineplex.dao.impl.ManagerDaoImpl;
import net.cineplex.dao.impl.MemberDaoImpl;
import net.cineplex.dao.impl.MemberInfoDaoImpl;
import net.cineplex.dao.impl.MembershipDaoImpl;
import net.cineplex.dao.impl.MovieDaoImpl;
import net.cineplex.dao.impl.MovieHistoryDaoImpl;
import net.cineplex.dao.impl.MovieTypeDaoImpl;
import net.cineplex.dao.impl.PlanDaoImpl;
import net.cineplex.dao.impl.QuizDaoImpl;
import net.cineplex.dao.impl.QuizHistoryDaoImpl;
import net.cineplex.dao.impl.RechargeDaoImpl;
import net.cineplex.dao.impl.SeatDaoImpl;




public class DaoFactory {
	public static MailDao getMailDao()
	{
		return MailDaoImpl.getInstance();
	}
	
	public static MovieDao getMovieDao()
	{
		return MovieDaoImpl.getInstance();
	}
	public static MovieHistoryDao getMovieHistoryDao()
	{
		return MovieHistoryDaoImpl.getInstance();
	}
	
	public static ChoiceDao getChoiceDao()
	{
		return ChoiceDaoImpl.getInstance();
	}
	public static DealDao getDealDao(){
		return DealDaoImpl.getInstance();
	}
	public static HallDao getHallDao()
	{
		return	HallDaoImpl.getInstance();
	}	
	public static MemberDao getMemberDao()
	{
		return MemberDaoImpl.getInstance();
	}
	public static MemberInfoDao getMemberInfoDao()
	{
		return  MemberInfoDaoImpl.getInstance();
	}
	public static ManagerDao getManagerDao()
	{
		return ManagerDaoImpl.getInstance();
	}
	public static MovieTypeDao getMovieTypeDao()
	{
		return MovieTypeDaoImpl.getInstance();
	}
	public static PlanDao getPlanDao()
	{
		return PlanDaoImpl.getInstance();
	}
	
	public static QuizDao getQuizDao()
	{
		return QuizDaoImpl.getInstance();
	}
	public static QuizHistoryDao getQuizHistoryDao()
	{
		return QuizHistoryDaoImpl.getInstance();
	}
	public static RechargeDao getRechargeDao()
	{
		return RechargeDaoImpl.getInstance();
	}
	
	public static SeatDao getSeatDao()
	{
		return SeatDaoImpl.getInstance();
	}
	
	public static MembershipDao getMembershipDao()
	{
		return MembershipDaoImpl.getInstance();
	}
	
/*	public static TradeDao getTradeDao()
	{
		return TradeDaoImpl.getInstance();
	}*/
}
