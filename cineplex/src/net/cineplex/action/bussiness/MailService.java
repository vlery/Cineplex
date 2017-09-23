package net.cineplex.action.bussiness;

import java.util.List;

import net.cineplex.model.Mail;

public interface MailService {
	public void sendMovieCreateMail(String sender,String mid);
	public void sendPassMail(String mailId);
	public void sendFailMail(String mailId,String content);
	public List getReadedList(String id);
	public List getUnReadList(String id);
	public void setReaded(String id);
	
}
