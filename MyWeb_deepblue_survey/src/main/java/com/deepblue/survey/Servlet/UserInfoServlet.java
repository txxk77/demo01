package com.deepblue.survey.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deepblue.survey.Dao.UserInfoDao;
import com.deepblue.survey.Dao.Factory.surveyFactory;
import com.deepblue.survey.Model.UserInfo;

@WebServlet("/userInfoServlet")
public class UserInfoServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		doPost(request,response) ;
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		String op = request.getParameter("op");
		try {
			  if(op != null) {
				  if(op == "userlogin" || "userlogin".equals(op)) {
					  Userlogin(request,response);
				  }else if(op =="userregister" || "userregister".equals(op)) {
					  register(request,response);
				  }
			  }
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
	}
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobilePhone=request.getParameter("mobilePhone");
		String userPass=request.getParameter("userPass");
		String userName=request.getParameter("userName");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setMobilePhone(mobilePhone);
		userInfo.setUserPass(userPass);
		userInfo.setUserName(userName);
		
		UserInfoDao userInfoDao = surveyFactory.getUserInfoDao();
		boolean result=userInfoDao.register(userInfo);
		if(result) {
			request.getRequestDispatcher("userLogin.jsp").forward(request, response);
		}else {
			response.sendRedirect("register.jsp");
		}
		
		
		
	}
	private void Userlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobilePhone=request.getParameter("mobilePhone");
		String userPass=request.getParameter("userPass");
		UserInfo userInfo = new UserInfo();
		userInfo.setMobilePhone(mobilePhone);
		userInfo.setUserPass(userPass);
		
		UserInfoDao userInfoDao = surveyFactory.getUserInfoDao();
		UserInfo userinfo=userInfoDao.userlogin(userInfo);
		if(userinfo != null) {
			request.getSession().setAttribute("userInfo", userinfo);
			request.getRequestDispatcher("/paperServlet?op=userhome").forward(request, response);
		}else {
			response.sendRedirect("userLogin.jsp");
		}
		
	}
}
