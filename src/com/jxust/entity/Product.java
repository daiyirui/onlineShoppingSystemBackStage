package com.jxust.entity;

/**
 * @author shymain
 *
 */
public class Product {
	
	private int productid;		
	
	
	private String productname;	
	
	
	private double price;
	
	
	private int number;			
	

	private String quality;		
	
	
	private String picture;		
	
	
	private int classid;		
	
	
	private String remark;
	
	private String discount;
	private int tradenumber;
	private int evaluatenumber;
	
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public int getTradenumber() {
		return tradenumber;
	}

	public void setTradenumber(int tradenumber) {
		this.tradenumber = tradenumber;
	}

	public int getEvaluatenumber() {
		return evaluatenumber;
	}

	public void setEvaluatenumber(int evaluatenumber) {
		this.evaluatenumber = evaluatenumber;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname="
				+ productname + ", price=" + price + ", number=" + number
				+ ", quality=" + quality + ", picture=" + picture
				+ ", classid=" + classid + ", remark=" + remark + "]";
	}


		
}
