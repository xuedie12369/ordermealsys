<!DOCTYPE html>
<!-- saved from url=(0046)http://www.jq22.com/demo/formValidate20161108/ -->
<html lang="zh-CN"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <%@ page language="java" pageEncoding="UTF-8"%>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="css/register-css/bootstrap.min.css" rel="stylesheet">
  <link href="css/register-css/validator.css" rel="stylesheet">
  <link href="css/register-css/completer.css" rel="stylesheet">
  <link href="css/register-css/jedate.css" rel="stylesheet">
  <link href="css/register-css/date.css" type="text/css" rel="stylesheet">
  <link href="css/register-css/magic-check.css" rel="stylesheet">
  <link href="css/register-css/jquery-ui.css" rel="stylesheet">  
  <link href="css/register-css/index.css" rel="stylesheet">  
  <script src="js/register-js/jquery.min.js"></script><script src="js/register-js/jquery.min.js(1)"></script>
  <script src="js/register-js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/register-js/public.js"></script>
  <script type="text/javascript" src="js/register-js/jedate.js"></script>
  <link type="text/css" rel="stylesheet" href="css/register-css/jedate.css" id="jeDateSkin">
  <script type="text/javascript" src="js/register-js/date.js"></script>
  <script type="text/javascript" src="js/register-js/jquery-validate.js"></script>
  <script type="text/javascript" src="js/register-js/validator.js"></script>
  <script type="text/javascript" src="js/register-js/jquery-ui-1.10.2.js"></script>
  <script src="js/register-js/jquery-ui.min.js"></script>
  <script type="text/javascript" src="js/register-js/index.js"></script>


<script>
	$(document).ready(function() {
		$("p").click(function() {
			$(this).hide();
			alert("sadsa");
		});
	});
</script>


  <!-- ajax异步登录跳转 -->
<script>
	$(document).ready(function() {
		$("#submit").click(function() {
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'user/register.do',
				/*contentType : "application/json; charset=utf-8", */
				contentType : "application/x-www-form-urlencoded",
				data : $('#register-form').serialize(), 
//				data:{username:$("#username").val(),password:$("#password").val()},
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
					/* 	  var html = $("#testTmpl").render(data.data); */
						/* 	$("#list1").append(html); */
						/* $("#wenwebzhi").value(data.data.birth) */
						 alert("注册成功");
						 window.location.href = "/login.jsp"; 
					}
					else
					{
						/* console.log(jsonObject); */
						alert(data.msg);
						 window.location.href = "/login.jsp";
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
<header>
</header>
<div class="container">
  <div class="form-box row">
    <form action="" method="post" class="form-horizontal" role="form" id="register-form" novalidate="novalidate">
      <div class="form-group">
        <label for="username" class="col-sm-2  control-label">帐 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 号 :</label>
        <div class="col-sm-10  input-parent">
          <input type="text" class="form-control vinput" id="username" name="userName" placeholder="请输入帐户" aria-required="true">
        </div>
      </div>
      <div class="form-group">
        <label for="phone" class="col-sm-2  control-label">手 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 机 :</label>
        <div class="col-sm-10  input-parent">
          <input type="text" class="form-control vinput" id="phone" name="tel" placeholder="请输入手机号" aria-required="true">    
        </div>
      </div>
      <div class="form-group ">
        <label for="email" class="col-sm-2  control-label">邮 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 箱 :</label>
        <div class="col-sm-10 input-parent">
          <span role="status" aria-live="polite" class="ui-helper-hidden-accessible"></span><input type="text" class="form-control vinput ui-autocomplete-input" id="email" name="email" placeholder="请输入邮箱" aria-required="true" autocomplete="off">       
        </div>
      </div>
      <!-- <div class="form-group">
        <label for="birthday" class="col-sm-2  control-label">生 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日 :</label>
        <div class="col-sm-10  input-parent">
          <input type="text" class="form-control vinput" id="birthday" name="birthday" placeholder="请选择生日" readonly="" aria-required="true">
        </div>
       
      </div> -->
       <!--  <input type="date" class="form-control vinput"  name="birth" value="2014-01-22" placeholder="请选择生日" > -->
      <div class="form-group ">
        <label for="password" class="col-sm-2  control-label">密 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 码 :</label>
        <div class="col-sm-10  input-parent">
          <input type="password" class="form-control vinput" id="password" name="pwd" placeholder="请输入密码" aria-required="true">
        </div>
      </div>
      <div class="form-group">
        <label for="notpass" class="col-sm-2  control-label">确认密码 :</label>
        <div class="col-sm-10  input-parent">
          <input type="password" class="form-control vinput" id="notpass" name="notpass" placeholder="请再次输入密码" aria-required="true">
        </div>
      </div>
      <br>
      <div class="form-group">
        <div class="col-sm-12">
          <input type="checkbox" class="magic-checkbox" id="accept" name="accept" aria-required="true">
          <label for="accept" class="accept"><span>我已阅读并接受</span> <a href="javascript:;">《版权声明》</a> <span>和</span> <a href="javascript:;">《隐私保护》</a></label>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-12">
          <input type="submit" class="btn btn-primary form-control" id="submit" value="注册"> 
        </div>
      </div>
    </form>
  </div>
</div>

<footer>
</footer>


<div id="jedatebox" class="jedatebox" style="z-index: 999; display: none; left: 201.828px; top: 231px;"></div><ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all" id="ui-id-1" tabindex="0" style="display: none;"></ul></body></html>