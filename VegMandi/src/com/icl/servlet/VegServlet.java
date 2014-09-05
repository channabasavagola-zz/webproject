package com.icl.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icl.bean.LoginBean;
import com.icl.bean.RWBean;
import com.icl.bean.UserinfoBean;
import com.icl.handler.VegHandler;

public class VegServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		String handler=req.getParameter("handler");	  
		String action=req.getParameter("action");


		if(handler.equals("vegmgmt")){	
			
			
			if(action.equals("getfeedbackpage")){
				getfeedbackpage(req,resp);
			}
			if(action.equals("getindexpage")){
				getindexpage(req,resp);
			}	
			if(action.equals("getaboutpage")){
				getaboutpage(req,resp);
			}	
			if(action.equals("getcontactpage")){
				getcontactpage(req,resp);
			}	

			if(action.equals("verifyLogin")){
				verifyLogin(req,resp);
			}
			if(action.equals("getregpage")){
				getregpage(req,resp);
			}
			if(action.equals("insert")){
				insertUser(req,resp);
			}
			if(action.equals("insertPrice")){

				insertPrice(req,resp);
			}

			if(action.equals("viewPrevious")){

				viewPrevious(req,resp);
			}
			if(action.equals("insertPage")){
				insertPage(req,resp);
			}
			if(action.equals("statusupdate")){
				statusupdate(req,resp);
			}
			if(action.equals("approveUser")){
				approveUser(req,resp);
			}
			if(action.equals("feedbackDetails")){
				feedbackDetails(req,resp);
			}
			if(action.equals("todaysrates")){

				try {
					todaysRates(req,resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(action.equals("knowRates")){
				try {
					getAllrates(req,resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(action.equals("knowbestRetailer")){
				try {
					knowbestRetailer(req,resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}



	}

	public void getindexpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		LoginBean logBean= new LoginBean();
		RequestDispatcher rd= null;	
		req.setAttribute("logBean",new LoginBean());			
		rd=getServletContext().getRequestDispatcher("/index.jsp");	
		rd.forward(req, resp);	 
	}

	public void getaboutpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;				
		rd=getServletContext().getRequestDispatcher("/about.jsp");	
		rd.forward(req, resp);	 
	}

	public void getfeedbackpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;				
		rd=getServletContext().getRequestDispatcher("/feedback.jsp");	
		rd.forward(req, resp);	 
	}
	public void getcontactpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;				
		rd=getServletContext().getRequestDispatcher("/contact.jsp");	
		rd.forward(req, resp);	 
	}

	public void verifyLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;
		VegHandler vegHandler = new VegHandler();
		LoginBean logBean =vegHandler.verifyLogin(req, resp);

		System.out.println("logBean.getStatus() "+logBean.getStatus());

		if(logBean.getErrorFlag()==0 || logBean.getStatus()==0){
			req.setAttribute("logBean",logBean);			
			rd=getServletContext().getRequestDispatcher("/index.jsp");
		}else{

			vegHandler = new VegHandler();
			req.setAttribute("logBean",logBean);	

			ArrayList vegList=vegHandler.getAllVegetable(req, resp);
			req.setAttribute("vegList",vegList);

			ArrayList regList=vegHandler.getAllRegion(req, resp);
			req.setAttribute("regList",regList);

			rd=getServletContext().getRequestDispatcher("/update.jsp");
		}
		rd.forward(req, resp);	 
	}

	public void getregpage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;		
		VegHandler vegHandler = new VegHandler();


		ArrayList userList=vegHandler.getAllUser(req, resp);
		req.setAttribute("userList",userList);

		ArrayList regList=vegHandler.getAllRegion(req, resp);
		req.setAttribute("regList",regList);

		rd=getServletContext().getRequestDispatcher("/login.jsp");	 
		rd.forward(req, resp);	 
	}
	public void insertUser(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		UserinfoBean  userBean=  vegHandler.insertUser(req, resp);
		req.setAttribute("userBean",userBean);

		rd=getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);	 
	}

	public void insertPrice(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		String userID = req.getParameter("userID");
		req.setAttribute("userID",userID);

		String userName = req.getParameter("userName");
		req.setAttribute("userName",userName);

		RWBean  rwBean=  vegHandler.insertPrice(req, resp);
		req.setAttribute("rwBean",rwBean);


		ArrayList pricedetailsList=vegHandler.getAllPriceDetails(req, resp);
		req.setAttribute("pricedetailsList",pricedetailsList);

		rd=getServletContext().getRequestDispatcher("/rwdisplay.jsp");
		rd.forward(req, resp);	 
	}
	public void feedbackDetails(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{

		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		vegHandler.feedbackDetails(req, resp);
	
		rd=getServletContext().getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);	 
	}
	public void viewPrevious(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		String userID = req.getParameter("userID");
		String userName = req.getParameter("userName");

		req.setAttribute("userID",userID);
		req.setAttribute("userName",userName);

		ArrayList pricedetailsList=vegHandler.getAllPriceDetails(req, resp);
		req.setAttribute("pricedetailsList",pricedetailsList);

		rd=getServletContext().getRequestDispatcher("/rwdisplay.jsp");
		rd.forward(req, resp);	 
	}

	public void insertPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();
		LoginBean logBean= new LoginBean();
		String userID=req.getParameter("userID");
		int uid=Integer.parseInt(userID);
		logBean.setUserid(uid);
		String userName=req.getParameter("userName");
		logBean.setLoginname(userName);


		ArrayList vegList=vegHandler.getAllVegetable(req, resp);
		req.setAttribute("vegList",vegList);		
		req.setAttribute("logBean",logBean);
		rd=getServletContext().getRequestDispatcher("/update.jsp");
		rd.forward(req, resp);	 
	}


	public void getAllrates(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		ArrayList knowratesList=vegHandler.getAllrates(req, resp);
		req.setAttribute("knowratesList",knowratesList);

		rd=getServletContext().getRequestDispatcher("/knowrates.jsp");
		rd.forward(req, resp);	 
	}

	public void knowbestRetailer(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		UserinfoBean uiBean=vegHandler.knowbestRetailer(req, resp);
		req.setAttribute("uiBean",uiBean);
		System.out.println(1);
		rd=getServletContext().getRequestDispatcher("/knowbestretailer.jsp");
		rd.forward(req, resp);	 
	}

	public void statusupdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;		
		VegHandler vegHandler = new VegHandler();

		ArrayList retailerList=vegHandler.getAllRetailer(req, resp);
		req.setAttribute("retailerList",retailerList);

		ArrayList civilianList=vegHandler.getAllCivilians(req, resp);
		req.setAttribute("civilianList",civilianList);

		ArrayList wholesellerList=vegHandler.getAllWholesellers(req, resp);
		req.setAttribute("wholesellerList",wholesellerList);



		rd=getServletContext().getRequestDispatcher("/statusupdate.jsp");	 
		rd.forward(req, resp);	 
	}

	public void approveUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		RequestDispatcher rd= null;		
		VegHandler vegHandler = new VegHandler();

		vegHandler.approveUser(req, resp);

		ArrayList retailerList=vegHandler.getAllRetailer(req, resp);
		req.setAttribute("retailerList",retailerList);

		ArrayList civilianList=vegHandler.getAllCivilians(req, resp);
		req.setAttribute("civilianList",civilianList);

		ArrayList wholesellerList=vegHandler.getAllWholesellers(req, resp);
		req.setAttribute("wholesellerList",wholesellerList);



		rd=getServletContext().getRequestDispatcher("/statusupdate.jsp");	 
		rd.forward(req, resp);	 
	}

	public void todaysRates(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException, SQLException{
		RequestDispatcher rd= null;	
		VegHandler vegHandler = new VegHandler();

		ArrayList todayratesList=vegHandler.todaysRates(req, resp);
		req.setAttribute("todayratesList",todayratesList);

		rd=getServletContext().getRequestDispatcher("/pricetoday.jsp");
		rd.forward(req, resp);	 
	}


}
