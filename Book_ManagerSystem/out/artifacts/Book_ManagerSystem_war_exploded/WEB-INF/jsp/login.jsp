<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.smbms.tools.MD5Util" %>
<script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.js"></script>
<script src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
<!DOCTYPE html>
<style>
    body{ text-align:center}
    #divcss{margin:0 auto;border:1px solid #000;width:300px;height:100px}
</style>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 图书管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
    <script type="text/javascript">
	/* if(top.location!=self.location){
	      top.location=self.location;
	 } */
    </script>
</head>
<body class="login_bg">
    <section class="loginBox">
        <header class="loginHeader">
            <h1>图书管理系统</h1>
        </header>
        <section class="loginCont">
	        <form class="loginForm" action="${pageContext.request.contextPath }/dologin.html"  name="actionForm" id="actionForm"  method="post" >
				<div class="info">${error }</div>
				<div class="inputbox">
                    <%--@declare id="user"--%><label for="user">用户名：</label>
					<input type="text" class="input-text" id="usename" name="usename" placeholder="请输入用户名" required/>
				</div>	
				<div class="inputbox">
                    <%--@declare id="mima"--%><label for="mima">密码：</label>
                    <input type="password" id="Password" name="Password" placeholder="请输入密码" required/>
                </div>
				<div class="subBtn">
                    <input id="btn01" type="submit" value="登录"/>
                    <input type="reset" value="重置"/>

                </div class="divcss">
                <div>
                    <a href="${pageContext.request.contextPath }/regist.html">注册</a>
                    <a href="${pageContext.request.contextPath }/forget.html">忘记密码</a>
                </div>

			</form>
        </section>
    </section>
<script>
                document.getElementById("btn01").onclick=function(){
                    var form = document.getElementById("actionForm");
                    var password = document.getElementById("Password");
                    password.value =md5(password.value);
                    console.log(password.value);
                    form.submit();
            }
</script>
</body>
</html>
