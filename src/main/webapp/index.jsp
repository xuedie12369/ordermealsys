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
	<style>
		.btn 
		{
			padding: 9px 14.7px;
		}
	</style>

  </head>
  
  <body id="main">
	
<!-- 引入header -->
<%@include file="header1.jsp" %>
<!-- 引入轮播图 -->
<%@include file="broadcastImage.jsp" %>
<!-- 引入分类 -->
<%@include file="category1.jsp" %>
<!-- 引入商品列表 -->
<%@include file="productList1.jsp" %>
<%-- <!-- 引入分页 -->
<%@include file="paging.jsp" %> --%>
<!-- 引入footer -->
<%@include file="footer.jsp" %>
  </body>
</html>
