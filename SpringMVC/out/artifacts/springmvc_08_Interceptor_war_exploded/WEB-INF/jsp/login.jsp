<%--
  Created by IntelliJ IDEA.
  User: Joker大雄
  Date: 2022/6/18
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h2>登录</h2>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        账号：<input type="text" name="uname"><br/>
        密码：<input type="password" name="pwd"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
