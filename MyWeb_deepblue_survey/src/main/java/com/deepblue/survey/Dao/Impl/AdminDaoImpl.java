package com.deepblue.survey.Dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.deepblue.survey.Dao.AdminDao;
import com.deepblue.survey.Model.Admin;
import com.deepblue.survey.Util.OperationsUtil;

public class AdminDaoImpl extends OperationsUtil implements AdminDao{

	@Override
	public Admin loginAdmin(Admin admin) {
		Admin administrator=null;
		String sql="select * from admin where adminNo=? and adminPass=?";
		Object[] obj= {admin.getAdminNo(),admin.getAdminPass()};
		ResultSet rs= execute_Read(sql,obj);
		try {
			if(rs.next()) {
			  int adminId = rs.getInt("adminId");
			  String adminNo = rs.getString("adminNo");
			  String adminPass = rs.getString("adminPass");
			  String adminName = rs.getString("adminName");
			 administrator = new Admin(adminId,adminNo,adminPass,adminName); 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs,null,null);
		}
		return administrator;
	}

}
