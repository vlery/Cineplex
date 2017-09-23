package net.cineplex.action.bussiness;

import java.util.ArrayList;
import java.util.List;

import net.cineplex.dao.MailDao;
import net.cineplex.dao.MemberDao;
import net.cineplex.dao.MovieDao;
import net.cineplex.factory.DaoFactory;
import net.cineplex.factory.IDFactory;
import net.cineplex.factory.MemberIDFactory;
import net.cineplex.model.Mail;
import net.cineplex.model.Movie;

public class MailServiceBean implements MailService{

	static IDFactory memberIDFactory=new MemberIDFactory();
	DaoFactory daoFactory=new DaoFactory();
	@SuppressWarnings("static-access")
	MailDao mailDao=daoFactory.getMailDao();
	@SuppressWarnings("static-access")
	MovieDao movieDao=daoFactory.getMovieDao();
	
	@Override
	public void sendMovieCreateMail(String sender, String mid) {
		// TODO Auto-generated method stub
		//type:0
		Mail mail=new Mail();
		Movie  movie=movieDao.findById(mid);		
		mail.setContent("<table class=\"am-table am-table-striped am-table-hover\">"
				+ "<tbody>"
				+ "  <tr><td>影片名&nbsp;&nbsp;&nbsp;</td><td>"
				+ movie.getName()
				+ "</td></tr>"
				+ "<tr><td>日期</td><td>"
				+ String.valueOf(movie.getOnline())+"至 "+ String.valueOf(movie.getDownline())
				+ "</td></tr>"
				+ "<tr><td>时间</td><td>"
				+ String.valueOf(movie.getDuration())
				+ "分钟</td></tr>"
				+ "</tbody></table>"
				+ "<h4>简介：</h4><label>"
				+ movie.getIntroduction()
				+ "</label>"
				);
		mail.setIfRead(0);
		mail.setReceive("1");
		mail.setSend(sender);
		mail.setType(0);
		mail.setMid(mid);
		mailDao.save(mail);
	}

	@Override
	public void sendPassMail(String mailId) {
		// TODO Auto-generated method stub
		//type:1
		int mailID=Integer.parseInt(mailId);
		Mail mail=mailDao.findByMailId(mailID);
		Mail newMail=new Mail();
		newMail.setMid(mail.getMid());
		newMail.setIfRead(0);
		newMail.setReceive(mail.getSend());
		newMail.setSend(mail.getReceive());
		newMail.setType(1);
		Movie movie=movieDao.findById(mail.getMid());
		
		movie.setIfCheck(1);
		movieDao.update(movie);
		newMail.setContent("  <label class=\"am-text-sm\">"
							+"电影 《"
							+ movie.getName()
							+ "》批准上映！可以添加放映计划！</label>");
		
		mailDao.save(newMail);
		mail.setType(3);
		mailDao.update(mail);
		
	}

	@Override
	public void sendFailMail(String mailId, String content) {
		// TODO Auto-generated method stub
		//type:2
		int mailID=Integer.parseInt(mailId);
		Mail mail=mailDao.findByMailId(mailID);
		Mail newMail=new Mail();
		newMail.setMid(mail.getMid());
		newMail.setIfRead(0);
		newMail.setReceive(mail.getSend());
		newMail.setSend(mail.getReceive());
		newMail.setType(2);
		Movie movie=movieDao.findById(mail.getMid());
		newMail.setContent("<label class=\"am-text-sm\">电影 《"
						+ "鸟人"
						+ "》申请放映失败！<br/>"
						+ "修改意见："
						+ content
						+ "   </label>");
		
		mailDao.save(newMail);
		mail.setType(3);
		mailDao.update(mail);
	}

	@Override
	public List getReadedList(String id) {
		// TODO Auto-generated method stub
		List db_list=mailDao.findByReceiveId(id);
		List list=new ArrayList();
		for(int i=0;i<db_list.size();i++){
			Mail m = (Mail) db_list.get(i);
			if(m.getIfRead()==1){
				list.add(m);
			}
		}
		
		return list;
	}

	@Override
	public List getUnReadList(String id) {
		// TODO Auto-generated method stub
		List db_list=mailDao.findByReceiveId(id);
		List list=new ArrayList();
		for(int i=0;i<db_list.size();i++){
			Mail m = (Mail) db_list.get(i);
			if(m.getIfRead()==0){
				list.add(m);
			}
		}
		
		return list;
	}

	@Override
	public void setReaded(String id) {
		// TODO Auto-generated method stub
		List db_list=mailDao.findByReceiveId(id);
		
		for(int i=0;i<db_list.size();i++){
			Mail m = (Mail) db_list.get(i);
			if(m.getIfRead()==0){
				m.setIfRead(1);
				mailDao.update(m);
			}
		}
		
	
	}


}
