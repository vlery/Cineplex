package net.cineplex.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.model.Movie;
import net.cineplex.webmodel.MovieType;
import net.cineplex.webmodel.MovieVO;

/**
 * Servlet implementation class ModifyMovie
 */
@WebServlet("/modifyMovie")
public class ModifyMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MovieService movieService=new MovieServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyMovie() {
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
		
		String mid=request.getParameter("movieID");
		String modify=request.getParameter("modify");
		String back=request.getParameter("back");
		HttpSession session=request.getSession();
		ServletContext context = getServletContext();
		//staff修改电影,之后返回列表界面
		if(null!=modify){
				String id= (String) session.getAttribute("movieID");
				String name=request.getParameter("md_mname");
				String duration=request.getParameter("md_duration");
				String online=request.getParameter("md_online");
				String downline=request.getParameter("md_downline");
				String introduction=request.getParameter("md_introduction");
				String[] movieType=request.getParameterValues("movietype");
				MovieType type=new MovieType();
				type.setList(new ArrayList());
				for(String s:movieType){
					type.add(s);
				}
			
				movieService.modify(id,name,duration,online,downline,introduction,type);
				session.setAttribute("movie_modify_feedback", "修改成功！");
				context.getRequestDispatcher("/system/staff/movie_list.jsp").forward(request, response);
			//	response.sendRedirect("system/staff/movie_list.jsp");
				return;
		}
		//返回列表界面
		if(null!=back){
			context.getRequestDispatcher("/system/staff/movie_list.jsp").forward(request, response);
		//	response.sendRedirect("system/staff/movie_list.jsp");
			return;
		}
		//

		MovieVO movie=movieService.getMovie(mid);
		session.setAttribute("movieID", mid);
		session.setAttribute("movie", movie);
		//System.out.println("!!!!");
		//System.out.println(movie.getType().getList().size());
		//ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/staff/movie_modify.jsp").forward(request, response);
		//response.sendRedirect("system/staff/movie_modify.jsp");
		return;
		
	}
}
