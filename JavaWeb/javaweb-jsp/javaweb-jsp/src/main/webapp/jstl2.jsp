<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choose</title>
</head>
<body>

<%--定义一个变量--%>
<c:set var="score" value="90"></c:set>
<%--通过choose判断--%>
<c:choose>
    <c:when test="${score>=85}">
        你的成绩优秀
    </c:when>
    <c:when test="${score>=60}">
        你的成绩一般
    </c:when>
    <c:when test="${score>=0}">
        你的还需要努力
    </c:when>
</c:choose>
</body>
</html>
