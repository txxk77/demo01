package com.deepblue.survey.Model;

public class Showpaper {
   private int paperId;
   private int questionId;
   private String paperTitle;
   private String questionDesc;
   private String isChoice;
   private String optionA;
   private String optionB;
   private String optionC;
   private String optionD;
   private String optionE;
   public Showpaper() {
	   
   }
public Showpaper(int questionId,String questionDesc,String isChoice, String optionA, String optionB,
		String optionC, String optionD, String optionE) {
	super();
	this.paperId = paperId;
	this.questionId = questionId;
	this.paperTitle = paperTitle;
	this.questionDesc = questionDesc;
	this.isChoice = isChoice;
	this.optionA = optionA;
	this.optionB = optionB;
	this.optionC = optionC;
	this.optionD = optionD;
	this.optionE = optionE;
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
public String getPaperTitle() {
	return paperTitle;
}
public void setPaperTitle(String paperTitle) {
	this.paperTitle = paperTitle;
}
public String getQuestionDesc() {
	return questionDesc;
}
public void setQuestionDesc(String questionDesc) {
	this.questionDesc = questionDesc;
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
public String getIsChoice() {
	return isChoice;
}
public void setIsChoice(String isChoice) {
	this.isChoice = isChoice;
}


   
}
