<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<%--    JSP基本语法--%>
    <%--JSP表达式
    作用：用来将程序输出，输出到客户端
    <%= 变量表达式%>
    --%>
<%= new java.util.Date()%>
<hr>
<%--JSP脚本片段--%>
<%
    int sum=0;
    for(int i = 1;i<=100;i++){
        sum+=i;
    }
    out.print("<h1>Sum="+sum+"</h1>");
%>
<%--在代码中嵌入HTML元素--%>
<%
    for(int i=0;i<5;i++) {
%>
<h1>Hello World<%=i%></h1>
<%
    }
%>
<hr>
<%--定义全局变量--%>
<%!
    static {
        System.out.println("Loading Servlet");
    }
    private int globalVar =0;
    public void inner(){
        System.out.println("进入inner方法");
    }
%>
<!--Html注释-->
<%--JSP注释--%>




</body>
</html>
