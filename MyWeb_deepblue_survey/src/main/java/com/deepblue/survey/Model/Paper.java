package com.deepblue.survey.Model;

public class Paper {
	private int paperId; // �ʾ�Id
	 private String  paperTitle;  // �ʾ�����
	 private String  paperDesc; // �ʾ���ϸ����
	 private int  creatorId;  // �ʾ�����Id
	 private String  state;  // �ʾ�״̬ ���ѷ�����δ������
	 
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
