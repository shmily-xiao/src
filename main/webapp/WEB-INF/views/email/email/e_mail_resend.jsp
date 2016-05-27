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
<script src="../js/total.js" type="text/javascript"></script>

<script type="text/javascript">
function check(){
    if(confirm("确定取消么？")){
    
    	window.location.href="personalemailacceptdetail"; 
        return true;
    }else{
        return false;
    }
}

function isSearch(s)
        {
        var patrn=/[\"\'<>``!@#$%^&*+-\/\/\/\\//?,.]/;     //这里禁止<和>的输入
        if (patrn.exec(s))
        {
                alert("不能包含特殊字符(\"\'<>``!@#$%^&*+-\/\/\/\\//?,.)"); 
                return true;
        }
        return false;
  }

function personalsend(){
if(document.getElementById('acceptperson').value==""){
	alert("邮件收件人不能为空！");
}else if(document.getElementById('emailtheme').value==""){
	alert("邮件主题不能为空！");
}else if(document.getElementById('sendtext').value==""){
	alert("邮件内容不能为空！");
}else{
	document.getElementById('emailpersonalsend').action="personalsend";
    document.getElementById('emailpersonalsend').submit();
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
.f2{
width:222px;

}
.acceptbox{

margin-top:15px;
}
</style>
<body>
<%
	String acceptperson = (String)request.getAttribute("emailacceptperson");
	String emailtheme = (String)request.getAttribute("emailtheme");
 %>
		<form method="post" id="emailpersonalsend">
			<div class="right" style="float:left">
				<div>
				
					<input type="button" value="收件人：">
					<input class="f1" type="text" name="acceptperson"  id="acceptperson" readonly="true" tabindex="1" placeholder="用户id" value="<%=acceptperson %>">
				</div>
				<div  class="acceptbox" style="float:none">	
					<div style="float:left">
						<input type="button" value="主题">
						<input class="f2" type="text" name="emailtheme"  id="emailtheme" tabindex="1" placeholder="填写主题" value="<%=emailtheme%>">
					</div>
					<div  class="c1"><a href="personalemailacceptdetail"><input type="button" style="cursor:pointer"value="返回"/></a></div>
				</div>
				
				<div class="send" >
						
						<textarea id="sendtext" name="sendtext"  rows="16" style="resize:none"></textarea>
						
				</div>
				<div class="acceptbox">
					<input type="button" onclick="personalsend()" style="cursor:pointer"value="发送">	
					<input type="button" onClick="check()"name="back"style="cursor:pointer"value="取消">		
				</div>
			
			 </div>
			 </form>
</body>
</html>
