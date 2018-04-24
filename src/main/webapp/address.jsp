<!DOCTYPE html>
<html lang="zh">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ page language="java" pageEncoding="UTF-8"%>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<link href="css/simsCheckbox.css" rel="stylesheet" type="text/css">
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet" />
<script src="js/jquery-3.2.1.js"></script>
<!-- 引入jsrender插件 -->
<script src="//www.jsviews.com/download/jsviews.js"></script>
<script src="js/simsCheckbox.js" type="text/javascript"></script>

<!-- 地址模块模板-->
<script id="productListTmpl" type="text/x-jsrender">
<li class="sims-selectable btn btn-block btn-social btn-default">
					</i> 地址
				</li>
</script>
<script type="text/javascript">
	
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
<script type="text/javascript"> 	
var username='<%=session.getAttribute("username")%>';
if(username==null)
{
	alert("请先登录");
	window.location(login.jsp);
}
	/* alert("用户名是:"+username); 
	/* $(function() {
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
	/* 				changeNum();
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
	}); */
</script>


<style type="text/css">
.container {
	background: #fff;
	padding: 2em 0;
}
</style>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-body">
			<ul class="demo" style="margin: 0px; padding: 0px; height: auto;" id="productDiv">
				<li class="sims-selectable btn btn-block btn-social btn-default">
					</i> Lorem ipsum dolor sit amet
				</li>

			</ul>
		</div>
	</div>
	</div>
	<input type="hidden" id="detailAdd" name="detailAdd" value="é»è®¤ç" />

	<script type="text/javascript">
		$(document).ready(function() {
			$(".demo").simsCheckbox({
				"checkedClass" : 'btn-info'
			});
		});
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$(".sims-selectable").click(function() {
	
				var addressItems = document.getElementsByTagName("li")
				var addressChecks = document.getElementsByClassName("fa")
				for (var i = 0; i < addressItems.length; i++) {
					addressItems[i].className = "sims-selectable btn btn-block btn-social btn-default";
					addressChecks[i].className = "fa fa-fw fa-square-o"
				}
				this.className = "sims-selectable btn btn-block btn-social btn-info"
				addressChecks[$(this).index()].className = "fa fa-fw fa-check-square-o"
				$("#detailAdd").val(this.innerText)
	
			});
	
		});
	</script>

</body>

</html>