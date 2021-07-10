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
</head>

<body>
<jsp:include page="common.jsp"></jsp:include>
<div class="tm-about-img-container">

</div>

<section class="tm-section">
    <div class="container-fluid">
        <div class="row tm-2-rows-sm-swap">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <c:set var="thisAcitvity" value="${sessionScope.thisActivity}"></c:set>
                <c:set var="thisleader" value="${sessionScope.leadername}"></c:set>
                <h3 class="tm-gold-text">${thisAcitvity.theme}</h3>
                <p>${thisAcitvity.message}</p>
                <p>团长：${thisleader}</p>
                <p>联系电话：${thisAcitvity.number}</p>
                <p>活动时间：${thisAcitvity.date}</p>
                <p>活动起点：${thisAcitvity.start}</p>
                <p>活动费用(元)：${thisAcitvity.fee}</p>

            </div>


            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 tm-2-rows-sm-down-2">
                <ul class="nav">
                    <h3 class="tm-gold-text">参加人员</h3>
                    <c:forEach items="${requestScope.users}" var="user" varStatus="vs">
                        <li>${user.realname}</li>
                    </c:forEach>
                </ul>


            </div>
            <c:if test="${empty sessionScope.user}">
                <div class="alert alert-warning col-xs-12 col-sm-12 col-md-4 col-lg-4 col-xl-4">
                    <a href="#" class="close" data-dismiss="alert">
                        &times;
                    </a>
                    <strong>警告！</strong>请<a href="login.jsp">登录</a>后再参加活动！
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                <c:set var="thisAcitvity" value="${sessionScope.thisActivity}"></c:set>
                <c:set value="${sessionScope.user}" var="thisUser"></c:set>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                    <input type="hidden" id="addUseract" value="${thisAcitvity.id}">
                    <input type="hidden" id="addUseruser" value="${thisUser.id}">
                    <a href="javascript:addAct_t()" class="tm-btn text-uppercase">报名活动</a>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.fee}">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6 col-xl-6">
                    <a class="tm-btn text-uppercase" data-toggle="modal" data-target="#myModal">查看团费</a>
                </div>
            </c:if>
        </div>
        <%--		<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">缴费详情</h4>
                    </div>
                    <div class="modal-body">您目前需要缴纳的费用为：${aa}</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button" class="tm-btn text-uppercase" data-dismiss="modal">确认</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
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
<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
<!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
<script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->

</body>
</html>
