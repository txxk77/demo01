package com.deepblue.survey.Model;

public class Paperquestion {
	private int paperQuestionId;//-- 问卷问题id
	private int paperId;//问卷Id
	private int questionId;//问题Id
	public Paperquestion(){
		
	}
	public Paperquestion(int paperQuestionId, int paperId, int questionId) {
		super();
		this.paperQuestionId = paperQuestionId;
		this.paperId = paperId;
		this.questionId = questionId;
	}
	public int getPaperQuestionId() {
		return paperQuestionId;
	}
	public void setPaperQuestionId(int paperQuestionId) {
		this.paperQuestionId = paperQuestionId;
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
	
	
}
