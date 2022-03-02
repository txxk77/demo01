package com.deepblue.survey.Model;

import java.util.Date;

public class Survey {
	private int  surveyId;//-- 调查Id
	private int  paperId;  //-- 问卷Id
	private int questionId;  //-- 问题Id
	private String answer;  //-- 问题的答案  如果是选择题，则填写A,B,C,D,E等。如果是非选择题，则填写答案
	private Date surveyTime; //-- 调查时间
	public Survey() {
		
	}
	public Survey(int surveyId, int paperId, int questionId, String answer, Date surveyTime) {
		super();
		this.surveyId = surveyId;
		this.paperId = paperId;
		this.questionId = questionId;
		this.answer = answer;
		this.surveyTime = surveyTime;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getSurveyTime() {
		return surveyTime;
	}
	public void setSurveyTime(Date surveyTime) {
		this.surveyTime = surveyTime;
	}
	
	
}
