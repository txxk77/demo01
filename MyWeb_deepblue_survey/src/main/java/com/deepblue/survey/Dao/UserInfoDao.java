package com.deepblue.survey.Dao;

import com.deepblue.survey.Model.UserInfo;

public interface UserInfoDao {
public UserInfo userlogin(UserInfo userInfo);
public boolean register(UserInfo userInfo);
}
