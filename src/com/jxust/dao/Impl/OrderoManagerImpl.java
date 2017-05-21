package com.jxust.dao.Impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.OrderoManager;
import com.jxust.entity.Ordero;


public class OrderoManagerImpl implements OrderoManager {

	@Override
	public List<Ordero> findAllOrdero() {
			List<Ordero> orderos = new ArrayList<Ordero>();
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				conn = JDBCUtil.getConn();
				
				String sql = "select * from ordero";
				
				stat = conn.createStatement();
				
				rs = stat.executeQuery(sql);
				
				while(rs.next()){
					Ordero ordero = new Ordero();
					ordero.setOrderid(rs.getInt(1));
					ordero.setOrdername(rs.getString(2));
					ordero.setProductid(rs.getInt(3));
					ordero.setNumber(rs.getInt(4));
					ordero.setUserid(rs.getInt(5));
					ordero.setUserjudge(rs.getString(6));
					ordero.setCreatetime(rs.getDate(7));
					ordero.setIsdelorder(rs.getInt(8));
					ordero.setRemark(rs.getNString(9));
					
					orderos.add(ordero);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return orderos;
	}

	@Override
	public Ordero findOrderoById(int orderid) {
		Ordero ordero = new Ordero();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			
			stat = conn.prepareStatement("select * from ordero where orderid=?");
			stat.setInt(1, orderid);
			
			rs = stat.executeQuery();
			while(rs.next()){
				ordero.setOrderid(orderid);
				ordero.setOrdername(rs.getString(2));
				ordero.setProductid(rs.getInt(3));
				ordero.setNumber(rs.getInt(4));
				ordero.setUserid(rs.getInt(5));
				ordero.setUserjudge(rs.getString(6));
				ordero.setCreatetime(rs.getDate(7));
				ordero.setIsdelorder(rs.getInt(8));
				ordero.setRemark(rs.getNString(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, rs);
		}
		return ordero;
	}

	@Override
	public void deleteOrderoById(int orderid) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();

			String sql = "delete from ordero where orderid="+orderid;
			System.out.println("sql:" + sql);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}

	}

	@Override
	public void updateOrdero(Ordero ordero) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			
			conn = JDBCUtil.getConn();
		
			String sql = "update ordero set ordername=?,productid=?,number=?,userid=?,userjudge=?,createtime=?,isdelorder=?,remark=? where orderid=?";
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, ordero.getOrdername());
			stat.setInt(2, ordero.getProductid());
			stat.setInt(3, ordero.getNumber());
			stat.setInt(4, ordero.getUserid());
			stat.setString(5, ordero.getUserjudge());
			stat.setDate(6,ordero.getCreatetime());
			stat.setInt(7,ordero.getIsdelorder());
			stat.setString(8, ordero.getRemark());
			stat.setInt(9, ordero.getOrderid());
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
		

	}

	
	public List<Ordero> findOrderByDate(Date date1, Date date2) {
		List<Ordero> orderos = new ArrayList<Ordero>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "SELECT * FROM ordero WHERE createtime>=" +"'"+date1+"'"+" AND createtime<="+"'" +date2+ "'"+" ORDER BY createtime";
			System.out.println(sql);
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				Ordero ordero = new Ordero();
				ordero.setOrderid(rs.getInt(1));
				ordero.setOrdername(rs.getString(2));
				ordero.setProductid(rs.getInt(3));
				ordero.setNumber(rs.getInt(4));
				ordero.setUserid(rs.getInt(5));
				ordero.setUserjudge(rs.getString(6));
				ordero.setCreatetime(rs.getDate(7));
				ordero.setIsdelorder(rs.getInt(8));
				ordero.setRemark(rs.getNString(9));
				orderos.add(ordero);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderos;
	}

	@Override
	public void deleteOrderoByProductId(String id) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();

			String sql = "delete from ordero where productid = " + id;
			System.out.println("sql:" + sql);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}

		
	}

	@Override
	public void deleteOrderoByKindId(String id) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();

			String sql = "delete from ordero where productid in (select productid from product where classid = " + id + ")";
			System.out.println("sql:" + sql);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}

		
	}

	@Override
	public void deleteOrderoByUserId(String id) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "delete from ordero where userid=" + id;
			System.out.println("sql:" + sql);
			
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
		
	}

}
