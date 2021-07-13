<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title></title>
	<!-- load stylesheets -->
	<link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
	<link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
	<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<script>
		function countDown(){
			//获取初始时间
			var time = document.getElementById("Time");

			//获取到id为time标签中的数字时间
			if(time.innerHTML == 0){
				//等于0时清除计时，并跳转该指定页面
				window.history.go(-1);
			}else{
				time.innerHTML = time.innerHTML-1;
			}
		}
		//1000毫秒调用一次
		window.setInterval("countDown()",1000);
	</script>
	<style>
		#Time{
			font-size: 50px;
			text-align: center;
			color: red;
		}
		#Font,#p{
			font-size: 100px;
			text-align: center;
		}
	</style>
</head>

<body>
<div class="tm-contact-img-container"></div>
<%--<div>--%>
<%--	<h1 class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 col-md-offset-3 col-lg-offset-3 col-xl-offset-3 tm-gold-text">邮件发送成功</h1>--%>
<%--	<p style="color: yellow; ">页面将在<span id="Time" >5</span>秒后自动跳转，若没有，请点击<a onClick="javascript :history.back(-1);">这里</a></p>--%>
<%--</div>--%>
<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center">
    <h2 class="tm-gold-text tm-title">邮件发送成功</h2>
    <p class="tm-subtitle">页面将在<span id="Time" >5</span>秒后自动跳转，若没有，请点击<a onClick="javascript :history.back(-1);">这里</a></p>
</div>
<footer style="position:absolute; /* 必要 */
        bottom:0; /* 必要 */
        height:50px;
		color: #c6c6c6;
		background-color: #191919;
		background-image: url('./img/classic-pattern-bg.png');
		font-size: 1rem;"
		class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 tm-copyright-col">
				<p class="tm-copyright-text">Copyright &copy; 2021.Drifter All rights reserved.</p>
			</div>
		</div>
	</div>
</footer>

<%--  导入回传数据jsfiles  --%>
<script src="js/return.js"></script>
<!-- load JS files -->
<script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
<script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->

</body>
</html>
