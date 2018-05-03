<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<base href="<%=basePath%>">
<title>增加商品</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<title>完整demo</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<!--    <script src="./ueditor.parse.js"></script>我自己+的 -->
<script type="text/javascript" charset="utf-8"
	src="./ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="./ueditor/ueditor.all.min.js"> </script>
<script src="http://malsup.github.io/jquery.form.js"></script>
<!-- 加入jsviews模板的js -->
<script src="//www.jsviews.com/download/jsviews.js"></script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8"
	src="./ueditor/lang/zh-cn/zh-cn.js"></script>

<!-- <style type="text/css">
div {
	width: 100%;
};
.dropdown-menu>li>a:hover {
				background-color: #4cbeff;
				;
			}
</style> -->
<style>
.dropdown-menu>li>a:hover {
	background-color: #4cbeff;
	;
}
</style>


<!--商品模块模板-->
<script id="categoryListTmpl" type="text/x-jsrender">
		<li  >
					<a  class="categoryItem" data-categoryId={{:id}}>{{:name}}</a>
		</li>
</script>



<script type="text/javascript" charset="utf-8">
	$(function() {
		$.ajax({
			type : "POST",
			url : 'manage/category/list.do',
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(data) {
				
					console.log(data.status)
					var html = $("#categoryListTmpl").render(data.data);
					$("#categoryLi").append(html);
					/* 给分类项目设置点击响应事件结束 */
					$(".categoryItem").click(function() {
						var categoryId = this.dataset.categoryid;
						var categoryBtn = document.getElementById("categoryBtn");
						var categoryIdTag = document.getElementById("categoryId");
						categoryBtn.innerText = this.innerText;
						categoryIdTag.value = categoryId;
						/* 给分类项目设置点击响应事件结束 */

					});
					alert("添加产品成功");
			},
			error : function() {
				alert("查询分类数据失败");
			}
		});

	});
</script>



<script>
	$(document).ready(function() {
		$("#uploadImg").click(function() {
		$.ajax({
				type : "POST",
				url : 'manage/file/upload.do',
				/*contentType : "application/json; charset=utf-8", */
			
				 data : $('#addProductForm').serialize(), 
				enctype : 'multipart/form-data',
				/* data:{file:$("#file").val()}, */
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
					 	document.getElementById("productPic").value=data.msg
                   	$("#mainPic").removeAttr("hidden");
					
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
	});
</script>




<!-- ajax异步添加商品 -->
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
				enctype : 'multipart/form-data',
				//				data:{username:$("#username").val(),password:$("#password").val()},
				/*  data: fd,  */
				dataType : "json",
				success : function(data) {
					if (data.status == 0) {
						console.log(data.status)
						console.log(data)
					  /* window.location.href = "index.jsp";  */
					/* 	  var html = $("#testTmpl").render(data.data); */
					/* 	$("#list1").append(html); */
					/* $("#wenwebzhi").value(data.data.birth) */
					/* window.location.href = "index.jsp";  */
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
                success: function(data) {  
                    // 图片显示地址  
                    /* $("#allUrl").attr("src", data.path); */
                 	console.log(data)
                 	$('#mainPic').attr("src", data.msg);
                 	/* $('#productPic').val(data.msg) */
                 	/* alert($('#productPic').va) */
                 	document.getElementById("productPic").value=data.msg
                   	$("#mainPic").removeAttr("hidden");
                  
                   
                }  
        };  
          
        $("#addProductForm").ajaxSubmit(options);  
      
      	$(document).ready(function() {
		$("#tijiao").click(function() {
		uploadPic()

		});

	})
    }  
</script>  

</head>


<body>

	<h2 align="center" style="margin-top: 50px">编辑商品</h2>


	<form id="addProductForm" enctype="multipart/form-data" method="post">

		<div style="text-align: center;margin-top: 30px;">
			<form role="form" enctype="multipart/form-data" id="addProductForm"
				method="post">


				<div class="form-group form-inline">
					<label for="">名称:</label> <input type="text" class="form-control"
						id="exampleInputEmail1" name="name" placeholder="请输入您商品名称">
				</div>

				<div class="form-group form-inline	">
					<!-- 分类Div -->
					<label class="btn-block "> 分类:
						<div class="btn-group form-group form-inline " style="width:12%">

							<button class="btn btn-info dropdown-toggle btn-block "
								data-toggle="dropdown" type="button" id="categoryBtn" value="-1">
								点击选择分类<span class="caret"></span>
							</button>


							<ul class="dropdown-menu " style="text-align: center;"
								id="categoryLi">
								<input type="hidden" id="categoryId" name="categoryId">
							</ul>
						</div>
				</div>
				<!-- 商品分类 -->
				</label>
				<div class="form-group form-inline	">
					<label for="">价格:</label> 
					<input type="number" class="form-control"
						min="0" id="" name="price" placeholder="请输入价格 ">
						
				</div>
				
				<div class="form-group form-inline	" style="">
					<img src="1.png" id="mainPic" hidden style="width:200px;height:200px;margin-left: 40px">
						<input hidden="hidden" value="null"  name="mainPic" id="productPic" />
				</div>
				<div class="form-group form-inline">
					<label for="" >图片: </label>
					<input type="file"  id="upload_file"  style="display: none;"  onchange="uploadPic()" name="file" style="" class="form-control"
						min="0" id="" name="price" placeholder="请输入价格 ">
					<p  style="width: 12.5%;" href=""  onclick="upload_file.click();"  id="" class="btn btn-info btn-group-lg">
					<span class="glyphicon glyphicon-cloud-upload"> </span> 上 传 图 片
				</p>
					
				</div>
				
			
				<div class="form-group form-inline	">
					<label for="">库存:</label> <input type="number" class="form-control"
						id="" name="stock" placeholder="请输入库存 ">
				</div>

				<div class="form-group form-inline	">
					<label for="">餐盒价 :</label> <input type="number"
						class="form-control" id="" min="0" name="boxPrice"
						placeholder="请输入餐盒价格 ">
				</div>
		</div>

		<div align="center">
			<script id="editor" name="detail" type="text/plain"
				style="width:1024px;height:500px;"></script>
			<button type="submit" class="btn btn-danger" id="addProduct"
				style="text-align: center;">确认发布</button>
		</div>


	</form>































	<!--      <div id="btns">
    <div>
        <button onclick="getAllHtml()">获得整个html的内容</button>
        <button onclick="getContent()">获得内容</button>
        <button onclick="setContent()">写入内容</button>
        <button onclick="setContent(true)">追加内容</button>
        <button onclick="getContentTxt()">获得纯文本</button>
        <button onclick="getPlainTxt()">获得带格式的纯文本</button>
        <button onclick="hasContent()">判断是否有内容</button>
        <button onclick="setFocus()">使编辑器获得焦点</button>
        <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
        <button onmousedown="setblur(event)" >编辑器失去焦点</button>

    </div>
    <div>
        <button onclick="getText()">获得当前选中的文本</button>
        <button onclick="insertHtml()">插入给定的内容</button>
        <button id="enable" onclick="setEnabled()">可以编辑</button>
        <button onclick="setDisabled()">不可编辑</button>
        <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
        <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
        <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
    </div>

    <div>
        <button onclick="getLocalData()" >获取草稿箱内容</button>
        <button onclick="clearLocalData()" >清空草稿箱</button>
    </div>

</div>
<div>
    <button onclick="createEditor()">
    创建编辑器</button>
    <button onclick="deleteEditor()">
    删除编辑器</button>
</div>
 -->
	<script type="text/javascript">
	
		//实例化编辑器
		//建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
		var ue = UE.getEditor('editor');
	
	
		function isFocus(e) {
			alert(UE.getEditor('editor').isFocus());
			UE.dom.domUtils.preventDefault(e)
		}
		function setblur(e) {
			UE.getEditor('editor').blur();
			UE.dom.domUtils.preventDefault(e)
		}
		function insertHtml() {
			var value = prompt('插入html代码', '');
			UE.getEditor('editor').execCommand('insertHtml', value)
		}
		function createEditor() {
			enableBtn();
			UE.getEditor('editor');
		}
		function getAllHtml() {
			alert(UE.getEditor('editor').getAllHtml())
		}
		function getContent() {
			var arr = [];
			arr.push("使用editor.getContent()方法可以获得编辑器的内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getContent());
			alert(arr.join("\n"));
		}
		function getPlainTxt() {
			var arr = [];
			arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
			arr.push("内容为：");
			arr.push(UE.getEditor('editor').getPlainTxt());
			alert(arr.join('\n'))
		}
		function setContent(isAppendTo) {
			var arr = [];
			arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
			UE.getEditor('editor').setContent('欢迎使用ueditor', isAppendTo);
			alert(arr.join("\n"));
		}
		function setDisabled() {
			UE.getEditor('editor').setDisabled('fullscreen');
			disableBtn("enable");
		}
	
		function setEnabled() {
			UE.getEditor('editor').setEnabled();
			enableBtn();
		}
	
		function getText() {
			//当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
			var range = UE.getEditor('editor').selection.getRange();
			range.select();
			var txt = UE.getEditor('editor').selection.getText();
			alert(txt)
		}
	
		function getContentTxt() {
			var arr = [];
			arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
			arr.push("编辑器的纯文本内容为：");
			arr.push(UE.getEditor('editor').getContentTxt());
			alert(arr.join("\n"));
		}
		function hasContent() {
			var arr = [];
			arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
			arr.push("判断结果为：");
			arr.push(UE.getEditor('editor').hasContents());
			alert(arr.join("\n"));
		}
		function setFocus() {
			UE.getEditor('editor').focus();
		}
		function deleteEditor() {
			disableBtn();
			UE.getEditor('editor').destroy();
		}
		function disableBtn(str) {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				if (btn.id == str) {
					UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
				} else {
					btn.setAttribute("disabled", "true");
				}
			}
		}
		function enableBtn() {
			var div = document.getElementById('btns');
			var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
			for (var i = 0, btn; btn = btns[i++];) {
				UE.dom.domUtils.removeAttributes(btn, [ "disabled" ]);
			}
		}
	
		function getLocalData() {
			alert(UE.getEditor('editor').execCommand("getlocaldata"));
		}
	
		function clearLocalData() {
			UE.getEditor('editor').execCommand("clearlocaldata");
			alert("已清空草稿箱")
		}
	</script>

	
</body>
</html>
