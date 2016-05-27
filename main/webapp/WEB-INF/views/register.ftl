<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery-1.11.1.min.js"></script>
    <script type="text/ecmascript" src="/js/md5.js"></script>
</head>
<script type="text/javascript">
    function sub(){
        var input = document.getElementById("password");
        var name = input.value;
//        alert(name);
        var password = hex_md5(name);
//        alert(password);
        document.getElementById("password").value = password;
//        alert("确认提交？");
        document.register.action="/register";
        document.register.submit();
    }

</script>
<style>
</style>
<body>
<form name="register" id="register" method="post">
    用户ID:<input type="text" name="id">
    用户名:<input type="text" name="name" id="name">
    密 码：<input type="password" name="password" id="password">
    <br>

    <input type="button" onclick="sub()" value="提交">

</form>
${message}
<script type="text/javascript">

</script>
</body>
</html>