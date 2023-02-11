<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍查询</title>
<%--    bootstrap CSS--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<%--使用BootStrap 需要导入--%>
<div class="container">
<%--    栅格系统--%>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表</small>
                </h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
            </div>
            <div class="col-md-4 column">
<%--                查询书籍--%>
                <form action="${pageContext.request.contextPath}/book/queryBook" method="post" class="form-inline">
                      <div style="float: right;margin-right: -380px;">
                          <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称">
                          <input type="submit" class="btn btn-primary" value="查询">
                      </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详细</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
<%--                    从list中遍历--%>
                    <c:forEach var="book" items="${list}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookID}">修改</a>
                                 &nbsp;|&nbsp;
                                <a class="btn btn-danger" href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
