<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>
<link href="/css/datepicker.css" rel="stylesheet">
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/navbar-fixed-top.css" rel="stylesheet">
<link href="/css/signin.css" rel="stylesheet">
</head>
<script type="text/javascript">


function show(){
	alert("若无法登录系统请于管理员联系！");
}

function check(){
	alert(request.getAttribute("msg2"));
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

<style type="text/css">
      .head_intro{
        margin: auto;
        display: block;
        font-size: 50px;
      }
      #main{
      margin: 50px 184px;
      border-radius: 9px 9px 9px 9px;
      -moz-border-radius: 9px 9px 9px 9px;
      -webkit-border: 9px 9px 9px 9px;
      padding-bottom: 30px;
      padding-top: 20px;
      box-shadow: -2px 0px 5px #C3C1C1, 0px -2px 5px #C3C1C1, 2px 0px 5px #C3C1C1, 0px 2px 5px #C3C1C1;
    }
    .style_row{
      margin-left: 10px;
      margin-right: 10px;
    }
    .style_col{
      margin-top: 5px;
    }
    .error_input{
      background-color: #F2DE6C ;
      display: none;
      width: 935px;
      margin: auto;
    }
    .error_color{
      color: red;
    }
</style>
<body class="cas zh " >
      <div id = "main">
        <h1>欢迎进入您的安全邮箱注册界面</h1>
        <hr>
        <div class="input-group-addon error_input " id = "register_error"></div>
		<form method="post" action="user/front/register" th:action="@{user/front/register}">
          <div class="row style_row">
          <div class="col-lg-6 style_col">
            <div class="input-group" id = "userid">
              <span class="input-group-addon">用户账号</span>
              <input type="text" class="form-control" maxlength="10" onfocusout="if(isSearch(this.value))this.focus()" onkeydown="if(event.keyCode==32) return false"  onKeypress="if ((event.keyCode > 32 && event.keyCode < 48) || (event.keyCode > 57 && event.keyCode < 65) || (event.keyCode > 90 && event.keyCode < 97)||event.keyCode == 32) event.returnValue = false;" id="acceptperson" tabindex="1" placeholder="用户id 这是您登录系统的唯一账号，不能用中文" id = "user_id" name = "user_id">
            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 -->  
          <div class="col-lg-6 style_col">
            <div class="input-group" id = "username">
              <span class="input-group-addon">您的名字</span>
              <input type="text" class="form-control" abindex="1" placeholder="这将显示在您的主页上，请谨慎填写！" onkeydown="if(event.keyCode==32) return false"  onKeypress="if ((event.keyCode > 32 && event.keyCode < 48) || (event.keyCode > 57 && event.keyCode < 65) || (event.keyCode > 90 && event.keyCode < 97)||event.keyCode == 32) event.returnValue = false;"id = "user_name" name = "user_name">
            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 -->  
          <div class="col-lg-6 style_col" id = 'userpw'>
            <div class="input-group" id = "userpw">
              <span class="input-group-addon">您的密码</span>
              <input type="password" class="form-control" onfocusout="if(isSearch(this.value))this.focus()"onkeydown="if(event.keyCode==32) return false"  onKeypress="if ((event.keyCode > 32 && event.keyCode < 48) || (event.keyCode > 57 && event.keyCode < 65) || (event.keyCode > 90 && event.keyCode < 97)||event.keyCode == 32) event.returnValue = false;" id = "user_pw1" name = "user_pw1">

            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 --> 
          
          <div class="col-lg-6 style_col">
            <div class="input-group" id = "userpw2">
              <span class="input-group-addon">确认密码</span>
              <input type="password" class="form-control" onfocusout="if(isSearch(this.value))this.focus()" id = "user_pw2" name = "user_pw2">
            </div><!-- /input-group -->
          </div><!-- /.col-lg-6 -->  
		  <div class="col-lg-6 style_col">
           
        
		  <div class="field">
			<div class="input-group ">
				<input type="text" class="form-control input-lg" style="width:150px" name="registerrand" tabindex="1" placeholder="验证码" 
						value="" data-required="true" />
				<img title="看不清？换一张" src="coder" style="cursor:pointer" onClick="this.src='code?date='+new Date();"/>
			</div>
							
		 </div>  
		 </div><!-- /.col-lg-6 -->  
          <div class="col-lg-6 style_col">
		  		<button type="submit" onclick = "register_ajax();return false;" class="btn btn-success style_row style_col">确认提交</button>
		  </div>
        </form>
       </div>
</body>
</html>
