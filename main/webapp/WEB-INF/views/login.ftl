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
        var password = hex_md5(name);
        document.getElementById("password").value = password;
        document.login.action="/login";
        document.login.submit();
    }

</script>
<body>
    <form name="login" id="login" method="post">
        用户名:<input type="text" name="id">
        <br>
        密  码：<input type="password" name="password" id="password">
        <br>
        <input type="button" onclick="sub()" value="登陆">
    </form>
    <br>
    ${message}
    <br>
        是否注册？
        <a href="/register">注册</a>

</body>
</html>