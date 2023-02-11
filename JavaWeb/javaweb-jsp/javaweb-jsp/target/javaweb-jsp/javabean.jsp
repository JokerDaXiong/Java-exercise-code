<%--
  Created by IntelliJ IDEA.
  User: Joker大雄
  Date: 2022/4/8
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
JavaBean：
    id:实体类名
    class：类
--%>
<jsp:useBean id="people" class="com.jokerdig.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="address" value="西安"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="21"/>
<jsp:setProperty name="people" property="name" value="小王"/>
<%--获取值--%>
姓名：<jsp:getProperty name="people" property="name" />
年龄：<jsp:getProperty name="people" property="age" />
ID：<jsp:getProperty name="people" property="id" />
地址：<jsp:getProperty name="people" property="address" />


</body>
</html>
