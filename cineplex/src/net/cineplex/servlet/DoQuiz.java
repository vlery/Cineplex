package net.cineplex.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.QuizService;
import net.cineplex.action.bussiness.QuizServiceBean;
import net.cineplex.model.Member;
import net.cineplex.webmodel.UserQuizList;

/**
 * Servlet implementation class DoQuiz
 */
@WebServlet("/doQuiz")
public class DoQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       QuizService quizService=new QuizServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoQuiz() {
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
		
		HttpSession  session=request.getSession();
		Member member=(Member) session.getAttribute("crtUser");
		String id=member.getId();
//		String id="0000001";
		UserQuizList uql=new  UserQuizList();
		uql.setList(quizService.getAvailableList(id));
		session.setAttribute("quizList", uql);
		ServletContext context = getServletContext();
		context.getRequestDispatcher("/system/user/quiz.jsp").forward(request, response);
		//response.sendRedirect("system/user/quiz.jsp");
		return;
	}

}
