<%@ page language="java" import="java.util.*,com.email.dto.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>邮件系统</title>
<link href="<%=basePath %>css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="../js/total.js">

</script>
<style>
	.d9{
	margin-left:10%;
	}
	.d10{
	margin-left:13%;
	margin-top:15px;
	}
	.d11{
	margin-left:29%;
	}
</style>
<body>
		
			
		<form action="emailgroupmodelsend" method="post">
		<div >
			<div align="left" style="float:left" align="center" class="d9" >
				<div >
					<a href=""><input type="submit" style="cursor: pointer"value="确认"></a>
					<a href="emailgroupsendjudge"><input type="button" style="cursor: pointer"value="返回"></a>
				</div>
				
			</div>
			<div style="float:left"class ="dd"><table align="center"> <tr> 共${totalP}页   &nbsp; &nbsp; 当前在${curP}页&nbsp;&nbsp; </tr></table>  </div>
			<div   style="float:none"> 
				<div style="font-size:12px" class="d11">
				<a href="emailgroupmodel?curp=1"><input type="button" name ="top" style="cursor:pointer"value="首页"/></a>
				<a href="emailgroupmodel?curp=${curP-1}"><input type="button" name ="up" style="cursor:pointer"value="上一页"/></a>
				<a href="emailgroupmodel?curp=${curP+1}"><input type="button" name="next" style="cursor:pointer" value="下一页"></a>
				<a href="emailgroupmodel?curp=${totalP}"><input type="button" name="down" style="cursor:pointer" value="尾页"></a>
				
				</div>
			</div>
			
			<div class="d10" style="float:none">
			<table border="1" cellpadding="0" cellspacing="0" >
				<tr >
					<th width="150px">邮件编号</th>
					<th width="450px">主题</th>
					
				</tr>
				<%  
				 
					ArrayList<Email> emailmodel = (ArrayList<Email>)request.getAttribute("groupemailmodel"); 
				
					for(Email email:emailmodel){
				
				%>
				<tr class="t2">
					<td> <input type="radio" name="emailid" value="<%=email.getE_mail_id()%>"/><%=email.getE_mail_id() %></td>
					<td ><input type="hidden" name="emailtheme" value="<%=email.getE_mail_theme()%>"/><%=email.getE_mail_theme() %></td>
					
				</tr>
				
				
				<%} %>
				
			</table>
			</div>
		</div>
		</form>
	
</body>
</html>
