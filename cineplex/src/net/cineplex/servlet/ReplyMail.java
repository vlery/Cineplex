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
import net.cineplex.webmodel.MailList;

/**
 * Servlet implementation class ReplyMail
 */
@WebServlet("/replyMail")
public class ReplyMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MailService mailService=new  MailServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(response ,request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(response ,request);
	
	}

	private void process(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String mailId=request.getParameter("mail");
		String success=request.getParameter("success");
		String fail=request.getParameter("fail");
		if(null!=success){
			mailService.sendPassMail(mailId);
		}
		
		if(null!=fail){
			String replyMsg=request.getParameter("replyMsg");
			if(null!=replyMsg){
				replyMsg="нч";
			}
			mailService.sendFailMail(mailId, replyMsg);
		}
		
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("mngID");
		List u_mail=mailService.getReadedList(String.valueOf(id));
	//	response.sendRedirect("getMail");
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/getMail").forward(request, response);
		return;
	}

}
