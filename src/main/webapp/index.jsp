<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css" href="http://s0.meituan.net/bs/fe-web-meituan/b61fdf7/css/com_header.css">
	<link rel="stylesheet" href="css/main.css" />
  </head>
  
  <body id="main">

<!-- 引入header -->
<%@include file="header.jsp" %>
<!-- 引入商品列表 -->
<%@include file="productList.jsp" %>
<!-- 引入footer -->
<%@include file="footer.jsp" %>
  </body>
</html>
