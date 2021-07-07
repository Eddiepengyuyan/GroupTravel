<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新建活动</title>

    <!-- load stylesheets -->
    <link rel="stylesheet" href="css/bootstrap.min.css">                                      <!-- Bootstrap style -->
    <link rel="stylesheet" href="css/templatemo-style.css">                                   <!-- Templatemo style -->
</head>

<body>
    <jsp:include page="common.jsp"></jsp:include>
    <div class="tm-contact-img-container">

    </div>

    <section class="tm-section">
        <div class="container-fluid">
            <div class="row">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 col-lg-offset-3 col-xl-offset-3">
                    <section>
                        <h3 class="tm-gold-text tm-form-title">输入编辑后的活动信息</h3>
                        <form action="index.jsp" method="post" class="tm-contact-form">
                            <div class="form-group">
                                <input type="text" id="activity_name" name="activity_name" class="form-control" placeholder="姓名"  required/>
                            </div>
                            <div class="form-group">
                                <input type="text" id="activity_number" name="activity_number" class="form-control" placeholder="联系电话"  required/>
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

    <!-- load JS files -->
    <script src="js/jquery-1.11.3.min.js"></script>             <!-- jQuery (https://jquery.com/download/) -->
    <script src="https://www.atlasestateagents.co.uk/javascript/tether.min.js"></script> <!-- Tether for Bootstrap, http://stackoverflow.com/questions/34567939/how-to-fix-the-error-error-bootstrap-tooltips-require-tether-http-github-h -->
    <script src="js/bootstrap.min.js"></script>                 <!-- Bootstrap (http://v4-alpha.getbootstrap.com/) -->
</body>
</html>