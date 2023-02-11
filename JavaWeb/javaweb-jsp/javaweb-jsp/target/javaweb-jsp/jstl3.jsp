<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入JSTL核心标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>forEach</title>
</head>
<body>

<%--定义一个数组--%>
<%
    ArrayList<String> list=new ArrayList<String>();
    list.add(0,"张三");
    list.add(1,"李四");
    list.add(2,"王五");
    list.add(3,"赵六");
    list.add(4,"小王");
    request.setAttribute("list",list);
%>
<%--使用forEach遍历数组--%>
<%--var：遍历出的值  item：便利的数组--%>
<h2>用户信息：</h2>
<c:forEach var="li" items="${list}">
    <c:out value="${li}"/><br>
</c:forEach>
<hr>
<%--begin：起始序列  end：结束序列  step：步长--%>
<h2>用户信息：</h2>
<c:forEach var="li" items="${list}" begin="1" end="3" step="2">
    <c:out value="${li}"/><br>
</c:forEach>

</body>
</html>
