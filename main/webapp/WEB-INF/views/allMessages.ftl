<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
</head>
<script type="text/javascript">

</script>
<style>
</style>
<body>
<div>
公共论坛
</div>
<a href="/add/send/detail">发帖？</a>
<br>
<#list details as d>
    <hr>
    <form  method="get">
        帖子编号:<input type="text" readonly="true" name="detailId" value="${d.detailId}">
        发帖人ID:<input type="text" readonly="true"  name="sendPersonId" value="${d.sendPersonId}">
        发帖人名字:<input type="text" readonly="true" name="sendPersonName" value="${d.sendPersonName}">
        <br>
        发帖主题:<input type="text" readonly="true" name="Theme" value="${d.theme}">
        发帖时间:<input type="text" readonly="true" name="sendTime" value="${d.sendTime}">
        <br>
        <input type="button" value="查看" onclick="location.href='/see/send/detail/1'">
    </form>
    <hr>
</#list>



</body>
</html>