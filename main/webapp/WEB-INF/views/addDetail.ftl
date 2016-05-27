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

${message}
${error}
<form action="/addDetail" method="get">
    发帖人ID：<input type="text" name="sendPersonId" readonly="true" value="${userId}">
    发帖人名字：<input type="text" name="sendPersonName" readonly="true" value="${userName}">
    发帖主题：<input type="text" name = "theme">
    <br>
    内容：
    <br>
    <textarea id="f1"  rows="16" cols="125" style="resize:none" name="information"></textarea>
    <input type="submit"   value="添加">
</form>
</body>
</html>