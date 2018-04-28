<!DOCTYPE html>
<html>
	
<head>
<%@ page language="java" pageEncoding="UTF-8"%>
<link href="css/login.css" rel='stylesheet' type='text/css' />
  <script src="js/jquery-3.2.1.js"></script>
  
  <!-- ajax异步登录跳转 -->
<script>
	$(document).ready(function() {
		$("#login").click(function() {
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'user/login.do',
				/*contentType : "application/json; charset=utf-8", */
				contentType : "application/x-www-form-urlencoded",
				/* data : $('#J-normal-form').serialize(), */
				data:{username:$("#username").val(),password:$("#password").val()},
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.data.birth)
					/* 	  var html = $("#testTmpl").render(data.data); */
						/* 	$("#list1").append(html); */
						/* $("#wenwebzhi").value(data.data.birth) */
					 window.location.href = "index.jsp";  
					 window.event.returnValue=false; 
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
<body style="">
	<div class="login-03">
		<div class="third-login">
			<h1><img src="images/twit.png" alt=""> &nbsp;用 &nbsp;户 &nbsp;登 &nbsp;录</h1>
			<form class="three" id="loginForm" method="post"  >
					<p>Username / Email</p>
					<li class="base">
					<input type="text" id="username"  ><a href="#" class=" icons3 user3"></a>
				</li>
					<p>Password</p>
					<li>
							<input type="password" id="password"><a href="#" class=" icons3 lock3"></a>
					</li>

					<div class="submit-three">
						<input type="button" id="login"  value="登 录"> 
					</div>
			</form>
		</div>
	</div>

</body>
</html>