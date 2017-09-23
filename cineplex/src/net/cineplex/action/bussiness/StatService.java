package net.cineplex.action.bussiness;

import net.cineplex.webmodel.stat.AddressVO;
import net.cineplex.webmodel.stat.AgeVO;
import net.cineplex.webmodel.stat.ConsumeVO;
import net.cineplex.webmodel.stat.DayVO;
import net.cineplex.webmodel.stat.FavorList;
import net.cineplex.webmodel.stat.FavorTypeVO;
import net.cineplex.webmodel.stat.FavorVO;
import net.cineplex.webmodel.stat.GenderVO;
import net.cineplex.webmodel.stat.MemberInfoVO;
import net.cineplex.webmodel.stat.MembershipVO;
import net.cineplex.webmodel.stat.MonthVO;
import net.cineplex.webmodel.stat.QuizVO;

public interface StatService {
	public MemberInfoVO getMemberInfoStat();
	public AgeVO getAgeStat();
	public GenderVO getGenderStat();
	public AddressVO getAddressStat();
	public ConsumeVO getConsumeStat();
	public MembershipVO getMembershipStat();
	public QuizVO getQuizStat();
	public FavorVO getFavorStat();
	public DayVO getDayStat();
	public MonthVO getMonthStat();
	public void test();
	public void removeUserStat(String id);
	public FavorTypeVO getFavorTypeStat();
}
