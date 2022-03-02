package com.deepblue.survey.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.SurveyDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.Survey;

@WebServlet("/surveyServlet")
public class SurveyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		 String op = request.getParameter("op");
			try {
				  if(op != null) {
					  if(op == "Addanswer" || "Addanswer".equals(op)) {
						  Addanswer(request,response);//将用户填写答案加入调查表
					  }
				  }
						} catch (ServletException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
	}
	private void Addanswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		int questionId=Integer.parseInt(request.getParameter("questionId"));
		String answer=request.getParameter("answer");
		Survey survey =new Survey();
		survey.setPaperId(paperId);
		survey.setQuestionId(questionId);
		survey.setAnswer(answer);
		
		SurveyDao surveyDao = surveyFactory.getSurveyDao();
		boolean result = surveyDao.Addanswer(survey);
		response.getWriter().print(result);
//		if(result) {
//			request.getRequestDispatcher("/paperServlet?op=userhome").forward(request, response);
//		}else {
//			response.sendRedirect("userpaper.jsp");
//		}  
		
	}
}
