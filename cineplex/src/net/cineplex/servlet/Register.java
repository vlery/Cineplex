package net.cineplex.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import net.cineplex.model.MemberInfo;
import net.cineplex.webmodel.RegisterInfo;



/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	MemberService memberService=new  MemberServiceBean(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			process(request,response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			process(request,response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		
		
		Member member=(Member) session.getAttribute("member");
		String password=request.getParameter("confirm_password");
		
		String  name=request.getParameter("username");
		//System.out.println(name);
		String gender=request.getParameter("gender");
		String  birthday=request.getParameter("birthday");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String mail=request.getParameter("mail");
		String tel=request.getParameter("tel");
		String bankID=request.getParameter("bankID");
		 //两次密码输入不一致
		
		if(!password.equals(member.getPassword())){
			session.setAttribute("register_alert","密码输入与之前不符!");
			RegisterInfo ri=(RegisterInfo) session.getAttribute("registerInfo");
			ri.setBankID(bankID);
			ri.setCity(city);
			ri.setProvince(province);
			ri.setBirthday(birthday);
			
			ri.setGender(gender);
			System.out.println(gender);
			ri.setMail(mail);
			ri.setName(name);
			ri.setTel(tel);
			session.setAttribute("registerInfo", ri);
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		/*可扩充：银行卡、电话格式不正确等情况
		 *
		 *
		 */
		
		//注册
		member.setPassword(password);
		member.setName(name);
		member.setBankID(bankID);
		MemberInfo memberInfo =new MemberInfo();
			
		
		memberInfo.setBirthday( new DateTool().stringToDate(birthday));
		memberInfo.setTel(tel);
		if(gender.equals("男")){
			memberInfo.setGender(1);
		}else{
			memberInfo.setGender(0);
		}
		
		memberInfo.setMail(mail);
		memberInfo.setProvince(Integer.parseInt(province));
		memberInfo.setCity(Integer.parseInt(city));
		memberService.register(member, memberInfo);
		session.removeAttribute("registerInfo");
		session.setAttribute("crtUser", member);
		response.sendRedirect("system/user/register_success.jsp");
		return;
	}
}
