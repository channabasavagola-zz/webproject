package com.icl.bean;

public class LoginBean {
	String loginname = "";
	String password = "";
	int usertypeID = 0;
	int ErrorFlag = 0;
	String ErrorMessage = "";
	int userid = 0;
	int status = 0;
	String statusmessage = "";

	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getErrorFlag() {
		return ErrorFlag;
	}
	public void setErrorFlag(int errorFlag) {
		ErrorFlag = errorFlag;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public int getUsertypeID() {
		return usertypeID;
	}
	public void setUsertypeID(int usertypeID) {
		this.usertypeID = usertypeID;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusmessage() {
		return statusmessage;
	}
	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

}
