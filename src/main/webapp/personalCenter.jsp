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
                        <c:forEach items="${requestScope.joiAct}" var="joiAct" varStatus="vs">
                            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                                <div class="tm-content-box">
                                    <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                    <h4 class="tm-margin-b-20 tm-gold-text">${joiAct.theme}</h4>
                                    <p class="tm-margin-b-20">${joiAct.message} <br>
                                            ${joiAct.number}</p>
                                    <input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
<%--
                    活动是否已结束
                    未结束
--%>
                                    <c:if test="${joiAct.status == 0 || joiAct.status == 1}">
                                        <p class="tm-gold-text" >请等待活动结束再进行缴费</p>
<%--                                        <c:out value="请等待活动结束再进行缴费"></c:out>--%>
                                    </c:if>
                                    <c:if test="${joiAct.status == 2}">
                                        <input type="hidden" id="thisActTheme" value="${joiAct.theme}">
                                        <a role="menuitem" tabindex="-1" href="javascript:pay()" class="tm-btn tm-gold-text text-uppercase" onclick="">缴纳费用</a>
                                    </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
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
