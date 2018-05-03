<!DOCTYPE html>
<html >

	<head>
		<meta charset="UTF-8">
		<title>美食系列</title>
		<%@ page language="java" pageEncoding="UTF-8"%>
		<link rel="stylesheet" type="text/css" href="css/index-common.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" href="css/carouselImage.css">
		<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
		<script type="text/javascript">
			function stops() {
				return false;
			}
			document.oncontextmenu = stops;
		</script>
	<style>
		
		.btn 
		{
			padding: 9px 14.7px;
		}
		.btn-info :ACTIVE
		{
			background-color: #13d1be;
			
		}
		.btn-info :HOVER
		{
			background-color: #13d1be;
			
		}
	</style>
	</head>




	<body>
		
		<!--网站导航区域开始-->
		<ul class="breadnav clearfix">
			<li class="bnav-item">
				<a href="index.html">首页</a>
			</li>
			<li class="bnav-item">&lt;</li>
			<li class="bnav-item">
				<a href="meishi.html">美食系列</a>
			</li>
			<li class="bnav-item">&lt;</li>
			<li class="bnav-item">
				<a href="javascript:;">全部菜品</a>
			</li>
		</ul>
		<!--导航区域结束-->
		
		
		<!--分类模块开始-->
		<div class="clearfix table-wrap" id="tab-span">
			<span class="table-item">全部菜品</span>
			<span class="table-item">经典牛排</span>
			<span class="table-item">意面/烩饭</span>
			<span class="table-item">风味披萨</span>
			<span class="table-item">甜品小食</span>
			<span class="table-item">酒水饮料</span>
			<span class="table-item">其他</span>
			<div class="search clearfix" style="margin-left: auto;margin-right: auto; width:296px">
				<input class="inp-txt" type="text" name="address" value="输入关键字" onfocus="if(this.value=='输入关键字'){this.value=''};this.style.color='black';" onblur="if(this.value==''||this.value=='输入关键字'){this.value='输入关键字';this.style.color='gray';}" 
			
					/>
					
					<a style="color: white; font-size: 18px; margin-top: -8px;" class="btn btn-info" ><span class="glyphicon   glyphicon-search" style="font-size: 10px; "></span>搜索</a>
				
			</div>
		</div>
		<!--分类模块结束-->
		

		
		
	</body>
	<!--jq调用-->
	<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
	<script>
	</script>
	<!--给分类添加鼠标进入事件-->
	<script type="text/javascript">
		$(document).ready(function() {
			$(".table-item").mouseover(function(){
//				$(this).siblings().className="table-item ";
				$(this).className="table-item table-active"
			})
		});
		//导航当前项切换	
		$(".nav-item").click(function() {
			$(this).parent("li").siblings().children().removeClass("nav-active");
			//点击对象的父级（li）的兄弟级（li）的子集（a）移除类
			$(this).addClass("nav-active");

			//给点击对象添加类
		});

		//	鼠标经过自动改变颜色
		function navItemOnMouseMove(x) {
			$(x).siblings().children().removeClass("nav-active");
		}


		//美食系列当前项切换
		$(".table-item").click(function() {
			$(this).siblings().removeClass("table-active");
			$(this).addClass("table-active");
		});
	
	</script>

</html>