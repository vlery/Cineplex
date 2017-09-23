package net.cineplex.action.bussiness;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.DealDao;
import net.cineplex.dao.HallDao;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.dao.MovieHistoryDao;
import net.cineplex.dao.MovieTypeDao;
import net.cineplex.dao.PlanDao;
import net.cineplex.exception.IDGenerateException;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.factory.MovieIDFactory;
import net.cineplex.model.Deal;
import net.cineplex.model.Member;
import net.cineplex.model.Movie;
import net.cineplex.model.MovieHistory;
import net.cineplex.model.MovieType;
import net.cineplex.model.Plan;
import net.cineplex.webmodel.MovieDisplayVO;
import net.cineplex.webmodel.MovieHistoryVO;
import net.cineplex.webmodel.MoviePlanByDay;
import net.cineplex.webmodel.MoviePlanVO;
import net.cineplex.webmodel.MovieVO;
import net.cineplex.webmodel.PlanListVO;
import net.cineplex.webmodel.PlanVO;

public class MovieServiceBean implements MovieService{
	QuizService quizService=new QuizServiceBean();
	static MovieIDFactory movieFactory=new MovieIDFactory();
	
	static IDFactory memberIDFactory=new MemberIDFactory();
	DaoFactory daoFactory=new DaoFactory();
	
	@SuppressWarnings("static-access")
	MovieDao movieDao=daoFactory.getMovieDao();
	@SuppressWarnings("static-access")
	MemberDao memberDao=daoFactory.getMemberDao();
	
	@SuppressWarnings("static-access")
	MovieTypeDao movieTypeDao=daoFactory.getMovieTypeDao();
	@SuppressWarnings("static-access")
	PlanDao planDao=daoFactory.getPlanDao();
	
	@SuppressWarnings("static-access")
	DealDao dealDao=daoFactory.getDealDao();
	@SuppressWarnings("static-access")
	HallDao hallDao=daoFactory.getHallDao();
	@SuppressWarnings("static-access")
	MovieHistoryDao movieHistoryDao=daoFactory.getMovieHistoryDao();
	
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movie.setMid(movieFactory.generate());
		movieDao.save(movie);
	}

	@Override
	public Movie scanInfo(String mid) {
		// TODO Auto-generated method stub
		return movieDao.findById(mid);
	}

	@Override
	public List getDisplayList() {
		// TODO Auto-generated method stub
		List displayList= movieDao.findOnline();
		ArrayList list=new ArrayList();
		for(int i=0;i<displayList.size();i++){
			Movie movie=(Movie) displayList.get(i);
			MovieDisplayVO mdv=new MovieDisplayVO();
			mdv.setMid(movie.getMid());
			mdv.setName(movie.getName());
			/*
			*
			*从参与的活动表获得数据
			*/
			double score=quizService.getScore(movie.getMid());
			if(score>0){
				mdv.setScore(String.valueOf(score));
			}else{
				mdv.setScore("暂无");
			}
			//System.out.println(String.valueOf(quizService.getScore(movie.getMid())));
			mdv.setSimpleInfo(movie.getIntroduction().substring(0,120)+"...");
			list.add(mdv);
		}
		return list;
	}

	@Override
	public void buyTicket(String id, int type, double amount,String mid) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		if(type==0){
		amount=new MemberLevel().doDiscount(amount,member.getLevel());
		}
			Deal deal=new Deal();
			deal.setId(id);
			deal.setType(type);
			deal.setAmount(amount);
			deal.setMid(mid);
			deal.setTime(new DateTool().getNowDate());
			dealDao.save(deal);
			if(type==0){
			//扣除余额
			member.setDeposit(member.getDeposit()-amount);
			//增加积分
			member.setIntegral(member.getIntegral()+(int)Math.floor(amount/10));
			memberDao.updateById(member);
			}
	}

	@Override
	public void watchMovie(String id, String sid, String pid) {
		// TODO Auto-generated method stub
		MovieHistory mh=new MovieHistory();
		Plan plan=planDao.findByPid(pid);
		mh.setDay(plan.getDay());
		mh.setId(id);
		mh.setPid(pid);
		mh.setSid(sid);
		movieHistoryDao.save(mh);
	}

	@Override
	public void selectSeat(String pid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MovieVO getMovieByMid(String mid) {
		// TODO Auto-generated method stub
		
		Movie movie=movieDao.findById(mid);
		MovieVO movieVO=new MovieVO();
		movieVO.setMid(mid);
		movieVO.setName(movie.getName());
		movieVO.setOnline(new DateTool().dateToShortString(movie.getOnline()));
		movieVO.setDownline(new DateTool().dateToShortString(movie.getDownline()));
		movieVO.setDuration(String.valueOf(movie.getDuration()));
		movieVO.setIntroduction(movie.getIntroduction());
		return movieVO;
	}

	@Override
	public List getTypeListByMid(String mid) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		List list_temp=movieTypeDao.findByMid(mid);
		
		for(int i=0;i<list_temp.size();i++){
			MovieType mt=(MovieType) list_temp.get(i);
			list.add(mt.getType());
			//System.out.println(mt.getType());
		}
		
		return list;
	}

	@Override
	public List getModifiableList() {
		// TODO Auto-generated method stub
		List db_list= movieDao.find();
		ArrayList list=new ArrayList();
		for(int i=0;i<db_list.size();i++){
			Movie movie=(Movie) db_list.get(i);
			if(!new DateTool().ifDownLine(movie.getDownline())){
				list.add(movie);
			}
		}
		return list;
	}

	@Override
	public MovieVO getMovie(String mid) {
		// TODO Auto-generated method stub
		MovieVO movieVO=new MovieVO();
		Movie movie=movieDao.findById(mid);
		movieVO.setMid(mid);
		movieVO.setName(movie.getName());
		movieVO.setOnline(String.valueOf(movie.getOnline()));
		movieVO.setDownline(String.valueOf(movie.getDownline()));
		movieVO.setIntroduction(movie.getIntroduction());
		movieVO.setDuration(String.valueOf(movie.getDuration()));
		net.cineplex.webmodel.MovieType mt=new net.cineplex.webmodel.MovieType();
		mt.setList(new ArrayList());
		List list= movieTypeDao.findByMid(mid);
		for(int i=0;i<list.size();i++){
			MovieType m=(MovieType) list.get(i);
			mt.add(String.valueOf(m.getType()));
		}
		movieVO.setType(mt);
	//	System.out.println(movieVO.getType().getList().size());
		return movieVO;
		
	}

	@Override
	public void modify(String mid, String name, String duration, String online,
			String downline, String introduction, net.cineplex.webmodel.MovieType type) {
		// TODO Auto-generated method stub
		
		Movie movie=movieDao.findById(mid);
		movie.setName(name);
		movie.setDuration(Integer.parseInt(duration));
		movie.setOnline(new DateTool().stringToDate(online));
		movie.setDownline(new DateTool().stringToDate(downline));
		movie.setIntroduction(introduction);
		
		movieTypeDao.deleteByMid(mid);

		List typeList=type.getList();
		for(int i=0;i<typeList.size();i++){
			String index=(String) typeList.get(i);
			MovieType mt=new MovieType();
			mt.setMid(mid);
			mt.setType(Integer.parseInt(index));
			movieTypeDao.save(mt);
		}
		
		movieDao.update(movie);
	}

	@Override
	public String add(String name, String duration, String online,
			String downline, String introduction,  net.cineplex.webmodel.MovieType type) {
		// TODO Auto-generated method stub
		Movie movie=new Movie();
		String mid=new MovieIDFactory().generate();
		movie.setMid(mid);
		movie.setDuration(Integer.valueOf(duration));
		movie.setOnline(new DateTool().stringToDate(online));
		movie.setDownline(new DateTool().stringToDate(downline));
		movie.setIntroduction(introduction);
		movie.setIfCheck(0);
		movie.setName(name);
		
		List typeList=type.getList();
		for(int i=0;i<typeList.size();i++){
			String index=(String) typeList.get(i);
			MovieType mt=new MovieType();
			mt.setMid(mid);
			mt.setType(Integer.parseInt(index));
			movieTypeDao.save(mt);
		}
		movieDao.save(movie);
		
		quizService.addScoreQuiz(mid);
		return mid;
	}

	@Override
	public void createPlan(String mid, String hid, String day, String time,
			String price) {
		// TODO Auto-generated method stub
		Plan plan=new Plan();
		plan.setHid(hid);
		plan.setMid(mid);
		plan.setPrice(Integer.valueOf(price));
		plan.setDay(new DateTool().stringToDate(day));
		plan.setTime(new DateTool().stringToTime(time));
		planDao.save(plan);
	}

	@Override
	public List getPlanList() {
		// TODO Auto-generated method stub
		List list=planDao.find();
		
		List moviePlanList=new ArrayList();
		
		List mvList=getModifiableList();
		for(int i=0;i<mvList.size();i++){
				Movie m=(Movie)mvList.get(i);
				String mid=m.getMid();
				String name=m.getName();
				MoviePlanVO mpv=new MoviePlanVO();
				mpv.setMid(mid);
				mpv.setName(name);
				List plist=new ArrayList();
				mpv.setList(plist);
				for(int j=0;j<list.size();j++){
					Plan p=(Plan) list.get(j);
					if(p.getMid().equals(mid)){
						PlanVO pv=new PlanVO();
						pv.setPid(String.valueOf(p.getPid()));
						pv.setMovie(name);
						pv.setHall(hallDao.findById(p.getHid()).getName());
						pv.setPrice(String.valueOf(p.getPrice()));
						
						pv.setDay(new DateTool().dateToShortString(p.getDay()));
						pv.setTime(String.valueOf(p.getTime().getHours())+":"+String.valueOf(p.getTime().getMinutes()));
						mpv.add(pv);
					}
				}
				if(mpv.getListSize()>0){
					moviePlanList.add(mpv);
				}
				
			}
		return moviePlanList;
		
		

	}

	@Override
	public Plan getPlan(String pid) {
		// TODO Auto-generated method stub
		Plan p=planDao.findByPid(pid);
		return p;
	}

	@Override
	public void updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		planDao.updateById(plan);
	}

	@Override
	public void deletePlan(int pid) {
		// TODO Auto-generated method stub
		planDao.deleteById(pid);
	}

	@Override
	public List getPlanListByMovie(MovieVO movie) {
		// TODO Auto-generated method stub
		List plist=planDao.findByMovie(movie.getMid());
		Date today=new DateTool().getNowDate();
		List plist_tmp=new ArrayList();
		for(int i=0;i<plist.size();i++){
			Plan plan=(Plan) plist.get(i);
	
			if(!plan.getDay().before(today)){
				plist_tmp.add(plan);
				
			}
		}
		plist=plist_tmp;
		List list=new ArrayList();
		List tp_list=plist;
		int count=0;
		while(count<plist.size()){
			Date date=((Plan)tp_list.get(0)).getDay();
//			System.out.println(date);
			List pvList=new ArrayList();
			for(int i=0;i<plist.size();i++){
				Plan p=(Plan)plist.get(i);
				Date date_p=p.getDay();
//				System.out.println(date_p);
//				System.out.println(date.equals(date_p));
				if(date.equals(date_p)){
					PlanVO pv=new PlanVO();
					pv.setPid(String.valueOf(p.getPid()));
					pv.setMovie(movie.getName());
					pv.setHall(hallDao.findById(p.getHid()).getName());
					pv.setPrice(String.valueOf(p.getPrice()));
					pv.setDay(new DateTool().dateToShortString(p.getDay()));
					pv.setTime(String.valueOf(p.getTime().getHours())+":"+String.valueOf(p.getTime().getMinutes()));
					
					pvList.add(pv);
				}
			}
			MoviePlanByDay mpbd=new MoviePlanByDay();
			mpbd.setDay(String.valueOf(date));
			mpbd.setList(pvList);
			mpbd.sortByTime();
			//System.out.println(pvList.size() );
			list.add(mpbd);
			List ttp_list=new ArrayList();
			for(int j=0;j<tp_list.size();j++){
				Plan p=(Plan)tp_list.get(j);
				Date date1=p.getDay();
				if(date1.equals(date)){
					count++;
				}else{
					ttp_list.add(p);
				}
			}
			tp_list=ttp_list;
		}
		
		
		return list;
	}

	@Override
	public List getMovieHistoryByPid(String pid) {
		// TODO Auto-generated method stub
		return movieHistoryDao.findByPlan(pid);
	}

	@Override
	public boolean testDeposit(String id, double amount) {
		// TODO Auto-generated method stub
		Member member=memberDao.findById(id);
		if(member.getDeposit()<amount){
			return false;
		}else{
			return true;
	
		}
	}

	@Override
	public List getMovieHistoryById(String id) {
		// TODO Auto-generated method stub
		List list=movieHistoryDao.findByMember(id);
		List voList=new ArrayList();
		for(int i=0;i<list.size();i++){
			MovieHistory movieHistory=(MovieHistory) list.get(i);
			MovieHistoryVO vo=new MovieHistoryVO();
			vo.setDay(String.valueOf(movieHistory.getDay()));
			String pid=movieHistory.getPid();
			Plan plan=getPlan(pid);
			vo.setMovie(scanInfo(plan.getMid()).getName());
			voList.add(vo);
		}
		return voList;
	}
	
		
}
