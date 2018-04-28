<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<!-- 引入jsrender插件 -->
<script src="js/jsviews.js"></script>

<!-- 地址模块模板-->
<script id="qrTmpl" type="text/x-jsrender">
		<p>
				<a href="#" class="btn btn-info btn-lg">
					<span class="glyphicon   glyphicon-ok"></span> 订单编号:111
				</a>
			</p>
		<div class="col-sm-6 col-md-3" style="margin-left: 38%;" >
			<a href="#" class="thumbnail"  >
			<img src="qr-18.png" alt="" style="text-align: center;">
			</a>
		</div>
</script>
<script type="text/javascript">
	
</script>

<script type="text/javascript" charset="utf-8">
	

	$(function() {
		/*    var fd = new FormData(document.querySelector("form")); */
		$.ajax({
			type : "GET",
			url : 'order/pay.do',
			/*contentType : "application/json; charset=utf-8", */
			contentType : "application/x-www-form-urlencoded",
			/* 	data : $('#J-normal-form').serialize(), */
			/*  data: fd,  */
			dataType : "json",
			success : function(data) {
				var html = $("#qrTmpl").render(dataSrouce);
				$("#qr").append(html);
				console.log(data.data);
			},
			error : function() {
				alert("提交数据失败");
			}
		});
	});


		

</script>

<body>
	
<!-- 引入header -->
<%@include file="header.jsp" %>

	<div class="container" style=" text-align: center; margin-top: 10px;" id="qr">
			
	</div>
<%@include file="footer.jsp" %>

</body>

</html>