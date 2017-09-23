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

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import net.cineplex.action.bussiness.MemberService;
import net.cineplex.action.bussiness.MemberServiceBean;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.action.bussiness.QuizService;
import net.cineplex.action.bussiness.QuizServiceBean;
import net.cineplex.model.Member;
import net.cineplex.model.MovieHistory;
import net.cineplex.webmodel.Anchor;
import net.cineplex.webmodel.MovieHistoryList;
import net.cineplex.webmodel.QuizHistoryList;
import net.cineplex.webmodel.RegisterInfo;

/**
 * Servlet implementation class Info
 */
@WebServlet("/info")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuizService quizService=new QuizServiceBean();
	MovieService movieService=new MovieServiceBean();
	MemberService memberService=new MemberServiceBean();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
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
		//参与活动
		List qList=quizService.getQuizListById(member.getId());
		QuizHistoryList  qhl= new QuizHistoryList();
		qhl.setList(qList);
		session.setAttribute("quizHistoryList", qhl);
		
		//观影历史
		List mhList=movieService.getMovieHistoryById(member.getId());
	//	System.out.println(mhList.size());
		MovieHistoryList mhl=new MovieHistoryList(); 
		mhl.setList(mhList);
		session.setAttribute("movieHistoryList", mhl);
		
		
        RegisterInfo   crtUserInfo=memberService.findRevisableInfo(member.getId());
        
       // System.out.println(crtUserInfo.getBankID());
        session.setAttribute("crtUserInfo",crtUserInfo );
		
		
		String panel=request.getParameter("panel");
		Anchor anchor=new Anchor();
		anchor.setPanel(panel);
		session.setAttribute("anchor", anchor);
		String url="/system/user/info.jsp";
//		String url="system/user/info.jsp";
		ServletContext context = getServletContext();
		context.getRequestDispatcher(url).forward(request, response);
		
	//	response.sendRedirect(url);
		return;
	}
	
}
