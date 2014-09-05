<%@ page language="java"
	import="com.icl.bean.UserinfoBean,com.icl.bean.LoginBean"
	contentType="text/html; charset=ISO-8859-1"%>
<jsp:useBean id="uiBean" class="com.icl.bean.UserinfoBean"
	scope="request"></jsp:useBean>
<jsp:useBean id="vege" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="region" class="java.lang.String" scope="request"></jsp:useBean>
<jsp:useBean id="date" class="java.lang.String" scope="request"></jsp:useBean>

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
<h3><font color="#df7000">Best Retailer in <%=uiBean.getRegionname() %></font></h3>
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


<p>Retailer Name : <%=uiBean.getUsername() %></p>
<p>address : <%=uiBean.getAddress() %></p>
<p>email : <%=uiBean.getEmail() %></p>
<p>phone no : <%=uiBean.getPhone() %></p>
<p>region : <%=uiBean.getRegionname() %></p>
<p>vegetable : <%=uiBean.getVegetablename() %></p>
<p>date : <%=date %></p>
<p></p>








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
