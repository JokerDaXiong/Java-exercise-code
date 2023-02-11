<%--解决乱码--%>
%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导包--%>
<%@ page import="java.util.Date" %>
<%--定制错误页面--%>
<%@ page errorPage="error/error.jsp" %>
<%--显示错误页面--%>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>JSP指令</title>
</head>
<body>
<%
    int i =1/0;
    new Date();
%>
</body>
</html>
