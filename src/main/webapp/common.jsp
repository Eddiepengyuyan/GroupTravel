<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo-style.css">
</head>
<body>
<div class="tm-header">
    <div class="container-fluid">
        <div class="tm-header-inner">
            <a href="index" class="navbar-brand tm-site-name">HuFenWEB</a>
            <!-- 导航栏 -->
            <nav class="navbar tm-main-nav">
                <button class="navbar-toggler hidden-md-up" type="button" data-toggle="collapse" data-target="#tmNavbar">
                    &#9776;
                </button>
                <div class="collapse navbar-toggleable-sm" id="tmNavbar">
                    <ul class="nav navbar-nav">
                        <li class="nav-item">
                            <a href="index" id="a" class="nav-link">首页</a>
                        </li>
                        <%--                        <li class="nav-item active">--%>
                        <%--                            <a href="about.jsp" class="nav-link">关于我们</a>--%>
                        <%--                        </li>--%>
                        <c:if test="${empty sessionScope.user}">
                            <li class="nav-item">
                                <a href="login" id="" class="nav-link">登录</a>
                            </li>
                        </c:if>
                        <c:if test="${not empty sessionScope.user}">
                            <c:set value="${sessionScope.user}" var="thisUser" scope="session"></c:set>
                            <li class="nav-item">
                                <a href="personalCenter" class="nav-link">个人中心</a>
                            </li>
                            <li class="nav-item">
                                <a href="logout" id="d" class="nav-link">注销</a>
                            </li>
                        </c:if>
                    </ul>
                </div>

            </nav>

        </div>
    </div>
</div>
</body>
</html>
