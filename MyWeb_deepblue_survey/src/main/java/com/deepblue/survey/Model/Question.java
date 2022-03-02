package com.deepblue.survey.Model;

public class Question {
	private int  questionId; //问题Id
    private String questionType;  //-- 问题类型 （超市、米粉店、花店、快餐店）
    private String questionDesc;  //-- 问题描述
    private String isChoice;  //-- 是否为选择题
    private String optionA;   //-- 选项1
    private String optionB;   //-- 选项2
    private String optionC;   //-- 选项3
    private String optionD;   //-- 选项4
    private String optionE;   //-- 选项5
    public Question() {
    	
    }
	public Question(int questionId, String questionType, String questionDesc, String isChoice, String optionA,
			String optionB, String optionC, String optionD, String optionE) {
		super();
		this.questionId = questionId;
		this.questionType = questionType;
		this.questionDesc = questionDesc;
		this.isChoice = isChoice;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.optionE = optionE;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getQuestionDesc() {
		return questionDesc;
	}
	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}
	public String getIsChoice() {
		return isChoice;
	}
	public void setIsChoice(String isChoice) {
		this.isChoice = isChoice;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionE() {
		return optionE;
	}
	public void setOptionE(String optionE) {
		this.optionE = optionE;
	}
	
	
    
}
