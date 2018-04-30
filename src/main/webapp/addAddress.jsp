
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<title>水平表单</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>



<!-- ajax保存地址 -->
<script>
	$(document).ready(function() {
		$("#save").click(function() {
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'shipping/add.do',
				contentType : "application/x-www-form-urlencoded",
				data : $('#addAddressForm').serialize(),
				//				data:{username:$("#username").val(),password:$("#password").val()},
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
						/* 	  var html = $("#testTmpl").render(data.data); */
						/* 	$("#list1").append(html); */
						/* $("#wenwebzhi").value(data.data.birth) */
						alert("添加成功");
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

	})
</script>



</head>

<body>

	<!-- 引入header -->
	<%@include file="header.jsp"%>
	<form class="form-horizontal" role="form"
		style="margin-left:30%;margin-right: auto;margin-top: 10px"
		id="addAddressForm">
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="consigneeName"
					placeholder="请输入收货人姓名">
			</div>
		</div>


		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">电话：</label>
			<div class="col-sm-3">
				<input type="tel" class="form-control" id="tel" name="tel"
					placeholder="请输入您的电话">
			</div>

		</div>


		<div class="form-group ">
			<label for="" class="col-sm-2 control-label">地址：</label>
			<div class="col-sm-3">
				<textarea class="form-control" rows="3" name="detailedAdd"></textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10 form-inline">
				<div class="radio">
					<label class=""> <input type="radio" name="sex" value="1">
						男

					</label>
				</div>
				<div class="radio">
					<label> <input type="radio" name="sex" value="0"> 女
					</label>

				</div>
			</div>
		</div>
<div class="form-group">
		<div class="col-sm-offset-3" id="save">
			<!-- <button type="button" class="btn btn-info ">保存</button> -->
			<a href="#" class="btn btn-info btn-lg" style="text-align: center;">
					<span class="glyphicon glyphicon-ok"></span>&nbsp;&nbsp;保&nbsp; 存 &nbsp;&nbsp;
			</a>
		</div>
	</div>
	</form>

	<!-- 引入footer -->
	<%@include file="footer.jsp"%>

</body>

</html>