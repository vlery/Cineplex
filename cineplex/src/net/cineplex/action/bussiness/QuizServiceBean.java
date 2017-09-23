package net.cineplex.action.bussiness;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.ChoiceDao;
import net.cineplex.dao.ManagerDao;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.dao.MovieHistoryDao;
import net.cineplex.dao.PlanDao;
import net.cineplex.dao.QuizDao;
import net.cineplex.dao.QuizHistoryDao;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.model.Choice;
import net.cineplex.model.Member;
import net.cineplex.model.Movie;
import net.cineplex.model.MovieHistory;
import net.cineplex.model.Plan;
import net.cineplex.model.Quiz;
import net.cineplex.model.QuizHistory;
import net.cineplex.webmodel.MovieQuiz;
import net.cineplex.webmodel.QuizVO;
import net.cineplex.webmodel.SelectList;
import net.cineplex.webmodel.UserQuizList;
import net.cineplex.webmodel.UserQuizListByMovie;
import net.cineplex.webmodel.UserQuizVO;

public class QuizServiceBean implements QuizService{
	

	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	QuizDao quizDao=daoFactory.getQuizDao();
	@SuppressWarnings("static-access")
	MemberDao memberDao=daoFactory.getMemberDao();
	@SuppressWarnings("static-access")
	ChoiceDao choiceDao=daoFactory.getChoiceDao();
	@SuppressWarnings("static-access")
	MovieDao movieDao=daoFactory.getMovieDao();	
	@SuppressWarnings("static-access")
	PlanDao planDao=daoFactory.getPlanDao();	
	@SuppressWarnings("static-access")
	QuizHistoryDao quizHistoryDao=daoFactory.getQuizHistoryDao();	
	@SuppressWarnings("static-access")
	MovieHistoryDao movieHistoryDao=daoFactory.getMovieHistoryDao();	
	
	
	@Override
	public void create(Quiz quiz, SelectList sl) {
		// TODO Auto-generated method stub
		quizDao.save(quiz);
		String qid=String.valueOf(quizDao.getQidByQuiz(quiz));
		List list=sl.getList();
		for(int i=0;i<list.size();i++){
			Choice choice=new Choice();
			choice.setAnswer((String)list.get(i));
			choice.setQid(qid);
			choice.setVote(0);
			choiceDao.save(choice);
		}
	}
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
	public List getQuizList() {
		// TODO Auto-generated method stub
		List mlist=getModifiableList();
		List list=new ArrayList();
		for(int i=0;i<mlist.size();i++){
			Movie movie=(Movie) mlist.get(i);
			String mid=String.valueOf(movie.getMid());
			List qlist=quizDao.findByMovie(mid);
			if(qlist.size()>0){
				MovieQuiz mq=new MovieQuiz();
				mq.setMovie(movie.getName());
				mq.setList(qlist);
				list.add(mq);
			}
		}
		//System.out.println(((MovieQuiz)list.get(0)).getQuestionNum());
		return list;
	}
	@Override
	public void delete(String qid) {
		// TODO Auto-generated method stub
		quizDao.deleteByQid(qid);
		choiceDao.deleteByQuestion(qid);
	}
	@Override
	public List getQuizListById(String id) {
		// TODO Auto-generated method stub
		List list= new ArrayList();
		List db_list=quizHistoryDao.findByMember(id);
		for(int i=0;i<db_list.size();i++){
			QuizHistory qh=(QuizHistory) db_list.get(i);
			QuizVO qd=new QuizVO();
		
			Choice c=choiceDao.findByCid(qh.getCid());
			Quiz q=quizDao.findByQid(c.getQid());
//			System.out.println(c.getQid());
//			System.out.println(q);
			Movie m=movieDao.findById(q.getMid());
			qd.setMovie(m.getName());
			qd.setQuestion(q.getQuestion());
			if(null==q.getBestChoice() ){
				qd.setResult("活动未结束");
			}else{
				if(q.getBestChoice().equals(c.getCid())){
					qd.setResult("1分");
				}else{
					qd.setResult("0分");
				}
			}
			list.add(qd);
		}
		
		return list;
	}
	@Override
	public List getAvailableList(String id) {
		// TODO Auto-generated method stub 
		List mhList=movieHistoryDao.findByMember(id);
		List watchedMovieList=getWatchedList(mhList);
		List answeredQuizList=quizHistoryDao.findByMember(id);
		
		
		List list=new ArrayList();
		for(int i=0;i<watchedMovieList.size();i++){
			UserQuizListByMovie uqlm=new UserQuizListByMovie();
			
			String mid=(String) watchedMovieList.get(i);
			Movie movie=movieDao.findById(mid);
			uqlm.setMovie(movie.getName());
			
			List qList=new ArrayList();
			List quizList=quizDao.findByMovie(mid);
			for(int j=0;j<quizList.size();j++){
				Quiz quiz=(Quiz) quizList.get(j);
				List clist=choiceDao.findByQuestion(String.valueOf(quiz.getQid()));
				if(!ifAnswered(clist, answeredQuizList)){
					UserQuizVO qv=new UserQuizVO();
					qv.setQuiz(quiz);
					qv.setChoiceList(clist);
					//System.out.println(clist.size());
					qList.add(qv);
				}
			}
			if(qList.size()>0){
				uqlm.setList(qList);
				
				list.add(uqlm);
			
			}
		}

			
		return list ;
	}
	
	public List getWatchedList(List list){
		List watched=new ArrayList();
		
		for(int i=0;i<list.size();i++){
			MovieHistory mh=(MovieHistory) list.get(i);
			String pid=mh.getPid();
			Plan plan=planDao.findByPid(pid);
			boolean ifExist=false;
			for(int j=0;j<watched.size();j++){
				if(((String)watched.get(j)).equals(plan.getMid())){
					ifExist=true;
				}
			}
			
			if(!ifExist){
				watched.add(plan.getMid());
			}
		}
		return  watched;
	}
	public boolean ifAnswered(List clist,List answer){
		boolean ifAnswer=false;
		for(int i=0;i<clist.size();i++){
			Choice choice=(Choice) clist.get(i);
			String cid=String.valueOf(choice.getCid());
			for(int j=0;j<answer.size();j++){
				QuizHistory qh=(QuizHistory) answer.get(j);
				if(qh.getCid().equals(cid)){
					ifAnswer=true;
					break;
				}
			}
			if(ifAnswer){
				break;
			}
			
		}
		return ifAnswer;
	}
	@Override
	
	public void choose(String id, String cid) {
		// TODO Auto-generated method stub
		List list=quizHistoryDao.findByMember(id);
		
		Choice choice=choiceDao.findByCid(cid);
		String qid=choice.getQid();
		List clist=choiceDao.findByQuestion(qid);
		
		boolean ifChoose=false;
		for(int i=0;i<list.size();i++){
			QuizHistory qh=(QuizHistory) list.get(i);
			for(int j=0;j<clist.size();j++){
				Choice c=(Choice) clist.get(j);
				if(String.valueOf(c.getCid()).equals(qh.getCid())){
					if(!qh.getCid().equals(cid)){
						QuizHistory rs_qh=quizHistoryDao.findByIdAndCid(id,qh.getCid());
						rs_qh.setCid(cid);
						quizHistoryDao.update(rs_qh);
						
						Choice rs_c1=choiceDao.findByCid(qh.getCid());
						rs_c1.setVote(rs_c1.getVote()-1);
						choiceDao.update(rs_c1);
						
						Choice rs_c2=choiceDao.findByCid(cid);
						rs_c2.setVote(rs_c2.getVote()+1);
						choiceDao.update(rs_c2);
					}
					ifChoose=true;
					break;
				}
			}
		}
		//System.out.println(ifChoose);
		if(!ifChoose){
			QuizHistory quizHistory=new QuizHistory();
			quizHistory.setCid(cid);
			quizHistory.setId(id);
			quizHistoryDao.save(quizHistory);
			Choice c=choiceDao.findByCid(cid);
			c.setVote(c.getVote()+1);
			choiceDao.update(c);
		}
		
	}
	@Override
	public double getScore(String mid) {
		// TODO Auto-generated method stub
		List list=quizDao.findByMovie(mid);
		Quiz quiz=null;
		for(int i=0;i<list.size();i++){
			quiz=(Quiz) list.get(i);
			if(quiz.getQuestion().equals("您对该电影的评价为几分？")){
				break;
			}
		}
		String qid=String.valueOf(quiz.getQid());
		List clist=choiceDao.findByQuestion(qid);
		double score_total=0;
		int vote=0;
		for(int j=0;j<clist.size();j++){
				Choice c=(Choice) clist.get(j);
				String cid=String.valueOf(c.getCid()) ;
				List qhlist=quizHistoryDao.findByChoice(cid);
				int score=0;
				switch(c.getAnswer()){
				case "1分":score=1;break;
				case "2分":score=2;break;
				case "3分":score=3;break;
				case "4分":score=4;break;
				case "5分":score=5;break;
				default:;
				}
				score_total=score_total+score*qhlist.size();
				vote=vote+qhlist.size();
		}
		if(vote>0){
			return score_total/vote;
		}else{
			return 0;
		}
	}
	@Override
	public void checkResult() {
		// TODO Auto-generated method stub
		List qlist=quizDao.findUnResulted();
		for(int i=0;i<qlist.size();i++){
			Quiz quiz=(Quiz) qlist.get(i);
			String mid=quiz.getMid();
			Movie movie=movieDao.findById(mid);
			Date today=new DateTool().getNowDate();
			//处理问题
			//System.out.println(movie);
			if(today.after(movie.getDownline())){
				String cid=getBestChoice(quiz.getQid());
				if(null!=cid){
					List qhList=quizHistoryDao.findByChoice(cid);
					for(int j=0;j<qhList.size();j++){
						QuizHistory qh=(QuizHistory) qhList.get(j);
						Member member=memberDao.findById(qh.getId());
						member.setIntegral(member.getIntegral()+2);
						memberDao.updateById(member);
					}
					quiz.setBestChoice(cid);
				}else{
					quiz.setBestChoice("0");
					//System.out.println(quiz.getQid());
				}
				quizDao.update(quiz);
			}
		}
		
	}
	private String getBestChoice(int qid) {
		// TODO Auto-generated method stub
		//System.out.println(qid);
		List list=choiceDao.findByQuestion(String.valueOf(qid));
		double total=0;
		double[] vote=new double[list.size()];
		for(int i=0;i<list.size();i++){
			Choice c=(Choice) list.get(i);
			vote[i]=c.getVote();
			total+=c.getVote();
		}
		for(int n=0;n<list.size();n++){
			
			if(vote[n]*100/total>=75){
				Choice choice=(Choice) list.get(n);
				//System.out.println("best:"+choice.getCid());
				return String.valueOf(choice.getCid());
			}
		}
		//System.out.println("best:null");
		return null;
	}
	@Override
	public void addScoreQuiz(String mid) {
		// TODO Auto-generated method stub
		
		Quiz quiz=new Quiz();
		quiz.setMid(mid);
		quiz.setQuestion("您对该电影的评价为几分？");
		quizDao.save(quiz);
		List list=quizDao.findByMovie(mid);
		quiz=null;
		for(int i=0;i<list.size();i++){
			quiz=(Quiz) list.get(i);
			if(quiz.getQuestion().equals("您对该电影的评价为几分？")){
				break;
			}
		}
		String qid=String.valueOf(quiz.getQid());
		for(int i=1;i<6;i++){
			Choice choice=new Choice();
			choice.setAnswer(String.valueOf(i)+"分");
			choice.setVote(0);
			choice.setQid(qid);
			choiceDao.save(choice);
		}
	}

}
