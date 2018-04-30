
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh-CN">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" pageEncoding="UTF-8"%>
<title>水平表单</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<script type="text/javascript" src="js/jquery-3.2.1.js"></script>

<!-- 引入jsrender插件 -->
<script src="js/jsviews.js"></script>

<!-- 地址模块模板-->
<script id="addressTml" type="text/x-jsrender">
		<form class="form-horizontal" role="form"
		style="margin-left:30%;margin-right: auto;margin-top: 10px"
		id="addAddressForm">
	<input type="hidden" name="id" value="{{:id}}" />
		<div class="form-group">
			<label for="" class="col-sm-2 control-label">姓名：</label>
			<div class="col-sm-3">
				<input type="text" class="form-control" name="consigneeName"
					placeholder="请输入收货人姓名" value="{{:consigneeName}}">
			</div>
		</div>


		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">电话：</label>
			<div class="col-sm-3">
				<input type="tel" class="form-control" id="tel" value="{{:tel}}" name="tel"
					placeholder="请输入您的电话">
			</div>

		</div>


		<div class="form-group ">
			<label for="" class="col-sm-2 control-label">地址：</label>
			<div class="col-sm-3">
				<textarea class="form-control" rows="3" name="detailedAdd">{{:detailedAdd}}
</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10 form-inline">
	{{if sex == 1}}
<div class="radio">
					<label class="">
			 <input type="radio" name="sex" value="1" checked="checked">
						男
					</label>
				</div>
	<div class="radio">
					<label> <input type="radio" name="sex" value="0"> 女
					</label>

				</div>
	 {{/if}}
	{{if sex == 0}}
<div class="radio">
					<label class="">
			 <input type="radio" name="sex" value="1" >
						男
					</label>
				</div>
	<div class="radio">
					<label> <input type="radio" name="sex" value="0" checked="checked"> 女
					</label>

				</div>
	 {{/if}}
				
			</div>
		</div>
<div class="form-group">
		<div class="col-sm-offset-3" id="save">
			<!-- <button type="button" class="btn btn-info ">保存</button> -->
			<a href="#" class="btn btn-info btn-lg" style="text-align: center;">
					<span class="glyphicon glyphicon-refresh"></span>&nbsp;&nbsp;更&nbsp; 新 &nbsp;&nbsp;
			</a>
		</div>
	</div>
	</form>

</script>




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
		if(id==-1)
		{
			alert("参数错误")
		}
		else{
		
		/* 异步查询商品信息 */
		$.ajax({
			type : "GET",
			url : 'shipping/select.do',
			contentType : "application/x-www-form-urlencoded",
			data : {
				addressId : id
			},
			dataType : "json",
			success : function(data) {
				if (data.status == 0) {
					console.log(data.data)
					var html = $("#addressTml").render(data.data);
					$("#addressForm").append(html);
					updatePro(); 
					
				} else {
					alert(data.msg); 
					
				}
			},
			error : function() {
				alert("提交数据失败");
			}
		});
		}
	})
</script>
<!-- 异步添加商品到购物车 -->


<!-- ajax异步更新-->
<script>
	function updatePro() {
		$("#save").click(function() {
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'shipping/update.do',
				contentType : "application/x-www-form-urlencoded",
				data : $('#addAddressForm').serialize(),
				//				data:{username:$("#username").val(),password:$("#password").val()},
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
						alert("更新成功");
					} else {
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

	<!-- 引入header -->
	<%@include file="header.jsp"%>
	<div id="addressForm">
	
	</div>
	
	<!-- 引入footer -->
	<%@include file="footer.jsp"%>

</body>

</html>