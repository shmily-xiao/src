<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Logout.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
	#top{
	
	background-repeat:repeat-x;
	height:100px;
	}
	
	body{
	height:98%;
	background:rgb(221,244,249);
	background-repeat:repeat-x;
	background-position:50% 100%;
	}
	
	#msh{
	color:#666666;
	}
	</style>
	<script language="javascript">
	var times=6;
	clock();
	function clock()
	{
   	window.setTimeout('clock()',1000);
   	times=times-1;
   	time.innerHTML =times;
	}
</script>
<meta http-equiv= "Refresh" content= "5;url=mylogin.jsp ">
  </head>
  
  <body>
  <div id="top"></div>
  <div align="center" id= "time"><h1 id="msh">您已成功登出！！</h1></div>
   
  </body>
</html>
