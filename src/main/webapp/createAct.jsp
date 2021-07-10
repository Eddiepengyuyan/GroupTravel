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
                        <h3 class="tm-gold-text tm-form-title">创建新活动</h3>
                        <p class="tm-form-description">亲爱的团长，您可以在此选择创建新的活动项目供他人选择。请根据提示填写以下表单，感谢每一位团长的配合。</p>

                        <form action="/transfer" method="post" class="tm-contact-form">
                            <div class="form-group">
                                <input type="text" id="activity_name" name="activity_name" class="form-control" placeholder="姓名"  required/>
                            </div>
                            <div class="form-group">
                                <input type="email" id="activity_email" name="activity_number" class="form-control" placeholder="邮箱"  required/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="activity_subject" name="activity_subject" class="form-control" placeholder="活动主题"  required/>
                            </div>
                            <div class="form-group">
                                <input type="date" id="activity_time" name="activity_time" class="form-control" placeholder="活动时间"  required/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="activity_start" name="activity_start" class="form-control" placeholder="活动起点"  required/>
                            </div>
                            <div class="form-group">
                                <input type="number" id="activity_cost" name="activity_cost" class="form-control" placeholder="活动费用(元)"  required/>
                            </div>
                            <div class="form-group">
                                <textarea id="activity_message" name="activity_message" class="form-control" rows="6" placeholder="活动详情" required></textarea>
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


<%--                            <div class="tm-content-box tm-margin-t-mid tm-content-box-contact">--%>
<%--                                <img src="img/tm-img-310x180-2.jpg" alt="Image" class="tm-margin-b-20 img-fluid">--%>
<%--                                <h4 class="tm-margin-b-20 tm-gold-text">Lorem ipsum dolor #2</h4>--%>
<%--                                <p class="tm-margin-b-20 tm-p-small">Aenean cursus tellus mauris, quis--%>
<%--                                consequat mauris dapibus id. Donec--%>
<%--                                scelerisque porttitor pharetra</p>--%>
<%--                                <a href="#" class="tm-btn text-uppercase">Read More</a>--%>
<%--                            </div>--%>

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
