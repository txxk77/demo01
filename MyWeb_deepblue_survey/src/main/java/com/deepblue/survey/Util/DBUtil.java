package com.deepblue.survey.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String driver = "com.mysql.cj.jdbc.Driver" ;
	private static String url = "jdbc:mysql://localhost:3306/survey?useSSL=false&serverTimezone=Asia/Shanghai" ;
	private static String user = "root" ;
	private static String password = "123456" ;
	private static Connection con = null ;
	
	static {
		try {
			Class.forName(driver) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(ResultSet rs,Statement stmt,Connection con) {
			try {
				if(rs != null) {
				rs.close();
				rs=null;
			}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
					try {
						if( stmt!= null) {
						stmt.close();
						stmt=null;
					}
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
							try {
								if(con != null) {
								con.close();
								con=null;
							}
							}catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
			}
		}
	}

