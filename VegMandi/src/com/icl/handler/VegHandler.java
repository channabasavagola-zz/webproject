package com.icl.handler;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icl.bean.FeedbackBean;
import com.icl.bean.LoginBean;
import com.icl.bean.RWBean;
import com.icl.bean.RegionBean;
import com.icl.bean.UserinfoBean;
import com.icl.database.VegDb;
import java.util.StringTokenizer;

public class VegHandler {
	public LoginBean verifyLogin(HttpServletRequest req, HttpServletResponse resp){
		LoginBean logBean = new LoginBean();

		String loginame=req.getParameter("login");
		String password=req.getParameter("password");

		logBean.setLoginname(loginame);
		logBean.setPassword(password);

		VegDb  vegDb= new VegDb();
		logBean =vegDb.verifyLogin(logBean);


		return logBean;	
	}

	public ArrayList getAllUser(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList userList=vegDb.getAllUser();
		return userList;

	}	

	public ArrayList getAllRegion(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList regList=vegDb.getAllRegion();
		return regList;

	}	

	public ArrayList getAllVegetable(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList vegList=vegDb.getAllVegetable();
		return vegList;

	}	

	public UserinfoBean insertUser(HttpServletRequest req, HttpServletResponse resp){

		UserinfoBean userBean = new UserinfoBean();	
		LoginBean logBean = new LoginBean();


		String logname=req.getParameter("loginname");	
		String password=req.getParameter("password");		
		String firstname=req.getParameter("username");	
		String address=req.getParameter("address");
		String phone=req.getParameter("phone");
		int phoneno=Integer.parseInt(phone);
		String emailid=req.getParameter("email");
		String regionid=req.getParameter("region");
		int regionno=Integer.parseInt(regionid);
		String usertype=req.getParameter("usertype");
		int usertypeno=Integer.parseInt(usertype);

		logBean.setLoginname(logname);
		logBean.setPassword(password);
		logBean.setUsertypeID(usertypeno);

		userBean.setUsername(firstname);
		userBean.setAddress(address);
		userBean.setPhone(phoneno);
		userBean.setEmail(emailid);
		userBean.setRegionid(regionno);

		VegDb  vegDb= new VegDb();
		userBean=vegDb.insertUser(logBean, userBean);

		return userBean;
	}
	
	public void feedbackDetails(HttpServletRequest req, HttpServletResponse resp){

		FeedbackBean fBean = new FeedbackBean();	
	
		String name=req.getParameter("loginname");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String Feedback=req.getParameter("Feedback");
		
		fBean.setAddress(address);
	
		fBean.setName(name);
		fBean.setEmailid(email);
		fBean.setFeedback(Feedback);
		fBean.setPhoneno(phone);
		
		VegDb  vegDb= new VegDb();
		vegDb.feedbackDetails(fBean);
	}

	public RWBean insertPrice(HttpServletRequest req, HttpServletResponse resp){

		RWBean rwBean = new RWBean();	
		LoginBean logBean = new LoginBean();

		String date1=req.getParameter("date");	




		String str = date1;

		String day="",month="",year="";
		StringTokenizer st2 = new StringTokenizer(str, "-");

		while (st2.hasMoreElements()) {
			day=st2.nextToken();
			month=st2.nextToken();
			year=st2.nextToken();
			System.out.println("date one"+year+"-"+month+"-"+day);
		}
		if(month.equals("JAN")){
			month="01";
		}else if(month.equals("FEB")){
			month="02";
		}else if(month.equals("MAR")){
			month="03";
		}else if(month.equals("APR")){
			month="04";
		}else if(month.equals("MAY")){
			month="05";
		}else if(month.equals("JUN")){
			month="06";
		}else if(month.equals("JUL")){
			month="07";
		}else if(month.equals("AUG")){
			month="08";
		}else if(month.equals("SEP")){
			month="09";
		}else if(month.equals("OCT")){
			month="10";
		}else if(month.equals("NOV")){
			month="11";
		}else if(month.equals("DEC")){
			month="12";
		}

		String date=year+"-"+month+"-"+day;
		System.out.println("date="+date);

		String price=req.getParameter("price");	
		int price1=Integer.parseInt(price);
		String quantity=req.getParameter("quantity");
		int quantity1=Integer.parseInt(quantity);
		String veg=req.getParameter("vege");
		int vegno=Integer.parseInt(veg);

		String userid=req.getParameter("userID");
		int uid=Integer.parseInt(userid);


		rwBean.setDate(date);
		rwBean.setPrice(price1);
		rwBean.setQuantity(quantity1);
		rwBean.setVegid(vegno);

		logBean.setUserid(uid);
		System.out.println("User id : "+uid);
		VegDb  vegDb= new VegDb();
		rwBean=vegDb.insertPrice(rwBean, logBean);

		return rwBean;
	}

	public ArrayList getAllPriceDetails(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();
		String userid=req.getParameter("userID");
		System.out.println("userid view price = " + userid);
		ArrayList rwList=vegDb.getAllPriceDetails(userid);
		return rwList;

	}	


	public ArrayList getAllrates(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		VegDb  vegDb= new VegDb();

		String vege = req.getParameter("vege");
		String region = req.getParameter("region");
		String date1=req.getParameter("date");	

		String str = date1;

		String day="",month="",year="";
		StringTokenizer st2 = new StringTokenizer(str, "-");

		while (st2.hasMoreElements()) {
			day=st2.nextToken();
			month=st2.nextToken();
			year=st2.nextToken();

		}
		if(month.equals("JAN")){
			month="01";
		}else if(month.equals("FEB")){
			month="02";
		}else if(month.equals("MAR")){
			month="03";
		}else if(month.equals("APR")){
			month="04";
		}else if(month.equals("MAY")){
			month="05";
		}else if(month.equals("JUN")){
			month="06";
		}else if(month.equals("JUL")){
			month="07";
		}else if(month.equals("AUG")){
			month="08";
		}else if(month.equals("SEP")){
			month="09";
		}else if(month.equals("OCT")){
			month="10";
		}else if(month.equals("NOV")){
			month="11";
		}else if(month.equals("DEC")){
			month="12";
		}

		String date=year+"-"+month+"-"+day;

		req.setAttribute("vege",vege);
		req.setAttribute("region",region);
		req.setAttribute("date",date);




		ArrayList knowratesList=vegDb.getAllrates(vege,region,date);
		return knowratesList;

	}	


	public UserinfoBean knowbestRetailer(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		VegDb  vegDb= new VegDb();

		String vege = req.getParameter("vege");
		String region = req.getParameter("region");
		String date1=req.getParameter("date");	

		String str = date1;

		String day="",month="",year="";
		StringTokenizer st2 = new StringTokenizer(str, "-");

		while (st2.hasMoreElements()) {
			day=st2.nextToken();
			month=st2.nextToken();
			year=st2.nextToken();

		}
		if(month.equals("JAN")){
			month="01";
		}else if(month.equals("FEB")){
			month="02";
		}else if(month.equals("MAR")){
			month="03";
		}else if(month.equals("APR")){
			month="04";
		}else if(month.equals("MAY")){
			month="05";
		}else if(month.equals("JUN")){
			month="06";
		}else if(month.equals("JUL")){
			month="07";
		}else if(month.equals("AUG")){
			month="08";
		}else if(month.equals("SEP")){
			month="09";
		}else if(month.equals("OCT")){
			month="10";
		}else if(month.equals("NOV")){
			month="11";
		}else if(month.equals("DEC")){
			month="12";
		}

		String date=year+"-"+month+"-"+day;

		req.setAttribute("vege",vege);
		req.setAttribute("region",region);
		req.setAttribute("date",date);


		System.out.println(2);

		UserinfoBean uiBean=vegDb.knowbestRetailer(vege,region,date);
		return uiBean;

	}	

	public ArrayList getAllRetailer(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList retailerList=vegDb.getAllRetailer();
		return retailerList;

	}	
	public ArrayList getAllCivilians(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList civilianList=vegDb.getAllCivilians();
		return civilianList;

	}	
	public ArrayList getAllWholesellers(HttpServletRequest req, HttpServletResponse resp)
	{
		VegDb  vegDb= new VegDb();

		ArrayList wholesellerList=vegDb.getAllWholesellers();
		return wholesellerList;

	}
	public void approveUser(HttpServletRequest req, HttpServletResponse resp){

		String[] userarry=req.getParameterValues("uid");

		VegDb  vegDb= new VegDb();
		vegDb.approveUser(userarry);



	}
	public ArrayList todaysRates(HttpServletRequest req, HttpServletResponse resp) throws SQLException
	{
		VegDb  vegDb= new VegDb();
		ArrayList todayratesList=vegDb.todaysRates();
		return todayratesList;

	}	


}
