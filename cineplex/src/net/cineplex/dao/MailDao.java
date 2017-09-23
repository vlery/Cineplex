package net.cineplex.dao;

import java.util.List;

import net.cineplex.model.Mail;

public interface MailDao {
		
	void save(Mail mail);
	List findByReceiveId(String id);
	void update(Mail mail);
	Mail findByMailId(int mailId);
	
}
