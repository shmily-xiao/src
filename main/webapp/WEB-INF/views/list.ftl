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
${message}
<form action="/delete/user" method="get">
    <table >
        <tr>
            <td width="100px">用户id</td>
            <td width="100px">用户名</td>
            <td width="100px">密码</td>
            <td width="400px">操作</td>
        </tr>

        <#list list as user>
        <tr>
            <td><input type="radio" name="id" value="${user.id}">${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
            <td>
                <input type="button"  value="删除用户" onclick="location.href='/delete/user'">
                <a href="/user/addRoot?id=${user.id}"> <input type="button"  value="权限提升"></a>
                <a href="/user/deleteRoot?id=${user.id}"><input type="button" value="权限消除"> </a>
            </td>

        </tr>
        </#list>
    </table>
</form>


</body>
</html>