<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSPTag1</h1>
<%--JSP标签--%>
<%--<jsp:include page="header.jsp"></jsp:include>--%>
<%--请求转发 携带参数--%>
<%--jsp标签中间不要写注释--%>
<jsp:forward page="/jspTag2.jsp">
    <jsp:param name="person1" value="person1"/>
    <jsp:param name="person2" value="person2"/>
</jsp:forward>

</body>
</html>
