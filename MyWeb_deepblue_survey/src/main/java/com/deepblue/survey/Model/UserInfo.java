package com.deepblue.survey.Model;

public class UserInfo {
	private int userId;//-- 用户Id
    private String mobilePhone; //-- 手机号
    private String userPass; //-- 用户密码
    private String userName; //-- 用户姓名
    private String nickName; //-- 用户昵称
    private String gender; //-- 性别
    private String brief; //--  简介
    public UserInfo() {
    	
    }
	public UserInfo(int userId, String mobilePhone, String userPass, String userName, String nickName, String gender,
			String brief) {
		super();
		this.userId = userId;
		this.mobilePhone = mobilePhone;
		this.userPass = userPass;
		this.userName = userName;
		this.nickName = nickName;
		this.gender = gender;
		this.brief = brief;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
    
}
