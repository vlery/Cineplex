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

import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.webmodel.MovieTypeVO;
import net.cineplex.webmodel.MovieVO;
import net.cineplex.webmodel.PlanListVO;

/**
 * Servlet implementation class ShowMovie
 */
@WebServlet("/showMovie")
public class ShowMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MovieService movieService=new MovieServiceBean();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMovie() {
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
		String mid=request.getParameter("movie");
		MovieVO movie=movieService.getMovieByMid(mid);
		MovieTypeVO movieType=new MovieTypeVO();
		
		List list=movieService.getTypeListByMid(mid);
	    
		
		movieType.setList(list);
		session.setAttribute("movieType", movieType);
		session.setAttribute("movie",movie);
		
		PlanListVO plv=new PlanListVO();
		List planList=movieService.getPlanListByMovie(movie);
	
		plv.setList(planList);
		plv.sortByDay();
		session.setAttribute("planList", plv);
		ServletContext context = getServletContext();
		
		if(null==session.getAttribute("crtUser")){
			context.getRequestDispatcher("/system/movie_unlog.jsp").forward(request, response);
		
		}else{
			context.getRequestDispatcher("/system/movie.jsp").forward(request, response);
			
		}
	}
}
