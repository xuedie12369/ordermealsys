<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
 <script src="http://malsup.github.io/jquery.form.js"></script>
 
 
 <script type="text/javascript">  
    function uploadPic() {  
        // 上传设置  
        var options = {  
                // 规定把请求发送到那个URL  
                url:'manage/file/upload.do',  
                // 请求方式  
                type: "post",  
                // 服务器响应的数据类型  
                dataType: "json",  
                // 请求成功时执行的回调函数  
                success: function() {  
                    // 图片显示地址  
                    /* $("#allUrl").attr("src", data.path); */
                    alert("asdsa")
                      
                }  
        };  
          
        $("#addProductForm").ajaxSubmit(options);  
    }  
</script>  
 
  </head>
  
  <body>
    This is my JSP page. <br>
     <form id="addProductForm"  method="post" enctype="multipart/form-data">  
              <input name="file"  id="upload_file"  style="display: none;"  type="file" onchange="uploadPic()"/> 
              <button id="tijiao" >upload</button> 
              <button type="button" class="btn btn-primary" id="select_file"  
            onclick="upload_file.click();">浏览  
    </button>  
  	</form>
  </body>
</html>
