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
    <title>用户注册 - 图书管理系统</title>
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
        <h1>用户注册</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/Register.html"  name="actionForm" id="actionForm"  method="post" >
            <div class="info">${error }</div>
            <div class="inputbox">
                <%--@declare id="user"--%><label for="user">用户名：</label>
                <input type="text" class="input-text" id="userName" name="userName" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="mima">密码：</label>
                <input type="text" class="input-text" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
            </div>
            <div class="inputbox">
                <label for="mimacheck">确认：</label>
                <input type="text" class="input-text" id="ruserPassword" name="ruserPassword" placeholder="请再次输入密码" required/>
            </div>
            <div class="divcss">
                <input type="submit" name="add" id="add" value="保存" >
            </div>

        </form>
    </section>
</section>
<script>
    document.getElementById("add").onclick=function(){
        var form = document.getElementById("actionForm");
        var password = document.getElementById("userPassword");
        var repassword =document.getElementById("ruserPassword");
        password.value =md5(password.value);
        repassword.value = md5(repassword.value);
        console.log(password.value);
        console.log(repassword.value);
        form.submit();
    }
</script>
</body>
</html>

