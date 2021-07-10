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
<div class="tm-blog-img-container">
    <div class="col-xs-10 col-sm-8 col-md-8 col-lg-6 col-xl-6 col-xs-offset-1 col-sm-offset-2 col-md-offset-2 col-lg-offset-3 col-xl-offset-3">
        <h2 class="tm-gold-text tm-title">您好<span class="tm-gold-text">${sessionScope.user.username}</span>！</h2>
    </div>
</div>
<section class="tm-section">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <div class="tm-blog-post">
                    <h3 class="tm-gold-text">我的团队
                        <a href="createAct.jsp"><span class="glyphicon glyphicon-plus-sign"></span></a>
                    </h3><br>
                    <c:forEach items="${requestScope.creAct}" var="creAct" varStatus="vs">
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                            <div class="tm-content-box">
                                <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                <h4 class="tm-margin-b-20 tm-gold-text">${creAct.theme}</h4>
                                <p class="tm-margin-b-20">${creAct.message} <br>
                                        ${creAct.number}</p>
                                <div class="dropdown">
                                    <input type="hidden" id="actTheme_${vs.index}" name="actTheme"
                                           value="${creAct.theme}"/>
                                    <button type="button" class="tm-btn dropdown-toggle" id="dropdownMenu1"
                                            data-toggle="dropdown">详情
                                    </button>
                                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                        <li role="presentation">
                                            <a role="menuitem" tabindex="-1" href="GroupAct.jsp" class="tm-gold-text text-uppercase"><i class="glyphicon glyphicon-info-sign"></i>团队详情</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <hr class="tm-margin-t-small">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <div class="tm-blog-post">
                    <h3 class="tm-gold-text">我报名的活动</h3><br>
                    <c:if test="${not empty requestScope.joiAct}">
                        <c:forEach items="${requestScope.joiAct}" var="joiAct" varStatus="vs">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                                <div class="tm-content-box">
                                    <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                    <h4 class="tm-margin-b-20 tm-gold-text">${joiAct.theme}</h4>
                                    <p class="tm-margin-b-20">${joiAct.message} <br>
                                            ${joiAct.number}</p>
                                    <a href="about" class="tm-btn text-uppercase">活动详情</a>
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
        alert("操作成功！")
    }
</script>

</body>
</html>
