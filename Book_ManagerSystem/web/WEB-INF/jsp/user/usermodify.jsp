<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/user/usermodifysave.html">
			<input type="hidden" name="method" value="modifyexe">
			<input type="hidden" name="uid" value="${user.uid }"/>
			 <div>
                <label for="uname">用户名称：</label>
                <input type="text" name="uname" id="uname" value="${user.uname }">
                <font color="red"></font>
             </div>
            <div>
                <label for="pwd">密码：</label>
                <input type="text" name="pwd" id="pwd" value="${user.pwd }">
                <font color="red"></font>
            </div>
            <div>
                <label for="balance">余额：</label>
                <input type="text" name="balance" id="balance" value="${user.balance }">
                <font color="red"></font>
            </div>
			 <div class="providerAddBtn">
                    <input type="submit" name="save" id="save" value="保存" />
                    <input type="button" id="back" name="back"
                           onclick="window.history.back()"
                            value="返回"/>
                </div>
            </form>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/usermodify.js"></script>--%>
