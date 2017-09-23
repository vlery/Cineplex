package net.cineplex.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MailService;
import net.cineplex.action.bussiness.MailServiceBean;
import net.cineplex.action.bussiness.ManagerService;
import net.cineplex.action.bussiness.ManagerServiceBean;
import net.cineplex.model.Mail;
import net.cineplex.webmodel.MailList;

/**
 * Servlet implementation class GetMail
 */
@WebServlet("/getMail")
public class GetMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MailService mailService=new MailServiceBean();
	ManagerService managerService=new ManagerServiceBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request,response);
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mngID");
		List u_mail=mailService.getUnReadList(String.valueOf(id));
		List r_mail=mailService.getReadedList(String.valueOf(id));
		MailList unread=new MailList();
		unread.setList(u_mail);
	
		for(int i=0;i<u_mail.size();i++){
			Mail m=(Mail) u_mail.get(i);
			System.out.println(m.getMailId()+":"+m.getType());
		}
		MailList readed=new MailList();
		readed.setList(r_mail);
		session.setAttribute("unreadList", unread);
		session.setAttribute("readedList", readed);
		ServletContext context = getServletContext();
		if(managerService.ifStaff(Integer.parseInt(id))){
		
			context.getRequestDispatcher("/system/staff/mail.jsp").forward(request, response);
		//	response.sendRedirect("system/staff/mail.jsp");
			
			return;
		}else{
			context.getRequestDispatcher("/system/manager/mail.jsp").forward(request, response);
			//response.sendRedirect("system/manager/mail.jsp");
			return;
		}
	}

}
