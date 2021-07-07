<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo-style.css">
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
<div class=""></div>
<div class="col-xs-1 col-sm-2 col-md-2 col-lg-3 col-xl-3"></div>
<div class="col-xs-10 col-sm-8 col-md-8 col-lg-6 col-xl-6">
    <form action="dologin" method="post" class="tm-contact-form">
        <div class="panel-heading" style="height: 100px;"></div>
        <div class="panel-body" style="padding: 40px 70px 20px;">
            <form role="form">
                <div class="input-group">
                    <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-user"></i></span>
                    <input type="text" id="username" name="username" placeholder="用户名" class="form-control" style="border-bottom: solid #cc9900; border-left: none;"/>
                </div>
                <br>
                <div class="input-group">
                    <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-lock"></i></span>
                    <input type="text" id="password" name="password" class="form-control" style="border-bottom: solid #cc9900; border-left: none;" placeholder="密码"/>
                </div>
                <br>
                <div>
                    <input type="checkbox" id="rememberme"/>记住我
                </div>
                <br/>
                <button type="submit" class="tm-btn">登录</button>
                <div>
                    <a href="register.jsp">还没有账号？注册一个</a>
                </div>
            </form>
        </div>
    </form>
</div>
<div class="col-xs-1 col-sm-2 col-md-2 col-lg-3 col-xl-3"></div>
</body>
</html>