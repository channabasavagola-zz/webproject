package com.icl.bean;

public class RWBean {

	int vegid = 0;
	int regid = 0;
	String regionname = "";
	int price = 0;
	int quantity = 0;
	String date ="";
	int userid = 0;
	int usertypeid = 0;
	String username = "";
	int MessageFlag = 0;
	String Message = "";
	String vegname = "";

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRegid() {
		return regid;
	}
	public void setRegid(int regid) {
		this.regid = regid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getVegid() {
		return vegid;
	}
	public void setVegid(int vegid) {
		this.vegid = vegid;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public int getMessageFlag() {
		return MessageFlag;
	}
	public void setMessageFlag(int messageFlag) {
		MessageFlag = messageFlag;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getVegname() {
		return vegname;
	}
	public void setVegname(String vegname) {
		this.vegname = vegname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	public int getUsertypeid() {
		return usertypeid;
	}
	public void setUsertypeid(int usertypeid) {
		this.usertypeid = usertypeid;
	}


}
