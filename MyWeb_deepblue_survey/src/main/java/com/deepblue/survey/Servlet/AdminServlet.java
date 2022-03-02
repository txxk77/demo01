package com.deepblue.survey.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.AdminDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.Admin;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		 String op = request.getParameter("op");
		 try {
		 if(op != null) {
			 if(op == "adminlogin" || "adminlogin".equals(op)) {
				 Adminlogin(request,response);
			    }
		      }					
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		 
		 
		 
	
	private void Adminlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminNo = request.getParameter("adminNo");
		 String adminPass = request.getParameter("adminPass");
		 
		 Admin admin = new Admin();
		 admin.setAdminNo(adminNo);
		 admin.setAdminPass(adminPass);
		 
		 AdminDao adminDao = surveyFactory.getAdminDao();
		 Admin admins = adminDao.loginAdmin(admin);
		 
		 if(admins != null) {
			 request.getSession().setAttribute("Admin", admins);
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		 }else {
			 response.sendRedirect("Adlogin.jsp");
		 }
		
	}
}
