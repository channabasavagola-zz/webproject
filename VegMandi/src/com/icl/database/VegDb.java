package com.icl.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.ws.profile.anttasks.GetStringRegExpAntTask;
import com.icl.bean.FeedbackBean;
import com.icl.bean.LoginBean;
import com.icl.bean.RWBean;
import com.icl.bean.RegionBean;
import com.icl.bean.UserinfoBean;
import com.icl.bean.UsertypeBean;
import com.icl.bean.VegBean;



public class VegDb {

	Connection con= null;
	private Connection getConnection(){

		Connection con=null;	
		try{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con=DriverManager.getConnection("jdbc:db2:EMANDI", "db2admin","icl13");
			System.out.println("con = " + con);
		}	
		catch(ClassNotFoundException e){
			System.out.println(e);
		}
		catch(SQLException e){
			System.out.println(e);
		}

		return con;	
	}

	public LoginBean verifyLogin(LoginBean logBean){
		con=getConnection();
		Statement stmt= null;
		try {  
			stmt=con.createStatement();
			System.out.println("check point before verifying");
			String maxQuery="select count(userid) from login_t where loginname='"+logBean.getLoginname()+"' and password='"+logBean.getPassword()+"'";
			ResultSet rs=stmt.executeQuery(maxQuery);
			System.out.println("check point after verifying");
			int flag=0;	

			while(rs.next()){						
				flag=rs.getInt(1);	
			}

			if(flag==0){
				logBean.setErrorFlag(0)	;
				logBean.setErrorMessage("User Not Exist");
			}else{
				String maxQuery1="select userid,usertypeid from login_t where loginname='"+logBean.getLoginname()+"'";
				ResultSet rs1=stmt.executeQuery(maxQuery1);
				int userID=0, 
				userTypeID=0;

				while(rs1.next()){						
					userID=rs1.getInt(1);
					userTypeID=rs1.getInt(2);

				}
				logBean.setUserid(userID);
				logBean.setUsertypeID(userTypeID);
				logBean.setErrorFlag(1)	;
				System.out.println("userID "+userID);
				String maxQuery2="select status from user_t where userid="+userID+"";
				ResultSet rs2=stmt.executeQuery(maxQuery2);

				int status = 0;
				while(rs2.next()){
					status=rs2.getInt(1);
				}
				System.out.println("status "+status);
				logBean.setStatus(status);
				if(status==0){
					logBean.setStatusmessage("Unauthorised !");
				}
			}
			stmt.close();
			con.close();

		} 
		catch (SQLException e) {			
			e.printStackTrace();
		}

		return logBean;	
	}

	public UserinfoBean insertUser(LoginBean logBean,UserinfoBean userBean){

		con=getConnection();
		Statement stmt= null;


		try {   	

			stmt=con.createStatement();
			System.out.println("check point before max userid");
			String maxQuery="select max(userid) from login_t";
			ResultSet rs=stmt.executeQuery(maxQuery);
			System.out.println("check point after max userid");
			int userid=0;	
			while(rs.next()){						
				userid=rs.getInt(1);			

			}

			int uid=userid+1;
			System.out.println("check point in insert user before logquery");
			String logQuery="insert into login_t values("+uid+",'"+logBean.getLoginname()+"','"+logBean.getPassword()+"',"+logBean.getUsertypeID()+")";
			stmt.execute(logQuery);
			System.out.println("check point in insert user after logquery");
			String stdQuery="insert into user_t values("+uid+",'"+userBean.getUsername()+"','"+userBean.getEmail()+"','"+userBean.getAddress()+"',"+userBean.getPhone()+","+0+","+userBean.getRegionid()+")";
			stmt.execute(stdQuery);
			stmt.close();
			con.close();

			userBean.setMessageFlag(1);
			userBean.setMessage("User Successfully Registered");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return userBean;	
	}
	
	public void feedbackDetails(FeedbackBean fBean){

		con=getConnection();
		Statement stmt= null;


		try {   	
			System.out.println("check point before insert");
			stmt=con.createStatement();
			
			String feedQuery="insert into feeback_t values('"+fBean.getName()+"','"+fBean.getPhoneno()+"','"+fBean.getEmailid()+"','"+fBean.getAddress()+"','"+fBean.getFeedback()+"')";
			stmt.execute(feedQuery);
		
			stmt.close();
			con.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList getAllUser(){

		con=getConnection();
		Statement stmt= null;
		ArrayList userList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getalluser="select usertypeid,usertype from usertype_t";
			ResultSet rs=stmt.executeQuery(getalluser);
			while(rs.next()){
				UsertypeBean ubean= new UsertypeBean();
				int uid=rs.getInt("usertypeid");
				ubean.setUsertypeId(uid);
				String uname=rs.getString("usertype");
				ubean.setUserType(uname);
				userList.add(ubean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 userList;

	}

	public ArrayList getAllVegetable(){

		con=getConnection();
		Statement stmt= null;
		ArrayList vegList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallvegetable="select vegid,vegname from veg_t";
			ResultSet rs=stmt.executeQuery(getallvegetable);
			while(rs.next()){
				VegBean vbean= new VegBean();
				int vid=rs.getInt("vegid");
				vbean.setVegid(vid);
				String vname=rs.getString("vegname");
				vbean.setVegname(vname);
				vegList.add(vbean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 vegList;

	}



	public ArrayList getAllRegion(){

		con=getConnection();
		Statement stmt= null;
		ArrayList regList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallregion="select regionid,regionname from region_t";
			ResultSet rs=stmt.executeQuery(getallregion);
			while(rs.next()){
				RegionBean rbean= new RegionBean();
				int rid=rs.getInt("regionid");
				rbean.setRegionid(rid);
				String rname=rs.getString("regionname");
				rbean.setRegionname(rname);
				regList.add(rbean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 regList;

	}



	public RWBean insertPrice(RWBean rwBean, LoginBean logBean){

		con=getConnection();
		Statement stmt= null;


		try {   	

			stmt=con.createStatement();

			String maxQuery="select regionid from user_t where user_t.userid="+logBean.getUserid()+"";
			ResultSet rs=stmt.executeQuery(maxQuery);
			int rid = 0;
			int uid = logBean.getUserid();
			while(rs.next()){
				rid=rs.getInt("regionid");
			}

			String logQuery="insert into price_t values('"+rwBean.getDate()+"',"+rwBean.getQuantity()+","+rwBean.getPrice()+","+rwBean.getVegid()+","+rid+","+uid+")";
			stmt.execute(logQuery);

			stmt.close();
			con.close();

			rwBean.setMessageFlag(1);
			rwBean.setMessage("User Successfully Registered");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return rwBean;	
	}

	public ArrayList getAllPriceDetails(String userid){
		System.out.println("userid view price = " + userid);
		con=getConnection();
		Statement stmt= null;

		int uid=Integer.parseInt(userid);

		ArrayList rwList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallpricedetails="select date,vegname,price,quantity from price_t, veg_t where veg_t.vegid=price_t.vegid and price_t.userid="+uid+"";
			ResultSet rs=stmt.executeQuery(getallpricedetails);
			while(rs.next()){
				RWBean rwbean= new RWBean();
				String date=rs.getString("date");
				rwbean.setDate(date);
				String vname=rs.getString("vegname");
				rwbean.setVegname(vname);
				int price=rs.getInt("price");
				rwbean.setPrice(price);
				int quantity=rs.getInt("quantity");
				rwbean.setQuantity(quantity);
				rwList.add(rwbean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 rwList;

	}

	public ArrayList getAllrates(String vege, String region, String date) throws SQLException{


		System.out.println(4);

		con=getConnection();
		Statement stmt= null;



		int vegid=Integer.parseInt(vege);
		int regionid=Integer.parseInt(region);

		stmt=con.createStatement();
		String maxQuery1="select regionname from region_t where regionid="+regionid+"";
		ResultSet rs2=stmt.executeQuery(maxQuery1);
		String regionname="";
		while(rs2.next()){
			regionname=rs2.getString("regionname");
		}

		stmt=con.createStatement();
		String maxQuery2="select vegname from veg_t where vegid="+vegid+"";
		ResultSet rs1=stmt.executeQuery(maxQuery2);
		String vegname="";
		while(rs1.next()){	
			vegname=rs1.getString("vegname");
		}

		ArrayList knowratesList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallpricedetails="select quantity,price,name, usertypeid from price_t, user_t, login_t where price_t.vegid="+vegid+" and price_t.regionid="+regionid+" and price_t.date='"+date+"' and price_t.userid=user_t.userid and price_t.userid=login_t.userid ";
			ResultSet rs=stmt.executeQuery(getallpricedetails);
			while(rs.next()){
				RWBean rwbean= new RWBean();

				int price=rs.getInt("price");
				rwbean.setPrice(price);

				int quantity=rs.getInt("quantity");
				rwbean.setQuantity(quantity);

				int usertypeid=rs.getInt("usertypeid");
				rwbean.setUsertypeid(usertypeid);

				String username = rs.getString("name");
				rwbean.setUsername(username);


				rwbean.setVegname(vegname);
				rwbean.setDate(date);
				rwbean.setRegionname(regionname);

				knowratesList.add(rwbean);
			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 knowratesList;

	}

	public UserinfoBean knowbestRetailer(String vege, String region, String date) throws SQLException{
		System.out.println(3);
		con=getConnection();
		Statement stmt= null;

		int vegid=Integer.parseInt(vege);
		int regionid=Integer.parseInt(region);
		System.out.println(4);
		stmt=con.createStatement();
		String maxQuery1="select regionname from region_t where regionid="+regionid+"";
		ResultSet rs2=stmt.executeQuery(maxQuery1);
		String regionname="";
		while(rs2.next()){
			regionname=rs2.getString("regionname");
		}
		System.out.println(5);
		stmt=con.createStatement();
		String maxQuery2="select vegname from veg_t where vegid="+vegid+"";
		ResultSet rs1=stmt.executeQuery(maxQuery2);
		String vegname="";
		while(rs1.next()){	
			vegname=rs1.getString("vegname");
		}
		System.out.println(6);
		stmt=con.createStatement();

		String minpricedetails="select min(price) as minimumprice from price_t, login_t where price_t.vegid="+vegid+" and price_t.regionid="+regionid+" and price_t.date='"+date+"' and price_t.userid=login_t.userid and login_t.usertypeid="+3+"";
		System.out.println("minpricedetails "+minpricedetails);
		ResultSet rs=stmt.executeQuery(minpricedetails);

		System.out.println(7);

		int minimumprice = 0;
		while(rs.next()){

			minimumprice=rs.getInt("minimumprice");
		}
		System.out.println("minimum price : "+minimumprice);

		stmt=con.createStatement();

		String togetuserid="select userid from price_t where price_t.price="+minimumprice+" and price_t.vegid="+vegid+" and price_t.regionid="+regionid+" and price_t.date='"+date+"'";
		ResultSet rs8=stmt.executeQuery(togetuserid);


		int userid = 0;
		while(rs8.next()){


			userid=rs8.getInt("userid");
		}

		UserinfoBean uiBean = new UserinfoBean();	
		System.out.println(7);
		stmt=con.createStatement();
		String minretailerdetails="select name, emailid, address, phoneno from user_t where userid="+userid+"";
		ResultSet rs4=stmt.executeQuery(minretailerdetails);
		String name = "", emailid = "", address = "";
		int phoneno = 0;
		while(rs4.next()){
			name = rs4.getString("name");
			emailid = rs4.getString("emailid");
			address = rs4.getString("address");
			phoneno = rs4.getInt("phoneno");
		}

		uiBean.setAddress(address);
		uiBean.setEmail(emailid);
		uiBean.setPhone(phoneno);
		uiBean.setUsername(name);
		uiBean.setRegionname(regionname);
		uiBean.setVegetablename(vegname);


		return 	 uiBean;

	}

	public ArrayList getAllRetailer(){

		con=getConnection();
		Statement stmt= null;
		ArrayList retailerList = new ArrayList();// where user_t.status="+0+" login_t.usertypeid="+3+" and
		try {
			stmt=con.createStatement();

			String getallretailers="select user_t.userid, user_t.name, user_t.emailid from user_t, login_t where user_t.userid =login_t.userid and login_t.usertypeid="+3+" and user_t.status="+0+"";

			ResultSet rs=stmt.executeQuery(getallretailers);

			while(rs.next()){
				UserinfoBean ubean= new UserinfoBean();

				int userid=rs.getInt("userid");

				ubean.setUserid(userid)	;

				String uname=rs.getString("name");
				ubean.setUsername(uname);
				String emailid=rs.getString("emailid");
				ubean.setEmail(emailid);
				retailerList.add(ubean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 retailerList;

	}
	public ArrayList getAllCivilians(){

		con=getConnection();
		Statement stmt= null;
		ArrayList civilianList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallcivilians="select user_t.userid, user_t.name, user_t.emailid from user_t, login_t where user_t.userid =login_t.userid and login_t.usertypeid="+2+" and user_t.status="+0+"";
			ResultSet rs=stmt.executeQuery(getallcivilians);
			while(rs.next()){
				UserinfoBean ubean= new UserinfoBean();

				int userid=rs.getInt("userid");
				ubean.setUserid(userid)	;
				String uname=rs.getString("name");
				ubean.setUsername(uname);
				String emailid=rs.getString("emailid");
				ubean.setEmail(emailid);
				civilianList.add(ubean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 civilianList;

	}
	public ArrayList getAllWholesellers(){

		con=getConnection();
		Statement stmt= null;
		ArrayList wholesellerList = new ArrayList();
		try {
			stmt=con.createStatement();
			String getallwholesellers="select user_t.userid, user_t.name, user_t.emailid from user_t, login_t where user_t.userid =login_t.userid and login_t.usertypeid="+4+" and user_t.status="+0+"";
			ResultSet rs=stmt.executeQuery(getallwholesellers);
			while(rs.next()){
				UserinfoBean ubean= new UserinfoBean();

				int userid=rs.getInt("userid");
				ubean.setUserid(userid)	;			
				String uname=rs.getString("name");
				ubean.setUsername(uname);
				String emailid=rs.getString("emailid");
				ubean.setEmail(emailid);
				wholesellerList.add(ubean);


			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 wholesellerList;

	}

	public void approveUser(String[] userarry){

		con=getConnection();
		Statement stmt= null;
		for(int i=0;i<userarry.length;i++){
			try {
				stmt=con.createStatement();	

				int userid = Integer.parseInt(userarry[i]);

				String updateQuery="update user_t set user_t.status = "+1+" where user_t.userid = "+userid+"";
				stmt.execute(updateQuery);

			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	public ArrayList todaysRates() throws SQLException{

		con=getConnection();
		Statement stmt= null;


		stmt=con.createStatement();
		String maxdateQuery="select max(date) from price_t";
		ResultSet rs3=stmt.executeQuery(maxdateQuery);
		String date="";
		while(rs3.next()){	
			date=rs3.getString(1);
		}
		System.out.println("date "+date);

		ArrayList todayratesList = new ArrayList();
		try {
			stmt=con.createStatement();
			String maxQuery1="select veg_t.vegname,price_t.price from price_t,veg_t,login_t where price_t.userid=login_t.userid and login_t.usertypeid="+1+" and price_t.vegid=veg_t.vegid and date = (select max(date) from price_t,login_t where price_t.userid=login_t.userid and login_t.usertypeid="+1+" )";
			ResultSet rs2=stmt.executeQuery(maxQuery1);
			System.out.println("******************************");
			while(rs2.next()){
				RWBean rwbean= new RWBean();

				int price=rs2.getInt("price");
				rwbean.setPrice(price);


				String vegname = rs2.getString("vegname");
				rwbean.setVegname(vegname);
				rwbean.setDate(date);

				System.out.println("vegname,price,date"+rwbean.getVegname() +price +date);
				todayratesList.add(rwbean);
			}


		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 	 todayratesList;

	}



}