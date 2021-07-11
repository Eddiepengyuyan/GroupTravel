<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>

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

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
</head>

<body>
    <jsp:include page="common.jsp"></jsp:include>

    <div class="tm-contact-img-container">

    </div>

    <section class="tm-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-8">

                    <section>
                        <h3 class="tm-gold-text tm-form-title">创建新团队</h3>
                        <p class="tm-form-description">先生/女士您好，欢迎每一位用户创建团队，加入到团长的大家庭中！</p>
                        <form action="/createGroupTransfer" method="post" class="tm-contact-form">
                            <div class="form-group">
                                <input type="text" id="group_name" name="group_name" class="form-control" placeholder="团队名称"  required/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="group_leader" name="group_leader" class="form-control" placeholder="团长姓名"  required/>
                            </div>
                            <div class="form-group">
                                <textarea id="group_info" name="group_info" class="form-control" rows="6" placeholder="团队介绍" required></textarea>
                            </div>
                            <button type="submit" class="tm-btn">提交</button>
                            <button type="reset" class="tm-btn">重置</button>
                        </form>
                    </section>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-4 col-xl-4 tm-contact-right">

                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">


                            <c:forEach items="${requestScope.activities}" var="activities" varStatus="vs">
                                <div class="tm-content-box tm-content-box-contact">
                                    <img src="img/tm-img-310x180-1.jpg" alt="Image" class="tm-margin-b-20 img-fluid">
                                    <h4 class="tm-margin-b-20 tm-gold-text">${activities.theme}</h4>
                                    <p class="tm-margin-b-20 tm-p-small">
                                            ${activities.message} <br>
                                            ${activities.number}
                                    </p>
                                    <input type="hidden" id="actTheme_${vs.index}" name="actTheme" value="${activity.theme}"/>
                                    <a href="javascript:submit_t(${vs.index})" class="tm-btn text-uppercase">活动详情</a>
                                </div>
                                <br>
                            </c:forEach>
                        </div>
                    </div>
                    <hr class="tm-margin-t-mid">
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
    <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
    <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
</body>
</html>
