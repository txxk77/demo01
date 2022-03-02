package com.deepblue.survey.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperationsUtil extends DBUtil{
         
	private  Connection con = null;
	private  PreparedStatement stmt = null;
	
	public boolean executeCUD(String sql,Object[] object) {
		boolean b=false;
             con=getConnection();
		try {
			stmt = con.prepareStatement(sql);
			
			if(object != null) {
				for(int i=0;i<object.length;i++) {
					stmt.setObject(i+1, object[i]);
				}
			}
			int cute=stmt.executeUpdate();
			if(cute > 0) {
				b=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(null, stmt, con);
		}
		return b;
	}
	
	public ResultSet execute_Read(String sql,Object[] object) {
		Connection con=getConnection();
		ResultSet rs=null;
		
		try {
			stmt=con.prepareStatement(sql);
			
			if(object != null) {
				for(int i=0;i<object.length;i++) {
					stmt.setObject(i+1, object[i]);
				}
			}
			
			System.out.print(stmt.toString());
			rs=stmt.executeQuery();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
