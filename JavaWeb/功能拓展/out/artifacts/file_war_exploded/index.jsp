<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>

<%--  通过表单上传--%>
  <form action="${pageContext.request.contextPath}/upload.do" method="post" enctype="multipart/form-data">
<%--    get有上传大小限制--%>
    <input type="file" name="file1"><br>
    <input type="file" name="file2"><br>
    <input type="submit">
    <input type="reset">
  </form>
  </body>
</html>
