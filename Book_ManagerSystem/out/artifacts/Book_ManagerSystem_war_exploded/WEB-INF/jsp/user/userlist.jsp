<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>用户管理页面</span>
	</div>
	<div class="search">
		<form method="get" action="${pageContext.request.contextPath }/sys/user/user.do">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>用户名：</span>
			<input name="queryname" class="input-text"	type="text" value="${queryUserName }">

			<input type="hidden" name="pageIndex"/>
			<input	value="查 询" type="submit" id="searchbutton">
			<a href="${pageContext.request.contextPath}/sys/user/useradd.html" >添加用户</a>
		</form>
	<%--  form end--%>

	</div>
	<!--用户-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="10%">用户序号</th>
			<th width="20%">用户名称</th>
			<th width="10%">用户密码</th>
			<th width="10%">借阅书籍数量</th>
			<th width="10%">余额</th>
			<th width="30%">操作</th>
		</tr>
		<c:forEach var="user" items="${userList }" varStatus="status">
			<tr>
				<td>
					<span>${user.uid }</span>
				</td>
				<td>
					<span>${user.uname }</span>
				</td>
				<td>
					<span>${user.pwd }</span>
				</td>
				<td>
					<span>${user.num }</span>
				</td>
				<td>
					<span>${user.balance }</span>
				</td>

				<td>
						<span>
							<%--第一种方法--%>
							<%--<a class="viewUser" href="${pageContext.request.contextPath }/sys/user/userview.html?uid=${user.id}"  userid=${user.id }  username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>--%>
								<%--第二种方法--%>
							<a class="viewUser" href="${pageContext.request.contextPath }/sys/user/userview.html?uid=${user.uid}" uname=${user.uname }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
						<%--第三种方法:通过js文件实现，出错，原因未知--%>
						<%--<a class="viewUser"   userid=${user.id }  username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>--%>
					<span>
							<a class="modifyUser" href="${pageContext.request.contextPath }/sys/user/usermodify.html?uid=${user.uid}" uname=${user.uname }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
					<span>
							<a class="deleteUser" href="${pageContext.request.contextPath }/sys/user/userdelete.html?uid=${user.uid}" uname=${user.uname }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
				</td>
			</tr>
		</c:forEach>
	</table>

	<%--引入（导入）rollpage.jsp文件--%>
	<input type="hidden" id="totalPageCount" value="${pageSupport.totalPageCount}"/>

	<c:import url="../common/rollpage.jsp">
		<c:param name="totalCount" value="${pageSupport.totalCount}"/>
		<c:param name="currentPageNo" value="${pageSupport.currentPageNo}"/>
		<c:param name="totalPageCount" value="${pageSupport.totalPageCount}"/>
	</c:import>


</div><%--class="right"  end --%>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
	<div class="removerChid">
		<h2>提示</h2>
		<div class="removeMain">
			<p>你确定要删除该用户吗？</p>
			<a href="#" id="yes">确定</a>
			<a href="#" id="no">取消</a>
		</div>
	</div>
</div>

<%@include file="../common/foot.jsp" %>

<%--<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>--%>

