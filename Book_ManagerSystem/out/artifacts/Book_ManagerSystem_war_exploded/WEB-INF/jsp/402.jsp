<%--
  Author: 四两数字先生（微信公众号/CSDN）
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>操作失败</title>
</head>
<body>
<h1>可能是填写的数据有空值</h1>
<div class="providerAdd">
    <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/book/book.do">
        <input type="hidden" name="method" value="add">
        <div class="providerAddBtn">
            <input type="submit" name="add" id="add" value="Back" >
        </div>
    </form>
</div>
</body>
</html>
