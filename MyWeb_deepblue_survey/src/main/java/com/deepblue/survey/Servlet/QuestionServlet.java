package com.deepblue.survey.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.PaperDao;
import com.deepblue.survey.Dao.QuestionDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.Question;

@WebServlet("/questionServlet")
public class QuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		    String op = request.getParameter("op");
		try {
			  if(op != null) {
				  if(op == "Addquestion" || "Addquestion".equals(op)) {
					  Addquestion(request,response);//增加问题
				  }else if(op == "questionManage" || "questionManage".equals(op)) {
					  questionManage(request,response);//显示所有问题
				  }else if(op == "deletequestion" || "deletequestion".equals(op)) {
					  Deletequestion(request,response);//删除问题
				  }else if(op == "joinquestion" || "joinquestion".equals(op)) {
					  joinquestion(request,response);//将问题加入问卷
				  }else if(op == "sendquestion"|| "sendquestion".equals(op)) {
					  Sendquestion(request,response);//将questionId发送到修改问题页面
				  }else if(op == "updatequestion" || "updatequestion".equals(op)) {
					  Updatequestion(request,response);//修改问题
				  }
			  }
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
		
		}
	
	private void Updatequestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionId=Integer.parseInt(request.getParameter("questionId"));
		String questionType=request.getParameter("questionType");
		String questionDesc=request.getParameter("questionDesc");
		String isChoice=request.getParameter("isChoice");
		String optionA=request.getParameter("optionA");
		String optionB=request.getParameter("optionB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String optionE=request.getParameter("optionE");
		
		Question que = new Question();
		que.setQuestionId(questionId);
		que.setQuestionType(questionType);
		que.setQuestionDesc(questionDesc);
		que.setIsChoice(isChoice);
		que.setOptionA(optionA);
		que.setOptionB(optionB);
		que.setOptionC(optionC);
		que.setOptionD(optionD);
		que.setOptionE(optionE);
		
		QuestionDao questionDao = surveyFactory.getQuestionDao();
		boolean result = questionDao.Updatequestion(que);
		if(result) {
			request.getRequestDispatcher("/questionServlet?op=questionManage").forward(request, response);
		}else {
			response.sendRedirect("Updatequestion.jsp");
		}
	}
	private void Sendquestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int questionId=Integer.parseInt(request.getParameter("questionId"));
		  QuestionDao questionDao = surveyFactory.getQuestionDao();
		  Question question = questionDao.getQuestionId(questionId);
		   request.setAttribute("question", question);
		   request.getRequestDispatcher("Updatequestion.jsp").forward(request, response);
		
	}
	private void joinquestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDao questionDao = surveyFactory.getQuestionDao();
		List<Question> questionList=questionDao.QuestionManage();
		request.setAttribute("questionList", questionList);
		request.getRequestDispatcher("Addquestion.jsp").forward(request, response);
		
	}
	private void Deletequestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int questionId=Integer.parseInt(request.getParameter("questionId"));
		Question question=new Question();
		question.setQuestionId(questionId);
		QuestionDao questionDao = surveyFactory.getQuestionDao();
		boolean result = questionDao.Deletequestion(question);
		if(result) {
			request.getRequestDispatcher("/questionServlet?op=questionManage").forward(request, response);
		}else {
			response.sendRedirect("question.jsp");
		}
		
	}
	private void questionManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDao questionDao = surveyFactory.getQuestionDao();
		List<Question> questionList=questionDao.QuestionManage();
		request.setAttribute("questionList", questionList);
		request.getRequestDispatcher("question.jsp").forward(request, response);
		
	}
	private void Addquestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionType=request.getParameter("questionType");
		String questionDesc=request.getParameter("questionDesc");
		String isChoice=request.getParameter("isChoice");
		String optionA=request.getParameter("optionA");
		String optionB=request.getParameter("optionB");
		String optionC=request.getParameter("optionC");
		String optionD=request.getParameter("optionD");
		String optionE=request.getParameter("optionE");
		
		Question question = new Question();
		question.setIsChoice(isChoice);
		question.setQuestionType(questionType);
		question.setQuestionDesc(questionDesc);
		question.setOptionA(optionA);
		question.setOptionB(optionB);
		question.setOptionC(optionC);
		question.setOptionD(optionD);
		question.setOptionE(optionE);
		
		QuestionDao questionDao = surveyFactory.getQuestionDao();
		boolean result = questionDao.Addquestion(question);
		if(result) {
				request.getRequestDispatcher("createquestion.jsp").forward(request, response);
		}else {
				response.sendRedirect("index.jsp");
		
	}
	}
}

