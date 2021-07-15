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
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
				<c:set var="thisActivity" value="${sessionScope.thisActivity}" ></c:set>
				<c:set var="thisleader" value="${sessionScope.leadername}"></c:set>
				<c:set var="teamId" value="${requestScope.teamId}"></c:set>
				<input type="hidden" id="thisActTheme" value="${thisActivity.theme}"/>
						<h3 class="tm-gold-text">${thisActivity.theme}</h3>
						<p>${thisActivity.message}</p>
						<p>团长：${thisleader}</p>
						<p>联系方式：${thisActivity.number}</p>
						<p>活动时间：${thisActivity.date}</p>
						<p>活动起点：${thisActivity.start}</p>
						<p>活动费用(元)：${thisActivity.fee}</p>
						<p>活动id：${thisActivity.id}</p>

			</div>


			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 tm-2-rows-sm-down-2">
				<ul class="nav">
					<h3 class="tm-gold-text">参加人员</h3>
					<c:forEach items="${requestScope.users}" var="user" varStatus="vs">
						<li>${user.realname}</li>
					</c:forEach>
				</ul>


			</div>
<%--
		是否加入团队
		未加入
--%>
			<c:if test="${!requestScope.isInTeam}">
				<div class="alert alert-warning col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
					<a href="#" class="close" data-dismiss="alert">
						&times;
					</a>
					<strong>警告！</strong>请<a href="GroupAbout?teamId=${teamId}">加入团队</a>后再参加活动！
				</div>
			</c:if>
<%--
		已加入
--%>
			<c:if test="${requestScope.isInTeam}">
				<c:set value="${sessionScope.user}" var="thisUser"></c:set>

<%--
			是否已经参加活动
			未参加
--%>
				<c:if test="${!requestScope.isInAct}">
					<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
						<input type="hidden" id="addUseract" value="${thisActivity.id}">
						<input type="hidden" id="addUseruser" value="${thisUser.id}">
						<a href="javascript:addAct_t()" class="tm-btn text-uppercase">报名活动</a>
					</div>
				</c:if>
<%--
			已参加
--%>
				<c:if test="${requestScope.isInAct}">
<%--
				活动是否已结束
				未结束
--%>
					<c:if test="${thisActivity.status == 0 && thisActivity.status == 1}">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
							<c:out value="您已加入活动，请等待活动结束进行缴费。"></c:out>
						</div>
					</c:if>
<%--
					下拉框
--%>
					<div class="dropdown col-xs-12 col-sm-12 col-md-7 col-lg-7 col-xl-7">
						<button type="button" class="tm-btn dropdown-toggle" id="dropdownMenu2"
								data-toggle="dropdown">缴费
						</button>

						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
<%--
				活动是否已结束
				已结束
--%>
					<c:if test="${thisActivity.status == 2}">
							<li role="presentation">
								<a href="" class=" tm-gold-text text-uppercase"><i class="glyphicon glyphicon-info-sign"></i>缴纳费用</a>
							</li>
					</c:if>
							<li role="presentation">
								<a data-toggle="modal" data-target="#myModal" role="menuitem" herf="#" tabindex="-1" class="tm-gold-text text-uppercase"><i class="glyphicon glyphicon-credit-card"></i>追加费用</a>
							</li>
						</ul>
					</div>
				</c:if>
			</c:if>
		</div>
		<%--		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">追加缴费</h4>
					</div>
					<div class="modal-body">您要追加的费用为：
						<input type="text" style="margin-left: 20px;margin-right: 20px" id="zj_perfee" class="form-control">元
					</div>
					<div class="modal-footer">
						<button type="button" class="tm-btn text-uppercase" onclick="add_zjperfee()" data-dismiss="modal">确认</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal -->
		</div>
		<hr class="tm-margin-t-small col-md-12 col-lg-12 col-xl-12">
		<h3 class="tm-gold-text">其他活动</h3>
		<div class="row tm-margin-t-mid">
			<c:forEach items="${requestScope.activities}" var="activity" varStatus="vs">
				<div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
					<div class="tm-content-box">
						<img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
						<h4 class="tm-margin-b-20 tm-gold-text">${activity.theme}</h4>
						<p class="tm-margin-b-20">${activity.message} <br>
								${activity.number}</p>
						<input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
						<input type="hidden" id="teamId" value="${teamId}"/>
						<a href="javascript:submit_t(${vs.index})" class="tm-btn text-uppercase">活动详情</a>
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
