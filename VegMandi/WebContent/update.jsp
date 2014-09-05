<%@ page language="java"
	import="com.icl.bean.LoginBean,com.icl.bean.VegBean,java.util.ArrayList,com.icl.bean.RegionBean,java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1"%>
<jsp:useBean id="logBean" class="com.icl.bean.LoginBean" scope="request"></jsp:useBean>
<jsp:useBean id="regList" class="java.util.ArrayList" scope="request"></jsp:useBean>
<jsp:useBean id="vegList" class="java.util.ArrayList" scope="request"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Mandi Online</title>
<meta name="keywords" content="E-Mandi Online, free E vegetable market" />
<meta name="description" content="E-Mandi Online" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="gallery_style.css" />
<link rel="stylesheet" type="text/css" media="all" href="datepicker.css" />
<script type="text/javascript" src="datepicker.js"></script>
<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"inputField",
			dateFormat:"%d-%M-%Y"
			
		});
		new JsDatePick({
			useMode:2,
			target:"inputField1",
			dateFormat:"%d-%M-%Y"
			
		});
	};
</script>
</head>

<body bgcolor="#5e6875">
<div id="templatemo_container">
<div id="templatemo_top_panel">
<div id="templatemo_header_section">
<div id="templatemo_header">E-Mandi</div>
</div>
<!-- end of header section -->

<div id="templatemo_menu_login_section">
<div id="templatemo_menu_section">
<div id="templatemo_menu_panel">
<ul>
	<li><a
		href="/VegMandi/VegServlet?handler=vegmgmt&action=getindexpage">Home</a></li>
	<li><a
		href="/VegMandi/VegServlet?handler=vegmgmt&action=getaboutpage">About</a></li>
	<li><a
		href="/VegMandi/VegServlet?handler=vegmgmt&action=getcontactpage">Contact</a></li>
	<li><a
		href="/VegMandi/VegServlet?handler=vegmgmt&action=getregpage">Sign
	up</a></li>
</ul>
</div>
<!-- end of menu --></div>
<div>
<%if(logBean.getUsertypeID()==2){ %>
<h3><font color="#df7000">Civilian Form</font></h3>
<%} %>
<%if(logBean.getUsertypeID()==3){ %>
<h3><font color="#df7000">Retailer Form</font></h3>
<%} %>
<%if(logBean.getUsertypeID()==4){ %>
<h3><font color="#df7000">Wholeseller Form</font></h3>
<%} %>
<%if(logBean.getUsertypeID()==1){ %>
<h3><font color="#df7000">Admin Form</font></h3>
<%} %>
</div>

</div>
<!-- end of top panel -->

<div id="templatemo_gallery_panel"></div>

<script type="text/javascript">
var imgid = 'image';
var imgdir = 'images/fullsize';
var imgext = '.jpg';
var thumbid = 'thumbs';
var auto = true;
var autodelay = 5;
</script> <script type="text/javascript" src="slide.js"></script></div>

<div id="templatemo_content_panel_1">

<div id="templatemo_section_1_9">
<%if(logBean.getUsertypeID()==2){ %>
<h3>Hi <%=logBean.getLoginname()%>,</h3>
<hr width="800" size="1" />
<div id="templatemo_box_1">
<form action="/VegMandi/VegServlet" method="post"><input
	type="hidden" name="handler" value="vegmgmt"> <input
	type="hidden" name="action" value="knowRates"> <input
	type="hidden" name="userID" value="<%=logBean.getUserid() %>"><input
	type="hidden" name="userName" value="<%=logBean.getLoginname()%>">
<table>
	<th>Know Rates</th>

	<%Iterator itr = vegList.iterator();%>

	<tr>
		<td><font color="white">Choose vegetable </font></td>
		<td><select name="vege">
			<option>----select vegetable----</option>
			<%
			while (itr.hasNext()) {
			%>

			<%
			VegBean vBean = (VegBean) itr.next();
			%>

			<option value="<%=vBean.getVegid() %>"><%=vBean.getVegname()%></option>
			<%
			}
			%>
		</select></td>
	</tr>


	<%
	Iterator itr1 = regList.iterator();
	%>
	<tr>
		<td>Region</td>
		<td><select name="region">
			<option>------select region-------</option>
			<%
			while (itr1.hasNext()) {
			%>

			<%
			RegionBean rBean = (RegionBean) itr1.next();
			%>

			<option value="<%=rBean.getRegionid() %>"><%=rBean.getRegionname()%></option>
			<%
			}
			%>
		</select></td>
	</tr>

	<tr>
		<td><font color="white">Date </font></td>
		<td><input type="text" name="date" size="20" id="inputField" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="submit" /></td>
		<td align="right"><input type="reset" value="Reset" /></td>
	</tr>

</table>


</form>
</div>
<div id="templatemo_box_1">
<form action="/VegMandi/VegServlet" method="post"><input
	type="hidden" name="handler" value="vegmgmt"> <input
	type="hidden" name="action" value="knowbestRetailer"> <input
	type="hidden" name="userID" value="<%=logBean.getUserid() %>"><input
	type="hidden" name="userName" value="<%=logBean.getLoginname()%>">
<table>
	<th>Find Retailers</th>


	<%Iterator itr3 = vegList.iterator();%>

	<tr>
		<td><font color="white">Choose vegetable </font></td>
		<td><select name="vege">
			<option>----select vegetable----</option>
			<%
			while (itr3.hasNext()) {
			%>

			<%
			VegBean vBean = (VegBean) itr3.next();
			%>

			<option value="<%=vBean.getVegid() %>"><%=vBean.getVegname()%></option>
			<%
			}
			%>
		</select></td>
	</tr>


	<%
	Iterator itr2 = regList.iterator();
	%>
	<tr>
		<td>Region</td>
		<td><select name="region">
			<option>------select region-------</option>
			<%
			while (itr2.hasNext()) {
			%>

			<%
			RegionBean rBean = (RegionBean) itr2.next();
			%>

			<option value="<%=rBean.getRegionid() %>"><%=rBean.getRegionname()%></option>
			<%
			}
			%>
		</select></td>
	</tr>

	<tr>
		<td><font color="white">Date </font></td>
		<td><input type="text" name="date" size="20" id="inputField1" /></td>
	</tr>
	<tr>
		<td><input type="submit" name="submit" value="submit" /></td>
		<td align="right"><input type="reset" value="Reset" /></td>
	</tr>

</table>
</form>
</div>


<%}else{ %>
<h3>Hi <%=logBean.getLoginname()%></h3>
<hr size="1" width="800" />
<form action="/VegMandi/VegServlet" method="post"><input
	type="hidden" name="handler" value="vegmgmt"> <input
	type="hidden" name="action" value="insertPrice"> <input
	type="hidden" name="userID" value="<%=logBean.getUserid() %>"><input
	type="hidden" name="userName" value="<%=logBean.getLoginname()%>">
<table>
	<th><font color="white">
	<h3>Update Price Here</h3>
	</font></th>
	<%
				Iterator itr = vegList.iterator();
				%>
	<tr>
		<td><font color="white">Choose vegetable </font></td>
		<td><select name="vege">
			<option>----select vegetable----</option>
			<%
			while (itr.hasNext()) {
			%>

			<%
			VegBean vBean = (VegBean) itr.next();
			%>

			<option value="<%=vBean.getVegid() %>"><%=vBean.getVegname()%></option>
			<%
			}
			%>
		</select></td>

	</tr>
	<tr>
		<td><font color="white">Set your price</font></td>
		<td><input type="text" name="price" size="20" /></td>
	</tr>
	<tr>
		<td><font color="white">Set Quantity </font></td>
		<td><input type="text" name="quantity" size="20" /></td>
	</tr>
	<tr>
		<td><font color="white">Date </font></td>
		<td><input type="text" name="date" size="20" id="inputField" /></td>
	</tr>

	<tr>

		<td align="left"><input type="reset" value="Reset" /></td>
		<td align="right"><input type="submit" name="submit"
			value="submit" /></td>
	</tr>

</table>
</form>
<form action="/VegMandi/VegServlet" method="post"><input
	type="hidden" name="handler" value="vegmgmt"> <input
	type="hidden" name="action" value="viewPrevious"> <input
	type="hidden" name="userID" value="<%=logBean.getUserid()%>"> <input
	type="hidden" name="userName" value="<%=logBean.getLoginname()%>">
<table>
	<tr>

		<td colspan="2" align="right"><input type="submit" name="view"
			value="View" /></td>
	</tr>


</table>
</form>

<%} %> <%if(logBean.getUsertypeID()==1){ %> <a
	href="/VegMandi/VegServlet?handler=vegmgmt&action=statusupdate"><font
	color="white">Authenticate Users</font></a> <%} %>
</div>
<!-- end of section 1 -->
<div class="cleaner_with_height">&nbsp;</div>
</div>



<div id="templatemo_content_panel_2">
<div class="templatemo_section_2"><img
	src="images/templatemo_image_01.jpg" alt="image" width="270"
	height="190" alt="" /></div>
<div class="templatemo_section_2"><img
	src="images/templatemo_image_02.jpg" alt="image" width="270"
	height="190" alt="" /></div>
<div class="templatemo_section_2"><img
	src="images/templatemo_image_03.jpg" alt="image" width="270"
	height="190" alt="" /></div>

<div class="cleaner_with_height">&nbsp;</div>
</div>
<!-- end of content panel 2 -->

<div id="templatemo_content_panel_3">






<div class="cleaner_with_height">&nbsp;</div>
</div>
<!-- end of content panel 3 -->

<div id="templatemo_footer_panel">Copyright © 2048 <a
	href="index.html">E-mandi Online</a></div>
</div>
<!-- end of container -->
<div align=center>Created by RCS and M. &copy; Copyrights
researved</div>
</body>
</html>
