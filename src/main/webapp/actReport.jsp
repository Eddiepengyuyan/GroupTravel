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
        <div class="row tm-2-rows-sm-swap">            <div class="col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3" style="margin-bottom: 10px">
                <ul class="nav">
                    <h3 class="tm-gold-text">活动列表</h3>
                    <c:forEach items="${requestScope.actList}" var="actList" varStatus="vs">
                        <input type="hidden" id="actTheme_${vs.index}" value="${actList.theme}"/>
                        <input type="hidden" id="teamId" value="${requestScope.teamId}"/>
                        <li><a href="javascript:actReport(${vs.index})">${actList.theme}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9 col-md-offset-5 col-lg-offset-5 col-xl-offset-5">
                <c:set var="thisAcitvity" value="${requestScope.thisActivity}"></c:set>
                <c:set var="thisLeader" value="${requestScope.leaderName}"></c:set>
                <c:set var="countUser" value="${requestScope.countUser}"></c:set>
                <c:set var="feePerUser" value="${requestScope.feePerUser}"></c:set>
                <h2 class="tm-gold-text tm-title">活动报告</h2>
                <h3 class="tm-gold-text">活动名称：${thisAcitvity.theme}</h3>
                <p>活动团长：${thisLeader}</p>
                <p>活动总消费(元)：${thisAcitvity.fee}</p>
                <p>活动总人数：${countUser}</p>
                <p>人均缴费：${feePerUser}</p>
                <p>已缴费人数：${thisAcitvity.fee}</p>
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

<%--<script>--%>
<%--    function numDiv(num1,num2){--%>
<%--        var baseNum, baseNum1, baseNum2;--%>
<%--        try{--%>
<%--            baseNum1=num1.toString().split(".")[1].length;--%>
<%--        }catch(e){--%>
<%--            baseNum1=0;--%>
<%--        }--%>
<%--        try{--%>
<%--            baseNum2=num2.toString().split(".")[1].length;--%>
<%--        }catch(e){--%>
<%--            baseNum2=0;--%>
<%--        }--%>
<%--        with(Math){--%>
<%--            baseNum=Math.pow(10,baseNum2-baseNum1);--%>
<%--            // document.write((Number(num1.toString().replace(".",""))/Number(num2.toString().replace(".","")))*baseNum);--%>
<%--            return (Number(num1.toString().replace(".",""))/Number(num2.toString().replace(".","")))*baseNum;--%>
<%--            // return 666;--%>
<%--        }--%>
<%--    }--%>
<%--</script>--%>

<%--  导入回传数据jsfiles  --%>
<script src="js/return.js"></script>
<!-- load JS files -->
<script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
<script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script>
<!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
<script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->

</body>
</html>
