<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
 <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>用户编号：</strong><span>${user.uid }</span></p>
            <p><strong>用户名称：</strong><span>${user.uname }</span></p>
            <p><strong>密码：</strong><span>${user.pwd }</span></p>
            <p><strong>已借阅书籍：</strong><span>${user.num }</span></p>
            <p><strong>余额：</strong><span>${user.balance }</span></p>
        </div>
     <div class="providerAddBtn">
         <input type="button" id="back" name="back" onclick="javascript:window.history.back()" value="返回" >
     </div>
</div>

</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userview.js"></script>