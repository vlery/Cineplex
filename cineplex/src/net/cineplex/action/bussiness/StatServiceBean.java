package net.cineplex.action.bussiness;

import java.awt.peer.ChoicePeer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import net.cineplex.dao.ChoiceDao;
import net.cineplex.dao.DealDao;
import net.cineplex.dao.HallDao;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MemberInfoDao;
import net.cineplex.dao.MembershipDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.dao.MovieHistoryDao;
import net.cineplex.dao.MovieTypeDao;
import net.cineplex.dao.PlanDao;
import net.cineplex.dao.QuizDao;
import net.cineplex.dao.QuizHistoryDao;
import net.cineplex.dao.SeatDao;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.model.Choice;
import net.cineplex.model.Deal;
import net.cineplex.model.Hall;
import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;
import net.cineplex.model.Membership;
import net.cineplex.model.Movie;
import net.cineplex.model.MovieHistory;
import net.cineplex.model.Plan;
import net.cineplex.model.Quiz;
import net.cineplex.webmodel.stat.AddressVO;
import net.cineplex.webmodel.stat.AgeVO;
import net.cineplex.webmodel.stat.CityVO;
import net.cineplex.webmodel.stat.ConsumeVO;
import net.cineplex.webmodel.stat.DayVO;
import net.cineplex.webmodel.stat.FavorList;
import net.cineplex.webmodel.stat.FavorTypeVO;
import net.cineplex.webmodel.stat.FavorVO;
import net.cineplex.webmodel.stat.GenderVO;
import net.cineplex.webmodel.stat.HallUpperByDayVO;
import net.cineplex.webmodel.stat.MemberInfoVO;
import net.cineplex.webmodel.stat.MembershipVO;
import net.cineplex.webmodel.stat.MonthVO;
import net.cineplex.webmodel.stat.MovieUpperByDayVO;
import net.cineplex.webmodel.stat.MovieVO;
import net.cineplex.webmodel.stat.MovieWatchVO;
import net.cineplex.webmodel.stat.QuizVO;

public class StatServiceBean implements StatService{
	static IDFactory memberIDFactory=new MemberIDFactory();
	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	MemberDao memberDao=daoFactory.getMemberDao();
	@SuppressWarnings("static-access")
	MemberInfoDao memberInfoDao=daoFactory.getMemberInfoDao();
	@SuppressWarnings("static-access")
	DealDao dealDao=daoFactory.getDealDao();
	@SuppressWarnings("static-access")
	MembershipDao membershipDao=daoFactory.getMembershipDao();
	@SuppressWarnings("static-access")
	QuizHistoryDao quizHistoryDao=daoFactory.getQuizHistoryDao();
	@SuppressWarnings("static-access")
	MovieDao movieDao=daoFactory.getMovieDao();
	@SuppressWarnings("static-access")
	ChoiceDao choiceDao=daoFactory.getChoiceDao();
	@SuppressWarnings("static-access")
	QuizDao quizDao=daoFactory.getQuizDao();
	@SuppressWarnings("static-access")
	PlanDao planDao=daoFactory.getPlanDao();
	@SuppressWarnings("static-access")
	HallDao hallDao=daoFactory.getHallDao();
	@SuppressWarnings("static-access")
	MovieTypeDao movieTypeDao=daoFactory.getMovieTypeDao();
	@SuppressWarnings("static-access")
	SeatDao seatDao=daoFactory.getSeatDao();
	@SuppressWarnings("static-access")
	MovieHistoryDao movieHistoryDao=daoFactory.getMovieHistoryDao();	
	@Override
	public MemberInfoVO getMemberInfoStat() {
		// TODO Auto-generated method stub
		List memberList=memberDao.find();
		int member=0;
		int registor=0;
		for(int i=0;i<memberList.size();i++){
			Member m=(Member) memberList.get(i);
			registor++;
			if(m.getForceful()==1){
				member++;
			}
		}
		
	
	
		MemberInfoVO miv=new MemberInfoVO();
		miv.setMember(String.valueOf(member));
		miv.setRegistor(String.valueOf(registor));
		
		return miv;
	}

	@Override
	public AgeVO getAgeStat() {
		// TODO Auto-generated method stub
		double tenToTwenty=0,twentyToThirty=0,thirtyToForty=0,fortyToFifty=0,
				fiftyToSixty=0,sixtyToSeventy=0;
		double member=0;
		List infoList=memberInfoDao.find();
		
		for(int i=0;i<infoList.size();i++){
			MemberInfo m=(MemberInfo) infoList.get(i);
			String id=m.getId();
			Member mem=memberDao.findById(id);
			if(mem.getForceful()==1){
				    member++;
					Date birth=m.getBirthday();
					Date today=new DateTool().getNowDate();
					int age=today.getYear()-birth.getYear()+1;
					System.out.println("age!!!"+age);
					if(age>70){
						
					}else if(age>60){
						sixtyToSeventy++;
					}else if(age>50){
						fiftyToSixty++;
					}else if(age>40){
						fortyToFifty++;
					}else if(age>30){
						thirtyToForty++;
					}else if(age>20){
						twentyToThirty++;
					}else if(age>10){
						tenToTwenty++;
					}else{
						
					}
			}
		}
		double tenplus=tenToTwenty/member*100;
		double twentyplus=twentyToThirty/member*100;
		double thirtyplus=thirtyToForty/member*100;
		double fortyplus=fortyToFifty/member*100;
		double fiftyplus=fiftyToSixty/member*100;
		double sixtyplus=sixtyToSeventy/member*100;
		double other=1*100-tenplus-twentyplus-thirtyplus-fortyplus-fiftyplus-sixtyplus;
		
		
		//DecimalFormat df = new DecimalFormat("#.00");
        AgeVO ageVO=new AgeVO();
		ageVO.setFiftyToSixty(String.valueOf(fiftyplus));
		ageVO.setFortyToFifty(String.valueOf(fortyplus));
		ageVO.setOther(String.valueOf(other));
		ageVO.setSixtyToSeventy(String.valueOf(sixtyplus));
		ageVO.setTenToTwenty(String.valueOf(tenplus));
		ageVO.setThirtyToForty(String.valueOf( thirtyplus));
		ageVO.setTwentyToThirty(String.valueOf(twentyplus));
		return ageVO;
	}

	@Override
	public GenderVO getGenderStat() {
		// TODO Auto-generated method stub
		int female=0;
		int male=0;
		List infoList=memberInfoDao.find();
		
		for(int i=0;i<infoList.size();i++){
			MemberInfo m=(MemberInfo) infoList.get(i);
			if(m.getGender()==1){
				male++;
			}else{
				female++;
			}
		}
		GenderVO gv=new GenderVO();
		gv.setFemale(String.valueOf(female));
		gv.setMale(String.valueOf(male));
		gv.setTotal(String.valueOf(female+male));
		return gv;
	}

	@Override
	public AddressVO getAddressStat() {
		// TODO Auto-generated method stub
		List list=memberInfoDao.find();
		double total=list.size();
	
		int[] count=new int[35];
		
		for(int i=0;i<count.length;i++){
			count[i]=0;
		}
		
		for(int j=0;j<list.size();j++){
			MemberInfo m=(MemberInfo) list.get(j);
			count[m.getProvince()]++;
		}
		List cityList=new ArrayList();
		
		
		for(int n=0;n<8;n++){
			int i=1;
			for(int j=1;j<35;j++){
				if(count[j]>count[i]){
					i=j;
				}
			}
			if(count[i]!=0){
			
				CityVO cv=new CityVO();
				double c=count[i];
				cv.setPercent(String.valueOf(c*100/total));
			
				cv.setCity(new AddressTool().getProvinceName(i));
				cityList.add(cv);
				count[i]=0;
			}
		}
		
		
		double other=100;
		for(int m=0;m<cityList.size();m++){
			CityVO cv=(CityVO) cityList.get(m);
			other=other-Double.parseDouble(cv.getPercent());
		}
		
		AddressVO addressVO=new AddressVO();
		addressVO.setOtherPercent(String.valueOf(other));
		System.out.println(String.valueOf(other));
		addressVO.setList(cityList);
		
		return addressVO;
	}

	@Override
	public ConsumeVO getConsumeStat() {
		// TODO Auto-generated method stub
		List clist=dealDao.findByType(1);
		List onlist=dealDao.findByType(0);
		ConsumeVO cv=new ConsumeVO();
		double cash=0;
		double online=0;
		for(int i=0;i<clist.size();i++){
			Deal deal=(Deal) clist.get(i);
			Date d=deal.getTime();
			Date today=new DateTool().getNowDate();
			if(d.getYear()==today.getYear()&&
				d.getMonth()==today.getMonth()){
				cash=cash+deal.getAmount();
			}
		}
		for(int j=0;j<onlist.size();j++){
			Deal deal=(Deal) onlist.get(j);
			Date d=deal.getTime();
			Date today=new DateTool().getNowDate();
			if(d.getYear()==today.getYear()&&
					d.getMonth()==today.getMonth()){
					online=online+deal.getAmount();
			}
		}
		DecimalFormat    df   = new DecimalFormat("######0.00");   

		cv.setTotal(df.format(cash+online));
		
		if(cash+online==0){
			cv.setOnline("0");
			cv.setCash("0");
		}else{
			cv.setCash(String.valueOf(cash));
			cv.setOnline(String.valueOf(online));
		}
		
		return cv;
	}

	@Override
	public MembershipVO getMembershipStat() {
		// TODO Auto-generated method stub
		List newList=membershipDao.findByType(0);
		List pauseList=membershipDao.findByType(1);
		List stopList=membershipDao.findByType(2);
		
		int n=0,p=0,s=0;
		for(int i=0;i<newList.size();i++){
			Membership m= (Membership) newList.get(i);
			Date d=m.getTime();
			Date today=new DateTool().getNowDate();
			if(d.getYear()==today.getYear()&&
				d.getMonth()==today.getMonth()){
				n++;
			}
		}
		for(int i=0;i<pauseList.size();i++){
			Membership m= (Membership) pauseList.get(i);
			Date d=m.getTime();
			Date today=new DateTool().getNowDate();
			if(d.getYear()==today.getYear()&&
				d.getMonth()==today.getMonth()){
				p++;
			}
		}
		for(int i=0;i<stopList.size();i++){
			Membership m= (Membership) stopList.get(i);
			Date d=m.getTime();
			Date today=new DateTool().getNowDate();
			if(d.getYear()==today.getYear()&&
				d.getMonth()==today.getMonth()){
				s++;
			}
		}
		MembershipVO mv=new MembershipVO();
		mv.setCancel(String.valueOf(s));
		mv.setPause(String.valueOf(p));
		mv.setStart(String.valueOf(n));
		
		return mv;
	}

	@Override
	public QuizVO getQuizStat() {
		// TODO Auto-generated method stub
		ArrayList<String> mid=getThisMonthMovie();
		int[] choice=new int[mid.size()];
		for(int i=0;i<choice.length;i++){
			choice[i]=0;
		}
		for(int j=0;j<mid.size();j++){
			List qlist=quizDao.findByMovie(mid.get(j));
			for(int n=0;n<qlist.size();n++){
				Quiz quiz=(Quiz) qlist.get(n);
				int qid=quiz.getQid();
				List clist=choiceDao.findByQuestion(String.valueOf(qid));
				for(int m=0;m<clist.size();m++){
					Choice c=(Choice) clist.get(m);
					List qhList=quizHistoryDao.findByChoice(String.valueOf(c.getCid()));
					choice[j]=choice[j]+qhList.size();
				}
			}
		}
		
		String[] movieName=new String[mid.size()];
		for(int i=0;i<mid.size();i++){
			movieName[i]=movieDao.findById(mid.get(i)).getName();
		}
		
		QuizVO qv=new QuizVO();
		qv.setChoice(choice);
		qv.setMovie(movieName);
		
		return qv;
	}

	@Override
	public FavorVO getFavorStat() {
		// TODO Auto-generated method stub
		ArrayList<String> mid=getThisMonthMovie();
		String mlist="";
		QuizService quizService=new QuizServiceBean();
		String slist="";
		String plist="";
		for(int j=0;j<mid.size();j++){
			Movie m=movieDao.findById(mid.get(j));
			mlist=mlist+"'"+m.getName()+"',";
			double score=quizService.getScore(m.getMid());
			if(score==0){
				slist=slist+"null,";
			}else{
				slist=slist+String.valueOf(quizService.getScore(m.getMid()))+",";
			}
			List planList=planDao.findByMovie(mid.get(j));
			int people=0;
			for(int n=0;n<planList.size();n++){
				Plan p=(Plan) planList.get(n);
				if(new DateTool().ifThisMonth(p.getDay(),p.getDay())){
					List mhList=movieHistoryDao.findByPlan(String.valueOf(p.getPid()));
					people=people+mhList.size();
				}
			}
			plist=plist+String.valueOf(people)+",";
		}
		mlist=mlist.substring(0,mlist.length()-1);
		slist=slist.substring(0,slist.length()-1);
		plist=plist.substring(0,plist.length()-1);
		FavorVO fv=new FavorVO();
		fv.setMovieList(mlist);
		fv.setScoreList(slist);
		fv.setPeopleList(plist);
		return fv;
	}
	
	ArrayList<String>  getThisMonthMovie(){
		List movieList=movieDao.find();
		ArrayList<String> mid=new ArrayList<String>();

		for(int i=0;i<movieList.size();i++){
			Movie m=(Movie) movieList.get(i);
			Date startTime=m.getOnline();
			Date endTime=m.getDownline();
			DateTool dateTool=new DateTool();
			if(dateTool.ifThisMonth(startTime,endTime)){
				mid.add(m.getMid());
			
			}
				
		}
		return mid;
	}

	@Override
	public DayVO getDayStat() {
		// TODO Auto-generated method stub
		String day="";
		String totalUpper="";
		String people="";
		
		Date today=new DateTool().getNowDate();
		int today_day=today.getDate();
	
		for(int i=1;i<today_day;i++){
			day=day+"'"+String.valueOf(i)+"',";
			Date d=new Date(today.getYear(),today.getMonth(),i);
			List mhList=movieHistoryDao.findByDay(d);
			double people_upper=mhList.size();
			List pList=planDao.findByDay(d);
			double total_people=0;
			for(int j=0;j<pList.size();j++){
				Plan p=(Plan) pList.get(j);
				String hid=p.getHid();
				total_people=seatDao.findByHall(hid).size()+total_people;
			}
			if(total_people!=0){
				totalUpper=totalUpper+String.valueOf(people_upper/total_people)+",";
			}else{
				totalUpper=totalUpper+"null,";
			}
			people=people+String.valueOf(people_upper)+",";
			
		}
		
		
		List hlist=hallDao.find();
		List hallList=new ArrayList();
		//ArrayList<String> hall_name=new ArrayList<String>();
		for(int i=0;i<hlist.size();i++){
			Hall hall=(Hall) hlist.get(i);
			HallUpperByDayVO huv=new HallUpperByDayVO();
			huv.setHallName("'"+hall.getName()+"'");
			String hid=String.valueOf(hall.getHid());
			int seatSize=seatDao.findByHall(hid).size();
			String hallUpper="";
			double total=0;
			double upper=0;
			//System.out.println(today);
			for(int d=1;d<today_day;d++){
				
				Date dayCount=new Date(today.getYear(),today.getMonth(),d);
				//System.out.println(dayCount);
				List plist=planDao.findByDayAndHall(dayCount,hid);
			//	System.out.println(dayCount+": "+hid+"!!!"+plist.size());
				total=plist.size()*seatSize;
				for(int planCount=0;planCount<plist.size();planCount++){
					Plan planItem=(Plan) plist.get(planCount);
					String pid=String.valueOf(planItem.getPid()) ;
					int upper_day=movieHistoryDao.findByPidAndDay(pid,dayCount).size();
					upper=upper+upper_day;
				}
				if(total==0){
					//System.out.println("a");
					hallUpper=hallUpper+"null,";
				}else{
					//System.out.println("b");
					hallUpper=hallUpper+String.valueOf(upper/total)+",";
				}
			}
			//System.out.println(hallUpper);
			
			if(hallUpper.length()>0){
				hallUpper=hallUpper.substring(0,hallUpper.length()-1);
			}
			huv.setHallUpper(hallUpper);
			hallList.add(huv);
		}
		
		List movieList=new ArrayList();
		ArrayList<String> movie=getThisMonthMovie();
		for(int i=0;i<movie.size();i++){
			MovieUpperByDayVO muv=new  MovieUpperByDayVO();
			Movie m=movieDao.findById(movie.get(i));
			muv.setMovieName("'"+m.getName()+"'");
			String mid=m.getMid();
			String movieUpper="";
			
			for(int d=1;d<today_day;d++){
			
				Date dayCount=new Date(today.getYear(),today.getMonth(),d);
				
				
				double total=0;
				double upper=0;
				List plist=planDao.fingByDayAndMovie(dayCount, mid);
				if(plist.size()==0){
					movieUpper=movieUpper+"null,";
				}else{
					for(int planCount=0;planCount<plist.size();planCount++){
						Plan planItem=(Plan) plist.get(planCount);
						String pid=String.valueOf(planItem.getPid()) ;
						int upper_day=movieHistoryDao.findByPidAndDay(pid,dayCount).size();
						upper=upper+upper_day;
						int seatSize=seatDao.findByHall(planItem.getHid()).size();
						
						total=seatSize+total;
					}
					movieUpper=movieUpper+String.valueOf(upper/total)+",";
					
				}
				
			}
			if(movieUpper.length()>0){
				movieUpper=movieUpper.substring(0,movieUpper.length()-1);
			}
			muv.setMovieUpper(movieUpper);
			movieList.add(muv);
			
		}
		
		
		
		
		if(day.length()>0){
			day.substring(0,day.length()-1);
		}
		if(people.length()>0){
			people=people.substring(0,people.length()-1);
		}
		if(totalUpper.length()>0){
			totalUpper=totalUpper.substring(0,totalUpper.length()-1);
		}
		DayVO dv=new DayVO();
		dv.setDay(day);
		dv.setPeople(people);
		dv.setTotalUpper(totalUpper);
		dv.setHallList(hallList);
		dv.setMovieList(movieList);
		
		
		return dv;
		
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
		planDao.findByDayAndHall(new Date(115,2,1), "15");
	}

	@Override
	public MonthVO getMonthStat() {
		// TODO Auto-generated method stub
		ArrayList<String> movieList=getThisMonthMovie();
		List movieWatchList=new ArrayList();
		int total_watch=0;
		int member_watch=0;
		DateTool dateTool=new DateTool();
		for(int i=0;i<movieList.size();i++){
			Movie movie=movieDao.findById(movieList.get(i));
			MovieWatchVO mwv=new MovieWatchVO();
			mwv.setMovie("'"+movie.getName()+"'");
			int watch=0;
			List plist=planDao.findByMovie(movie.getMid());
			for(int p=0;p<plist.size();p++){
				Plan planItem=(Plan) plist.get(p);
				if(dateTool.ifThisMonth(planItem.getDay(), planItem.getDay())){
					List mhList=movieHistoryDao.findByPlan(String.valueOf(planItem.getPid()));
					for(int j=0;j<mhList.size();j++){
						MovieHistory mh=(MovieHistory) mhList.get(j);
						watch++;
						total_watch++;
						if(!mh.getId().equals("0000000")){
							member_watch++;
						}
					}
				}
			}
			mwv.setCount(String.valueOf(watch));
			movieWatchList.add(mwv);
		}
		
		List dealList=dealDao.findByType(0);
		int online_ticket=0;
		int cash_ticket=0;
		for(int i=0;i<dealList.size();i++){
			Deal d=(Deal) dealList.get(i);
			if(new DateTool().ifThisMonth(d.getTime(), d.getTime())){
				if(d.getType()==0){
					online_ticket++;
				}else{
					cash_ticket++;
				}
			}
		}
		
		String hallName="";
		String hallUpper="";
		
		List hlist=hallDao.find();
		List planList=planDao.find();
		for(int i=0;i<hlist.size();i++){
			Hall hall=(Hall) hlist.get(i);
			String hid=String.valueOf(hall.getHid());
			hallName=hallName+"'"+hall.getName()+"',";
			double total=0;
			double upper=0;
			int hallSize=seatDao.findByHall(hid).size();
			for(int j=0;j<planList.size();j++){
				Plan  p=(Plan) planList.get(j);
				if(new DateTool().ifThisMonth(p.getDay(), p.getDay())
						&&p.getHid().equals(hid)){
					 total=total+hallSize;
					 String pid=String.valueOf(p.getPid());
					 upper=upper+movieHistoryDao.findByPlan(pid).size();
				}
			}
			if(total==0){
				hallUpper=hallUpper+"null,";
			}else{
			
				hallUpper=hallUpper+String.valueOf(upper/total*100)+",";
		
			}
		}
		String movieName="";
		String movieUpper="";
		for(int i=0;i<movieList.size();i++){
			Movie movie=movieDao.findById(movieList.get(i));
			movieName=movieName+"'"+movie.getName()+"',";
			String mid=movie.getMid();
			double total=0;
			double upper=0;
		
			for(int j=0;j<planList.size();j++){
				Plan  p=(Plan) planList.get(j);
				if(new DateTool().ifThisMonth(p.getDay(), p.getDay())
						&&p.getMid().equals(mid)){
					int hallSize=seatDao.findByHall(p.getHid()).size();
					total=total+hallSize;
					 String pid=String.valueOf(p.getPid());
					 upper=upper+movieHistoryDao.findByPlan(pid).size();
				}
			}
			if(total==0){
				movieUpper=movieUpper+"null,";
			}else{
			
				movieUpper=movieUpper+String.valueOf(upper/total*100)+",";
		
			}
		}
		
		hallName=hallName.substring(0,hallName.length()-1);
		hallUpper=hallUpper.substring(0,hallUpper.length()-1);
		movieName=movieName.substring(0,movieName.length()-1);
		movieUpper=movieUpper.substring(0,movieUpper.length()-1);
		
		MonthVO mv=new MonthVO();
		mv.setTotalMemberWatch(String.valueOf(member_watch));
		mv.setTotalPeopleWatch(String.valueOf(total_watch));
		mv.setMovieWatchList(movieWatchList);
		mv.setTotalTicket(String.valueOf(online_ticket+cash_ticket));
		mv.setOnlineTicket(String.valueOf(online_ticket));
		mv.setCashTicket(String.valueOf(cash_ticket));
		mv.setHallName(hallName);
		mv.setHallUpper(hallUpper);
		mv.setMovieName(movieName);
		mv.setMovieUpper(movieUpper);
		return mv;
		
		
		
		
		
	}

	@Override
	public void removeUserStat(String id) {
		// TODO Auto-generated method stub
		quizHistoryDao.deleteByMember(id);
		movieHistoryDao.deleteByMember(id);
	}

	@Override
	public FavorTypeVO getFavorTypeStat() {
		// TODO Auto-generated method stub
		ArrayList<String> mlist=getThisMonthMovie();
		int total=0;
		int[] count=new int[25];
		//System.out.println(1);
		for(int i=0;i<count.length;i++){
			count[i]=0;
		}
		for(int i=0;i<mlist.size();i++){
			String mid=mlist.get(i);
			List typeList=movieTypeDao.findByMid(mid);
			for(int j=0;j<typeList.size();j++){
				net.cineplex.model.MovieType mt=(net.cineplex.model.MovieType) typeList.get(j);
				count[mt.getType()]++;
				total++;
			}
		}
		//System.out.println(2);
		String[] type=new String[8];
		int[] stat=new int[8];
		for(int i=0;i<7;i++){
			int temp=0;
			for(int j=0;j<25;j++){
				if(count[j]>count[temp]){
					temp=j;
				}
			}
			
			type[i]= "'"+new MovieType().getTypeName(temp)+"'";
			stat[i]=count[temp];
			total=total-count[temp];
			count[temp]=-i;
		}
		//System.out.println(3);
		type[7]="'ÆäËû'";
		stat[7]=total;
		FavorTypeVO ftv=new FavorTypeVO();
		ftv.setCount(stat);
		ftv.setType(type);
		return ftv;
	}

	
}
