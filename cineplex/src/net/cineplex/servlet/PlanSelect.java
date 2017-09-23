package net.cineplex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import net.cineplex.model.MovieHistory;
import net.cineplex.model.Plan;
import net.cineplex.model.Seat;
import net.cineplex.webmodel.SeatListInHall;
import net.cineplex.webmodel.SeatListInRow;
import net.cineplex.webmodel.UsedSeatList;

/**
 * Servlet implementation class PlanSelect
 */
@WebServlet("/planSelect")
public class PlanSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    MovieService movieService=new MovieServiceBean();
	ManagerService managerService=new ManagerServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlanSelect() {
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
		String pid=request.getParameter("plan");
	
		Plan plan=movieService.getPlan(pid);
		String hid=plan.getHid();
		List seatList=managerService.getSeatByHall(hid);
		List usedSeatList=movieService.getMovieHistoryByPid(pid);
	//	System.out.println(usedSeatList.size());
//		System.out.println("seatList:"+seatList.size());
//		System.out.println("used:"+usedSeatList.size());
		UsedSeatList usl=new UsedSeatList();
		List usList=new ArrayList();
		usl.setList(usList);
		
		for(int i=0;i<usedSeatList.size();i++){
			MovieHistory movieHistory=(MovieHistory) usedSeatList.get(i);
			usl.addSeat(movieHistory.getSid());
		}
	
		SeatListInHall slih=new SeatListInHall();
		List list=new ArrayList();
		int count=0;
		List temp=seatList;
		while(count<seatList.size()){
			int row=((Seat)temp.get(0)).getRow();
			SeatListInRow slir=new SeatListInRow();
			slir.setRow(row);
			List l=new ArrayList();
			for(int i=0;i<seatList.size();i++){
				Seat s=(Seat) seatList.get(i);
				if(s.getRow()==row){
					l.add(s);
				}
			}
			
			slir.setList(l);
			//System.out.println(slir.getSeatNum());
			list.add(slir);
			
			List ttp=new ArrayList();
			for(int i=0;i<temp.size();i++){
				if(((Seat)temp.get(i)).getRow()==row){
					count++;
				}else{
					ttp.add(temp.get(i));
				}
			}
			temp=ttp;
		}
		
		slih.setList(list);
		
		HttpSession session=request.getSession();
		session.setAttribute("crtPlan", pid);
		session.setAttribute("seatListInHall", slih);
		session.setAttribute("usedSeatList", usl);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/user/seat.jsp").forward(request, response);
	//	response.sendRedirect("system/user/seat.jsp");
		return;
//		PrintWriter  out=response.getWriter();
//		
//		out.println("select plan:"+pid);
		
	}

}
