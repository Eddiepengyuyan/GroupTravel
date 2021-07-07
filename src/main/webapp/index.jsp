<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo-style.css">
</head>
<body>
    <jsp:include page="common.jsp"></jsp:include>
    <div class="tm-home-img-container">
        <img src="img/tm-home-img.jpg" alt="Image" class="hidden-lg-up img-fluid">
    </div>

    <section class="tm-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-xs-center">
                    <h2 class="tm-gold-text tm-title">欢迎</h2>
                    <p class="tm-subtitle">这里的一切都是你的！</p>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${requestScope.activities}" var="activity" varStatus="vs">
<%--                    <c:set value="${activity}" scope="session" var="thisActivity"></c:set>--%>
                    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3 col-xl-3">

                        <div class="tm-content-box">
                            <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                            <h4 class="tm-margin-b-20 tm-gold-text">${activity.theme}</h4>
                            <p class="tm-margin-b-20">${activity.message} <br>
                                    ${activity.number}</p>
                            <input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
                            <a href="javascript:submit_t(${vs.index})" class="tm-btn text-uppercase">活动详情</a>
                        </div>
<%--                        onclick="submit_t(${vs.index})"--%>
                    </div>
                </c:forEach>
            </div> <!-- row -->



            </div> <!-- row -->

        </div>
    </section>

    <footer class="tm-footer">
        <div class="container-fluid">

            <div class="row">
                <div class="col-xs-12 tm-copyright-col">
                    <p class="tm-copyright-text">Copyright &copy; 2021.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
                </div>
            </div>
        </div>
    </footer>

<%--    <script>--%>
<%--        function submit_t(){--%>
<%--            var theme = document.getElementById("actTheme").value;--%>
<%--            var url = "about";--%>
<%--            url += "?actTheme="+theme;--%>
<%--            window.location = url;--%>
<%--        }--%>

<%--    </script>--%>
    <%--  导入回传数据jsfiles  --%>
    <script src="js/return.js"></script>
    <!-- load JS files -->
    <script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
    <script src="js/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
    <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
</body>
</html>