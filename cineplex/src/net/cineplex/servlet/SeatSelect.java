package net.cineplex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.ManagerService;
import net.cineplex.action.bussiness.ManagerServiceBean;
import net.cineplex.action.bussiness.MovieService;
import net.cineplex.action.bussiness.MovieServiceBean;
import net.cineplex.model.Member;
import net.cineplex.model.Plan;
import net.cineplex.webmodel.PlanVO;
import net.cineplex.webmodel.SeatList;

/**
 * Servlet implementation class SeatSelect
 */
@WebServlet("/seatSelect")
public class SeatSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MovieService movieService=new MovieServiceBean();
	ManagerService managerService=new ManagerServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatSelect() {
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
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String seats=request.getParameter("seat");
		String seat[]=seats.split("-");
		HttpSession session=request.getSession();
		
		Member member=(Member) session.getAttribute("crtUser");
		
		if(null!=member){
				String pid=(String) session.getAttribute("crtPlan");
				Plan plan=movieService.getPlan(pid);
				if(movieService.testDeposit(member.getId(),plan.getPrice()*seat.length)){
					movieService.buyTicket(member.getId(), 0, plan.getPrice()*seat.length,plan.getMid());
					SeatList sl=new SeatList();
					sl.setList(new ArrayList());
					for(int i=0;i<seat.length;i++){
							movieService.watchMovie(member.getId(), seat[i], pid);
							sl.addItem(managerService.getSeatBySid(seat[i]));
							//System.out.println(managerService.getSeatBySid(seat[i]));
					}
					
					PlanVO planVO=new PlanVO();
					planVO.setPid(String.valueOf(plan.getPid()));
					planVO.setHall(managerService.getHallNameByHid(plan.getHid()));
					planVO.setMovie(movieService.getMovie(plan.getMid()).getName());
					planVO.setDay(String.valueOf(plan.getDay()));
					planVO.setPrice(String.valueOf(plan.getPrice()));
					planVO.setTime(String.valueOf(plan.getTime()));
					session.setAttribute("choosePlan",planVO);
					session.setAttribute("chooseSeat", sl);
					response.sendRedirect("system/user/deal_success.jsp");
					return;
				}else{
					response.sendRedirect("system/user/deal_fail.jsp");
					return;
				}
		}else{
			String pid=(String) session.getAttribute("crtPlan");
			Plan plan=movieService.getPlan(pid);
				String mid="0000000";
				movieService.buyTicket(mid, 1, plan.getPrice()*seat.length,plan.getMid());
				SeatList sl=new SeatList();
				sl.setList(new ArrayList());
				for(int i=0;i<seat.length;i++){
						movieService.watchMovie(mid, seat[i], pid);
						sl.addItem(managerService.getSeatBySid(seat[i]));
						//System.out.println(managerService.getSeatBySid(seat[i]));
				}
				
				PlanVO planVO=new PlanVO();
				planVO.setPid(String.valueOf(plan.getPid()));
				planVO.setHall(managerService.getHallNameByHid(plan.getHid()));
				planVO.setMovie(movieService.getMovie(plan.getMid()).getName());
				planVO.setDay(String.valueOf(plan.getDay()));
				planVO.setPrice(String.valueOf(plan.getPrice()));
				planVO.setTime(String.valueOf(plan.getTime()));
				session.setAttribute("choosePlan",planVO);
				session.setAttribute("chooseSeat", sl);
				response.sendRedirect("system/user/deal_success.jsp");
				return;
			
			}
		}
		
		
	
		//PrintWriter  out=response.getWriter();
		
		//out.println("select seats:"+seats);
		
	}


