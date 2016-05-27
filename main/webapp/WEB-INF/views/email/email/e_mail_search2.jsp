<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮件系统</title>
<link href="../css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="../js/total.js">

</script>
<style>
.t1{
background-color:#B0EEED;
}
.t2{
background-color:#B0EC80;#3FEF8E
}
</style>
<body>
		
			
		
		<div>
		<div class="c2">
			<div align="left" style="float:left">
				<a href="e_mail_welcome.jsp"><input type="button" value="返回"></a>
				<input type="button" onClick="check()"value="删除">
				
			</div>
			<div align="center"  style="float:none">
				<input type="button" name ="up"value="上一页">
				<input type="button" name="next" value="下一页">
			</div>
			<div class="acceptbox">
			
			<table border="1" cellpadding="0" cellspacing="0">
				<tr >
					<th width="100px">收件人</th>
					<th width="400px">主题</th>
					<th width="100px">时间</th>
				</tr>
				<tr class="t1">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t2">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t1">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t2">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t1">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t2">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t1">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t2">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t1">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				<tr class="t2">
					<td> <input type="checkbox" name="username" /> 王总</td>
					<td> 生日祝福</td>
					<td> 2014-2-4</td>
				
				</tr>
				
			</table>
			</div>
			</div>
		</div>
	
</body>
</html>
