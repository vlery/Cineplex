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

import net.cineplex.action.bussiness.ManagerService;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.ManagerServiceBean;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.model.Movie;
import net.cineplex.webmodel.HallList;
import net.cineplex.webmodel.MovieModifiableList;
import net.cineplex.webmodel.PlanListVO;

/**
 * Servlet implementation class PlanCreate
 */
@WebServlet("/planCreate")
public class PlanCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ManagerService managerService=new ManagerServiceBean();
	MovieService movieService=new MovieServiceBean();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanCreate() {
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
		String create=request.getParameter("add");
		HttpSession session=request.getSession();
		ServletContext context = getServletContext();
		
		if(null!=create){
			String mid=request.getParameter("movie");
			String hid=request.getParameter("hall");
			String  day=request.getParameter("day");
			String time=request.getParameter("time");
			String price=request.getParameter("price");
			movieService.createPlan(mid,hid,day,time,price);
			
			session.setAttribute("plan_create_feedback", "创建成功！");
			//更新planlist
			List list=movieService.getPlanList();
			PlanListVO plv=new PlanListVO();
			plv.setList(list);
			session.setAttribute("planList", plv);
//			ServletContext context = getServletContext();
			context.getRequestDispatcher("/system/staff/plan_create.jsp").forward(request, response);
		//	response.sendRedirect("system/staff/plan_create.jsp");
			
	
			return;
		}
		
		//初始化session参数
		HallList hallList=new HallList();
		hallList.setList(managerService.getHallList());
		session.setAttribute("hallList", hallList);
		
		List list=movieService.getPlanList();
		PlanListVO plv=new PlanListVO();
		plv.setList(list);
		session.setAttribute("planList", plv);
		context.getRequestDispatcher("/system/staff/plan_create.jsp").forward(request, response);
	//	response.sendRedirect("system/staff/plan_create.jsp");
		return;
	}

}
