<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!--引入js库-->
<script src="js/jquery-3.2.1.js"></script>
<!-- 引入jsrender插件 -->
<script src="//www.jsviews.com/download/jsviews.js"></script>
	<link rel="stylesheet" type="text/css" href="http://s0.meituan.net/bs/fe-web-meituan/c19c6e9/css/main.css">
		<link rel="stylesheet" type="text/css" href="http://s1.meituan.net/bs/fe-web-meituan/2946ee4/css/index.css">


<!-- 异步查询数据库商品 -->
 <script type="application/javascript">
	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "POST",
			url : 'product/listAll.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			/*  data: fd,  */
			dataType : "json",
			success : function(data) {
				if (data.status == 0) {
					console.log(data.data)
					var html = $("#productListTmpl").render(data.data);
					/* 追加内容 */
					$("#productDiv").append(html);
					/* 覆盖所有内容
					$("#productDiv").html(html);
					 */
					/* 
					 var html = $("#testTmpl").render(data);
					 	$("#list1").html(html);  */


				/* 	$("#list1").append(html);  */
				/* $("#wenwebzhi").value(data.data.birth) */
				/* window.location.href = "index.html"; */
				} else {
					/* console.log(jsonObject); */
					alert(data.msg);
				}
			},
			error : function() {
				alert("提交数据失败");
			}
		});

	});
</script>
 







<!--商品模块模板-->
<script id="productListTmpl" type="text/x-jsrender">
		<div class="col-xs-6 col-md-3">
			<a href="#" class="thumbnail">
				<img src="2.png" style="height: 180px; width: 100%; display: block;" alt="">
			</a>
			<div class="caption"  style="margin: 0px;">
				<h4>名称:{{:name}}</h4>
 			
				<p>价格:{{:price}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  销量:{{:sales}}</p>
			</div>  
		</div>
	    
		
</script>

<!-- <script type="text/javascript" charset="utf-8">
	$(function() {
		var dataSrouce = [ {
			name : "张三"
		},
			{
				name : "zhangsi"
			},
			{
				name : "张三"
			},
			{
				name : "张三"
			},
			{
				name : "张三"
			},
			{
				name : "张三"
			}, {
				name : "张三"
			}, {
				name : "张三"
			}, {
				name : "张三"
			}, {
				name : "张三"
			}, {
				name : "张三"
			},

		];

		var html = $("#productListTmpl").render(dataSrouce);

		$("#productDiv").append(html);
	});

</script>

 -->
</script>
 		<style>
			
			.caption{
				margin-top: 0px;
				color: red;
			}
			h5{
				margin: 0px;
			}
			.thumbnail{
				margin-bottom:5px;
			}
			a{
				color:red;
			}
		</style>
</head>

<body>

<div class="container" >
	<a href="#">全部</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	<a href="#">下午茶</a>
	
</div>
			<!-- 这里填充商品展示模板 -->
			
	<div class="container" style="margin-top:20px"  >
	<div class="index-nav-container undefined" style="background: linear-gradient(to right, rgb(18, 210, 198) 2%, rgb(14, 190, 212) 97%) rgb(18, 210, 198);">
				<ul class="clearfix ">
					<li class="title nav-item mf-shang-hei-regular">猜你喜欢</li>
					<li class="nav-item active">为你甄选最适合的</li>
				</ul>
			</div>
    <div class="row" id="productDiv">
    
	</div>
</div>
	<!--商品模块结束-->

</body>

</html>