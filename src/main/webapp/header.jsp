<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<%@ page language="java" pageEncoding="UTF-8"%>
		<title>美食系列</title>
		<link rel="stylesheet" type="text/css" href="css/index-common.css" />
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<script src="js/jquery-3.2.1.js"></script>
		<script src="js/jsviews.js"></script>
		<script type="text/javascript">
			function stops() {
				return false;
			}
			document.oncontextmenu = stops;
		</script>
		<style>
			/* .btn {
				padding: 9px 12px;
			}
			 */
		/* 	.btn-info {
				background: #13d1be;
			}
			 */
		/* 	.btn-info :hover {
				background-color: #13d1be;
			} */
		</style>
		
<script>
$(function(){
	
	
	logout();
}
);

</script>	
		
		<!--添加按钮开始-->
<script>
	function logout() {
		$("#logout").click(function() {
			$.ajax({
				type : "GET",
				url : 'user/logout.do',
				contentType : "application/x-www-form-urlencoded",
				success : function(data) {
					if(data.status==0)
					{
						window.location.href="login.jsp"
					}
					else
					{
					alert(data.msg)
					}
					console.log(data);
					console.log(data.data);
				},
				error : function() {
					alert("提交数据失败");
				}
			});
		});

	}
</script>
	</head>

	<body>
		<!--头部开始-->
		<div class="clearfix nav" style="" >
			<a class="logo" href="javascript:;"></a>
			<ul class="clearfix nav-wrap">
			<!-- onmousemove="navItemOnMouseMove(this)" -->
				<li >
					<a class="nav-item" href="index.jsp">首页</a>
				</li>
				<li >
					<a class="nav-item" href="order.jsp">我的订单</a>
				</li>
				<li >
					<a class="nav-item" href="cart.jsp">购物车</a>
				</li>
				<li >
					<a class="nav-item" href="shop.html">入驻加盟</a>
				</li>
				
				<li >
					<a class="nav-item" href="login.jsp">登录</a>
				</li>
				<li id="logout">
					<a class="nav-item" href="">退出</a>
				</li>
			</ul>
		</div>
		<!--头部结束-->
		

	</body>


























</html>