<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.servletContext.contextPath}/servlet/login">
        账号：<input type="text" name="username"><br>
        密码：<input type="password" name="pwd"><br>
        <input type="submit">
    </form>
</body>
</html>
