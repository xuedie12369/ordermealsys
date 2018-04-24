<!DOCTYPE html>

<meta name="renderer" content="webkit">

<title ng-bind="SEO.title" class="ng-binding">记得回来点单哦！ - 饿了么</title>

<meta name="format-detection" content="telephone=no, email=no">

<!--不可删除部分-->
<link href="https://shadow.elemecdn.com/faas/desktop/vendor.606e96.css" rel="stylesheet">
<link href="https://shadow.elemecdn.com/faas/desktop/main.fb5e6b.css" rel="stylesheet">
<!--不可删除部分结束-->

<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- 引入jsrender插件 -->
<script src="//www.jsviews.com/download/jsviews.js"></script>

<script id="productListTmpl" type="text/x-jsrender">
	<dd ng-repeat="item in basket" class="ng-scope" >
							<div class="checkoutcart-tablerow">
								<div class="cell itemname ng-binding" ng-bind="item.name" title="肉碎肠粉-超大份">肉碎肠粉-超大份</div>
								<div class="cell itemquantity">
									<button ng-click="cart.sub(item)" class="reduceBtn" data-cartitemid="cartItemId" type="button">-</button>
									<input ng-model="item.quantity" id="3"min="1" value="1" ng-change="cart.update(item)" "="" class="ng-pristine ng-valid">
									<button class="addBtn" data-cartitemid="cartItemId" type="button">+</button></div>
								<div class="cell itemtotal ng-binding" ng-bind="'¥' + (item.price * item.quantity | number:2)">¥18.00</div>
							</div>
						</dd>

</script>
 
<script type="text/javascript" charset="utf-8">
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



<!--添加按钮开始-->
<script>
	$(function() {
		$(".addBtn").click(function() {
			//  	获得被点击按钮对象
			//	var  a=	document.getElementById('first');
			//		获得被点击按钮的data-index的值
			var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById(cartItemId);
			var cartItemNum = parseInt(cartItemEle.value);
			cartItemEle.value = cartItemNum + 1;
		});

	})
</script>

<!--添加按钮结束-->

<script>
	$(function() {
		$("#submitOrder").click(function() {
		});

	})
</script>

<!--减少按钮-->
<script>
	$(function() {
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
	})
</script>

<!--点击地址列表影响事件-->
		<script type="text/javascript">
			$(document).ready(function() {
				$(".checkout-address").click(function() {
				var addressItems = document.getElementsByTagName("li")
//					var addressChecks = document.getElementsByClassName("fa")
					for(var i = 0; i < addressItems.length; i++) {
						addressItems[i].className = "checkout-address ng-scope ";
					}
					this.className = "checkout-address ng-scope  active"
//					赋值给隐藏域
				$("#addressId").val(this.id)
				});
			});
		</script>

</head>

<body style="height: auto;" cute-title="">

	<form>

		<div class="container clearfix ng-scope">

			<div ng-if="!loading &amp;&amp; !nofood" class="checkout-cart ng-scope ng-isolate-scope" checkout-cart="cart">
				<div class="checkoutcart-container">
					<div class="checkoutcart-title">
						<h2>订单详情</h2>
						<a ng-href="/shop/159433790" href="">&lt; 返回首页</a>
					</div>
					<div class="checkoutcart-tablerow tablehead">
						<div class="cell itemname">商品</div>
						<div class="cell itemquantity">份数</div>
						<div class="cell itemtotal">小计（元）</div>
					</div>
					<!-- ngRepeat: basket in cart.vm.group -->
					<!-- ngIf: basket.length -->
							
					<dl id="productDiv" ng-if="basket.length" ng-repeat="basket in cart.vm.group" class="checkoutcart-group ng-scope">
						<!-- ngRepeat: item in basket -->

						<!--购物车显示模块开始-->
						<dd ng-repeat="item in basket" class="ng-scope" >
							<div class="checkoutcart-tablerow">
								<div class="cell itemname ng-binding" ng-bind="item.name" title="肉碎肠粉-超大份">肉碎肠粉-超大份</div>
								<div class="cell itemquantity">
									<button ng-click="cart.sub(item)" class="reduceBtn" data-cartitemid="cartItemId" type="button">-</button>
									<input ng-model="item.quantity" id="cartItemId" min="1" value="1" ng-change="cart.update(item)" "="" class="ng-pristine ng-valid">
									<button class="addBtn" data-cartitemid="cartItemId" type="button">+</button></div>
								<div class="cell itemtotal ng-binding" ng-bind="'¥' + (item.price * item.quantity | number:2)">¥18.00</div>
							</div>
						</dd>
						<!--购物车显示模块结束-->

					</dl>
					<ul ng-if="cart.vm.extra || cart.vm.records " class="ng-scope ">
						<!-- ngRepeat: item in cart.vm.extra -->
						<li ng-repeat="item in cart.vm.extra " class="checkoutcart-tablerow extra ng-scope ">
							<div class="cell itemname "><span ng-bind="item.name " title="配送费 " class="ng-binding ">配送费</span>
								<!-- ngIf: item.name === '配送费' --><span ng-if="item.name==='配送费' " class="icon-circle-help ng-scope " tooltip=" " tooltip-placement="left "></span>
								<!-- end ngIf: item.name === '配送费' -->
							</div>
							<div class="cell itemquantity "></div>
							<div class="cell itemtotal ng-binding " ng-class="{minus: item.price < 0} " ng-bind=" '¥' + (item.price | number:2) ">¥4.00</div>
						</li>
					</ul>
					<div class="checkoutcart-total color-stress ">¥<span class="num ng-binding " ng-bind="cart.vm.total | number: 2 ">35.90</span></div>
					<div class="checkoutcart-totalextra ">共 <span ng-bind="cart.pieces " class="ng-binding ">3</span> 份商品
						<!-- ngIf: cart.vm.benefit -->
					</div>
				</div>
			</div>
		
			<div ng-if="!loading &amp;&amp; !nofood " class="checkout-content ng-scope " style="height: auto;">
				<div class="checkout-select ng-isolate-scope " checkout-address=" " checkout-data="checkoutData " address-list="addressList " address="address " isbaisheng="isBaishengRst ">
					<h2>收货地址 <a ng-show="addressList.length " class="checkout-addaddress " href="javascript: " ng-click="addAddress() ">添加新地址</a></h2>

 	<input type="hidden" id="addressId" />

		<ul ng-hide="!addressList.length" class="checkout-address-list showmore" ng-class="{ showmore: showMoreAddress, showfirst: noInitAddress }">
				<!-- ngRepeat: item in addressList -->
				<!-- end ngRepeat: item in addressList -->
				<!-- end ngRepeat: item in addressList -->
				<li class="checkout-address ng-scope active" ng-repeat="item in addressList" ng-click="selectAddress($event, item)" ng-class="{active: address.id === item.id}" ng-mouseenter="selectAddress($event, item)"><i class="checkout-address-icon icon-location-line"></i>
					<div class="checkout-address-info">
						<p ng-bind="item.name + [' ', ' 先生 ', ' 女士 '][item.sex] + item.phone" class="ng-binding">邵海楠 先生 18924933537</p>
						<p class="color-weak ng-binding" ng-bind="item.address + item.address_detail">吴文陆图书馆电子科技大学中山学院图书馆(到图书馆门口了打电话)</p>
					</div>
					<div class="checkout-address-edit">
					<!--	<a href="javascript:" ng-click="editAddress($event, item)">修改</a>
						<a href="javascript:" ng-click="removeAddress($event, item)">×</a>-->
					</div>
				</li>
				<!-- end ngRepeat: item in addressList -->
				<li  id="addItem" class="checkout-address ng-scope" ng-repeat="item in addressList" ng-click="selectAddress($event, item)" ng-class="{active: address.id === item.id}" ng-mouseenter="selectAddress($event, item)"><i class="checkout-address-icon icon-location-line"></i>
					<div class="checkout-address-info">
						<p ng-bind="item.name + [' ', ' 先生 ', ' 女士 '][item.sex] + item.phone" class="ng-binding">邵海楠 先生 15319109070</p>
						<p class="color-weak ng-binding" ng-bind="item.address + item.address_detail">如家快捷酒店(天坛红桥店)天坛东路66号1层118号房(到了打电话，)</p>
					</div>
					<div class="checkout-address-edit">
						<a href="javascript:" ng-click="editAddress($event, item)">修改</a>
						<a href="javascript:" ng-click="removeAddress($event, item)">×</a>
					</div>
					<!-- ngIf: !item.st_geohash -->
					<!-- ngIf: !item.is_deliverable -->
					<!-- end ngIf: !item.is_deliverable -->
					<!-- ngIf: item.st_geohash && item.poi_type === 1 && isbaisheng -->
				</li>
				
				<!-- end ngRepeat: item in addressList -->
				<li class="checkout-address ng-scope" ng-repeat="item in addressList" ng-click="selectAddress($event, item)" ng-class="{active: address.id === item.id}" ng-mouseenter="selectAddress($event, item)"><i class="checkout-address-icon icon-location-line"></i>
					<div class="checkout-address-info">
						<p ng-bind="item.name + [' ', ' 先生 ', ' 女士 '][item.sex] + item.phone" class="ng-binding">邵先生 先生 18924933537</p>
						<p class="color-weak ng-binding" ng-bind="item.address + item.address_detail">电子科技大学中山学院宿舍楼18幢728</p>
					</div>
					<div class="checkout-address-edit">
						<a href="javascript:" ng-click="editAddress($event, item)">修改</a>
						<a href="javascript:" ng-click="removeAddress($event, item)">×</a>
					</div>
					<!-- ngIf: !item.st_geohash -->
					<!-- ngIf: !item.is_deliverable -->
					<!-- ngIf: item.st_geohash && item.poi_type === 1 && isbaisheng -->
				</li>
				
				
				
				<!-- end ngRepeat: item in addressList -->
				<a class="checout-showmoreaddress ng-hide" href="javascript:" ng-click="showMoreAddress = true" ng-show="!showMoreAddress &amp;&amp; addressList.length > 1">显示更多地址<i class="icon-arrow-down"></i></a>
				<a class="checout-showmoreaddress" href="javascript:" ng-click="showMoreAddress = false" ng-show="showMoreAddress &amp;&amp; addressList.length > 1">收起<i class="icon-arrow-up"></i></a>
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
								<div><button quicksubmit-trigger="" submit-visable="checkout.submitVisable" class="btn-stress btn-lg ng-binding ng-isolate-scope" ng-disabled="orderButton.disabled" ng-bind="orderButton.text" ng-click="orderSubmit()">确认下单</button>
								</div>
							</div>
							<!-- end ngIf: !loading && !nofood -->
				</div>
	</form>
</body>

</html>