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

    .f1{
        width:25px;
        height: 20px;

    }
    element.style {
        margin: 0px;
        width: 500px;
        height: 32px;
    }
</style>
<body>
<div>
${userName} 个人中心
</div>
这个页面暂时还没有用到
<div>   其他人给您的留言板     </div>
<form action="/delete/accept/detail/1" method="get">
    <#list detail as d>

        <input type="button" name="sendPersonName" value="${d.sendPersonName}">${d.sendPersonName}
        <br>
        <textarea id="f1" readonly="true" rows="4"name="information" style="resize:none" >${detail.information}</textarea>
        <input type="hidden" name="detailId" value="${detail.detailId}">
        <br>
        <input type="submit"   value="删除">
        <input type="button" value="回复">

    </#list>
</form>


</body>
</html>