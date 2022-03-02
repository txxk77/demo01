package com.deepblue.survey.Model;

public class Admin {
	private int adminId;
    private String adminNo;
    private String adminPass;
    private String adminName;
    
    public Admin () {
    	
    }

	public Admin(int adminId, String adminNo, String adminPass, String adminName) {
		super();
		this.adminId = adminId;
		this.adminNo = adminNo;
		this.adminPass = adminPass;
		this.adminName = adminName;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminNo() {
		return adminNo;
	}

	public void setAdminNo(String adminNo) {
		this.adminNo = adminNo;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
    
}
