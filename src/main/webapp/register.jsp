<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo-style.css">
</head>
<body>
<jsp:include page="common.jsp"></jsp:include>
<div class="col-xs-10 col-sm-8 col-md-8 col-lg-6 col-xl-6 col-xs-offset-1 col-sm-offset-2 col-md-offset-2 col-lg-offset-3 col-xl-offset-3">
    <div class="panel-heading" style="height: 100px;"></div>
    <div class="panel-body" style="padding: 40px 70px 20px">
        <form role="form" action="skip" method="post" class="tm-contact-form" onSubmit="return check()">
            <div class="input-group">
                <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-user"></i></span>
                <input type="text" id="username" name="username" placeholder="用户名" class="form-control" style="border-bottom: solid #cc9900; border-left: none;"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-user"></i></span>
                <input type="email" id="number" name="number" placeholder="联系邮箱" class="form-control" style="border-bottom: solid #cc9900; border-left: none;"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-user"></i></span>
                <input type="text" id="realname" name="realname" placeholder="真实姓名" class="form-control" style="border-bottom: solid #cc9900; border-left: none;"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-lock"></i></span>
                <input type="text" id="password" name="password" class="form-control" style="border-bottom: solid #cc9900; border-left: none;" placeholder="密码"/>
            </div>
            <br>
            <div class="input-group">
                <span class="input-group-addon" style="background-color: white; border-right: none; border-bottom: solid #cc9900;"><i class="glyphicon glyphicon-check"></i></span>
                <input type="text" id="repassword" name="repassword" class="form-control" style="border-bottom: solid #cc9900; border-left: none;" placeholder="确认密码"/>
            </div>
            <br/>
<!--                <button type="submit" class="tm-btn1" onclick="check()">注册</button>-->
            <input type="submit" class="tm-btn" value="注册"/>
        </form>
    </div>
</div>
</body>
<script language="JavaScript" type="text/javascript">
    function check()
    {
        var name=document.getElementById("username").value;
        var patrn_name=/^[a-zA-Z][a-zA-Z0-9]{3,15}$/;   //用户名4-16位，字母开头
        if(name!=null&&!patrn_name.exec(name))
        {
            alert("用户名输入不符合要求"+name);
            return false;
        }
        var tel=document.getElementById("number").value;
        var patrn_tel=/^[1][0-9]{10}$/;   //tel:13562276780
        if(tel!=null&&!patrn_tel.exec(tel))
        {
            alert("联系电话格式错误");
            return false;
        }
        var name=document.getElementById("realname").value;
        var patrn_name = /[^\x00-\x80]/;
        if(name!=null&&!patrn_name.exec(name))
        {
            alert("请正确输入姓名");
            return false;
        }
        var pass1=document.getElementById("password").value;
        var pass2=document.getElementById("repassword").value;
        var patrn_pass=/^[A-Z][a-zA-Z0-9]{3,15}$/;   //用户名4-16位，首字母大写
        if(pass1!=null&&!patrn_pass.exec(pass1))
        {
            alert("密码输入不符合要求,首字母大写"+pass1);
            return false;
        }
        if(pass1!=pass2)
        {
            alert("两次输入的密码不同密码不同");
            return false;
        }
        return true;
    }
</script>
</html>
