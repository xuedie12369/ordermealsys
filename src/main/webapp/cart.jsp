<!DOCTYPE HTML>
<html>

<head>
<meta charset="utf-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script src="js/jsviews.js"></script>
<style>
.th {
	text-align: center;
	vertical-align: middle;
}

td {
	text-align: center;
	vertical-align: middle;
}

table-condensed {
	padding: 50px;
}
</style>

<!--全选按钮开始-->
<script>
	$(document).ready(function() {
		$("#checkAll").click(function() {
			var productIdss = document.getElementsByName("productIds");
			for (var i = 0; i < productIdss.length; i++) {
				/* alert(productIdss[i].dataset.productid) */
				productIdss[i].checked = !productIdss[i].checked;
			}
		});

	});
</script>

<!--全选按钮结束-->

<!-- 删除购物车项目函数开始 -->
<script type="text/javascript">

	function deleteItem() {
		$(".deleteItem").click(function() {
			var productIds = this.dataset.productid;
			alert(productIds)
			$.ajax({
				type : "GET",
				url : 'cart/delete_product.do?productIds=' + productIds + '',
				/*contentType : "application/json; charset=utf-8", */
				contentType : "application/x-www-form-urlencoded",
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						alert(data.msg);
						window.location.href = "cart.jsp";
					}
				},
				error : function() {
					alert("提交数据失败");
				}
			});
		});





	}
</script>
<!-- 删除购物车项目函数结束 -->


<!--商品模块模板-->
<script id="productListTmpl" type="text/x-jsrender">

			<!--商品模块模板-->
				
					<!--显示购物车记录开始-->
					<tr>
						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
<div style="float: left;">								
<input type="checkbox" name="productIds" value={{:id}} data-productId={{:id}}  /></div>
<div style="float: right;">
								<a href="productDetail.jsp?id={{:productId}}" class="thumbnail" style="text-align: right;">
									<img src="{{:productMainPic}}" alt="通用的占位符缩略图">
								</a>
</div>
							</div>
						</td>
						<td style="vertical-align: middle;">{{:productName}}</td>
						<td style="vertical-align: middle;">{{:productPrice}}</td>
						<td style="text-align: center;vertical-align: middle;">
							<div class="text-center">
								<span class="input-group">
									<span class="reduceBtn" data-cartItemId ={{:id}}>
											<button   class="btn btn-default" type="button"  >-</button>
									</span>
												<input  name="cartItemQty" style="width:35px;height: 33px; text-align: center;" id={{:id}} value={{:productNum}}>										  
									<span class="addBtn" data-cartItemId={{:id}}>
										<button class="btn btn-default" type="button"  >+</button>				
									</span>
								</span>
							</div>

						</td>
						<td style="vertical-align: middle;"> 100 </td>
						<td style="vertical-align: middle;" class="deleteItem" data-productId={{:productId}}>

							<a href="#"  class="btn btn-info btn-group-sm ">
								<span class="glyphicon glyphicon-trash" ></span> 删除
							</a>
							</p>

						</td>
					</tr>
						</td>
					</tr>
					<p>asdasdsadsad</p>

					<!--显示购物车记录结束-->

			<!--自己写的-->
			</script>


<!-- 异步查询数据 开始-->
<script type="text/javascript">

	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "GET",
			url : 'cart/list.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			/*  data: fd,  */
			dataType : "json",
			success : function(data) {
				if (data.status == 10) {
					alert(data.msg);
					window.location.href = "login.jsp"
				}
				var html = $("#productListTmpl").render(data.data.cartProductVoList);
				/* 追加内容 */
				$("#productDiv").append(html);
				console.log(data.data);
				addBtn();
				deleteItem();
				
			},
			error : function() {
				alert("提交数据失败");
			}
		});
	});



</script>
<!-- 异步查询数据结束 -->


<!-- 改变购物车项目的处理函数开始 -->
<script>
	function addBtn() {
		$(".addBtn").click(function() {
			//  	获得被点击按钮对象
			//				var  a=	document.getElementById('cartItemId');
			//		获得被点击按钮的data-index的值
			var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById(cartItemId);
			var cartItemNum = parseInt(cartItemEle.value);
			cartItemEle.value = cartItemNum + 1;
		});


		$(".reduceBtn").click(function() {
			var cartItemId = this.dataset.cartitemid;
			var cartItemEle = document.getElementById(cartItemId);
			var cartItemNum = parseInt(cartItemEle.value);
			if (cartItemNum > 1) {
				cartItemEle.value = cartItemNum - 1;
			}

		});
	}
</script>

<!-- 改变购物车项目的处理函数结束 -->




<script type="text/javascript">

$(function(){
	balance();
	clear();
});

function balance(){
	$("#balance").click(function() {
	alert("进来 了")
		$.ajax({
			type : "POST",
			url : 'cart/select.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			data: {productId:50}, 
			dataType : "json",
			success : function(data) {
				if (data.status == 10) {
					alert(data.msg);
					/* window.location.href = "login.jsp" */
				}
			
			},
			error : function() {
				alert("提交数据失败");
			}
		});
});	
};






/* 清空购物车 */
function clear(){
	$("#clear").click(function() {
		var productIdss=document.getElementsByName("productIds");
		var productIdStr="";
		var b=0;
		for(var i=0;i<productIdss.length;i++)
			{
				if(productIdss[i].checked)
					{
					productIdStr +=productIdss[i].value+","
					}
			}
});	
};















</script>
</head>

<body>

	<%@include file="header.jsp"%>

	<table class="table   table-hover table-condensed table-responsive "
		style="margin-bottom: 0px;">
		<thead>
			<!--购物车模块列表展示开始-->
			<tr>
				<th style="text-align: left;" class="col-sm-1"><input
					type="checkbox" id="checkAll" class="" /> 商品图片</th>
				<th class="col-sm-1" style="text-align: center;">商品名称</th>
				<th class="col-sm-1" style="text-align: center;">单价</th>
				<th class="col-sm-1" style="width: 4.8%; text-align: center;">数量</th>
				<th class="col-sm-1" style="text-align: center;">金额</th>
				<th class="col-sm-1" style="text-align: center;">操作</th>
			</tr>
			<!--购物车模块列表展示结束-->

		</thead>
		<tbody id="productDiv">

		</tbody>
	</table>
	<div style="text-align: right;margin-top: 5px">
		<tr>
			<button class="btn btn-danger " href="" id="balance" onclick="">结算</button>
		</tr>
		<tr>
			<button class="btn btn-danger " href="" id="clear">清空</button>
		</tr>
	</div>

	<!-- 引入footer -->
	<%@include file="footer.jsp"%>
	</table>

</body>
</html>