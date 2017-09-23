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
import net.cineplex.webmodel.Anchor;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	MemberService memberService=new  MemberServiceBean(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String new_password=request.getParameter("confirm_new_password");
		String old_password=request.getParameter("old_password");
//		System.out.println(new_password+"!!!new");
//		System.out.println(old_password+"!!!old");
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("crtUser");
		
		if(memberService.changePassword(member.getId(),old_password, new_password)){
			session.setAttribute("changePassword_feedback","ÐÞ¸Ä³É¹¦£¡");
		}else{
			session.setAttribute("changePassword_feedback","¾ÉÃÜÂë´íÎó£¡");
		}
		ServletContext context = getServletContext();
		
		Anchor anchor=new Anchor();
		anchor.setPanel("password_panel");
		session.setAttribute("anchor", anchor);
		//response.sendRedirect("/system/user/info.js");
		context.getRequestDispatcher("/system/user/info.jsp").forward(request, response);;
		return;
		
		
	}
	
	

}
