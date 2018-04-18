<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<%@ page language="java" pageEncoding="UTF-8"%>
		<title>鼠标悬浮高亮的表格</title>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
			
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

	
		<!--改变购物车项目的处理函数结束-->
		
		
		
		
		
			<!--商品模块模板-->
		<script id="listTmpl" type="text/x-jsrender">

					<tr>

						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
								<!--<input type="checkbox" name="checkBox" />-->
								<a href="#" class="thumbnail" style="text-align: right;">

									<img src="1.png" alt="通用的占位符缩略图">
								</a>
							</div>

						</td>
						<td style="vertical-align: middle;">商品名称</td>
						<td style="vertical-align: middle;">11</td>

						<td style="vertical-align: middle;">111</td>
						<td style="vertical-align: middle;">11</td>
						<td style="vertical-align: middle;">
							<span class="productStatus" data-productId="1">
							<a href="#" class="btn btn-info btn-group-sm" >
								下架
							</a>
							</span>
							<span class="productStatus" data-productId="2">
						<a href="#" class="btn btn-info btn-group-sm">
								<span class="glyphicon glyphicon-trash"></span> 删除
							</a>
							</span>
							<span  class="productStatus" data-productId="3">
										<a href="#" class="btn btn-info btn-group-sm">
							编辑
							</a>
							</span>
						</td>
					</tr>

		
		</script>
		
		
		<script type="text/javascript" charset="utf-8">
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
				

				var html = $("#listTmpl").render(dataSrouce.jihe);

				$("#listDiv").append(html);
			});
		</script>
	
	
<!-- 	<script type="application/javascript">
	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "POST",
			url : 'manage/product/list.do',
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

 -->

	
	
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

					//				点击的是删除的响应
					$(".productStatus").click(function() {
				/* 		 var cartItemId=this.dataset.productid */
						/*var cartItemEle = document.getElementById(cartItemId);
						var cartItemNum = parseInt(cartItemEle.value);*/ 
						alert("asda");
						

					});

				}

			)
		</script>
	
	
	
	
	
	</head>

	<body>
	
		<form>
			<table class="table   table-hover table-condensed table-responsive " style="margin-bottom: 0px;">
				<thead>
					<!--商品管理模块列表展示开始-->
					<tr>
						<th style="text-align: left;" class="col-sm-1">
							商品图片
						</th>
						<th class="col-sm-1">商品名称</th>
						<th class="col-sm-1">价格</th>
						<th class="col-sm-1" style="width: 4.8%;">库存</th>
						<th class="col-sm-1">销量</th>
						<th class="col-sm-1">操作</th>
					</tr>
					<!--商品管理模块列表展示结束-->

				</thead>
				<tbody id="listDiv">


			<!--一行模板-->
				
					<tr>

						<td>
							<div class="col-sm-6 col-md-5 checkbox-inline">
								<!--<input type="checkbox" name="checkBox" />-->
								<a href="#" class="thumbnail" style="text-align: right;">

									<img src="1.png" alt="通用的占位符缩略图">
								</a>
							</div>

						</td>
						<td style="vertical-align: middle;">商品名称</td>
						<td style="vertical-align: middle;">11</td>

						<td style="vertical-align: middle;">111</td>
						<td style="vertical-align: middle;">11</td>
						<td style="vertical-align: middle;">
							<span class="productStatus" data-productId="1">
							<a href="#" class="btn btn-info btn-group-sm" >
								下架
							</a>
							</span>
							<span class="productStatus" data-productId="2">
						<a href="#" class="btn btn-info btn-group-sm ">
							<span class="glyphicon glyphicon-trash"></span>删除
							</a>
							</span>
							<span  class="productStatus" data-productId="3">
										<a href="#" class="btn btn-info btn-group-sm">
							编辑
							</a>
							</span>
						</td>
					</tr>

		
				
				</tbody>
			</table>

		</form>

	</body>

</html>