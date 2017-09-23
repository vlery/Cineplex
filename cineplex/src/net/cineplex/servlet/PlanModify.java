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

import net.cineplex.action.bussiness.DateTool;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.model.Plan;
import net.cineplex.webmodel.PlanListVO;
import net.cineplex.webmodel.PlanVO;

/**
 * Servlet implementation class PlanModify
 */
@WebServlet("/planModify")
public class PlanModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
     MovieService movieService=new MovieServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanModify() {
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
		String back=request.getParameter("back");
		String modify=request.getParameter("modify");
		String delete=request.getParameter("delete");
		HttpSession session=request.getSession();
		ServletContext context = getServletContext();
		
		if(null!=back){
			session.removeAttribute("plan");
			response.sendRedirect("system/staff/plan_list.jsp");
			return;
		}
		
		if(null!=modify){
			Plan plan=(Plan) session.getAttribute("plan");
			plan.setDay(new DateTool().stringToDate(request.getParameter("day_m")));
			plan.setTime(new DateTool().stringToTime(request.getParameter("time_m")));
			plan.setHid(request.getParameter("hall_m"));
			plan.setPrice(Integer.valueOf(request.getParameter("price_m")));
			movieService.updatePlan(plan);
			
			session.setAttribute("plan_modify_feedback", "修改成功！");
			
			List list=movieService.getPlanList();
			PlanListVO plv=new PlanListVO();
			plv.setList(list);
			session.setAttribute("planList", plv);
			
			session.removeAttribute("plan");
//			ServletContext context = getServletContext();
			context.getRequestDispatcher("/system/staff/plan_list.jsp").forward(request, response);
			//response.sendRedirect("system/staff/plan_list.jsp");
			return;
		}
		
		if(null!=delete){
			Plan plan=(Plan) session.getAttribute("plan");
			movieService.deletePlan(plan.getPid());
			session.setAttribute("plan_modify_feedback", "删除成功！");
			
			List list=movieService.getPlanList();
			PlanListVO plv=new PlanListVO();
			plv.setList(list);
			session.setAttribute("planList", plv);
			
			session.removeAttribute("plan");
			context.getRequestDispatcher("/system/staff/plan_list.jsp").forward(request, response);
			//
			//response.sendRedirect("system/staff/plan_list.jsp");
			return;
		}
		//list项点击触发 ，初始化session参数
		String pid=request.getParameter("planID");
		Plan plan=movieService.getPlan(pid);
		session.setAttribute("plan", plan);
		context.getRequestDispatcher("/system/staff/plan_modify.jsp").forward(request, response);
		//response.sendRedirect("system/staff/plan_modify.jsp");
		return;
	}

}
