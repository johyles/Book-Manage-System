<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/9
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>图书管理页面</span>
    </div>
    <div class="search">
        <form method="get" action="${pageContext.request.contextPath }/sys/book/book.do">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>图书名：</span>
            <input name="queryname" class="input-text"	type="text" value="${queryBookName }">

            <span>图书种类：</span>
            <select name="queryBookClass">
                <c:if test="${classList != null }">
                    <option value="0">--请选择--</option>
                    <c:forEach var="classs" items="${classList}">
                        <option <c:if test="${classs.class_id ==queryBookClass }">selected="selected"</c:if>
                                value="${classs.class_id}">${classs.class_name}</option>
                    </c:forEach>
                </c:if>
            </select>

            <input type="hidden" name="pageIndex" />
            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/sys/book/bookadd.html" >添加书籍</a>
        </form>
        <%--  form end--%>

    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">书籍编码</th>
            <th width="10%">书籍名称</th>
            <th width="10%">ISBN</th>
            <th width="10%">价格</th>
            <th width="10%">类别</th>
            <th width="10%">馆藏数量</th>
            <th width="10%">简介</th>
            <th width="10%">作者</th>
            <th width="10%">出版社</th>
            <th width="40%">操作</th>
        </tr>
        <c:forEach var="book" items="${bookList }" varStatus="status">
            <tr>
                <td>
                    <span>${book.bid }</span>
                </td>
                <td>
                    <span>${book.bname}</span>
                </td>
                <td>
                    <span>${book.ISBN}</span>
                </td>
                <td>
                    <span>${book.price}</span>
                </td>
                <td>
                    <span>${book.bookClassName}</span>
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
							<%--第一种方法--%>
							<%--<a class="viewUser" href="${pageContext.request.contextPath }/sys/user/userview.html?uid=${user.id}"  userid=${user.id }  username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>--%>
								<%--第二种方法--%>
                        <%--第三种方法:通过js文件实现，出错，原因未知--%>
                        <%--<a class="viewUser"   userid=${user.id }  username=${user.userName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>--%>
                    <span>
							<a class="modifyUser" href="${pageContext.request.contextPath }/sys/book/bookmodify.html?bid=${book.bid}"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span>
							<a class="deleteUser" href="${pageContext.request.contextPath }/sys/book/bookdelete.html?bid=${book.bid}"><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
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

