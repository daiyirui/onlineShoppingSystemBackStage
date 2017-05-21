package com.jxust.dao.Impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sun.misc.BASE64Encoder;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.UserManager;
import com.jxust.entity.User;

/**
 * @author shymain
 *
 */
public class UserManagerImpl implements UserManager {

	@Override
	public int checkLogin(String username, String userpassword) {
		int flag=0;
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		String password=null;
		 try {
			password = EncoderByMd5(userpassword);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
		}finally{
		  try {
			  connection=JDBCUtil.getConn();
			  statement=connection.createStatement();
			String sql="select * from user "
					+ "where username='"+username+"' and userpassword='"+password+"' and type=1";
			
			 rs=statement.executeQuery(sql); 
		    while(rs.next()){
		    	flag= rs.getInt(1);
		    }
  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			 JDBCUtil.closeDB(connection, statement, rs);
		}
	}
		  
		return flag;
}

	@Override
	public List<User> findAllUser() {
		List<User> list=new ArrayList<User>();
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		connection=JDBCUtil.getConn();
		try {
			stmt=connection.prepareStatement("Select * from user WHERE type=0");
			rs=stmt.executeQuery();
			while(rs.next()){
				User user =new User();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setType(rs.getInt(7));
				user.setRemark(rs.getString(8));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(connection, stmt, null);
		}
		return list;
	}

	@Override
	public void deleteUserById(int id) {
		Connection conn =null;
		Statement stmt =null;
		conn = JDBCUtil.getConn();
		try {
			String sql ="delete from user where userid="+id;
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}
		
	}

	@Override
	public User findUserById(int id) {
		User user =new User();
		Connection conn=null;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		conn =JDBCUtil.getConn();
		try {
			stmt =conn.prepareStatement("select * from user where userid=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				user.setUserid(id);
				user.setUsername(rs.getString(2));
				user.setUserpassword(EncoderByMd5(rs.getString(3)));
				user.setAge(rs.getInt(4));
				user.setSex(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setType(rs.getInt(7));
				user.setRemark(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}
		return user;
	}

	@Override
	public void updateUserById(User user) {

		Connection conn=null;
		PreparedStatement stmt=null;
		conn=JDBCUtil.getConn();
		try {
			stmt=conn.prepareStatement("update user set username='"+user.getUsername()
					+"',userpassword='"+EncoderByMd5(user.getUserpassword())+"',age='"+user.getAge()
					+"',email='"+user.getEmail()+"',type='"+user.getType()
					+"',remark='"+user.getRemark()+"'where userid='"+user.getUserid()+"'");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}
		return;
		
	}

	@Override
	public void addUser(User user) {

		Connection conn=null;
		Statement stmt=null;
		//获取数据库连接
		conn=JDBCUtil.getConn();
		String sql="insert into user(username,userpassword,age,sex,email,type,remark) "
				+ "values('"+user.getUsername()+"','"+user.getUserpassword()
				+"','"+user.getAge()+"','"+user.getSex()+"','"+user.getEmail()+"',0,'"+user.getRemark()+"')";
		try {
			stmt =conn.createStatement();
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}

	}
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		 //确定计算方法
		         MessageDigest md5=MessageDigest.getInstance("MD5");
		         BASE64Encoder base64en = new BASE64Encoder();
		 //加密后的字符串
		         String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		 return newstr;
		     }

}

