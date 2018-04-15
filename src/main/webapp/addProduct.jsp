<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
	<title>基础表单</title>
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<%@ page language="java" pageEncoding="UTF-8"%>
	 <script src="js/jquery-3.2.1.js"></script>
	<style>
	</style>
	
  <!-- ajax异步登录跳转 -->
<script>
	$(document).ready(function() {
		$("#addProduct").click(function() {
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'manage/product/saveOrUpdate.do',
				/*contentType : "application/json; charset=utf-8", */
				contentType : "application/x-www-form-urlencoded",
				data : $('#addProductForm').serialize(), 
				enctype:'multipart/form-data',
//				data:{username:$("#username").val(),password:$("#password").val()},
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
					/* 	  var html = $("#testTmpl").render(data.data); */
						/* 	$("#list1").append(html); */
						/* $("#wenwebzhi").value(data.data.birth) */
						 /* window.location.href = "index.jsp";  */
					}
					else
					{
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
	<div style="text-align: center;margin-top: 30px;">
			<form role="form" enctype="multipart/form-data" id="addProductForm" method="post">
  <div class="form-group form-inline" >
    <label for="">名称:</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name" placeholder="请输入您商品名称">
  </div>
   <div class="form-group form-inline	"  >
    <label for="">价格:</label>
    <input type="number" class="form-control" id="" name="price" placeholder="请输入价格 ">
  </div>
  <div class="form-group form-inline	"  >
    <label for="">数量:</label>
    <input type="number" class="form-control" id="" placeholder="请输入数量">
  </div>
  
   
  <div class="form-group form-inline	"  >
    <label for="">库存:</label>
    <input type="number" class="form-control" id="" name="stock" placeholder="请输入库存 ">
  </div>
  
    <div class="form-group form-inline	"  >
    <label for="">餐盒价 :</label>
    <input type="number" class="form-control" id="" name="box_price" placeholder="请输入餐盒价格 ">
  </div>
  <input type="file" value="wenjian" name="mainPic">
   <img alt="" src="1.png">
  <button type="submit" class="btn btn-danger" id="addProduct">确认发布</button>
</form>	


		
	</div>

</body>
</html>