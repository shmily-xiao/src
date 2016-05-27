<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
</head>
<script type="text/javascript">
function replyDetail(){
    alert("回复");
    document.reply.action="/reply";
    document.reply.submit();
}
    function deleteDetail(){
        alert("删除");
        document.reply.action="/delete/admin/details/1";
        document.reply.submit();
}
</script>
<style>
</style>
<body>

<div>   ${detail.sendPersonName}的留言板     </div>
<hr>
<br>

<form action="/delete/admin/details/1" method="get">
    帖子编号:<input type="text" readonly="true" name="detailId" value="${detail.detailId}">
    发帖人ID:<input type="text" readonly="true" name="sendPersonId" value="${detail.sendPersonId}">
    发帖人名字:<input type="text" readonly="true" name="sendPersonName" value="${detail.sendPersonName}">
    <br>
    发帖主题:<input type="text" readonly="true" name="Theme" value="${detail.theme}">
    发帖时间:<input type="text" readonly="true" name="sendTime" value="${detail.sendTime}">
    <br>
    发帖内容:
    <br>
    <textarea id="f1" readonly="true" rows="4" cols="100" name="information" style="resize:none" >${detail.information}</textarea>
    <input type="button" value="删除" onclick="location.href='/delete/admin/details/1'">
</form>
<br>
<hr>
<br>
<br>
<hr>
您可以在这里留言：
<form action="/add/detail/1" method="get">
    版主ID:<input type="text" readonly="true"name="acceptPersonId" value="${detail.sendPersonId}">
    版主姓名:<input type="text" readonly="true" name="acceptPersonName" value="${detail.sendPersonName}" >
    <br>
    发送内容:
    <br>
    <textarea id="f1"  rows="4" cols="100" name="information" style="resize:none" ></textarea>
    <input type="hidden" name="followId" value="${detail.detailId}">
    <input type="hidden" name="detailId" value="${detail.detailId}">
    <br>
    <input type="button" value="留言" onclick="location.href='/add/detail/1'">
</form>
<hr>
这里是已有的留言：
    <#list followDetail as d>
    <hr>
    <form id ="reply" name="reply"  method="get">
        <input type="hidden" name="detailId" value="${d.detailId}">
        留言人ID:<input type="text" name="sendPersonId" value="${d.sendPersonId}">
        留言人名字：<input type="text" name="sendPersonName" value="${d.sendPersonName}">
        <br>
        留言时间:<input type="text" name="sendTime" value="${d.sendTime}">
        <br>
        留言内容:
        <br>
        <textarea id="f1" readonly="true" rows="4" cols="100" name="information" style="resize:none" >${d.information}</textarea>
        <input type="button" onclick="deleteDetail()" value="删除">
        <input type="button" onclick="replyDetail()" value="回复" >
    </form>

    </#list>
</body>
</html>