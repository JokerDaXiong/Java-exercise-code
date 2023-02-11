<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/upload" method="post"  enctype="multipart/form-data">
    <input type="file" multiple="multiple" name="file">
    <input type="submit">
  </form>
  <a href="${pageContext.request.contextPath}/download">下载</a>
  </body>
</html>
