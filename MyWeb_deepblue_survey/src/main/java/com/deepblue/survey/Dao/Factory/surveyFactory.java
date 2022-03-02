package com.deepblue.survey.Dao.Factory;

import com.deepblue.survey.Dao.AdminDao;
import com.deepblue.survey.Dao.PaperDao;
import com.deepblue.survey.Dao.PaperquestionDao;
import com.deepblue.survey.Dao.QuestionDao;
import com.deepblue.survey.Dao.SurveyDao;
import com.deepblue.survey.Dao.UserInfoDao;
import com.deepblue.survey.Dao.Impl.AdminDaoImpl;
import com.deepblue.survey.Dao.Impl.PaperDaoImpl;
import com.deepblue.survey.Dao.Impl.PaperquestionImpl;
import com.deepblue.survey.Dao.Impl.QuestionDaoImpl;
import com.deepblue.survey.Dao.Impl.SurveyDaoImpl;
import com.deepblue.survey.Dao.Impl.UserInfoDaoImpl;

public class surveyFactory {
 private static AdminDao adminDao=null;
 private static PaperDao paperDao = null;
 private static QuestionDao questionDao=null;
 private static PaperquestionDao paperquestionDao=null;
 private static SurveyDao surveyDao=null;
 private static UserInfoDao userInfoDao=null;
 
 public static AdminDao getAdminDao() {
	 if(adminDao == null) {
		 adminDao=new AdminDaoImpl();
	 }
	 return adminDao;
 }
 
 public static PaperDao getPaperDao() {
	 if(paperDao == null) {
		 paperDao = new PaperDaoImpl();
	 }
	 return paperDao;
 }
 
 public static PaperquestionDao getPaperQuestionDao() {
	 if(paperquestionDao == null) {
		 paperquestionDao = new PaperquestionImpl();
	 }
	 return paperquestionDao;
 }
 
 public static QuestionDao getQuestionDao() {
	 if(questionDao == null) {
		 questionDao = new QuestionDaoImpl();
	 }
	 return questionDao;
 }
 
 public static SurveyDao getSurveyDao() {
	 if(surveyDao == null) {
		 surveyDao = new SurveyDaoImpl();
	 }
	 return surveyDao;
 }
 
 public static UserInfoDao getUserInfoDao() {
	 if(userInfoDao == null) {
		 userInfoDao = new UserInfoDaoImpl();
	 }
	 return userInfoDao;
 }
}
