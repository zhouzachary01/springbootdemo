<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>系统登录</title>
  	<link rel="stylesheet" href="css/layui.css"  media="all">
	<script src="js/jquery/jquery.min.js" charset="utf-8"></script>
  <style>
		.log_bg {
				width: 350px;
				height: 290px;
				position: absolute;
				top: 50%;
				left: 50%;
				margin-top: -125px;
				margin-left: -205px;
				border: 5px solid #666666;
				background-color: #393D49
		}
		.log_title {
				width: 100%; height: 55px; color: #ffffff; border-bottom: 1px solid #ffffff; font-size: 20pt;
				font-weight: bold;font-family: "微软雅黑"; line-height: 55px; text-align: center; background-color: #32AA9F;
		}
	</style>
</head>
<body style="background-image: url(image/bg/bg2.jpg);">
	<!-- 登陆窗口 -->
	<div class="log_bg">
		<div class="log_title"><span>系统登录</span></span></div>
		<form class="layui-form" action="" method="post">
			<div class="layui-input-inline" style="margin-top: 25px">
				<input type="tel" id="phone" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="请输入账号" style="width: 280px; margin: 0px 30px 0px 30px; border-radius: 5px;">
			</div>
			<div class="layui-input-inline">
				<input type="password" id="password" name="password" autocomplete="off" class="layui-input" placeholder="请输入密码"  style="width: 280px; margin: 10px 30px 0px 30px; border-radius: 5px;">
			</div>
		  	<div class="layui-form-item" pane="">
		    <div class="layui-block" style="width: 150px; margin: 10px 0px 20px 30px;">
		      <input type="checkbox" id="remberpass" name="remberpass" lay-skin="primary" title="记住密码" checked="">
		    </div>
		  	</div>
		  <div class="layui-form-item">
		    <div class="layui-block" style="width: 280px; margin: 0px 30px 0px 30px;">
		      <button type="button" class="layui-btn" lay-submit="" onclick="getLogin()" style="width: 280px; font-size: 16pt; height: 45px;">登    录</button>
		    </div>
		  </div>
		</form>
 	</div>
 	
<script src="js/layui.js" charset="utf-8"></script>
<script>
	//		var surl = init();
	var surl = "http://127.0.0.1:8087/login";
	// 登陆调用接口
	function getLogin(){
		var userNum = document.getElementById('phone').value;
        var userPass = document.getElementById('password').value;
       /* layer.alert(userNum+"__"+userPass, {
		    	title: '提示:'
		});*/
        var params = {"m":"login","phone":userNum,"pass":userPass};
	  	$.ajax({
	      	url: surl,
	      	type: "POST",
	      	data: params,
	      	dataType : "json",
	      	success: function (returndata) {
				if(returndata.status == '200'){
					debugger
					//alert("登录成功");
                    window.location = "http://127.0.0.1:8087/success";
                    /*$.ajax({
                        url: "http://127.0.0.1:8087/success",
                        type: "GET"
                    })*/
				}
//

		    },  
		    error: function (returndata) { 
		       	alert("请求失败")
		    } 
	 	});
	}



</script>

</body>
</html>