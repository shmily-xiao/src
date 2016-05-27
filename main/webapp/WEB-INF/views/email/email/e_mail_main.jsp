<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>OA邮件系统</title>
</head>


	<frameset rows ="18%,*,18%" border = "0">
		<frame src="web/e_mail_logo.jsp" noresize="noresize"/>
		<frameset cols = "25%,*">
			<frame src="web/e_mail_left.jsp" noresize="noresize"/>
			<frame name ="right"src="web/e_mail_welcome.jsp" noresize="noresize"/>
		</frameset>	
		<frame src="web/e_mail_down.jsp" noresize="noresize"/>
	</frameset><noframes></noframes>
	
		




</html>