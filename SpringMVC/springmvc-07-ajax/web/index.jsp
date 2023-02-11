<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ajax</title>
    <!--    jquery-->
    <script src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script>
      function onblurJQ(){
        $.ajax({
          url:"${pageContext.request.contextPath}/ajax",
          data:{"name":$("#name").val()},
          success:function (data){
             alert(data);
          },
          error:function (){

          }
      })
      }
    </script>
  </head>
  <body>
<%--  失去一个焦点，发起请求(携带信息)到后台--%>
  账号：<input type="text" id="name" onblur="onblurJQ()"><br>
  密码：<input type="password" id="pwd">
  </body>
</html>
