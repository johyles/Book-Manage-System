<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/head_user.jsp"%>

<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>借阅管理页面</span>
	</div>
	<div class="search">
		<form method="get" action="${pageContext.request.contextPath }/sys/lend/lend.do">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>书籍名称：</span>
			<input name="queryname" class="input-text"	type="text" value="${queryUserName }">

			<input type="hidden" name="pageIndex"/>
			<input	value="查 询" type="submit" id="searchbutton">
		</form>
	<%--  form end--%>

	</div>
	<!--用户-->
	<table class="providerTable" cellpadding="0" cellspacing="0">
		<tr class="firstTr">
			<th width="20%">流水号</th>
			<th width="20%">书籍名称</th>
			<th width="20%">借阅日期</th>
			<th width="20%">应还日期</th>
			<th width="20%">操作</th>
		</tr>
		<c:forEach var="lend" items="${lendList }" varStatus="status">
			<tr>
				<td>
					<span>${lend.lid }</span>
				</td>
				<td>
					<span>${lend.bname}</span>
				</td>
				<td>
					<%--<span>${lend.lend_date}</span>--%>
					<span><fmt:formatDate value="${lend.lend_date}" type="date" pattern="yyyy-MM-dd" /></span>
				</td>
				<td>
					<%--<span>${lend.back_date}</span>--%>
					<span><fmt:formatDate value="${lend.back_date}" type="date" pattern="yyyy-MM-dd" /></span>
				</td>

				<td>

					<span>
							<a
									class="deleteBook" href="${pageContext.request.contextPath }
									/sys/lend/lenddelete.html?bid=${lend.bid}&uid=${lend.uid }">
								<img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="还书" title="还书"/>
							</a></span>
				</td>
			</tr>
		</c:forEach>
	</table>

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

