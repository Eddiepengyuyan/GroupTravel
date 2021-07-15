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
<c:set var="teamId" value="${requestScope.teamId}"></c:set>
<div class="tm-blog-img-container"></div>
<section class="tm-section">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-9 col-xl-9">
                <div class="tm-blog-post">
                    <h3 class="tm-gold-text">正在进行的活动
                        <a href="createAct?teamId=${teamId}"><span class="glyphicon glyphicon-plus-sign"></span></a>
                    </h3><br>
                    <c:forEach items="${requestScope.joiAct_under}" var="creAct" varStatus="vs">
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
                                            <a role="menuitem" tabindex="-1" href="javascript:submit_t(${vs.index})" class="tm-gold-text text-uppercase"><i class="glyphicon glyphicon-info-sign"></i>活动详情</a>
                                        </li>
                                        <li role="presentation">
                                            <a role="menuitem" tabindex="-1" href="javascript:editAct(${vs.index})" class="tm-gold-text text-uppercase"><i class="glyphicon glyphicon-edit"></i> 编辑</a>
                                        </li>
                                        <li role="presentation">
                                            <a role="menuitem" tabindex="-1" href="#" class="tm-gold-text" onclick="delete_t(${vs.index})"><i class="glyphicon glyphicon-trash"></i>删除</a>
                                        </li>
                                        <li role="presentation">
                                            <input type="hidden" id="teamId" value="${requestScope.teamId}">
                                            <a role="menuitem" tabindex="-1" href="export?actId=${creAct.id}" class="tm-gold-text"><i class="glyphicon glyphicon-floppy-disk"></i>导出数据</a>
                                        </li>
                                        <li role="presentation">
                                            <input type="hidden" id="actId" value="${creAct.id}">
                                            <a role="menuitem" tabindex="-1" href="javascript:setup(${vs.index})" class="tm-gold-text"><i class="glyphicon glyphicon-ok-circle"></i>成立</a>
                                        </li>
                                        <li role="presentation">
                                            <a role="menuitem" tabindex="-1" href="javascript:closeAct(${vs.index})"  class="tm-gold-text"><i class="glyphicon glyphicon-ban-circle"></i>结束</a>
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
                    <h3 class="tm-gold-text">已结束的活动</h3><br>
                    <c:forEach items="${requestScope.joiAct_close}" var="creAct" varStatus="vs">
                        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">
                            <div class="tm-content-box">
                                <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                <h4 class="tm-margin-b-20 tm-gold-text">${creAct.theme}</h4>
                                <p class="tm-margin-b-20">${creAct.message} <br>
                                        ${creAct.number}</p>
                                <div class="dropdown">
                                    <input type="hidden" id="actTheme_${vs.index}" name="actTheme"
                                           value="${creAct.theme}"/>
                                    <button type="button" class="tm-btn dropdown-toggle" id="dropdownMenu2"
                                            data-toggle="dropdown">详情
                                    </button>
                                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
                                        <li role="presentation">
                                            <a href="javascript:submit_t(${vs.index})" class="tm-gold-text"><i class="glyphicon glyphicon-info-sign"></i>活动详情</a>
                                        </li>
                                        <li role="presentation">
                                            <a href="javascript:actReport(${vs.index})" class="tm-gold-text"><i class="glyphicon glyphicon-align-left"></i>生成活动报告</a>
                                        </li>
                                        <li role="presentation">
                                            <a href="/Email" class="tm-gold-text "><i class="glyphicon glyphicon-envelope"></i>发送通知邮件</a>
                                        </li>
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
        alert("操作成功！")
    }
</script>
</body>
</html>
