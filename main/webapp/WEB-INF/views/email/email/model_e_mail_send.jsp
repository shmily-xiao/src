
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
<link href="<%=basePath %>css/e_mail.css" rel="stylesheet" type="text/css">
</head>
<script  type="text/javascript">
function check(){
    if(confirm("确定取消么？")){
    
    	window.location.href="web/e_mail_welcome.jsp"; 
        return true;
    }else{
        return false;
    }
    
}

function groupsend(){
if(document.getElementById('theme').value=="")
{
	alert("邮件主题不能为空！");
}else if(document.getElementById('sendtext').value==""){
	alert("邮件内容不能为空！");
}else{
	document.getElementById('emailallsend').action="sendemailmodel";
    document.getElementById('emailallsend').submit();
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
.d7{

width:400px;
size:20px;

}
</style>
<body>
			<div class="right" style="float:left">
				<div align="center">
					<div class="d7">
						<input type="button" value="您即将制作一份所有人都看得到的模板邮件,请谨慎操作！">
				
					</div>
				</div>
				
				<form  method="post"  id="emailallsend">
				<div  class="acceptbox" style="float:none">	
					<div style="float:left">
						
						<input type="button" value="主题">
						<input class="f2" type="text" maxlength="20"  name = "theme" id ="theme" tabindex="1" placeholder="填写主题" value=""onfocusout="if(isSearch(this.value))this.focus()" onkeydown="if(event.keyCode==32) return false">
						
					</div>
					<div  class="c1"><a href="web/e_mail_welcome.jsp"><input style="cursor:pointer" type="button" value="返回"/></a></div>
				</div>
				
				<div class="send" >
						
						<textarea id = "sendtext"name="text" maxlength="1000" rows="16" style="resize:none"></textarea>
						
				</div>
				<div class="acceptbox">
					<input type="button" onclick="groupsend()" style="cursor:pointer" value="制作">	
					<input type="button" onClick="check()"name="back" style="cursor:pointer" value="取消">	
				</div>
			</form>
			 </div>
</body>
</html>
