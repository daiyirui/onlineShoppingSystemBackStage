package com.jxust.commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtil {
	public static String url = "jdbc:mysql://192.168.2.52:3306/test";
	public static String user = "root";
	public static String password = "123456";

	public static Connection getConn() {
		Connection connection = null;
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
		
			connection = DriverManager.getConnection(url, user, password);
         
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeDB(Connection connection,Statement stat,ResultSet rs){
		
			try {
				if(null != connection)
				connection.close();
				if(null != stat)
					stat.close();
				if(null != rs)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
