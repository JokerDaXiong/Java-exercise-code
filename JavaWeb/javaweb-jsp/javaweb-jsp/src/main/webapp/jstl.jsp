<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>if</title>
</head>
<body>
<h1>if测试</h1>
<hr>
<%--${param.参数名} 表达式获取表单中的数据--%>
<form action="jstl.jsp" method="get">
    姓名：<input type="text" name="username" value="${param.username}">
    <input type="submit" value="提交">
</form>
<%--如果提交的用户名是管理员 则登录成功--%>
<c:if test="${param.username=='admin'}" var="isadmin" >
    <c:out value="管理员登录"/>
</c:if>
    <c:out value="${isadmin}"/>
</body>
</html>
