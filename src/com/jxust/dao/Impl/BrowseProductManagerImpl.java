package com.jxust.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.BrowseProductManager;
import com.jxust.entity.BrowseProduct;

/**
 * @author shymain
 *
 */
public class BrowseProductManagerImpl implements BrowseProductManager {

	@Override
	public List<BrowseProduct> findAllBrowseProduct() {
		
			List<BrowseProduct> list=new ArrayList<BrowseProduct>();
			Connection connection=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			connection=JDBCUtil.getConn();
			try {
				stmt=connection.prepareStatement("Select * from browseproduct");
				rs=stmt.executeQuery();
				while(rs.next()){
					BrowseProduct browseProduct =new BrowseProduct();
					browseProduct.setBrowseproductid(rs.getInt(1));
					browseProduct.setBrowseproductname(rs.getString(2));
					browseProduct.setProductid(rs.getInt(3));
					browseProduct.setClassid(rs.getInt(4));
					browseProduct.setPopularity(rs.getInt(5));
					browseProduct.setHotsale(rs.getInt(6));
					browseProduct.setKeywords(rs.getString(7));
					browseProduct.setRemark(rs.getString(8));
					browseProduct.setPicture(rs.getString(9));
					
					list.add(browseProduct);
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
	public void addBrowseProduct(BrowseProduct browseProduct) {
		Connection conn=null;
		Statement stmt=null;
		//获取数据库连接
		conn=JDBCUtil.getConn();
		
		String sql="insert into browseproduct(browseproductid,browseproductname,productid,classid,popularity,hotsale,keywords,picture,remark) "
				+ "values('"+browseProduct.getBrowseproductid()+"','"+browseProduct.getBrowseproductname()+"','"+browseProduct.getProductid()
				+"','"+browseProduct.getClassid()+"','"+browseProduct.getPopularity()+"','"+browseProduct.getHotsale()+"','"+browseProduct.getKeywords()
				+"','"+browseProduct.getPicture()+"','"+browseProduct.getRemark()+"')";
		System.out.println(sql);
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
	public void deleteBrowseProductById(int id) {
		Connection conn =null;
		Statement stmt =null;
		conn = JDBCUtil.getConn();
		try {
			String sql ="delete from browseproduct where browseproductid="+id;
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
	public BrowseProduct findBrowseProductById(int id) {
		
			BrowseProduct browseProduct =new BrowseProduct();
			Connection conn=null;
			PreparedStatement stmt =null;
			ResultSet rs =null;
			conn =JDBCUtil.getConn();
			try {
				stmt =conn.prepareStatement("select * from browseproduct where browseproductid=?");
				stmt.setInt(1,id);
				rs=stmt.executeQuery();
				
				while(rs.next()){
					browseProduct.setBrowseproductid(rs.getInt(1));
					browseProduct.setBrowseproductname(rs.getString(2));
					browseProduct.setProductid(rs.getInt(3));
					browseProduct.setClassid(rs.getInt(4));
					browseProduct.setPopularity(rs.getInt(5));
					browseProduct.setHotsale(rs.getInt(6));
					browseProduct.setKeywords(rs.getString(7));
					browseProduct.setPicture(rs.getString(9));
					browseProduct.setRemark(rs.getString(8));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil.closeDB(conn, stmt, null);
			}
			return browseProduct;
	}


	@Override
	public void updateBrowseProduct(BrowseProduct browseProduct) {

		Connection conn=null;
		PreparedStatement stmt=null;
		conn=JDBCUtil.getConn();
		try {
			stmt=conn.prepareStatement("update browseproduct set browseproductname='"+browseProduct.getBrowseproductname()+"',productid='"
					+browseProduct.getProductid()+"',classid='"+browseProduct.getClassid()+"',popularity='"+browseProduct.getPopularity()
					+"',hotsale='"+browseProduct.getHotsale()+"',picture='"+browseProduct.getPicture()+"',keywords='"+browseProduct.getKeywords()
					+"',remark='"+browseProduct.getRemark()
					+"'where browseproductid='"+browseProduct.getBrowseproductid()+"'");
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
