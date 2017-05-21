package com.jxust.dao;

import java.sql.Date;
import java.util.List;

import com.jxust.entity.Ordero;
public interface OrderoManager {
	public List<Ordero> findAllOrdero();
	
	public List<Ordero> findOrderByDate(Date date1,Date date2);
	public Ordero findOrderoById(int orderid);
	
	public void deleteOrderoById(int orderid);
	
	public void updateOrdero(Ordero ordero);

	/**
	 * 根据产品删除订单
	 * @param id
	 */
	public void deleteOrderoByProductId(String id);
	
	/**
	 * 根据类别删除订单
	 * 当删除类别时，删除相应的产品，从而删除相应的订单
	 * @param id
	 */
	public void deleteOrderoByKindId(String id);

	/**
	 * 根据用户id删除订单
	 * @param id
	 */
	public void deleteOrderoByUserId(String id);
}
