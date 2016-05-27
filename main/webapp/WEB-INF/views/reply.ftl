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


<div>   回复     </div>
<form action="/reply/detail" method="get">
    留言人ID:<input type="text" name="acceptPersonId" readonly="true" value="${userId}">
    留言人姓名:<input type="text" name="acceptPersonName"  readonly="true" value="${userName}">
    <br>
    <br>
    回复的内容:
    <br>
    <textarea id="f1" rows="4" cols="100" name="information" style="resize:none" ></textarea>
    <input type="hidden" name="followId" value="${detail.detailId}">
    <input type="hidden" name="detailId" value="${detail.detailId}">
    <br>
    <input type="button" value="提交" onclick="location.href='/reply/detail'">
</form>


</body>
</html>