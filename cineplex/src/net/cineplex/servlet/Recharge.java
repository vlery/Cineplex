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

import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;
import net.cineplex.webmodel.Anchor;
import net.cineplex.webmodel.MemberInfoVO;

/**
 * Servlet implementation class Recharge
 */
@WebServlet("/recharge")
public class Recharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	MemberService memberService=new MemberServiceBean();
    public Recharge() {
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
		Member member=(Member) session.getAttribute("crtUser");
		String id=member.getId();
		String password=request.getParameter("bank_password");
		String recharge_amount=request.getParameter("recharge_amount");
		double amount=Double.valueOf(recharge_amount);
		DecimalFormat   df   =   new   DecimalFormat("#####0.00");    
		recharge_amount=df.format(amount);
		amount=Double.valueOf(recharge_amount);
		if(memberService.anthenticateBank(id, password)){
			memberService.rechargeByBank(id, amount);
			Member db_member=memberService.findByNickname(member.getNickName());
			String feedback="充值成功！";
			if(db_member.getLevel()>member.getLevel()){
				feedback=feedback+"会员升级！";
			}
			session.setAttribute("crtUser", db_member);
			session.setAttribute("recharge_feedback", feedback);
			Member m=(Member) session.getAttribute("crtUser");
			m=memberService.findByNickname(m.getNickName());
			MemberInfoVO memberInfo=(MemberInfoVO) session.getAttribute("memberInfoVO");
			memberInfo.setDeposit(String.valueOf(m.getDeposit()));
		
			session.setAttribute("memberInfoVO", memberInfo);
		}else{
			session.setAttribute("recharge_feedback","银行卡密码错误！");
		}
		
		
		Anchor anchor=new Anchor();
		anchor.setPanel("recharge_panel");
		session.setAttribute("anchor", anchor);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/user/member_info.jsp").forward(request, response);;
		//response.sendRedirect("memberInfo?panel=recharge_panel");
		return;
		
	}
	
	

}
