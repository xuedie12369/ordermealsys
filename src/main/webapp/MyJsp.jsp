<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <title> New Document </title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <%@ page language="java" pageEncoding="UTF-8"%>
  <meta name="Generator" content="EditPlus">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
<%--   <script src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script> --%>
  
    <script src="js/jquery-3.2.1.js"></script>
<script src="//www.jsviews.com/download/jsviews.js"></script>
<!--<script src="//www.jsviews.com/download/sample-tag-controls/jsviews-jqueryui-widgets.js"></script>-->

<script>
	$(document).ready(function() {
		$("#tijiao").click(
		
		function() {
			alert("要执行ajxs")
			/*    var fd = new FormData(document.querySelector("form")); */
			$.ajax({
				type : "POST",
				url : 'user/login.do',
				/*contentType : "application/json; charset=utf-8", */
				contentType : "application/x-www-form-urlencoded",
				data : $('#J-normal-form').serialize(),
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.data.birth)
						alert(data.data.birth)
						
						/* var myTmpl = $.templates("#testTmpl"); 
						var html = myTmpl.render(data);   */ 
						 var html = $("#testTmpl").render(data);
						 	$("#list1").html(html);  
						/* 	$("#list1").append(html);  */
						/* $("#wenwebzhi").value(data.data.birth) */
						/* window.location.href = "index.html"; */
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
      <div>
      <table width="800" border="1">
        <thead>
          <tr>
            <th width="10%">序号</th>
            <th width="30%">姓名</th>
            <th width="80%">家庭成员</th>
          </tr>
        </thead>
        
     <!--   <tbody id="list">
          
        </tbody>-->
        
        <div id="list1"></div>
      </table>
      
      
      
      <form id="J-normal-form" method="POST" class="form form--stack">
					<div class="validate-info" style="visibility:hidden"></div>

					<span class="login-type" data-mtevent="login.mobile.switch">
						<a id="J-mobile-link"
						href="https://passport.meituan.com/account/unitivelogin?service=www&amp;continue=http%3A%2F%2Fwww.meituan.com%2Faccount%2Fsettoken%3Fcontinue%3Dhttp%253A%252F%252Fwww.meituan.com%252Faccount%252Fuserinfo%252F&amp;_nsmobilelogin=true">
							手机动态码登录 <i></i>
					</a> 账号登录
					</span>

					<div class="form-field form-field--icon">
						<i class="icon icon-user"></i> <input type="text" id="login-email"
							class="f-text" name="username" placeholder="手机号/用户名/邮箱" value="">
					</div>
					<div class="form-field form-field--icon">
						<i class="icon icon-password"></i> <input type="password"
							id="login-password" class="f-text" name="password"
							placeholder="密码">
					</div>
					<div class="form-field J-form-field-captcha form-field--captcha"
						style="display:none">
						<input type="text" id="captcha" class="f-text J-captcha-input"
							name="captcha" placeholder="验证码" autocomplete="off"> <img
							height="36" width="72" class="signup-captcha-img"
							id="signup-captcha-img" src="./登录 _ 美团网_files/captcha"> <a
							tabindex="-1" class="captcha-refresh inline-link"
							href="javascript:void(0)">看不清楚？换一张</a>
					</div>
					<div class="form-field form-field--auto-login cf">
						<a tabindex="-1"
							href="https://passport.meituan.com/account/retrievepassword?service=www&amp;continue=http%3A%2F%2Fwww.meituan.com%2Faccount%2Fsettoken%3Fcontinue%3Dhttp%253A%252F%252Fwww.meituan.com%252Faccount%252Fuserinfo%252F"
							target="_top" class="forget-password">忘记密码？</a> <input
							type="checkbox" value="1" name="auto_login" id="autologin"
							class="f-check ui-checkbox"> <label class="normal"
							for="autologin">7天内自动登录</label>
					</div>
					<div class="form-field form-field--ops">
						<input type="hidden" name="origin" value="account-login">
						<input type="hidden" name="fingerprint" class="J-fingerprint"
							value="0-3-1-"> <input type="hidden" name="csrf"
							value="k4QzSxUf-Cz2mTPNNE8kzfrIZEp-eegMnYek"> <input
							data-mtevent="login.normal.submit" id="tijiao"  type="button"
							class="btn" name="commit" value="登录">
							
							这是文本 <input type="text" id="wenbenzhi"  value="我是邵海楠"/>
					</div>
					<p class="signup-guide">
						还没有账号？<a
							href="https://passport.meituan.com/account/unitivesignup?service=www&amp;continue=http%3A%2F%2Fwww.meituan.com%2Faccount%2Fsettoken%3Fcontinue%3Dhttp%253A%252F%252Fwww.meituan.com%252Faccount%252Fuserinfo%252F"
							target="_top">免费注册</a>
					</p>
				</form>
      
      
    </div>
 </body>
</html>
<script id="testTmpl" type="text/x-jsrender">
<tr>
	<td>
		<input type="checkbox"  value="asd" style="width: 30px; color: red;" />
	</td>
	<input type="radio" />
    
    <td>{{:msg}}</td>
   
</tr>
</script>




<!-- 
<script type="text/javascript"  charset="utf-8">
$(function(){
    var dataSrouce = [{
        name: "张三",
        family: [
          "爸爸",
          "妈妈",
          "哥哥"
        ]
      },{
        name: "李四",
        family: [
          "爷爷",
          "奶奶",
          "叔叔"
        ]
      },
      {
        name: "李四",
        family: [
          "爷爷",
          "奶奶",
          "叔叔"
        ]
      }
      
    
    ];

      //几种渲染数据
      // 第一种(直接渲染)
      var html = $("#testTmpl").render(dataSrouce);
      // 第二种(直接templates指定渲染)
      //var html = $.templates("#testTmpl").render(dataSrouce);
      // 第三种(复制渲染)
   /*   $.templates("personTmpl", "#testTmpl"); 
      var html = $.render.personTmpl(dataSrouce);  */
      $("#list1").append(html);
});
</script>
 -->