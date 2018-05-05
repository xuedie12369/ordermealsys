<!DOCTYPE html>

<meta name="renderer" content="webkit">

<title ng-bind="SEO.title" class="ng-binding">记得回来点单哦！ - 饿了么</title>
<%@ page language="java" pageEncoding="UTF-8"%>
<meta name="format-detection" content="telephone=no, email=no">

<!--不可删除部分-->
<link href="https://shadow.elemecdn.com/faas/desktop/vendor.606e96.css" rel="stylesheet">
<link href="https://shadow.elemecdn.com/faas/desktop/main.fb5e6b.css" rel="stylesheet">
<link href="css/order.css" rel="stylesheet">

<!--不可删除部分结束-->

<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- 引入jsrender插件 -->
<script src="js/jsviews.js"></script>

<script id="orderItemListTmpl" type="text/x-jsrender">
	
	<div ng-switch-when="food" class="orderprogress-totalrow ng-scope">





<span class="cell name ng-binding" ng-bind="row.food.name">这里是名称</span>
<span class="cell quantity ng-binding" ng-bind="row.food.quantity">这里是数量</span>
<span class="cell price ng-binding" ng-bind="row.food.price * row.food.quantity | number:2">这里价格</span>


</div>


</script>
<script id="addressListTmpl" type="text/x-jsrender">
	<li  data-addressId="{{:id}}"  class="checkout-address ng-scope " ng-repeat="item in addressList" ng-click="selectAddress($event, item)" ng-class="{active: address.id === item.id}" ng-mouseenter="selectAddress($event, item)"><i class="checkout-address-icon icon-location-line"></i>
					<div class="checkout-address-info">
						<p ng-bind="item.name + [' ', ' 先生 ', ' 女士 '][item.sex] + item.phone" class="ng-binding">{{:consigneeName}} {{if sex ==1}}男{{/if}}
					{{if age ==0}} 女 {{/if}} {{:tel}}</p>
						<p class="color-weak ng-binding" ng-bind="item.address + item.address_detail">{{:detailedAdd}}</p>
					</div>
					<div class="checkout-address-edit" >
				<a  class="updateAddress" href="updateAddress.jsp?id={{:id}}" ng-click="editAddress($event, item)">修改</a>
						<a class="deleteAddress" data-addressId = "{{:id}}" style="color: red;" href="javascript:" ng-click="removeAddress($event, item)"><span class="glyphicon glyphicon-trash"></span></a>
					</div>
				</li>
</script>
 
<script type="text/javascript" charset="utf-8">
	$(function() {
		
		
		reduceBtn();
		addBtn();
	});

</script>


<!--添加按钮开始-->
<script>
	function addBtn() {
		$(".addBtn").click(function() {
			//  	获得被点击按钮对象
			//	var  a=	document.getElementById('first');
			//		获得被点击按钮的data-index的值
			var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById(cartItemId);
			var cartItemNum = parseInt(cartItemEle.value);
			cartItemEle.value = cartItemNum + 1;
		});

	}
</script>
<!--减少按钮-->
<script>
	function reduceBtn() {
		$(".reduceBtn").click(function() {
			var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById(cartItemId);
			var cartItemNum = parseInt(cartItemEle.value);
			if(cartItemNum <= 1) {
				cartItemEle.value = 1;
			} else {
				cartItemEle.value = cartItemNum - 1;
			}

		});
		}
</script>

<!--添加按钮结束-->

<script>
	$(function() {
		$("#submitOrder").click(function() {
		submitOrder();
		});

	})
</script>



<!--点击地址列表影响事件-->
		<script type="text/javascript">
		function address() {
				$(".checkout-address").click(function() {
				var addressItems = document.getElementsByClassName("checkout-address ng-scope")
//					var addressChecks = document.getElementsByClassName("fa")
					for(var i = 0; i < addressItems.length; i++) {
						addressItems[i].className = "checkout-address ng-scope ";
					}
					this.className = "checkout-address ng-scope  active"
//					赋值给隐藏域
				$("#addressId").val(this.dataset.addressid)
				});
				
					$(".deleteAddress").click(function() {
					   var addressId=this.dataset.addressid;
					deletePro(addressId);
				});
			}
		</script>


<!-- 异步查询收货地址开始 -->

<script type="text/javascript" charset="utf-8">
	
function addressList(){
		$.ajax({
			type : "GET",
			url : 'shipping/list.do',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(data) {
				if(data.status==0)
				{
				
				var html = $("#addressListTmpl").render(data.data.list);
				/* $("#addressList").append(html);  */
				$("#addressList").html(html);
				address(); 
				}
				else
				{
					alert(data.msg)
					window.location.href = "login.jsp"
					
				}
				console.log(data);
				console.log(data.data);
			},
			error : function() {
				alert("提交数据失败");
			}
		});
};
$(function(){

addressList();
/* orderItemList(); */
}
);


</script>

<script>
 orderItemList();
		
function orderItemList(){
		$.ajax({
			type : "GET",
			url : 'cart/select_checked_product.do',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(data) {
				if(data.status==0)
				{
				console.log(data);
				
				address(); 
		var html = $("#orderItemListTmpl").render(data.data)	
		$("#orderItem").append(html);
				}
				else
				{
					alert(data.msg)
					window.location.href = "login.jsp"
					
				}
				console.log(data);
				console.log(data.data);
			},
			error : function() {
				alert("提交数据失败");
			}
		});
};



</script>

<!-- 异步查询收货地址开始结束 -->




<!-- ajax异步删除-->
<script>
	function deletePro( addressId) {
			$.ajax({
				type : "GET",
				url : 'shipping/delete.do',
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				data:{addressId:addressId},
				success : function(data) {
					if (data.status == 0) {
						console.log(data)
						addressList();
					} else {
						alert(data.msg);
					}
				},
				error : function() {
					alert("提交数据失败");
				}
			});

}
</script>






<!-- ajax异步提交订单-->
<script>
	function submitOrder( addressId) {
			$.ajax({
				type : "POST",
				url : 'order/create.do',
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				data:{addressId:$('#addressId').val()},
				success : function(data) {
					var orderNo=data.data.orderNo;
					console.log(data);
					var str="pay.jsp?id="+orderNo+"";
					 window.location.href =str; 
				},
				error : function() {
				 	alert("提交数据失败"); 
				}
			});

}
</script>








</head>

<body style="height: auto;" cute-title="">
	
<!-- 引入header -->
<%@include file="header.jsp" %>
	<div>

		<div class="container clearfix ng-scope">

			<div ng-if="!loading &amp;&amp; !nofood" class="checkout-cart ng-scope ng-isolate-scope" checkout-cart="cart">
				<div class="checkoutcart-container">
					<!-- ngRepeat: basket in cart.vm.group -->
					<!-- ngIf: basket.length -->
				
					
						<div class="orderprogress-total" id="productDiv" >
												<div class="orderprogress-totalrow orderprogress-totaltitle" style="width: ;"><span class="cell name">菜品</span> <span class="cell quantity">数量</span> <span class="cell price">单价（元）</span></div>
												<!-- ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->

															<div id="orderItem">
															
															</div>
																											
										

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
													<div ng-switch-when="extra" class="orderprogress-totalrow ng-scope"><span class="cell name ng-binding" ng-bind="row.extra.name">餐盒</span> <span class="cell quantity"></span> <span class="cell price ng-binding" ng-class="{minus: row.extra.price < 0}" ng-bind="row.extra.price | number:2">0.00</span></div>
												</div>
												<!-- end ngRepeat: row in totalList -->
												<div ng-repeat="row in totalList" ng-switch="" on="row.type" class="ng-scope">
													<!-- ngSwitchWhen: baseline -->
													<!-- ngSwitchWhen: basketTitle -->
													<!-- ngSwitchWhen: food -->
													<!-- ngSwitchWhen: extra -->
													<div ng-switch-when="extra" class="orderprogress-totalrow ng-scope"><span class="cell name ng-binding" ng-bind="row.extra.name">配送费</span> <span class="cell quantity"></span> <span class="cell price ng-binding minus" ng-class="{minus: row.extra.price < 0}" ng-bind="row.extra.price | number:2">0.00</span></div>
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
												<div class="orderprogress-totalactual">实际支付：<span ng-bind="order.total_amount | number:2" class="ng-binding">111</span></div>
											</div>
						<!--购物车显示模块结束-->

					</dl>
				</div>
			</div>
		
			<div ng-if="!loading &amp;&amp; !nofood " class="checkout-content ng-scope " style="height: auto;">
				<div class="checkout-select ng-isolate-scope " checkout-address=" " checkout-data="checkoutData " address-list="addressList " address="address " isbaisheng="isBaishengRst ">
					<h2>收货地址 <a ng-show="addressList.length " class="checkout-addaddress " href="addAddress.jsp" ng-click="addAddress() ">添加新地址</a></h2>

 	<input type="hidden" id="addressId" value="-1" name="addressId" />

		<ul  id="addressList"  ng-hide="!addressList.length" class="checkout-address-list showmore" ng-class="{ showmore: showMoreAddress, showfirst: noInitAddress }">
				
				
				
				
			</ul>
								</div>
								<div class="checkout-select">
									<h2 class="checkout-title">其他信息</h2>
									<div class="checkout-info"><span class="checkout-infolabel">配送方式</span> <span>本订单由<a ng-bind="' [' + delivery + '] '" class="ng-binding"> 蜂鸟 </a>提供配送</span></div>

									<div class="checkout-info" ng-show="showDeliverTime"><span class="checkout-infolabel">送达时间</span>
										<div class="formselect ng-isolate-scope" formselect="" data="bookTimes" cancle-default-handle="true" choosed="time" selectfn="updateDeliverTime"><span class="formselect-value ng-binding">立即送达</span>
										</div>
										<div class="checkout-info"><span class="checkout-infolabel" style="margin-top: 30px; ">订单备注</span> <span><input class="checkout-input ng-pristine ng-valid" ng-model="note" ng-change="updateDescription(note)"></span></div>
									</div>

								</div>
								<div><button quicksubmit-trigger="" submit-visable="checkout.submitVisable" class="btn-stress btn-lg ng-binding ng-isolate-scope" ng-disabled="orderButton.disabled" id="submitOrder" >确认下单</button>
								</div>
							</div>
							<!-- end ngIf: !loading && !nofood -->
				</div>
	</div>

<!-- 引入footer -->
<%@include file="footer.jsp" %>
</body>

</html>