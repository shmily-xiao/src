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
<script type="text/javascript">

function deleteemail(){
	var b = confirm("确认要这封邮件吗？");
	if( b==true ){
   	 	document.getElementById("delete_email").submit();
	}
}

</script>
<style>
.c1{

padding-left:75%;
}
#sendtext{
width:90%;
height:95%;
margin-top:10px;
}
.f1{
width:250px;

}
.acceptbox{

margin-top:15px;
}
</style>
<body>

	<form method="post" action="deletepersonalacceptemail"id="delete_email">
			<div class="right" style="float:left">
				<div>
				
				
				<%
				
					ArrayList<Email> email = (ArrayList<Email>)request.getAttribute("personalacceptemail");
			
				
				 %>
				
				
					<input type="button" value="发件人：">
					<input class="f1" type="text" readonly="true" value="<%=email.get(0).getSend_person_id()%>">
					
					
				</div>
				<div  class="acceptbox" style="float:none">	
					<div style="float:left">
						
						<input type="button" value="收件人：">
						<input class="f1" type="text" readonly="true" id="sendperson" name="sendperson" value="<%=email.get(0).getAccept_person_id()%>">
						<input type="hidden" id="sendtime" name="sendtime" value="<%=email.get(0).getSend_time()%>">
					</div>
					<div  class="c1"><a href="emailsearchaccept"><input type="button" style="cursor:pointer"value="返回"/></a></div>
				</div>
				
				<div class="send" >
						
						<textarea id="sendtext" rows="16"readonly="true" style="resize:none"><%=email.get(0).getSend_Information() %></textarea>
						
				</div>
				<div class="acceptbox">
					<input type="button" onClick="deleteemail();"style="cursor:pointer"value="删除">		
					<a href="emailpersonalresend?acceptperson=<%=email.get(0).getSend_person_id()%>&emailtheme=<%=email.get(0).getE_mail_theme()%>"><input type="button" style="cursor:pointer"value="回复">	</a>
				</div>
			
			 </div>
			 </form>
</body>
</html>
