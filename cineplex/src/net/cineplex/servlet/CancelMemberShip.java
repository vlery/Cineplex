package net.cineplex.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.model.Member;

/**
 * Servlet implementation class CancelMemberShip
 */
@WebServlet("/cancelMemberShip")
public class CancelMemberShip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberService memberService=new MemberServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelMemberShip() {
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
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Member member =(Member) session.getAttribute("crtUser");
		String psw=request.getParameter("password");
		if(psw.equals(member.getPassword())){
			String id=member.getId();
			memberService.cancel(id);
			
			ServletContext context = getServletContext();
			context.getRequestDispatcher("/exit").forward(
						request, response);
			return;
		}else{
			session.setAttribute("cancel_feedback", "√‹¬Î¥ÌŒÛ£°");
			response.sendRedirect("memberInfo?panel=cancel_panel");
			return;
		}
		
		
	}

}
