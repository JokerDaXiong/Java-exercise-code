<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--JSP内置对象--%>
<%--赋值--%>
<%
    //  scope:作用域
    // 双亲委派机制
    // 从底层到高层(作用域) page->request->session->application
    pageContext.setAttribute("name1","张三"); // 在一个页面中有效
    request.setAttribute("name2","张三2"); // 在一次请求中有效
    session.setAttribute("name3","张三3"); // 在一次会话中有效
    application.setAttribute("name4","张三4"); // 在服务器中有效
%>
<%--取值--%>
<%
    // 用PageContext取出值
    String name1=(String)pageContext.findAttribute("name1");
    String name2=(String)pageContext.getAttribute("name2");
    String name3=(String)pageContext.getAttribute("name3");
    String name4=(String)pageContext.getAttribute("name4");
%>
<%--输出--%>
<h1>取出的值</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<%--用EL表达式取不存在得值会被过滤，不显示在页面上--%>
<%--而使用<%=name5%>方法取不存在的值，会在页面显示null--%>
<%--推荐使用EL表达式--%>
<h3>${name5}</h3>


</body>
</html>
