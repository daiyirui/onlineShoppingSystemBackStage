package com.jxust.entity;


/**
 * 
 * @author shymain
 *
 */
public class Kind{
	
	private int classid;
	
	
	private String classname;
	

	private String remark;


	public int getClassid() {
		return classid;
	}


	public void setClassid(int classid) {
		this.classid = classid;
	}


	public String getClassname() {
		return classname;
	}


	public void setClassname(String classname) {
		this.classname = classname;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public String toString() {
		return "Class [classid=" + classid + ", classname=" + classname
				+ ", remark=" + remark + "]";
	}

	
	
	
}
