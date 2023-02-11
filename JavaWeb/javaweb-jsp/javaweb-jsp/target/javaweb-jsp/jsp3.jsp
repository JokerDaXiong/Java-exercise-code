<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp指令实现--%>
<%--指令实现会将两个页面合二为一--%>
    <%@ include file="header.jsp"%>
    <h1>网页主体</h1>
    <%@ include file="footer.jsp"%>
    <hr>
<%--jsp标签实现--%>
<%--标签实现是拼接页面 推荐使用标签实现--%>
    <jsp:include page="header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="header.jsp"/>
</body>
</html>
