package net.cineplex.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MailService;
import net.cineplex.action.bussiness.MailServiceBean;

/**
 * Servlet implementation class Exit
 */
@WebServlet("/exit")
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MailService mailService =new MailServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exit() {
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
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		if(null!=session.getAttribute("crtUser")){
			session.removeAttribute("crtUser");
		}else{
			String mngID=(String) session.getAttribute("mngID");
			if(null!=mngID)
				mailService.setReaded(mngID);
			session.removeAttribute("mngID");
			
		}
		ServletContext context = getServletContext();
		try {
			
//			context.getRequestDispatcher("/main").forward(
//					request, response);
			response.sendRedirect("main");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
