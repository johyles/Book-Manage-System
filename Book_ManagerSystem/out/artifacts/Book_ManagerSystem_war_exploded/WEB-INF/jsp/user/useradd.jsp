<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户添加页面</span>
        </div>
        <div class="providerAdd">
            <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/user/useraddsave.html">
				<input type="hidden" name="method" value="add">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="uname">用户名称：</label>
                    <input type="text" name="uname" id="uname" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="pwd">用户密码：</label>
                    <input type="password" name="pwd" id="pwd" value="">
					<font color="red"></font>
                </div>
                <div>
                    <label for="ruserPassword">确认密码：</label>
                    <input type="password" name="ruserPassword" id="ruserPassword" value=""> 
					<font color="red"></font>
                </div>
                <div>
                    <label for="num">已借阅书籍：</label>
                    <input type="text" name="num" id="num" value="">
                    <font color="red"></font>
                </div>
                <div>
                    <label for="balance">用户余额：</label>
                    <input type="text" name="balance" id="balance" value="">
                    <font color="red"></font>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" name="add" id="add" value="保存" >
					<input type="button" id="back" name="back" onclick="javascript:window.history.back()" value="返回" >
                </div>
            </form>
        </div>
</div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/useradd.js"></script>--%>
