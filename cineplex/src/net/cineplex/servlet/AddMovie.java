package net.cineplex.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MailService;
import net.cineplex.action.bussiness.MailServiceBean;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.factory.MovieIDFactory;
import net.cineplex.webmodel.MovieModifiableList;
import net.cineplex.webmodel.MovieType;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/addMovie")
public class AddMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieService movieService=new MovieServiceBean();
	MailService mailService=new MailServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovie() {
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
		String add=request.getParameter("add");
		HttpSession session=request.getSession();
		ServletContext context = getServletContext();
		if(null!=add){
			
			String name=request.getParameter("mname");
			String duration=request.getParameter("duration");
			String online=request.getParameter("online");
			String downline=request.getParameter("downline");
			String introduction=request.getParameter("introduction");
			String[] movieType=request.getParameterValues("movietype");
			MovieType type=new MovieType();
			type.setList(new ArrayList());
			if(null!=movieType){
				for(String s:movieType){
					type.add(s);
					System.out.println(s);
				}
		
			}
			String mid=movieService.add(name,duration,online,downline,introduction,type);
			
			
			session.setAttribute("movie_add_feedback", "添加成功！");
			//向经理发送申请
			String id=(String) session.getAttribute("mngID");
			
			mailService.sendMovieCreateMail(id, mid);
			//更新可修改的列表
			List list=movieService.getModifiableList();
			MovieModifiableList mml=new MovieModifiableList();
			mml.setList(list);
			session.setAttribute("movieModList", mml);
			context.getRequestDispatcher("/system/staff/movie_create.jsp").forward(request, response);
			//response.sendRedirect("system/staff/movie_create.jsp");
			
			return;
		}
		
		List list=movieService.getModifiableList();
		MovieModifiableList mml=new MovieModifiableList();
		mml.setList(list);
		session.setAttribute("movieModList", mml);
		context.getRequestDispatcher("/system/staff/movie_create.jsp").forward(request, response);
		//response.sendRedirect("system/staff/movie_create.jsp");
		return;
	}

}
