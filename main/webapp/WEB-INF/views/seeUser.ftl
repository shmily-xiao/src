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
    <table >
        <tr>
            <td width="100px">用户id</td>
            <td width="100px">用户名</td>
            <td width="400px">操作</td>
        </tr>
    <#list list as user>
    <form action="/add" method="get">
        <tr>
            <td><input type="radio" name="acceptPersonId" value="${user.id}">${user.id}</td>
            <td name="acceptPersonName" value="${user.name}">${user.name}</td>
            <td>
                <input type="submit"  value="留言">
            </td>

        </tr>
    </#list>
    </table>
</form>


</body>
</html>