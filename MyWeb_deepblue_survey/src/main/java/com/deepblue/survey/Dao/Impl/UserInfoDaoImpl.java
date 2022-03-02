package com.deepblue.survey.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.deepblue.survey.Dao.UserInfoDao;
import com.deepblue.survey.Model.UserInfo;
import com.deepblue.survey.Util.OperationsUtil;

public class UserInfoDaoImpl extends OperationsUtil implements UserInfoDao{

	@Override
	public UserInfo userlogin(UserInfo userInfo) {
		UserInfo userinfo=null;
		String sql="select * from userInfo where mobilePhone=? and userPass=?";
		Object[] obj= {userInfo.getMobilePhone(),userInfo.getUserPass()};
		ResultSet rs=execute_Read(sql,obj);
		try {
			if(rs.next()){
				int userId = rs.getInt("userId");
				  String mobilePhone = rs.getString("mobilePhone");
				  String userPass = rs.getString("userPass");
				  String userName = rs.getString("userName");				  
				  String nickName = rs.getString("nickName");
				  String gender = rs.getString("gender");
				  String brief = rs.getString("brief");
				  userinfo=new UserInfo(userId,mobilePhone,userPass,userName,nickName,gender,brief);		  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userinfo;
	}

	@Override
	public boolean register(UserInfo userInfo) {
		String sql="insert into userInfo(mobilePhone,userPass,userName) values(?,?,?)";
		Object[] obj= {userInfo.getMobilePhone(),userInfo.getUserPass(),userInfo.getUserName()};
		boolean result = executeCUD(sql,obj);
		return result;
	}

}
