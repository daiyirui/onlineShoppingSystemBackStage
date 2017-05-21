package com.jxust.entity;

import java.sql.Date;

/**
 * @author shymain
 *
 */
public class Ordero {

	private int orderid;
	

	private  String ordername;
	

	private String userjudge;
	

	private int productid;
	
	private Date createtime;
	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	private int number;
	
	private int userid;
	
	private int isdelorder;
	
	
	private String remark;


	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public String getOrdername() {
		return ordername;
	}


	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}


	public String getUserjudge() {
		return userjudge;
	}


	public void setUserjudge(String userjudge) {
		this.userjudge = userjudge;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getIsdelorder() {
		return isdelorder;
	}


	public void setIsdelorder(int isdelorder) {
		this.isdelorder = isdelorder;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Order [orderid=" + orderid + ", ordername=" + ordername
				+ ", userjudge=" + userjudge + ", productid=" + productid
				+ ", number=" + number + ", userid=" + userid + ", isdelorder="
				+ isdelorder + ", remark=" + remark + "]";
	}


	
	
	
}
