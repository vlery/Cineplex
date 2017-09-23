package net.cineplex.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.DateTool;
import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.model.Member;


import net.cineplex.webmodel.Anchor;
import net.cineplex.webmodel.MemberInfoVO;

/**
 * Servlet implementation class MemberInfo
 */
@WebServlet("/memberInfo")
public class MemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MemberService memberService=new MemberServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInfo() {
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
		MemberInfoVO memberInfoVO=new MemberInfoVO();
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("crtUser");
		member=memberService.findByNickname(member.getNickName());
		net.cineplex.model.MemberInfo memberInfo=memberService.scanInfo(member.getId());
		memberInfoVO.setRegisterTime(String.valueOf(memberInfo.getRegisterTime()));
		
		if(member.getForceful()==0){
			memberInfoVO.setDueTime("∑«ª·‘±");
		}else{
			memberInfoVO.setDueTime(new DateTool().getDueTime(member.getStartTime()));
		}
		memberInfoVO.setLevel(String.valueOf(member.getLevel()));
		DecimalFormat   df   =   new   DecimalFormat("#####0.00");    
		memberInfoVO.setDeposit(df.format(member.getDeposit()));
		memberInfoVO.setScore(String.valueOf(member.getIntegral()));
		session.setAttribute("memberInfoVO", memberInfoVO);
		String panel=request.getParameter("panel");
		Anchor anchor=new Anchor();
		anchor.setPanel(panel);
		session.setAttribute("anchor", anchor);
		String url="/system/user/member_info.jsp";
		//String url="/system/user/member_info.jsp?"+panel;
		
		ServletContext context = getServletContext();
		context.getRequestDispatcher(url).forward(request, response);
		
		//response.sendRedirect(url);
		return;
	}

}
