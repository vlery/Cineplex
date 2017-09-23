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
 * Servlet implementation class ChangeOtherInfo
 */
@WebServlet("/changeOtherInfo")
public class ChangeOtherInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService=new  MemberServiceBean(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeOtherInfo() {
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
		String nickname=request.getParameter("nickname");

		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String mail=request.getParameter("mail");
		String tel=request.getParameter("tel");
		String bankID=request.getParameter("bankID");
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("crtUser");
		String crtNickname=member.getNickName();
		if(memberService.changeOtherInfo(member.getId(),crtNickname,nickname,gender,birthday,mail,tel,bankID)){
			session.setAttribute("changeInfo_feedback","修改成功！");
		}else{			
			session.setAttribute("changeInfo_feedback","该昵称已被占用！");
		}
		Anchor anchor=new Anchor();
		anchor.setPanel("info_panel");
		session.setAttribute("anchor", anchor);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/user/info.jsp").forward(request, response);;
		
	//	response.sendRedirect("system/user/info.jsp"+"#info_panel");
		return;
	}
	

}
