<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<script src="js/jquery-3.2.1.js"></script>
<!-- 引入jsrender插件 -->
<script src="//www.jsviews.com/download/jsviews.js"></script>


<!--商品模块模板-->
<script id="productDetailTmpl" type="text/x-jsrender">
			<div class="form-inline form-group  "
				style="margin-left:30%; width: auto;">
				<div class=" col-lg-10 form-inline">
					<!--//图片模块-->
					<div class="col-sm-4" style="height: 250px;">
						<!--<input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的邮箱地址">-->
						<img class=" img-responsive input-group-sm" src="1.png"
							width="300px" height="400px" />
					</div>
					<div class="form-inline col-sm-4"
						style="float: left; height: 250px;">
						<div class="form-group">
							<div class=" col-sm-9">
								<h5>名称:{{:name}}</h5>
								<input type="hidden" id="productId" value="1" />
							</div>
							<div class=" col-sm-9">
								<h5>价格:{{:price}}</h5>
							</div>

							<div class=" col-sm-9">
								<h5>商品销量:{{:stock}}</h5>
							</div>
							<div class=" col-sm-9 ">
								<button type="submit" class="btn btn-default " id="addBtn">+</button>
								<input type="text" id="cartItemQty" name="count"
									class="form-control text-center" style="width: 45px;" value="1"></input>
								<button type="submit" class="btn btn-default " id="reduceBtn">-</button>
							</div>

							<div class=" col-sm-9">
								<button type="submit" class="btn btn-danger"
									style="margin-top: 15px;" id="addToCart">加入购物车</button>

							</div>
							<div class=" col-sm-9">
								<button type="submit" class="btn btn-danger"
									style="margin-top: 5px;" id="addToCart">&nbsp; 立即购买
									&nbsp;</button>
							</div>

						</div>

					</div>
				</div>
			</div>

<div class=" form-inline" style="text-align: center; margin-top: 30px;">

		{{:detail}}
</div>
		
</script>





<!--改变购物车项目的处理函数开始-->
<script>
	function changeNum() {
		$("#addBtn").click(function() {
			//  	获得被点击按钮对象
			//				var  a=	document.getElementById('cartItemId');
			//		获得被点击按钮的data-index的值
			//					var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById('cartItemQty');
			var cartItemNum = parseInt(cartItemEle.value);
			cartItemEle.value = cartItemNum + 1;
		});
		$("#reduceBtn").click(function() {

			var cartItemEle = document.getElementById('cartItemQty');
			var cartItemNum = parseInt(cartItemEle.value);
			if (cartItemNum > 1) {
				cartItemEle.value = cartItemNum - 1;

			}

		});

	}
</script>
<!--改变购物车项目的处理函数结束-->

<script type="text/javascript">
	$(function() {
		var url = location.search.substr(1);
		var id = -1;
		if (url != null) {
			var params = url.split("&");
			for (var i = 0; i < params.length; i++) {
				var attrMap = params[i].split("=");
				if (attrMap[0] == "id") {
					id = attrMap[1];
				}
			}
		}
		/* 异步查询商品信息 */
		$.ajax({
			type : "GET",
			url : 'product/detail.do',
			contentType : "application/x-www-form-urlencoded",
			data : {
				productId : id
			},
			dataType : "json",
			success : function(data) {
				if (data.status == 0) {
					console.log(data.data)
					var html = $("#productDetailTmpl").render(data.data);
					$("#productDetail").append(html);
					/* 	 添加改变购物车项目的处理函数开始 */
					changeNum();
					<!-- 异步添加商品到购物车 -->
					addToCart();
				} else {
					alert(data.msg);
				}
			},
			error : function() {
				alert("提交数据失败");
			}
		});
	})
</script>
<!-- 异步添加商品到购物车 -->

<script>
	function addToCart() {
		$("#addToCart").click(function() {
			$.ajax({
				type : "GET",
				url : 'cart/add.do',
				contentTyp : "application/x-www-form-urlencoded",
				//						data: $('#register-form').serialize(),
				data : {
					count : $("#cartItemQty").val(),
					productId : $("#productId").val()
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





<body>

	<div class=" form-inline" style="height: ;" style="height: 600px; ">
		<div id="productDetail"></div>

	</div>

</body>

</html>