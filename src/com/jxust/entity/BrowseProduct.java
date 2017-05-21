package com.jxust.entity;

/**
 * @author shymain
 *
 */
public class BrowseProduct {
	
	/**
	 * 产品图片
	 */
	private String picture;
	/**
	 * 浏览产品id
	 */
	private int browseproductid;
	/**
	 * 浏览产品名
	 */
	private String browseproductname;
	/**
	 * 产品id
	 */
	private int productid;
	/**
	 * 类别id
	 */
	private int classid;
	/**
	 * 人气指数
	 */
	private int popularity;
	/**
	 * 热销指数
	 */
	private int hotsale;
	/**
	 * 模糊查询关键字
	 */
	private String keywords;
	/**
	 * 说明
	 */
	private String remark;
	
	public int getBrowseproductid() {
		return browseproductid;
	}
	public void setBrowseproductid(int browseproductid) {
		this.browseproductid = browseproductid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public int getHotsale() {
		return hotsale;
	}
	public void setHotsale(int hotsale) {
		this.hotsale = hotsale;
	}
	
	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBrowseproductname() {
		return browseproductname;
	}
	public void setBrowseproductname(String browseproductname) {
		this.browseproductname = browseproductname;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "BrowseProduct [picture=" + picture + ", browseproductid="
				+ browseproductid + ", browseproductname=" + browseproductname
				+ ", productid=" + productid + ", classid=" + classid
				+ ", popularity=" + popularity + ", hotsale=" + hotsale
				+ ", keywords=" + keywords + ", remark=" + remark + "]";
	}
	
	
	
}
