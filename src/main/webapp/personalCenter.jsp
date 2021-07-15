<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>个人中心</title>

    <!-- load stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
<jsp:include page="common.jsp"></jsp:include>
<section class="tm-section">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <div class="tm-blog-post">
                    <h3 class="tm-gold-text">我的团队
                        <a href="createGroup"><span class="glyphicon glyphicon-plus-sign"></span></a>
                    </h3><br>
                        <c:forEach items="${requestScope.myTeam}" var="teams" varStatus="vs">
                            <c:set value="${requestScope.leader}" var="leader"></c:set>
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                                <div class="tm-content-box">
                                    <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                    <h4 class="tm-margin-b-20 tm-gold-text">团队名：${teams.name}</h4>
                                    <p class="tm-margin-b-20">团长用户名：${leader.username} <br>
                                        团长联系方式：${leader.number}</p>
                                    <input type="hidden" id="teamId_${vs.index}" value="${teams.id}"/>
                                    <a href="javascript:submit_myteam(${vs.index})" class="tm-btn text-uppercase">团队详情</a>
                                </div>
                                    <%--                        onclick="submit_t(${vs.index})"--%>
                            </div>
                        </c:forEach>
                </div>
            </div>
        </div>
        <hr class="tm-margin-t-small">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <div class="tm-blog-post">
                    <h3 class="tm-gold-text">我参加的活动</h3><br>
                    <c:if test="${not empty requestScope.joiAct}">
                        <c:forEach items="${requestScope.joiAct}" var="joiAct" varStatus="vs">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                                <div class="tm-content-box">
                                    <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                    <h4 class="tm-margin-b-20 tm-gold-text">${joiAct.theme}</h4>
                                    <p class="tm-margin-b-20">${joiAct.message} <br>
                                            ${joiAct.number}</p>
                                    <input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
                                    <div class="dropdown">
                                        <button type="button" class="tm-btn dropdown-toggle" id="dropdownMenu2"
                                                data-toggle="dropdown">详情
                                        </button>
                                        <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
                                            <li role="presentation">
                                                <a href="javascript:submit_ta(${vs.index})" class="tm-gold-text text-uppercase"><i class="glyphicon glyphicon-info-sign"></i>活动详情</a>
                                            </li>
                                            <li role="presentation">
                                                <a role="menuitem" tabindex="-1" href="#" class="tm-gold-text text-uppercase" onclick=""><i class="glyphicon glyphicon-credit-card"></i>缴纳费用</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
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
<script language="JavaScript">
    function tip() {
        alert("操作成功！");
    }
</script>

</body>
</html>
