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
import net.cineplex.webmodel.MemberInfoVO;

/**
 * Servlet implementation class TransferIntegral
 */
@WebServlet("/transferIntegral")
public class TransferIntegral extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 MemberService memberService=new MemberServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferIntegral() {
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
		
		HttpSession session=request.getSession();
		Member member =(Member) session.getAttribute("crtUser");
		String id=member.getId();
		memberService.integralToDeposit(id);
		session.setAttribute("transfer_feedback", "×ª»»³É¹¦£¡");
	    member=memberService.scanMemberInfo(id);
	    session.setAttribute("crtUser", member);
		
		MemberInfoVO memberInfo=(MemberInfoVO) session.getAttribute("memberInfoVO");
		memberInfo.setDeposit(String.valueOf(member.getDeposit()));
		memberInfo.setScore(String.valueOf(member.getIntegral()));
		session.setAttribute("memberInfoVO", memberInfo);
	    
	    Anchor anchor=new Anchor();
		anchor.setPanel("transfer_panel");
		session.setAttribute("anchor", anchor);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/user/member_info.jsp").forward(request, response);;
	    
		
	    //response.sendRedirect("memberInfo?panel=transfer_panel");
		return;
	}

}
