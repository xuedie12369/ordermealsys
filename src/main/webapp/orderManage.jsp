<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/orders.css">
<!--详情页的-->
<link rel="stylesheet" href="css/order.css" />
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--详情页的-->
	<script src="js/jquery-3.2.1.js"></script>
<!--引入js模板-->
<script src="js/jsviews.js"></script>

<!--引入模板-->

<!--商品模块模板-->
<script id="productListTmpl" type="text/x-jsrender">


			<div class="order-item clearfix">
				<div class="order-img">
					<a href="https://www.meituan.com/order/view/4302648258/" class="link" target="_blank">
						<div><img src="1.jpg" class="image"></div>
					</a>
				</div>
				<div class="order-info">
					<div class="info-box">
						<a href="https://www.meituan.com/order/view/4302648258/" class="link" target="_blank">
							<p class="order-title">订单编号:{{:orderNo}}</p>
						</a>
					</div>
				</div>
				<div class="order-price">总价: ￥{{:totalPrice}}</div>
				<div class="order-status" >
					{{if payStatus == 20}} <a href="#" data-id="{{:orderNo}}" class="delivery" target="_blank" style="color:red">发货</a> {{/if}}
					{{if payStatus == 10}} 未付款 {{/if}}
					{{if payStatus == 40}} 已发货 {{/if}}
					<!--也可以吧他们扯开用,如：{{if fullprice}}html markup{{/if}}和{{if fullprice}}html markup{{else}}html markup{{/if}}。但是这里需要注意两点：-->
				</div>
				<div class="order-status">
					<a data-toggle="collapse" data-parent="#accordion" href="#替换这里每个不一样">查看详情</a>
				</div>
				<div class="order-btn"></div>
			</div>
			<!--订单详情开始-->
			<div class="panel-group" id="accordion" style="margin-bottom: 0px">
				<div class="panel ">
					<!--订单详情页开始-->
					<div id="替换这里每个不一样" class="panel-collapse collapse " aria-expanded="true">
						<div class="panel-body">

							<div class="profile-panelcontent" ng-transclude="">

								<div ng-show="progressDisplay" class="ng-scope">

									<div orderprogress-rstinfo="" link="orderReady" class="ng-isolate-scope">
										<div class="orderprogress-rstinfo">
											<a ng-href="/shop/161201517" href="/shop/161201517"><img class="orderprogress-rstimg" ng-src="//fuss10.elemecdn.com/4/59/ae4d0bc906e691f4614e11d4b5461jpeg.jpeg?imageMogr2/thumbnail/44x44/format/webp/quality/85" width="44" height="44" ng-alt="蘑菇爱上饭(中山店)" src="//fuss10.elemecdn.com/4/59/ae4d0bc906e691f4614e11d4b5461jpeg.jpeg?imageMogr2/thumbnail/44x44/format/webp/quality/85"></a>
											<div class="orderprogress-rstgrid" style="margin: auto;">
												<h4 class="orderprogress-rstname"><a class="inherit ng-binding" ng-href="/shop/161201517" ng-bind="restaurant.name" href="/shop/161201517">蘑菇爱上饭(中山店)</a> <span style="margin-left: auto; color: red;">订单编号:{{:orderNo}}</span> <span style="margin-left: auto; color: red;"></span></h4>
											</div>

											<div class="orderprogress-rstoperate">
												<!-- ngIf: !favored -->
												<!-- end ngIf: !favored -->
												<!-- ngIf: favored -->
												<!-- ngIf: !complaintStatus -->
												<!-- end ngIf: !complaintStatus -->
												<!-- ngIf: complaintStatus === 1 -->
											</div>
										</div>

									</div>
									<div class="orderprogress-cardtable">
										<div class="orderprogress-cardcell ng-isolate-scope" style="width: 51%;" orderprogress-total="" link="orderReady">
											<div class="orderprogress-total">
												<div class="orderprogress-totalrow orderprogress-totaltitle" style="width: ;"><span class="cell name">菜品</span> <span class="cell quantity">数量</span> <span class="cell price">单价（元）</span></div>
												<!-- ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
{{for orderItem}}
													<div ng-switch-when="food" class="orderprogress-totalrow ng-scope">




 
<span class="cell name ng-binding" ng-bind="row.food.name">{{:name}}</span> 
<span class="cell quantity ng-binding" ng-bind="row.food.quantity">{{:num}}</span> 
<span class="cell price ng-binding" ng-bind="row.food.price * row.food.quantity | number:2">{{:price}}</span>


</div>{{/for}}

													<!-- ngSwitchWhen: extra -->
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<div ng-switch-when="baseline" class="orderprogress-baseline ng-scope"></div>
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
													<!-- ngSwitchWhen: extra -->
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
													<!-- ngSwitchWhen: extra -->
													<div ng-switch-when="extra" class="orderprogress-totalrow ng-scope"><span class="cell name ng-binding" ng-bind="row.extra.name">餐盒</span> <span class="cell quantity"></span> <span class="cell price ng-binding" ng-class="{minus: row.extra.price < 0}" ng-bind="row.extra.price | number:2">2.00</span></div>
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
													<!-- ngSwitchWhen: extra -->
													<div ng-switch-when="extra" class="orderprogress-totalrow ng-scope"><span class="cell name ng-binding" ng-bind="row.extra.name">配送费</span> <span class="cell quantity"></span> <span class="cell price ng-binding minus" ng-class="{minus: row.extra.price < 0}" ng-bind="row.extra.price | number:2">-4.00</span></div>
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<div ng-switch-when="baseline" class="orderprogress-baseline ng-scope"></div>
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
													<!-- ngSwitchWhen: extra -->
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div class="orderprogress-totalactual">实际支付：<span ng-bind="order.total_amount | number:2" class="ng-binding">{{:totalPrice}}</span></div>
											</div>
										</div>
										<div class="orderprogress-cardcell rightside ng-isolate-scope" orderprogress-deliveryinfo="" link="orderReady">
											<div class="orderprogress-deliveryinfo">
												<h5 class="orderprogress-deliverytitle">配送信息</h5>
												<div class="orderprogress-deliverygroup">
													<p><span class="orderprogress-deliverykey">配送方式：</span> <span class="ng-binding">蘑菇爱上饭(中山店)提供配送服务</span></p>
													<p><span class="orderprogress-deliverykey">送达时间：</span> <span ng-bind="order.detail_info.deliver_description" class="ng-binding">尽快送出</span></p>
												</div>
												<div class="orderprogress-deliverygroup">
													<p><span class="orderprogress-deliverykey">联 系 人：</span> <span ng-bind="order.detail_info.consignee" class="ng-binding">邵先生(先生)</span></p>
													<p><span class="orderprogress-deliverykey">联系电话：</span> <span ng-bind="order.detail_info.phone" class="ng-binding">18924933537</span></p>
													<p><span class="orderprogress-deliverykey">收货地址：</span> <span ng-bind="order.detail_info.address" class="ng-binding">电子科技大学中山学院宿舍楼18幢728</span></p>
												</div>
												<div class="orderprogress-deliverygroup tail">
													<p><span class="orderprogress-deliverykey">备 注：</span> <span ng-bind="order.detail_info.description || '无备注'" class="ng-binding">无备注</span></p>
												</div>
											</div>
										</div>
									</div>
									<div class="orderprogress-roundborder"></div>
								</div>

							</div>

						</div>
					</div>
					<!--订单详情页结束-->
				</div>
			</div>
			<!--订单详情结束-->

		</script>


<!-- 异步查询数据库商品 -->
<script type="application/javascript">
	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "GET",
			url : 'order/queryOrder.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			/*  data: fd,  */
			dataType : "json",
			success : function(data) {
				console.log(data)

				var html = $("#productListTmpl").render(data.data);
				/* 追加内容 */
				$("#productDiv").append(html);

			},
			error : function() {
				alert("提交数据失败");
			}
		});

	});
</script>






<!-- 异步查询数据库商品 -->
<script type="application/javascript">
	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "GET",
			url : 'order/queryOrder.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			/*  data: fd,  */
			dataType : "json",
			success : function(data) {
				console.log(data)

				var html = $("#productListTmpl").render(data.data);
				/* 追加内容 */
				$("#productDiv").append(html);
				delivery();

			},
			error : function() {
				alert("提交数据失败");
			}
		});

	});
</script>


<script>
	$(function(){
	var currentUserRole='<%=session.getAttribute("currentUserRole")%>';
	if(currentUserRole==1)
	{
		
	}
	else
	{
		window.location.href="login.jsp"
	}
	
	});
</script>


<script>
function delivery(){
			$(".delivery").click(function() {
				alert("asdsa")
			})};
</script>

</head>

<body id="main">
	<%@include file="header.jsp" %>
	<div id="app">
		<div class="page index" data-reactroot="">
			<div class="orders-container">
				<div style="float:left">
					<div class="orders-link-box">
						<div class="link-group">
							<p class="title">
							<h1>
								<a href="http://www.meituan.com/account/userinfo/"
									style="color: #31BBAC;">御膳房</a>
							</h1>
							</p>
						</div>
						<div class="link-group">
							<p class="title">
								<a href="http://www.meituan.com/rates/list/torate">我的订单</a>
							</p>
							<ul class="link-ul">
								<li><a href="http://www.meituan.com/rates/list/torate">待付款</a><span
									class="num"></span><i class="icon-right"></i></li>
								<li><a href="http://www.meituan.com/rates/list/rated">已付款</a><span
									class="num"></span><i class="icon-right"></i></li>
							</ul>
						</div>

						<div class="link-group">
							<p class="title">
								<a href="http://www.meituan.com/rates/list/torate">我的评价</a>
							</p>
							<ul class="link-ul">
								<li><a href="http://www.meituan.com/rates/list/torate">待评价</a><span
									class="num"></span><i class="icon-right"></i></li>
								<li><a href="http://www.meituan.com/rates/list/rated">已评价</a><span
									class="num"></span><i class="icon-right"></i></li>
							</ul>
						</div>
						<div class="link-group">
							<p class="title">
								<a href="http://www.meituan.com/account/settings">个人信息</a>
							</p>
							<ul class="link-ul">
								<li><a href="http://www.meituan.com/account/settings">账户设置</a><span
									class="num"></span><i class="icon-right"></i></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="orders-box clearfix">
					<div class="orders">
						<div class="orders-head">
							<ul class="orders-ul clearfix">
								<li class="order-condition active">全部订单</li>
								<li class="order-condition ">待付款<span class="num"></span></li>
								<li class="order-condition">已付款</li>
								<li class="order-condition">待评价<span class="num"></span></li>
								<li class="order-condition">退款/售后</li>
							</ul>
						</div>

						<!--订单模板开始-->
						<div id="productDiv"></div>

						<!--订单模板结束-->

					</div>

					<div class="btn-box"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
<%@include file="footer.jsp" %>
</body>

<!--点击订单状态筛选响应事件-->
<script type="text/javascript">
	$(document).ready(

		function() {
			$(".order-condition").click(function() {
				var clickIndex = $(this).index();
				var itmes = document.getElementsByClassName("order-condition")
				for (var i = 0; i < itmes.length; i++) {
					itmes[i].className = "order-condition ";
				}
				this.className = "order-condition active"
				alert(clickIndex)

			});

		}

	);
</script>

</html>