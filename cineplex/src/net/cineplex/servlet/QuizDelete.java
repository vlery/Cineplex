package net.cineplex.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.QuizService;
import net.cineplex.action.bussiness.QuizServiceBean;
import net.cineplex.dao.ChoiceDao;
import net.cineplex.dao.QuizDao;
import net.cineplex.dao.impl.ChoiceDaoImpl;
import net.cineplex.dao.impl.QuizDaoImpl;
import net.cineplex.webmodel.QuizList;

/**
 * Servlet implementation class QuizDelete
 */
@WebServlet("/quizDelete")
public class QuizDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuizService quizService=new QuizServiceBean();
	
	QuizDao quizDao=new QuizDaoImpl();
    ChoiceDao choiceDao=new ChoiceDaoImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizDelete() {
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
		String qid=request.getParameter("quiz");
		quizService.delete(qid);
		
		HttpSession session=request.getSession();
		
		//quizList
		List qList=quizService.getQuizList();
		QuizList ql=new QuizList();
		ql.setList(qList);
		session.setAttribute("quizList", ql);
		
		
		
		session.setAttribute("quiz_delete_feedback", "É¾³ý³É¹¦£¡");
		response.sendRedirect("system/staff/quiz_list.jsp");
		return;
	}

}
