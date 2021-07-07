<%@ page import="cn.edu.usts.cs2019.utils.Paginate" %><%--
  Created by IntelliJ IDEA.
  User: Drifter
  Date: 2021/3/23
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="../lib/bootstrap/js/bootstrap.min.js"></script>
<script src="../lib/js/jquery-3.4.1.min.js"></script>
<body>
<div style="max-width: 600px; margin: auto;padding: 130px 50px 50px">
    <div class="panel panel-default" style="border-radius: 20px; overflow:hidden; border: solid black 1px;">
        <div class="panel-heading" style="height: 80px; border-bottom: solid black 1px;"><h3>搜索结果</h3></div>
        <div class="panel-body">
            <table class="table">
                <tr>
                    <td></td>
                    <td><span class="glyphicon glyphicon-user"></span>&nbsp;编号</td>
                    <td>${id}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;部门编号</td>
                    <td>${department_id}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><span class="glyphicon glyphicon-calendar"></span>&nbsp;姓名</td>
                    <td>${name}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><span class="glyphicon glyphicon-map-marker"></span>&nbsp;部门负责人</td>
                    <td>${department_principal}</td>
                </tr>
                <tr>
                    <td></td>
                    <td><span class="glyphicon glyphicon-heart"></span>&nbsp;部门人数</td>
                    <td>${getDepartment_num}</td>
                </tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>
