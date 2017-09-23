package net.cineplex.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.StatService;
import net.cineplex.action.bussiness.StatServiceBean;
import net.cineplex.webmodel.stat.QuizVO;

/**
 * Servlet implementation class QuizStat
 */
@WebServlet("/quizStat")
public class QuizStat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       StatService statService=new StatServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizStat() {
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
		QuizVO qv=statService.getQuizStat();
		System.out.println(qv.getChocieNum(0));
		System.out.println(qv.getChocieNum(1));
		System.out.println(qv.getChocieNum(2));
		System.out.println(qv.getChocieNum(3));
		System.out.println(qv.getChocieNum(4));
		session.setAttribute("quizVO", qv);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/manager/quiz.jsp").forward(request, response);
		//response.sendRedirect("system/manager/quiz.jsp");
		return;
	}

}
