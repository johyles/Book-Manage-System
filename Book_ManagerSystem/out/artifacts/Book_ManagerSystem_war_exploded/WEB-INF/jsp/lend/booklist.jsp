<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head_user.jsp"%>

<div class="right">
       <div class="location">
           <strong>你现在所在的位置是:</strong>
           <span>书籍检索页面</span>
       </div>
       <div class="search">
       <form method="get" action="${pageContext.request.contextPath }/sys/lend/book.do">
			<input name="method" value="query" class="input-text" type="hidden">
			<span>书籍名称：</span>
			<input name="queryName" type="text" value="${queryName }">
			 
			<%--<span>种类：</span>
			<select name="queryClass">
				<c:if test="${ClassList != null }">
				   <option value="0">--请选择--</option>
				   <c:forEach var="class" items="${ClassList}">
				   		<option <c:if test="${class.class_id == queryClass }">selected="selected"</c:if>
				   		value="${class.class_id}">${class.bookClassName}</option>
				   </c:forEach>
				</c:if>
       		</select>--%>
			 <input	value="查 询" type="submit" id="searchbutton">
		</form>
       </div>
       <!--账单表格 样式和供应商公用-->
      <table class="providerTable" cellpadding="0" cellspacing="0">
          <tr class="firstTr">
              <th width="20%">商品名称</th>
              <th width="20%">ISBN</th>
              <th width="10%">分类</th>
              <th width="10%">馆藏数量</th>
              <th width="10%">简介</th>
              <th width="10%">作者</th>
			  <th width="10%">出版社</th>
          </tr>
          <c:forEach var="book" items="${bookList }" varStatus="status">
				<tr>
					<td>
					<span>${book.bname }</span>
					</td>
					<td>
					<span>${book.ISBN }</span>
					</td>
					<td>
					<span>${book.class_name}</span>
					</td>
					<td>
					<span>${book.number}</span>
					</td>
					<td>
						<span>${book.info}</span>
					</td>
					<td>
						<span>${book.author}</span>
					</td>
					<td>
						<span>${book.publish}</span>
					</td>
					<td>
					<span><a class="addleand" href="${pageContext.request.contextPath }
									/sys/lend/lendadd.html?bid=${book.bid}&class_id=${book.class_id}&number=${book.number}">
						<img src="${pageContext.request.contextPath }/statics/images/yes.png" alt="借书" title="借书"/></a></span>
					</td>
				</tr>
			</c:forEach>
      </table>
  </div>
</section>


<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<%--
<script type="text/javascript" src="${pageContext.request.contextPath }/js/billlist.js"></script>--%>
