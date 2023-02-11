<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>登录</h2>
<form action="${pageContext.request.contextPath}/login" method="post">
    账号：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    爱好：<input type="checkbox" name="hobby" value="音乐">音乐
    <input type="checkbox" name="hobby" value="电影">电影
   <input type="checkbox" name="hobby" value="其他">其他<br>
    <input type="submit">

</form>
</body>
</html>
