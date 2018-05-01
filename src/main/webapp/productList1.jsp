<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<%@ page language="java" pageEncoding="UTF-8"%>
		<meta name="author" content="order by dede58.com/">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">
		<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
		<meta http-equiv="cleartype" content="on">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-title" content="">
		<meta name="format-detection" content="telephone=no">
		<meta name="format-detection" content="email=no">
		<meta name="author" content="order by www.jsdaima.com">
		<link rel="stylesheet" type="text/css" href="css/font_409178_69q8i3vyzefav2t9.css">
		<link rel="stylesheet" type="text/css" href="css/animate.min.css">
		<link rel="stylesheet" type="text/css" href="css/lhcommon.css">
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<style>
		
			.btn 
		{
			padding: 9px 14.7px;
		}
		</style>
		<!-- <script src="js/jquery-3.2.1.js"></script> -->
	<!-- 	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
		<!--详情页的-->
		<!-- 引入js模板 -->
		<script src="js/jsviews.js"></script> 

		<!--引入模板-->

		<!--商品模块模板-->
		<script id="productListTmpl" type="text/x-jsrender">
			<li data-animated="fadeInUp" class="wow animated fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
					<a href="productDetail.jsp?id={{:id}}">
						<div class="img ">
							<img src="{{:mainPic}}" style="width:300px;height:300px" >
						</div>
						<h2>
												<p>{{:name}}</p>
                                    <span href="/a/tesecaipin/caipinfenleiyi/37.html">
                                        <em>
                                  
     									     优惠
                                        </em>
                                        <i class="" style="color: black;">
                                        	价格:{{:price}}
                                        </i>
                                    </span>
                        </h2>

						<a class="btn btn-info">
							<h4 style="font-size: 30px; margin: 0px;" class="addToCart" data-id = "{{:id}}">加入购物车 <span class="glyphicon glyphicon-shopping-cart"></span></h4></a>
					</a>
				</li>
		
		
		</script>
		<!--引入测试数据-->
		<!--<script type="text/javascript" charset="utf-8">
			$(function() {
				window.dataSrouce = {
					jihe: [{
							age: "1"
						},
						{
							age: "2"
						},
						{
							age: "1"
						}, {
							age: "2"
						},

					]

				}
				var html = $("#productListTmpl").render(dataSrouce.jihe);
				$("#productDiv").html(html);
//				$("#productDiv").append(html);
			});
		</script>
-->

		
		
		
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
					addToCart();
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
 



<!-- 异步添加商品到购物车 -->

<script>
	function addToCart() {
		$(".addToCart").click(function() {
			$.ajax({
				type : "GET",
				url : 'cart/add.do',
				contentTyp : "application/x-www-form-urlencoded",
				data : {
					count : 1,
					productId :this.dataset.id
				},
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
						alert("添加成功")

					/* $("#wenwebzhi").value(data.data.birth) */
					/* window.location.href = "index.jsp"; */
					} else {
						/* console.log(jsonObject); */
						alert(data.msg);
						 window.location.href = "login.jsp";
					}
				},
				error : function() {
					alert("提交数据失败");
				}
			});

		});
	}

</script>

	</head>

	<body class=" pace-done">
		<div class="container lh-other-container" style="margin-top: 10px">

			<ul class="lh-cusine-item clearfix lh-flex" id="productDiv">
					</ul>
		</div>
		
		
		<div class="container" style=" text-align: center; margin-top: 20px;">
			<p>
				
				<a href="#" class="btn btn-default  btn-lg" style="color: black;"   >
					<span class="glyphicon glyphicon-repeat  "></span> 首页
				</a>
				<a href="#" class="btn btn-default btn-lg" style="color: black;" >
					<span class="glyphicon glyphicon-arrow-left"></span> 上一页
				</a>
				<a href="#" class="btn btn-default btn-lg" style="color: black;" >
					<span class="glyphicon glyphicon-arrow-right" style="color: black;" ></span> 下一页
				</a>
				<a href="#" class="btn btn-default btn-lg" style="color: black;" >
					<span class="glyphicon glyphicon-pause"></span> 尾页
				</a>
			</p>

		</div>
		

	</body>

</html>