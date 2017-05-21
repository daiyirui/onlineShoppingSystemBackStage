package com.jxust.entity;


/**
 * @author shymain
 *
 */
public class Shoppingcar {
	
	private int shoppingcartid;
	
	
	private int productid;
	
	
	private int userid;
	

	private String remark;

	public int getShoppingcartid() {
		return shoppingcartid;
	}

	public void setShoppingcartid(int shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Shoppingcar [shoppingcartid=" + shoppingcartid + ", productid="
				+ productid + ", userid=" + userid + ", remark=" + remark + "]";
	}
	
	
}
