<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/6/10
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>

<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>图书管理页面 >> 图书添加页面</span>
    </div>
    <div class="providerAdd">
        <form id="bookForm" name="bookForm" method="post" action="${pageContext.request.contextPath }/sys/book/bookaddsave.html">
            <input type="hidden" name="method" value="add">
            <!--div的class 为error是验证错误，ok是验证成功-->
            <div>
                <label for="bname">书籍名称：</label>
                <input type="text" name="bname" id="bname" value="">
                <!-- 放置提示信息 -->
                <font color="red"></font>
            </div>
            <div>
                <label for="ISBN">ISBN：</label>
                <input type="text" name="ISBN" id="ISBN" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="price">书籍价格：</label>
                <input type="text" name="price" id="price" value="">
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
                <input type="text" name="number" id="number" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="info">书籍简介：</label>
                <input type="text" name="info" id="info" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="author">作者：</label>
                <input type="text" name="author" id="author" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="publish">出版社：</label>
                <input type="text" name="publish" id="publish" value="">
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
