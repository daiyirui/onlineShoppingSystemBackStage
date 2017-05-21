package com.jxust.dao.Impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jxust.commons.JDBCUtil;
import com.jxust.dao.ProductManager;
import com.jxust.entity.Product;


public class ProductManagerImpl implements ProductManager {

	@Override
	public List<Product> findAllProduct() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "select * from product";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				Product product = new Product();
				product.setProductid(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setClassid(rs.getInt(3));
				product.setPrice(rs.getDouble(4));
				product.setNumber(rs.getInt(5));
				product.setPicture(rs.getString(6));
				product.setRemark(rs.getNString(7));
				product.setDiscount(rs.getString(8));
				product.setTradenumber(rs.getInt(9));
				product.setEvaluatenumber(rs.getInt(10));
				products.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
		}
	
	
	public void addProduct(Product product) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();
			String sql = "insert into product(productname,classid,price,number,picture,remark,discount,tradenumber,evaluatenumber) "
					+ "values('" + product.getProductname() + "','" + product.getClassid() + "','"
					+ product.getPrice() + "','" + product.getNumber() + "','"
					+ product.getPicture() + "','" + product.getRemark() + "','"
					+ product.getDiscount() + "','"
					+ product.getTradenumber() + "','" + product.getEvaluatenumber() + "')";
			
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
	public Product findProductById(int productid) {
		Product product = new Product();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtil.getConn();
			
			
			stat = conn.prepareStatement("select * from product where productid=?");
	
			stat.setInt(1, productid);
			
		
			rs = stat.executeQuery();
			
		
			while(rs.next()){
				product.setProductid(productid);
				product.setProductname(rs.getString(2));
				product.setClassid(rs.getInt(3));
				product.setPrice(rs.getDouble(4));
				product.setNumber(rs.getInt(5));
				product.setPicture(rs.getString(6));
				product.setRemark(rs.getNString(7));
				product.setDiscount(rs.getString(8));
				product.setTradenumber(rs.getInt(9));
				product.setEvaluatenumber(rs.getInt(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, rs);
		}
		return product;
	}

	@Override
	public void deleteProductById(int productid) {
		Connection conn = null;
		Statement stat = null;
		try {
			
			conn = JDBCUtil.getConn();

			
			String sql = "delete from product where productid= "+productid;
			
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
	public void updateProduct(Product product) {
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			
			conn = JDBCUtil.getConn();

		
			String sql = "update product set productname=?,classid=?,price=?,number=?,picture=?,remark=?,discount=?,tradenumber=?,evaluatenumber=? where productid=?";
			
			stat = conn.prepareStatement(sql);
			stat.setString(1, product.getProductname());
			stat.setInt(2, product.getClassid());
			stat.setDouble(3, product.getPrice());
			stat.setInt(4, product.getNumber());
			stat.setString(5, product.getPicture());
			stat.setString(6, product.getRemark());
			stat.setString(7, product.getDiscount());
			stat.setInt(8, product.getTradenumber());
			stat.setInt(9, product.getEvaluatenumber());
			stat.setInt(10, product.getProductid());
			
			stat.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.closeDB(conn, stat, null);
		}
		
	}


	@Override
	public void deleteProductByKindId(String id) {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtil.getConn();
			
			String sql = "delete from product where classid="+id;
			
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


