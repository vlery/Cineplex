package net.cineplex.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.ManagerService;
import net.cineplex.action.bussiness.ManagerServiceBean;
import net.cineplex.webmodel.HallVO;
import net.cineplex.webmodel.Row;

/**
 * Servlet implementation class HallCreate
 */
@WebServlet("/hallCreate")
public class HallCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ManagerService managerService=new ManagerServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HallCreate() {
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
		
		String addRow=request.getParameter("addRow");
		String create=request.getParameter("create");
		HttpSession session=request.getSession();
		//添加座位排
		if(null!=addRow){
			String row=request.getParameter("row");
			String seat=request.getParameter("seat");
			String name=request.getParameter("hname");
			HallVO hallVO=(HallVO) session.getAttribute("hallVO");
			hallVO.setName(name);
			int index=Integer.valueOf(row);
			int seats=Integer.valueOf(seat);
			Row nRow=new Row();
			nRow.setIndex(index);
			nRow.setSeats(seats);
			hallVO.addRow(nRow);
			
			session.setAttribute("hallVO", hallVO);
			response.sendRedirect("system/staff/hall_create.jsp");
			return;
		}
		//创建播映厅
		if(null!=create){
			String name=request.getParameter("hname");
			HallVO hallVO=(HallVO) session.getAttribute("hallVO");
			hallVO.setName(name);
			managerService.createHall(hallVO);
			session.setAttribute("hall_create_feedback", "创建成功！");
			//清空数据
			hallVO.init();
			session.setAttribute("hallVO", hallVO);
			response.sendRedirect("system/staff/hall_create.jsp");
			return;
		}
		
		//初始化session参数
		HallVO hallVO=new HallVO();
		hallVO.init();
		
		session.setAttribute("hallVO", hallVO);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/staff/hall_create.jsp").forward(request, response);
	//	response.sendRedirect("system/staff/hall_create.jsp");
		return;
	}
}
