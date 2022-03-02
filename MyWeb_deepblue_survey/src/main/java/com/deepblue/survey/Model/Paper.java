package com.deepblue.survey.Model;

public class Paper {
	private int paperId; // 问卷Id
	 private String  paperTitle;  // 问卷主题
	 private String  paperDesc; // 问卷详细描述
	 private int  creatorId;  // 问卷创建人Id
	 private String  state;  // 问卷状态 （已发布，未发布）
	 
	 public Paper() {
		 
	 }

	public Paper(int paperId, String paperTitle, String paperDesc, int creatorId, String state) {
		super();
		this.paperId = paperId;
		this.paperTitle = paperTitle;
		this.paperDesc = paperDesc;
		this.creatorId = creatorId;
		this.state = state;
	}

	public int getPaperId() {
		return paperId;
	}

	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}

	public String getPaperTitle() {
		return paperTitle;
	}

	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}

	public String getPaperDesc() {
		return paperDesc;
	}

	public void setPaperDesc(String paperDesc) {
		this.paperDesc = paperDesc;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
     	 
	 
}
