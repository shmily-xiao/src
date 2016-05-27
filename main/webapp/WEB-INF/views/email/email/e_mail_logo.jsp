<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OA邮件</title>
<link href="../css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<style>
.title1{
color:#CCCCCC;
padding-top:10px;
}
</style>
<body>
	<div>
		<div class="title"align="center">
			<div class="title1" align="right" style="margin-right:50px">您好：${username}</div>
  			<div class="title2" align="center"><p align="center" class="titlefont">欢迎进入OA邮件系统</p>
  			
  			</div>

		</div>
	
	</div>
</body>
</html>