package net.cineplex.servlet;


import java.io.IOException;

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
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.model.Member;
import net.cineplex.model.MemberInfo;
import net.cineplex.webmodel.MovieDisplayVOList;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/main")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MovieService movieService=new MovieServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
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

	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MovieDisplayVOList list=new MovieDisplayVOList();
    	list.setList(movieService.getDisplayList());
    	
		 HttpSession session=request.getSession();
		 session.setAttribute("movieList", list);
		
		ServletContext context = getServletContext();
		if(null==request.getSession()){
			//context.getRequestDispatcher("/system/main_unlog.jsp").forward(request, response);
			
			context.getRequestDispatcher("/system/main_unlog.jsp").forward(request, response);
			 
			//response.sendRedirect("system/main_unlog.jsp");
			return;
		}
	
		if(null==session.getAttribute("crtUser")){
			//context.getRequestDispatcher("/system/main_unlog.jsp").forward(request, response);
			context.getRequestDispatcher("/system/main_unlog.jsp").forward(request, response);
			//response.sendRedirect("system/main_unlog.jsp");
			
			return;
		}else{
			context.getRequestDispatcher("/system/main.jsp").forward(request, response);
			//response.sendRedirect("system/main.jsp");
			return;
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		process(request,response);
	}
	

}
