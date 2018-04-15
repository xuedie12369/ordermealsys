<!DOCTYPE HTML>
<html>

	<head>
		<meta charset="utf-8">
		<title>鼠标悬浮高亮的表格</title>
		<%@ page language="java" pageEncoding="UTF-8"%>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/build.css">
		<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
		<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
		
		<script src="//www.jsviews.com/download/jsviews.js"></script>
		<style>
			th {
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
					var checkBoxs = document.getElementsByName("checkBox");
					for(var i = 0; i < checkBoxs.length; i++) {
						checkBoxs[i].checked = !checkBoxs[i].checked;
					}
				});
			});
		</script>
		<!--全选按钮结束-->

		<!--改变购物车项目的处理函数开始-->
		<script>
			$(function() {

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
					if(cartItemNum > 1) {
						cartItemEle.value = cartItemNum - 1;
					}

				});

			})
		</script>
		<!--改变购物车项目的处理函数结束-->
		
		
		
		
<script type="application/javascript">
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
				if (0 == 0) {
				alert(data.data.allChecked)
				 var html = $("#productListTmpl").render(data.data.cartProductVoList); 
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


		
		
		
		<script id="productListTmpl" type="text/x-jsrender">

			<!--商品模块模板-->
				
					<!--显示购物车记录开始-->
					<tr>

						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
								<input type="checkbox" name="checkBox" />
								<a href="#" class="thumbnail" style="text-align: right;">
									<img src="1.png" alt="通用的占位符缩略图">
								</a>
							</div>
						</td>
						<td style="vertical-align: middle;">{{:productName}}</td>
						<td style="vertical-align: middle;">{{:productPrice}}</td>
						<td style="text-align: center;vertical-align: middle;">
							<div class="text-center">
								<span class="input-group">
									<span class="reduceBtn" data-cartItemId = "cartitemid">
											<button   class="btn btn-default" type="button"  data-cartItemId = "cartitemid">-</button>
										
									</span>
								<span class="addBtn" data-cartItemId="cartitemid">
												<input  name="cartItemQty" style="width:35px;height: 33px; text-align: center;" id="cartitemid" value="{{:productNumn}}"/>										  
										<button class="btn btn-default" type="button"  >+</button>				
									</span>
								</span>
							</div>

						</td>
						<td style="vertical-align: middle;"> 100</td>
						<td style="vertical-align: middle;">

							<a href="#" class="btn btn-info btn-group-sm">
								<span class="glyphicon glyphicon-trash"></span> 删除
							</a>
							</p>

						</td>
					</tr>

					<!--显示购物车记录结束-->

			<!--自己写的-->
			</script>

		
		<!-- <script type="text/javascript" charset="utf-8">
			$(function() {
				var dataSrouce ={
					jihe:[{
						name: "张三"
					},
					{
						name: "zhangsi"
					},
					{
						name: "张三"
					},
					{
						name: "张三"
					},
					{
						name: "张三"
					},
					{
						name: "张三"
					}, {
						name: "张三"
					}, {
						name: "张三"
					}, {
						name: "张三"
					}, {
						name: "张三"
					}, {
						name: "张三"
					},

				]
					
				}
				

				var html = $("#productListTmpl").render(dataSrouce.jihe);

				$("#productDiv").append(html);
			});
		</script>
 -->
		
		
	</head>

	<body>
		<form>
			<table class="table   table-hover table-condensed table-responsive " style="margin-bottom: 0px;">
				<thead>
					<!--购物车模块列表展示开始-->
					<tr>
						<th style="text-align: left;" class="col-sm-1">
							<input type="checkbox" id="checkAll" class="" /> 商品图片
						</th>
						<th class="col-sm-1">商品名称</th>
						<th class="col-sm-1">单价</th>
						<th class="col-sm-1" style="width: 4.8%;">数量</th>
						<th class="col-sm-1">金额</th>
						<th class="col-sm-1">操作</th>
					</tr>
					<!--购物车模块列表展示结束-->

				</thead>
				<tbody id="productDiv">
						
			
			  	
			  	
			  	
			  	
			  		<!--显示购物车记录开始-->
					<tr>

						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
								<input type="checkbox" name="checkBox" />
								<a href="#" class="thumbnail" style="text-align: right;">
									<img src="1.png" alt="通用的占位符缩略图">
								</a>
							</div>
						</td>
						<td style="vertical-align: middle;">商品名称</td>
						<td style="vertical-align: middle;">11</td>
						<td style="text-align: center;vertical-align: middle;">
							<div class="text-center">
								<span class="input-group">
									<span class="reduceBtn" data-cartItemId = "cartitemid">
											<button   class="btn btn-default" type="button"  data-cartItemId = "cartitemid">-</button>
										
									</span>
								<span class="addBtn" data-cartItemId="cartitemid">
												<input  name="cartItemQty" style="width:35px;height: 33px; text-align: center;" id="cartitemid" value="1"/>										  
										<button class="btn btn-default" type="button"  >+</button>				
									</span>
								</span>
							</div>

						</td>
						<td style="vertical-align: middle;"> 100</td>
						<td style="vertical-align: middle;">

							<a href="#" class="btn btn-info btn-group-sm">
								<span class="glyphicon glyphicon-trash"></span> 删除
							</a>
							</p>

						</td>
					</tr>

					<!--显示购物车记录结束-->

					<tr>

						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
								<input type="checkbox" name="checkBox" />
								<a href="#" class="thumbnail" style="text-align: right;">

									<img src="1.png" alt="通用的占位符缩略图">
								</a>
							</div>

						</td>
						<td style="vertical-align: middle;">商品名称</td>
						<td style="vertical-align: middle;">11</td>
						<td style="text-align: center;vertical-align: middle;">
							<div class="text-center">
								<span class="input-group">
									<span class="reduceBtn" data-cartItemId = "cartitemid1">
											<button   class="btn btn-default" type="button"  >-</button>
										
									</span>
								<span class="addBtn" data-cartItemId="cartitemid1">
												<input  name="cartItemQty" style="width:35px;height: 33px; text-align: center;" id="cartitemid1" value="1"/>										  
										<button class="btn btn-default" type="button"  >+</button>				
									</span>
								</span>
							</div>

						</td>
						<td style="vertical-align: middle;"> 100</td>
						<td style="vertical-align: middle;">

							<a href="#" class="btn btn-info btn-group-sm">
								<span class="glyphicon glyphicon-trash"></span> 删除
							</a>
							</p>

						</td>
					</tr>

				
				
				


				</tbody>
			</table>
			<div style="text-align: right;">
				<tr>
					<button class="btn btn-danger " href="">结算</button>
				</tr>
			</div>

		</form>

	</body>

</html>