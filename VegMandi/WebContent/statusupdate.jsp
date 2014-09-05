<%@ page language="java"
	import="com.icl.bean.RWBean,com.icl.bean.UserinfoBean,com.icl.bean.LoginBean,java.util.ArrayList,java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1"%>
<jsp:useBean id="retailerList" class="java.util.ArrayList"
	scope="request"></jsp:useBean>
<jsp:useBean id="civilianList" class="java.util.ArrayList"
	scope="request"></jsp:useBean>
<jsp:useBean id="wholesellerList" class="java.util.ArrayList"
	scope="request"></jsp:useBean>
<jsp:useBean id="uBean" class="com.icl.bean.UserinfoBean"
	scope="request"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>E-Mandi Online</title>
<meta name="keywords" content="E-Mandi Online, free E vegetable market" />
<meta name="description" content="E-Mandi Online" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="gallery_style.css" />
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
<h3><font color="#df7000">Authenticate Users</font></h3>
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



<form action="/VegMandi/VegServlet" method="post"><input
	type="hidden" name="handler" value="vegmgmt"> <input
	type="hidden" name="action" value="approveUser">


<h3>List of unauthenticated Civilians</h3>
<hr width="800" size="1" />
<table class="tableborder">


	<tr>
		<td width="100" class="tdborder"><b><font color="#df7000">Sl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Check</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Civilian
		Name</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">EmailID</font></b></td>
	</tr>
	<%
				Iterator itr = civilianList.iterator();
				%>
	<%
				int i = 1;
			while (itr.hasNext()) {
			
			%>

	<%
			uBean = (UserinfoBean) itr.next();
			%>
	<tr>
		<td width="100" class="tdborder1"><%=i %></td>
		<td width="100" class="tdborder1"><input type="checkbox"
			name="uid" value="<%=uBean.getUserid() %>" /></td>
		<td width="100" class="tdborder1"><%=uBean.getUsername()%></td>
		<td width="100" class="tdborder1"><%=uBean.getEmail()%></td>
	</tr>
	<%
			i++;
			}
			%>
</table>
<h3>List of unauthenticated Retailers</h3>
<hr width="800" size="1" />
<table class="tableborder">


	<tr>
		<td width="100" class="tdborder"><b><font color="#df7000">Sl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Check</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Retailer
		Name</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">EmailID</font></b></td>
	</tr>
	<%
				Iterator itr2 = retailerList.iterator();
				%>
	<%
				int i2 = 1;
			while (itr2.hasNext()) {
			
			%>

	<%
			uBean = (UserinfoBean) itr2.next();
			%>
	<tr>
		<td width="100" class="tdborder1"><%=i2 %></td>
		<td width="100" class="tdborder1"><input type="checkbox"
			name="uid" value="<%=uBean.getUserid() %>" /></td>
		<td width="100" class="tdborder1"><%=uBean.getUsername()%></td>
		<td width="100" class="tdborder1"><%=uBean.getEmail()%></td>
	</tr>
	<%
			i2++;
			}
			%>
</table>
<h3>List of unauthenticated Wholesellers</h3>
<hr width="800" size="1" />
<table class="tableborder">


	<tr>
		<td width="100" class="tdborder"><b><font color="#df7000">Sl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Check</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Whole
		sellers</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">EmailID</font></b></td>
	</tr>
	<%
				Iterator itr1 = wholesellerList.iterator();
				%>
	<%
				int i1 = 1;
			while (itr1.hasNext()) {
			
			%>

	<%
			uBean = (UserinfoBean) itr1.next();
			%>
	<tr>
		<td width="100" class="tdborder1"><%=i1 %></td>
		<td width="100" class="tdborder1"><input type="checkbox"
			name="uid" value="<%=uBean.getUserid() %>" /></td>
		<td width="100" class="tdborder1"><%=uBean.getUsername()%></td>
		<td width="100" class="tdborder1"><%=uBean.getEmail()%></td>
	</tr>
	<%
			i1++;
			}
			%>
</table>
<hr width="800" size="1" />
<center><input type="submit" name="authenticate"
	value="Authenticate" /></center>
</form>
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
