<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>图书管理页面 >> 图书修改页面</span>
        </div>
        <div class="providerAdd">
        <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath }/sys/book/bookmodifysave.html">
			<input type="hidden" name="method" value="modifyexe">
			<input type="hidden" name="id" value="${book.bid}"/>
			 <div>
                    <label for="bname">图书名称：</label>
                    <input type="text" name="bname" id="bname" value="${book.bname }">
					<font color="red"></font>
             </div>
            <div>
                <label for="ISBN">ISBN：</label>
                <input type="text" name="ISBN" id="ISBN" value="${book.ISBN }">
                <font color="red"></font>
            </div>
            <div>
                <label for="price">价格：</label>
                <input type="text" name="price" id="price" value="${book.price }">
                <font color="red"></font>
            </div>
            <div>
                <label >书籍类别：</label>
                <!-- 列出所有的书籍分类 -->
                <select name="class_id" id="class_id">
                    <option value="1">传记类</option>
                    <option value="2">科幻类</option>
                    <option value="3" selected="selected">散文类</option>
                    <option value="4">音乐类</option>
                    <option value="5">信息技术类</option>
                </select>
                <font color="red"></font>
            </div>
            <div>
                <label for="number">馆藏数量：</label>
                <input type="text" name="number" id="number" value="${book.number}">
                <font color="red"></font>
            </div>
            <div>
                <label for="info">书籍简介：</label>
                <input type="text" name="info" id="info" value="${book.info}">
                <font color="red"></font>
            </div>
            <div>
                <label for="author">作者：</label>
                <input type="text" name="author" id="author" value="${book.author }">
                <font color="red"></font>
            </div>
            <div>
                <label for="publish">出版社：</label>
                <input type="text" name="publish" id="publish" value="${book.publish }">
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
