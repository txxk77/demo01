package com.deepblue.survey.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.PaperDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.Admin;
import com.deepblue.survey.Model.Paper;
import com.deepblue.survey.Model.Showpaper;

@WebServlet("/paperServlet")
public class PaperServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
	    String op = request.getParameter("op");
	    try {
	    if(op != null) {
	    	if(op == "addpaper" || "addpaper".equals(op)) {	    	    
					Addpaper(request,response);//增加问卷
	    	     }else if(op == "paperManage" || "paperManage".equals(op)) {
	    	    	 paperManage(request,response);//管理员管理问卷界面
	    	     }else if(op == "getpaperId" || "getpaperId".equals(op)) {
	    	    	 showpapercontent(request,response);//获取问卷Id并转发到修改界面,修改对应问卷Id的内容
	    	     }else if(op == "updatePaper" || "updatePaper".equals(op)) {
	    	    	 updatePaper(request,response);//修改问卷
	    	     }else if(op == "deletePaper" || "deletePaper".equals(op)) {
	    	    	 deletePaper(request,response);//删除问卷
	    	     }else if(op == "showpaper" || "showpaper".equals(op)) {
	    	    	 Showpaper(request,response);//管理员查看问卷内容
	    	     }else if(op == "userhome" || "userhome".equals(op)){
	    	    	 userHome(request,response);//已发布问卷显示在用户主页上
	    	     }else if(op == "writeanswer" || "writeanswer".equals(op)) {
	    	    	 Writeanswer(request,response);//用户点击填写问卷后的问卷界面
	    	     }else if(op == "publish" || "publish".equals(op)) {
	    	    	 Publish(request,response);//更改问卷状态为已发布
	    	     }else if(op == "unpublish" || "unpublish".equals(op)) {
	    	    	 Unpublish(request,response);//更改问卷状态为未发布
	    	     }
	          }
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    	
	private void Unpublish(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		Paper paper = new Paper();		
		paper.setPaperId(paperId);
		PaperDao paperDao = surveyFactory.getPaperDao();
		
		boolean result = paperDao.unpublish(paper);
		response.getWriter().print(result);
		
	}
	private void Publish(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		Paper paper = new Paper();		
		paper.setPaperId(paperId);
		PaperDao paperDao = surveyFactory.getPaperDao();
		
		boolean result = paperDao.publish(paper);
		response.getWriter().print(result);
	}
	private void Writeanswer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		String paperTitle = request.getParameter("paperTitle");
		Paper paper = new Paper();		
		paper.setPaperId(paperId);
		PaperDao paperDao = surveyFactory.getPaperDao();
		
		List<Showpaper> SpaperList = paperDao.showPaper(paper);
		request.setAttribute("SpaperList", SpaperList);
		request.setAttribute("paperId", paperId);
		request.setAttribute("paperTitle", paperTitle);
		request.getRequestDispatcher("userpaper.jsp").forward(request, response);
		
	}
	private void userHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaperDao paperDao = surveyFactory.getPaperDao();
		List<Paper> paperList = paperDao.paperManage();
		request.setAttribute("paperList", paperList);
		request.getRequestDispatcher("userhome.jsp").forward(request, response);
		
	}
	private void Showpaper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		String paperTitle = request.getParameter("paperTitle");
		Paper paper = new Paper();		
		paper.setPaperId(paperId);
		PaperDao paperDao = surveyFactory.getPaperDao();
		
		List<Showpaper> SpaperList = paperDao.showPaper(paper);
		request.setAttribute("SpaperList", SpaperList);
		request.setAttribute("paperId", paperId);
		request.setAttribute("paperTitle", paperTitle);
		request.getRequestDispatcher("showpaper.jsp").forward(request, response);		
	}
	private void deletePaper(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		Paper paper = new Paper();
		paper.setPaperId(paperId);
		PaperDao paperDao = surveyFactory.getPaperDao();
		boolean result = paperDao.Deletepaper(paper);
		if(result) {
			request.getRequestDispatcher("/paperServlet?op=paperManage").forward(request, response);
		}else {
			response.sendRedirect("tables.jsp");
		}
		
	}
	private void updatePaper(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		String paperTitle = request.getParameter("paperTitle");
		String paperDesc = request.getParameter("paperDesc");
		Paper paper = new Paper();
		paper.setPaperId(paperId);
		paper.setPaperTitle(paperTitle);
		paper.setPaperDesc(paperDesc);		
		PaperDao paperDao = surveyFactory.getPaperDao();
		boolean result = paperDao.Updatepaper(paper);
		if(result) {
			request.getRequestDispatcher("/paperServlet?op=paperManage").forward(request, response);
		}else {
			response.sendRedirect("updatepaper.jsp");
		}
		
	}
	private void showpapercontent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int paperId=Integer.parseInt(request.getParameter("paperId"));
		PaperDao paperDao = surveyFactory.getPaperDao();
		Paper paper = paperDao.getpaperId(paperId);
		request.setAttribute("paper", paper);
		request.getRequestDispatcher("updatepaper.jsp").forward(request, response);
		
	}
	private void paperManage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaperDao paperDao = surveyFactory.getPaperDao();
		List<Paper> paperList = paperDao.paperManage();
		request.setAttribute("paperList", paperList);
		request.getRequestDispatcher("tables.jsp").forward(request, response);
		
	}
	private void Addpaper(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = (Admin)request.getSession().getAttribute("Admin");
		if(admin == null) {
			response.sendRedirect("Adlogin.jsp");
		}
		String paperTitle = request.getParameter("paperTitle");
		String paperDesc = request.getParameter("paperDesc");
		int creatorId = admin.getAdminId();
		Paper paper = new Paper();
		paper.setCreatorId(creatorId);
		paper.setPaperTitle(paperTitle);
		paper.setPaperDesc(paperDesc);
		
		PaperDao paperDao = surveyFactory.getPaperDao();
		boolean result = paperDao.Addpaper(paper);
		if(result) {
			request.getRequestDispatcher("/paperServlet?op=paperManage").forward(request, response);
		}else {
			response.sendRedirect("paper/createpaper.jsp");
		}
		
		
		
	}
}
