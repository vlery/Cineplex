package net.cineplex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MailService;
import net.cineplex.action.bussiness.MailServiceBean;
import net.cineplex.action.bussiness.ManagerService;
import net.cineplex.action.bussiness.ManagerServiceBean;
import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.action.bussiness.QuizService;
import net.cineplex.action.bussiness.QuizServiceBean;
import net.cineplex.model.Member;
import net.cineplex.webmodel.MailVO;
import net.cineplex.webmodel.MovieModifiableList;
import net.cineplex.webmodel.RegisterInfo;
import net.cineplex.webmodel.UserVO;

/**
 * Servlet implementation class Enter
 */
@WebServlet("/enter")
public class Enter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberService memberService=new  MemberServiceBean(); 
	ManagerService managerService=new  ManagerServiceBean(); 
	MovieService movieService=new  MovieServiceBean(); 
	MailService mailService=new MailServiceBean();
	//QuizService quizService=new QuizServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enter() {
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
		request.setCharacterEncoding("utf-8");
		String  login=request.getParameter("login");
		String  register=request.getParameter("register");
		String  admin_login=request.getParameter("admin_login");	
		String  nickname=request.getParameter("nickname");
		String 	password=request.getParameter("password");
		String  remember_me=request.getParameter("remember_me");
		
		ServletContext context = getServletContext();
		String []sp=request.getHeader("Referer").split("cineplex/");
		String from=sp[sp.length-1];
		
		if(null!=login){
			HttpSession session=request.getSession();
			boolean  ifUserExist=memberService.checkNickName(nickname);
			if(!ifUserExist){
				session.setAttribute("enter_alert", "该用户名不存在");
				context.getRequestDispatcher("/"+from).forward(request, response);
				//response.sendRedirect(request.getHeader("Referer"));
				return;
			}
			
			boolean ifPswRight=memberService.anthenticate(nickname, password);
			if(!ifPswRight){
				session.setAttribute("enter_alert", "密码错误");
				context.getRequestDispatcher("/"+from).forward(request, response);
				//response.sendRedirect(request.getHeader("Referer"));			
				return;
			}
			
			Member member=memberService.findByNickname(nickname);
			session.setAttribute("crtUser",member);
			
				if(null!=remember_me){
//					Cookie cookie=null;
//					Cookie[] cookies=request.getCookies();
//					boolean cookieFound=false;
//					
//					if(null!=cookies){
//						for(int i=0; i<cookies.length;i++){
//							cookie=cookies[i];
//							if(cookie.getName().equals("cineplexNickname")){
//								cookieFound=true;
//								break;
//							}
//						}
//					}
//					if(cookieFound){
//						if(!nickname.equals(cookie.getValue())){
//							cookie.setValue(nickname);
//							response.addCookie(cookie);
//						}
//					}else{
//						cookie=new Cookie("cineplexNickname",nickname);
//						response.addCookie(cookie);
//					}
				}
			
				//context.getRequestDispatcher("/"+from.replace("_unlog", "")).forward(request, response);
			
				//System.out.println("from:"+from);
				
					response.sendRedirect("main");
			return;
		}
		
		
		
		if(null!=register){
			HttpSession session=request.getSession();
			boolean  ifUserExist=memberService.checkNickName(nickname);
			if(ifUserExist){
				session.setAttribute("enter_alert", "该用户名已存在");
				response.sendRedirect(request.getHeader("Referer"));	
				return;
			}
			 session.setAttribute("member", memberService.create(nickname, password));
			 RegisterInfo info=new RegisterInfo();
			 info.setName("");
			 info.setBankID("");
			 info.setBirthday("");
			 info.setGender("");
			 info.setMail("");
			 info.setTel("");
			 info.setCity("0");
			 info.setProvince("0");
			 session.setAttribute("registerInfo",info);
			response.sendRedirect("system/user/fullfill_info.jsp");	
			return;
		}
		
		
		
		if(null!=admin_login){
			HttpSession session=request.getSession();
			if(managerService.ifExist(nickname)){
				if(managerService.anthenticate(nickname, password)){
					int id=managerService.getIdByName(nickname);
					session.setAttribute("mngID", String.valueOf(id));
					List u_mail=mailService.getUnReadList(String.valueOf(id));
					
				
					MailVO mv=new MailVO();
					mv.setNumber(String.valueOf(u_mail.size()));
					session.setAttribute("mailVO",mv );
				
					if(managerService.ifStaff(id)){
						response.sendRedirect("addMovie");
						return;
					}else{
						response.sendRedirect("memberInfoStat");
						return;
					}
					
					
				}else{
					session.setAttribute("enter_alert", "密码错误");
					response.sendRedirect(request.getHeader("Referer"));
					return;
				}
			}else{
				session.setAttribute("enter_alert", "该用户名不存在");
				response.sendRedirect(request.getHeader("Referer"));
				return;
			}
			
			
//			PrintWriter  out = response.getWriter();
//			out.println("admin");
		}
		
	}
	
	
	
	
}
