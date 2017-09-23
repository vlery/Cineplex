package net.cineplex.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.cineplex.action.bussiness.QuizService;
import net.cineplex.action.bussiness.QuizServiceBean;
import net.cineplex.model.Quiz;
import net.cineplex.webmodel.QuizList;
import net.cineplex.webmodel.SelectList;

/**
 * Servlet implementation class QuizCreate
 */
@WebServlet("/quizCreate")
public class QuizCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuizService quizService=new QuizServiceBean();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizCreate() {
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
		request.setCharacterEncoding("utf-8");
		String add=request.getParameter("add");
		String create=request.getParameter("create");
	
		HttpSession session=request.getSession();
		
		if(null!=add){
			
			String ques=request.getParameter("question");
			String mid=request.getParameter("movie");
			Quiz quiz=(Quiz) session.getAttribute("quiz");
			quiz.setMid(mid);
			quiz.setQuestion(ques);
			session.setAttribute("quiz", quiz);
			String select=request.getParameter("select");
			SelectList sl=(SelectList) session.getAttribute("selectList");
			sl.add(select);
			session.setAttribute("selectList", sl);
			response.sendRedirect("system/staff/quiz_create.jsp");
			return;
		}
		if(null!=create){
			SelectList sl=(SelectList) session.getAttribute("selectList");
			String ques=request.getParameter("question");
			String mid=request.getParameter("movie");
			Quiz quiz=(Quiz) session.getAttribute("quiz");
			quiz.setMid(mid);
			quiz.setQuestion(ques);
			quizService.create(quiz,sl);
			
		    quiz=new Quiz();
			quiz.setQuestion("");
			quiz.setMid("");
			session.setAttribute("quiz", quiz);
			List list=new ArrayList();
			sl=new SelectList();
			sl.setList(list);
			session.setAttribute("selectList", sl);
			
			//quizList
			List qList=quizService.getQuizList();
			QuizList ql=new QuizList();
			ql.setList(qList);
			session.setAttribute("quizList", ql);
						
			session.setAttribute("quiz_create_feedback", "问题添加成功！");
			response.sendRedirect("system/staff/quiz_create.jsp");
			return;
		}
		
		
		
		SelectList sl=(SelectList) session.getAttribute("selectList");
		if(null!=sl){
				for(int i=0;i<sl.getSize();i++){
					String index=String.valueOf(i);
					if(null!=request.getParameter(index)){
						sl.remove(i);
						session.setAttribute("selectList", sl);
						
						String ques=request.getParameter("question");
						String mid=request.getParameter("movie");
						Quiz quiz=(Quiz) session.getAttribute("quiz");
						quiz.setMid(mid);
						quiz.setQuestion(ques);
						session.setAttribute("quiz", quiz);
						
						response.sendRedirect("system/staff/quiz_create.jsp");
						return;
					}
				}
		
		}
		//quiz对象
		Quiz quiz=new Quiz();
		quiz.setQuestion("");
		quiz.setMid("");
		session.setAttribute("quiz", quiz);
		//选项对象
		List list=new ArrayList();
		sl=new SelectList();
		sl.setList(list);
		session.setAttribute("selectList", sl);
		//quizList
		List qList=quizService.getQuizList();
		QuizList ql=new QuizList();
		ql.setList(qList);
		session.setAttribute("quizList", ql);
		
		response.sendRedirect("system/staff/quiz_create.jsp");
		return;
	}

}
