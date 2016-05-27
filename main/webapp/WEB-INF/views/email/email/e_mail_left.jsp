
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>导航</title>
<link href="../css/e_mail.css" rel="stylesheet" type="text/css"></link>
</head>

<script type="text/javascript" >
function show(i){
	if(i == 1){
		var l = document.getElementById('l1');
		if(l.style.display == 'block'){
			l.style.display = 'none';
		}else{
			l.style.display = 'block';
		}
	}
	if(i == 2){
		var l = document.getElementById('l2');
		if(l.style.display == 'block'){
			l.style.display = 'none';
		}else{
			l.style.display = 'block';
		}
	}
	if(i == 3){
		var l = document.getElementById('l3');
		if(l.style.display == 'block'){
			l.style.display = 'none';
		}else{
			l.style.display = 'block';
		}
	}
}
</script>
<style>

.d1{
border-bottom:thin;

}
ul li{
border:1px solid #666666;
background-color:#FFFFFF;
margin-top:2px;
width:70px;
}
.d2{
border-left:1px solid #999999;
width:1px;
height:400px;
margin-top:10px;
margin-left:90%;
}

</style>


<body>

<div class="center">
  <div class="left" style="float:left">
	<div class="item" onclick="show(1);">制作模板</div>
	<div class="itemlist" id="l1" align="center">
		<ul>
			<li><a href="../emailmodelsendjudge" target="right">制作</a></li>
			<li><a href="../emailmodeljudge" target="right">查看</a></li>
		</ul>
	</div>
	<div class="item" onclick="show(2);">个人邮件</div>
	<div class="itemlist" id="l2" align="center">
		<ul>
			<li><a href="../emailpersonalsendjudge" target="right">发送</a></li>
			<li><a href="../emailsearchaccept" target="right">收件箱</a></li>
			<li><a href="../emailsearchsend" target="right">已发送</a></li>
			
		</ul>
	</div>
	<div class="item"><a href="../logout" target="_top">退出登录</a></div>
	</div>
	
	<div class="d2"  style="float:none">
		
	</div>
	
</div>

</body>
</html>
