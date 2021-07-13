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
  <![endif]-->
</head>

<body>
<jsp:include page="common.jsp"></jsp:include>
<div class="tm-about-img-container">

</div>

<section class="tm-section">
	<div class="container-fluid">
		<div class="row tm-2-rows-sm-swap">
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 col-md-offset-2 col-lg-offset-2 col-xl-offset-2">
				<c:set var="this_team" value="${requestScope.thisTeam}" ></c:set>
					<c:set var="this_leader" value="${requestScope.leader}"></c:set>
						<h3 class="tm-gold-text">${this_team.name}</h3>
<%--						<p>${thisTeam.message}</p>--%>
						<p>团长：${this_leader.username}</p>
						<p>联系邮箱：${this_leader.number}</p>
						<p>团队信息：${this_team.message}</p>
			</div>

			<c:if test="${empty sessionScope.user}">
				<div class="alert alert-warning col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4 col-md-offset-4 col-lg-offset-4 col-xl-offset-4">
					<a href="#" class="close" data-dismiss="alert">
						&times;
					</a>
					<strong>警告！</strong>请<a href="login.jsp">登录</a>后再加入团队！
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.user}">
				<c:set var="thisTeam" value="${requestScope.thisTeam}" ></c:set>
				<c:set value="${sessionScope.user}" var="thisUser"></c:set>
				<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
					<input type="hidden" id="addUserteam" value="${thisTeam.id}">
					<input type="hidden" id="addUseruser" value="${thisUser.id}">
					<a href="javascript:addTeam_t()" class="tm-btn text-uppercase">报名团队</a>
				</div>
			</c:if>
		</div>
		<hr class="tm-margin-t-small col-md-12 col-lg-12 col-xl-12">
		<h3 class="tm-gold-text">团队活动</h3>
		<div class="row tm-margin-t-mid">
			<c:forEach items="${requestScope.thisActivities}" var="activity" varStatus="vs">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
					<div class="tm-content-box">
						<img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
						<h4 class="tm-margin-b-20 tm-gold-text">${activity.theme}</h4>
						<p class="tm-margin-b-20">${activity.message} <br>
								${activity.number}</p>
						<input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
						<c:set var="thisAcitvity" value="${sessionScope.thisActivity}" ></c:set>
						<c:set value="${sessionScope.user}" var="thisUser"></c:set>
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">
							<a href="javascript:submit_t(${vs.index})" class="tm-btn text-uppercase">活动详情</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div> <!-- row -->

	</div>
</section>

<footer class="tm-footer">
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
