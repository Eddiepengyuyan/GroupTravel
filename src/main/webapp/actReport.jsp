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
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 col-md-offset-2 col-lg-offset-2 col-xl-offset-2">
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
        </div>
    </div>
</section>


<%--            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 tm-2-rows-sm-down-2">--%>
<%--                <ul class="nav">--%>
<%--                    <h3 class="tm-gold-text">参加人员</h3>--%>
<%--                    <c:forEach items="${requestScope.users}" var="user" varStatus="vs">--%>
<%--                        <li>${user.realname}</li>--%>
<%--                    </c:forEach>--%>
<%--                </ul>--%>


<%--            </div>--%>
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
