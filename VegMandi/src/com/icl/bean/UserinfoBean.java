package com.icl.bean;

public class UserinfoBean {

	int userid = 0;
	String Username = "";
	int Phone= 0;
	String Email = "";
	String Address = "";
	int Regionid = 0;
	String Regionname = "";
	int UsertypeID = 0;
	int MessageFlag = 0;
	String Message ="";
	String vegetablename = "";

	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public int getRegionid() {
		return Regionid;
	}
	public void setRegionid(int regionid) {
		Regionid = regionid;
	}

	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getRegionname() {
		return Regionname;
	}
	public void setRegionname(String regionname) {
		Regionname = regionname;
	}
	public int getUsertypeID() {
		return UsertypeID;
	}
	public void setUsertypeID(int usertypeID) {
		UsertypeID = usertypeID;
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
	public String getVegetablename() {
		return vegetablename;
	}
	public void setVegetablename(String vegetablename) {
		this.vegetablename = vegetablename;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
