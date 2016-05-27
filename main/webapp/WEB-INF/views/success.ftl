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
<body>
    欢迎 ${userName} 登陆！
    <br>
    <a href="/manage/user/list?id=${userId}">管理用户</a>
    <br>
    <a href="/all/user/list">给其他用户留言</a>
    <br>
    <a href="/see/send/detail/1?acceptPersonId=${userId}">查看其他人给您留的言</a>
    <br>
    <a href="/see/accept/detail/1?sendPersonId=${userId}">查看您给其他人留的言</a>
    <br>
    <a href="/see/all/send">查看论坛</a>
    <br>
    <a href="/logout">安全退出</a>
    <br>
    ${message}
</body>
</html>