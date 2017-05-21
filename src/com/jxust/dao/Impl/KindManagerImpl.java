package com.jxust.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.KindManager;
import com.jxust.entity.Kind;


/**
 * @author shymain
 *
 */
public class KindManagerImpl implements KindManager {

	@Override
	public List<Kind> findAllKind() {
		
		List<Kind> list=new ArrayList<Kind>();
		Connection connection=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		connection=JDBCUtil.getConn();
		try {
			stmt=connection.prepareStatement("Select * from class");
			rs=stmt.executeQuery();
			while(rs.next()){
				Kind kind =new Kind();
				kind.setClassid(rs.getInt(1));
				kind.setClassname(rs.getString(2));
				kind.setRemark(rs.getString(3));
				list.add(kind);
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
	public void deleteKindById(int id) {
		Connection conn =null;
		Statement stmt =null;
		conn = JDBCUtil.getConn();
		try {
			String sql ="delete from class where classid="+id;
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
	public void addKind(Kind kind) {
		
		Connection conn=null;
		Statement stmt=null;
		//获取数据库连接
		conn=JDBCUtil.getConn();
		String sql="insert into class(classid,classname,remark) "
				+ "values('"+kind.getClassid()+"','"+kind.getClassname()+"','"+kind.getRemark()+"')";
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

	@Override
	public Kind findKindById(int id) {
		Kind kind =new Kind();
		Connection conn=null;
		PreparedStatement stmt =null;
		ResultSet rs =null;
		conn =JDBCUtil.getConn();
		try {
			stmt =conn.prepareStatement("select * from class where classid=?");
			stmt.setInt(1,id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				kind.setClassid(id);
				kind.setClassname(rs.getString(2));
				kind.setRemark(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}
		return kind;
	}

	@Override
	public void updateKindById(Kind kind) {

		Connection conn=null;
		PreparedStatement stmt=null;
		conn=JDBCUtil.getConn();
		try {
			stmt=conn.prepareStatement("update class set classname='"+kind.getClassname()
					+"',remark='"+kind.getRemark()+"'where classid='"+kind.getClassid()+"'");
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.closeDB(conn, stmt, null);
		}
		return;
	}
}
	
	
