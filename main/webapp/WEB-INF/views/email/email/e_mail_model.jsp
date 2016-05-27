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
<link href="<%=basePath %>/css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" >

function themesearch(){
	if(document.getElementById('theme').value==""){
		alert("搜索名不能为空!");
	}else{
		document.getElementById('search').action="emailthemesearch";
   		document.getElementById('search').submit();
	}
}

</script>
<style>
.d9{
	margin-left:10%;
}
.d10{
	margin-left:1%;
	margin-top:15px;
}
.d11{
	margin-left:29%;
}
.dd{
margin-left:6%;
font-size:12px;
margin-top:8px;

}
</style>
<body>
		
			
		<form action="emailpersonalmodelsend" method="post">
		<div>
		<div class="c2">
			<div align="left" style="float:left">
				
				<input type="hidden" onClick="deleteemail()"style="cursor:pointer" value="删除">
				<a href=""><input type="submit" style="cursor:pointer"value="查看内容"></a>
				
			</div>
			<div style="float:left"class = "dd"><table align="center"> <tr> 共${totalP}页   &nbsp; &nbsp; 当前在${curP}页 </tr></table>  </div>
			<div align="center"  style="float:none">
				<a href="emailpersonalmodel?curp=1"><input type="button" name ="up" style="cursor:pointer"value="首页"/></a>
				<a href="emailpersonalmodel?curp=${curP-1}"><input type="button" name ="up" style="cursor:pointer"value="上一页"/></a>
				<a href="emailpersonalmodel?curp=${curP+1}"><input type="button" name="next" style="cursor:pointer" value="下一页"></a>
				<a href="emailpersonalmodel?curp=${totalP}"><input type="button" name="next" style="cursor:pointer" value="尾页"></a>
			</div>
		
			<div class="d10" style="float:none">
			<table border="1" cellpadding="0" cellspacing="0" >
				<tr >
					
					<th width="150px">邮件编号</th>
					<th width="450px">主题</th>
					
				</tr>
					<%  
				 
					ArrayList<EmailModel> emailmodel = (ArrayList<EmailModel>)request.getAttribute("personalemailmodel"); 
				
					for(EmailModel email:emailmodel){
				
				%>
				<tr class="t1">
					<td> <input type="radio" name="emailid" value="<%=email.getE_mail_id()%>"/><%=email.getE_mail_id() %></td>
					<td ><input type="hidden" name="emailtheme" value="<%=email.getE_mail_theme()%>"/><%=email.getE_mail_theme() %></td>
					
				</tr>
				
				
				<%} %>
			</table>
			</div>
			</div>
			</div>
		
		</form>
	
</body>
</html>
