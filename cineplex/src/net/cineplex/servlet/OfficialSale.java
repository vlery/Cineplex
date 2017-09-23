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
import net.cineplex.webmodel.MovieVO;
import net.cineplex.webmodel.PlanListVO;

/**
 * Servlet implementation class OfficialSale
 */
@WebServlet("/officialSale")
public class OfficialSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       MovieService movieService=new MovieServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfficialSale() {
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
		String mid=request.getParameter("movie");
		String pid=request.getParameter("plan");
		HttpSession session=request.getSession();
		ServletContext context = getServletContext();
		//返回计划列表
		if(null!=mid){
			MovieVO movie=movieService.getMovieByMid(mid);
			PlanListVO plv=new PlanListVO();
			List planList=movieService.getPlanListByMovie(movie);
		
			plv.setList(planList);
			plv.sortByDay();
			session.setAttribute("planList", plv);
			//ServletContext context = getServletContext();
			context.getRequestDispatcher("/system/staff/sale_plan_list.jsp").forward(request, response);
//			//response.sendRedirect("system/staff/sale_plan_list.jsp");
			return;
		}
//		
//		//选座位
//		if(null!=pid){
//			
//		}
//		
		context.getRequestDispatcher("/system/staff/sale_movie_list.jsp").forward(request, response);
		//response.sendRedirect("system/staff/sale_movie_list.jsp");
		return;
		
		
//		HttpSession session=request.getSession();
		
		
		
//		PlanListVO plv=new PlanListVO();
//		List planList=movieService.getPlanListByMovie(movie);
//	
//		plv.setList(planList);
//		plv.sortByDay();
//		session.setAttribute("planList", plv);
	}

}
