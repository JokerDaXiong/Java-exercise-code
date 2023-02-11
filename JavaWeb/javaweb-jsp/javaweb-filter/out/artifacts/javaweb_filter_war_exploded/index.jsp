<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <h1>当前有<span><%=getServletConfig().getServletContext().getAttribute("onlyCount")%></span>人在线</h1>
  </body>
</html>
