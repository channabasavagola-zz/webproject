<%@ page language="java"
	import="com.icl.bean.RWBean,com.icl.bean.LoginBean,java.util.ArrayList,java.util.Iterator"
	contentType="text/html; charset=ISO-8859-1"%>
<jsp:useBean id="rwBean" class="com.icl.bean.RWBean" scope="request"></jsp:useBean>
<jsp:useBean id="vege" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="region" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="date" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="knowratesList" class="java.util.ArrayList"
	scope="request"></jsp:useBean>
<jsp:useBean id="logBean" class="com.icl.bean.LoginBean" scope="request"></jsp:useBean>

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
<h3><font color="#df7000">Details</font></h3>
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
	type="hidden" name="action" value="deletePrice"> <%
				Iterator itr1 = knowratesList.iterator();
				%> <%
				
			while (itr1.hasNext()) {
			
			%> <%
			rwBean = (RWBean) itr1.next();
			%> <%
			}
			%>

<h3>Rates of <%=rwBean.getVegname()%> in <%=rwBean.getRegionname()%>
on <%=date %> at different retailers are,</h3>
<hr width="800" size="1" />
<table class="tableborder">
	<tr>
		<td width="100" class="tdborder"><b><font color="#df7000">Sl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Retailer
		Name</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Price
		per Qtl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Qty
		in Qtl</font></b></td>
	</tr>
	<%
				Iterator itr = knowratesList.iterator();
				%>
	<%
				int i = 1;
			while (itr.hasNext()) {
			
			%>

	<%
			rwBean = (RWBean) itr.next();
			if(rwBean.getUsertypeid()==3){
			%>


	<tr>
		<td width="100" class="tdborder1"><%=i %></td>
		<td width="100" class="tdborder1"><%=rwBean.getUsername()%></td>
		<td width="100" class="tdborder1"><%=rwBean.getPrice()%></td>
		<td width="100" class="tdborder1"><%=rwBean.getQuantity()%></td>
	</tr>

	<%
			i++;
			}
			}
			%>
</table>




<%
				Iterator itr2 = knowratesList.iterator();
				%> <%
				
			while (itr2.hasNext()) {
			
			%> <%
			rwBean = (RWBean) itr2.next();
			%> <%
			}
			%>

<h3>Rates of <%=rwBean.getVegname()%> in <%=rwBean.getRegionname()%>
on <%=date %> at different Whole Sellers are,</h3>
<hr width="800" size="1" />
<table class="tableborder">
	<tr>
		<td width="100" class="tdborder"><b><font color="#df7000">Sl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Wholesellers</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Price
		per Qtl</font></b></td>
		<td width="100" class="tdborder"><b><font color="#df7000">Qty
		in Qtl</font></b></td>
	</tr>
	<%
				Iterator itr3 = knowratesList.iterator();
				%>
	<%
				int ii = 1;
			while (itr3.hasNext()) {
			
			%>

	<%
			rwBean = (RWBean) itr3.next();
			if(rwBean.getUsertypeid()==4){
			%>


	<tr>
		<td width="100" class="tdborder1"><%=ii %></td>
		<td width="100" class="tdborder1"><%=rwBean.getUsername()%></td>
		<td width="100" class="tdborder1"><%=rwBean.getPrice()%></td>
		<td width="100" class="tdborder1"><%=rwBean.getQuantity()%></td>
	</tr>

	<%
			ii++;
			}
			}
			%>
</table>

</form>


<hr width="800" size="1" />
<a href="/VegMandi/VegServlet?handler=vegmgmt&action=order"><font
	color="white">Order Here</font></a></div>
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
