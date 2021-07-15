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
            <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-xl-8 col-md-offset-4 col-lg-offset-4 col-xl-offset-4">
                <h2 class="tm-gold-text">缴费清单</h2>
                <c:set var="thisAcitvity" value="${sessionScope.thisActivity}"></c:set>
                <c:set var="thisleader" value="${sessionScope.leadername}"></c:set>
                <h3 class="tm-gold-text">活动名称：${thisAcitvity.theme}</h3>
                <p>人均缴费：${thisAcitvity.fee}</p>
                <p>追加活动费用：${thisAcitvity.fee}</p>
                <p>最终应缴费用：${thisAcitvity.fee}</p>
                <a role="menuitem" tabindex="-1" class="tm-btn" data-toggle="modal" data-target="#myModal2">缴纳费用</a>
            </div>
            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">二维码</h4>
                        </div>
                        <div class="modal-body">
                            <div style="right: 0; top: 0; left: 0; bottom: 0; margin: auto">
                                <img src="/img/pay.png" class="col-xs-10 col-sm-10 col-md-4 col-lg-4 col-xl-4">
                            </div>
                        </div>
                        <div class="modal-footer">请使用支付宝或微信扫描二维码进行缴费</div>
                    </div>
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

</body>
</html>
