package com.deepblue.survey.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.PaperquestionDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.Paperquestion;

@WebServlet("/PaperquestionServlet")
public class PaperquestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String op = request.getParameter("op");
		try {
			  if(op != null) {
				  if(op == "AddPQ" || "AddPQ".equals(op)) {
					  Addpaperquestion(request,response);//问题加入问卷(paperQuestion)
				  }else if(op == "repaperId" || "repaperId".equals(op)) {
					  RepaperId(request,response);//将paperId发送到问题加入问卷页面
				  }
			  }
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
	}
	private void RepaperId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paperId = Integer.parseInt(request.getParameter("paperId"));
		request.setAttribute("paperId", paperId);
		request.getRequestDispatcher("/questionServlet?op=joinquestion").forward(request, response);
		
	}
	private void Addpaperquestion(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int paperId = Integer.parseInt(request.getParameter("paperId"));
		int questionId = Integer.parseInt(request.getParameter("questionId"));
		Paperquestion paperquestion= new Paperquestion();
		paperquestion.setPaperId(paperId);
		paperquestion.setQuestionId(questionId);
		PaperquestionDao paperquestionDao = surveyFactory.getPaperQuestionDao();
		boolean result = paperquestionDao.AddPaperquestion(paperquestion);
		if(result) {
			request.getRequestDispatcher("/questionServlet?op=questionManage").forward(request, response);
		}else {
			response.sendRedirect("index.jsp");
		}
		
	}
}
