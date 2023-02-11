<html>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<body>
<h2>Hello World!</h2>
<%--这里提交的路径，需要寻找项目的路径--%>
<%--${pageContext.request.contextPath} 代表当前项目--%>
<form action="${pageContext.request.contextPath}/reqt" method="get">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit">

</form>




</body>
</html>
