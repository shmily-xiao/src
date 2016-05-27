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
<link href="../css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<script src="../js/total.js" type="text/javascript"></script>

<script type="text/javascript">
function getemail(){
	var b = confirm("确认要这收藏这份群邮件到收件箱吗？");
	if(b == true){
		document.getElementById("groupemail").action="grouptoperonalemail";
   	 	document.getElementById("groupemail").submit();
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
.acceptbox{

margin-top:15px;
}
.right{
width:75%;
height:500px;
margin-left:30px;
margin-top:10px;
padding-top:20px;
}
.send{

width:100%;
height:50%;
}
body,html{
	background-color:#deebf7;
	height:75%;
	
}

</style>
<body>

			<div class="right" style="float:left">
			
			<form action="groupemailsearch" id ="groupemail" method="post">
				<div  class="acceptbox" style="float:none">	
					<div style="float:left">
						
						<input type="button" value="主题："/>
						
							<%
								ArrayList<EmailModel> allemail = (ArrayList<EmailModel>)request.getAttribute("groupemail");
			
							%>	
						<input class="f1" type="text" name="theme" tabindex="1" readonly="true" value="<%=allemail.get(0).getE_mail_theme()%>"/>
						
						
					</div>
					<div  class="c1"><a href="emaillooklist"><input type="button" name="back"style="cursor: pointer"oncilk ="back()"value="返回"/></a></div>
				</div>
				
				<div class="send" >
						
						<textarea id="sendtext" name="text" rows="16" readonly="true" style="resize:none"><%=allemail.get(0).getE_mail_detail() %></textarea>
						
				</div>
				
				<div class="acceptbox">
					<input type="hidden" onClick="getemail();" style="cursor:pointer" value="收藏"/>		
				</div>
				
		</form>
			 </div>
			
</body>
</html>
